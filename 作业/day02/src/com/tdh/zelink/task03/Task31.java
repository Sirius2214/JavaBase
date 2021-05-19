package com.tdh.zelink.task03;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  10:30
 */
public class Task31 {
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    /**
     * 以时间为Key，ArrayList为值建立map集合
     * ArrayList的值是统一时间内的部门集合
     */

    private HashMap<String, ArrayList<DepartMent>> map = new HashMap<String, ArrayList<DepartMent>>();
    private void getInstance() {

        try {
//          创建连接
            conn = JdbcUtils.getConnection();
//          创建语句
            st = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void selectData() {
        //       获取Connection连接，和Statement资源
        getInstance();
        if (conn != null && st != null) {
//            拼接sql语句
            String sql = "SELECT substring_index(DJSJ,' ',1) as DJSJ ,(SELECT BMMC from t_depart WHERE BMDM =YHBM) as YHBM, (SELECT MC FROM ts_bzdm WHERE code = YHXB) as XB, COUNT(*) as Count from t_user GROUP BY substring_index(DJSJ,' ',1), YHBM,YHXB ";
            try {
//                执行sql查询语句
                rs = st.executeQuery(sql);
                while (rs.next()) {
//                   获取对应属性的信息
                    String djsj = rs.getString("DJSJ");
                    String yhbm = rs.getString("YHBM");
                    String xb = rs.getString("XB");
                    String count = rs.getString("Count");
//                    生成实体对象,放入性别和人数
                    SexCount sexCount = new SexCount();
                    sexCount.setCount(count);
                    sexCount.setSex(xb);
//                    如果map集合当前日期的记录为空时,进行直接生成新的部门并加入到map的value的集合内
                    if (map.get(djsj) == null) {
//                        生成部门对象,并放入相对应的性别和人员
                        DepartMent departMent = new DepartMent();
                        departMent.setSexCounts(sexCount);
                        departMent.setDepartName(yhbm);
//                        将当前部门对象放入集合内,并加入到map中
                        ArrayList<DepartMent> departMents = new ArrayList<DepartMent>();
                        departMents.add(departMent);
                        map.put(djsj, departMents);

                    } else {
//                        当map中有数据时,取出当前日期所对应的list集合
                        ArrayList<DepartMent> departMents = map.get(djsj);
                        /**
                         *for循环的变量,for循环结束时,用户判断是否正常退出for循环
                         */
                        int i=0;
                        for ( i= 0; i <departMents.size(); i++) {
//                            System.out.println(departMents.get(i).getDepartName());
//                            System.out.println(yhbm);
//                            System.out.println(sexCount);
//                            如果当前部门存在,进行性别对象的添加,完成后跳出for循环
                            if (departMents.get(i).getDepartName().equals(yhbm)) {
                                departMents.get(i).setSexCounts(sexCount);
                                break;
                            }

                        }
//                        正常退出for循环,表示当前循环中没有该部门.
                        if(i>=departMents.size()){
//                            生成新的部门对象,添加对应属性,并加入到list集合中
                                DepartMent departMent = new DepartMent();
                                departMent.setSexCounts(sexCount);
                                departMent.setDepartName(yhbm);
                                ArrayList<DepartMent> d = new ArrayList<DepartMent>();
                                departMents.add(departMent);


                        }
                    }
                }
//                数据有序化
//                获取map的所有key值
                Object[] key = map.keySet().toArray();
//                key值排序
                Arrays.sort(key);
//                以有序的key值进行数据遍历
                for (int i = 0; i < key.length; i++) {
                    System.out.println(key[i]);
                    for (DepartMent d: map.get(key[i])) {
                        System.out.println("\t\t"+d.getDepartName());
                        for (int j=0;j<d.getSexCounts().size();j++){
                            System.out.println( "\t\t\t\t"+d.getSexCounts().get(j).getSex()+":"+d.getSexCounts().get(j).getCount());

                        }
                        System.out.println();
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
//                关闭连接池
                JdbcUtils.close(rs, st, conn);
            }
        }

    }

}
