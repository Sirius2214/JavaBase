package com.tdh.zelink.task03;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  10:30
 */
public class Task31 {

    public Task31() {
        getData();
    }

    /**
     * 以时间为Key，ArrayList为值建立map集合
     * ArrayList的值是统一时间内的部门集合
     */

    private HashMap<String, ArrayList<DepartMent>> map = new HashMap<String, ArrayList<DepartMent>>();
    /**
     *用于存放性别代码的集合
     */
    private HashMap<String,String> sexMap = new HashMap<String, String>();
    /**
     *用于存放部门代码的集合
     */
    private HashMap<String,String> departCodeMap = new HashMap<String, String>();


    public void selectData()  {
//        获取Connection连接，和statement资源
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
//          创建连接
            conn = JdbcUtils.getConnection();
//            拼接sql语句
            //TODO sql 待优化  部门名称和性别  可通过第一题map的概念   只要查一次  通过缓存翻译
            String sql = "SELECT substring_index(DJSJ,' ',1) as DJSJ , YHBM,  YHXB, COUNT(*) as COUNT from T_USER GROUP BY substring_index(DJSJ,' ',1), YHBM,YHXB";
            pst=conn.prepareStatement(sql);
//                执行sql查询语句
            rs = pst.executeQuery(sql);
            while (rs.next()) {
//                   获取对应属性的信息
                String djsj = rs.getString("DJSJ");
                String yhbm = rs.getString("YHBM");
                String xb = rs.getString("YHXB");
                // TODO
                String count = rs.getString("COUNT");
//                    生成实体对象,放入性别和人数
                SexCount sexCount = new SexCount();
                sexCount.setCount(count);
                sexCount.setSex(sexMap.get(xb));
//                    如果map集合当前日期的记录为空时,进行直接生成新的部门并加入到map的value的集合内
                if (map.get(djsj) == null) {
//                        生成部门对象,并放入相对应的性别和人员
                    DepartMent departMent = new DepartMent();
                    departMent.setSexCounts(sexCount);
                    departMent.setDepartName(departCodeMap.get(yhbm));
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
                    int i = 0;
                    for (i = 0; i < departMents.size(); i++) {

//                            如果当前部门存在,进行性别对象的添加,完成后跳出for循环
                        if (departMents.get(i).getDepartName().equals(departCodeMap.get(yhbm))) {
                            departMents.get(i).setSexCounts(sexCount);
                            break;
                        }

                    }
//                        正常退出for循环,表示当前循环中没有该部门.
                    if (i >= departMents.size()) {
//                            生成新的部门对象,添加对应属性,并加入到list集合中
                        DepartMent departMent = new DepartMent();
                        departMent.setSexCounts(sexCount);
                        departMent.setDepartName(departCodeMap.get(yhbm));
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
                for (DepartMent d : map.get(key[i])) {
                    System.out.println("\t\t" + d.getDepartName());
                    for (int j = 0; j < d.getSexCounts().size(); j++) {
                        System.out.println("\t\t\t\t" + d.getSexCounts().get(j).getSex() + ":" + d.getSexCounts().get(j).getCount());

                    }
                    System.out.println();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//                关闭连接池
            JdbcUtils.close(rs, pst, conn);
        }
    }
    /**
     *
     * @description: 获取性别代码，和部门代码的相关数据，存入对应的集合
     * @param
     * @return : void
     * @author : Saturn
     * @date : 2021/4/20 15:48
     *
     */
    private void getData() {
//        获取Connection连接，和statement资源
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
//          创建连接
            conn = JdbcUtils.getConnection();

//        查询所有性别代码
            String sql = "select CODE ,MC from TS_BZDM";
//            执行sql语句
            //          创建语句
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
//                将用户编码放入到性别集合内
//                sexList.add(rs.getString("code"));
                sexMap.put(rs.getString("CODE"),rs.getString("MC"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //            关闭数据库连接
            JdbcUtils.close(rs, pst, conn);
        }

//        查询所有部门代码
//        获取Connection连接，和statement资源
        try {
//          创建连接
            conn = JdbcUtils.getConnection();

            String sql = "select BMDM ,BMMC from T_DEPART";
            //          创建语句
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            //            执行sql语句
            rs = pst.executeQuery();
            while (rs.next()) {
//                将所有的部门代码放入到部门集合内
                departCodeMap.put(rs.getString("BMDM"),rs.getString("BMMC"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //            关闭数据库连接
            JdbcUtils.close(rs, pst, conn);
        }
        System.out.println(sexMap);
        System.out.println(departCodeMap);


    }
}


