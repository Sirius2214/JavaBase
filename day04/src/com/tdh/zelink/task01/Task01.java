package com.tdh.zelink.task01;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.*;
import java.util.HashMap;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  8:52
 */
public class Task01 {
    HashMap<String, String> map = new HashMap<String, String>();
    /**
     *
     * @description: 根据指定部门代码获得相应的部门名称
     * @param departCode
     * @return : java.lang.String
     * @author : Saturn
     * @date : 2021/4/20 15:42
     *
     */
    //TODO  此题的意义是 通过去数据库获取一次 数据放到Map里 ；通过code 查询时  只要查下map 中的了；你这个方法要分成两个；一个放map 一个查map
    //TODO 放map   项目做一次就可以了
    public String getDepartName(String departCode){
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        ResultSet rs = null;
//        如果Map为空的时候从数据库获取数据
        if(map==null||map.get(departCode)==null) {
            System.out.println("进行数据库连接");
            try {
//          创建连接
                conn = JdbcUtils.getConnection();
//          创建语句
//                st = conn.createStatement();
                String sql = "select BMDM,BMMC from T_DEPART";
//                执行查询sql语句
                prepareStatement= conn.prepareStatement(sql);
                rs = prepareStatement.executeQuery();

                while (rs.next()) {
//                System.out.println(rs.getString("BMDM")+"---"+rs.getString("BMMC"));
//                获取的数据放入Map集合
                    map.put(rs.getString("BMDM"), rs.getString("BMMC"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
//                关闭连接
                JdbcUtils.close(rs, prepareStatement, conn);
            }
        }
//        从map中返回key所对应的value值
         return map.get(departCode)==null?"无相关部门":map.get(departCode);
    }


}
