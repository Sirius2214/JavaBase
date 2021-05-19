package com.tdh.zelink.task01;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  8:52
 */
public class Task01 {
    HashMap<String, String> map = new HashMap<String, String>();
    public String getDepartName(String BMDM){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
//        如果Map为空的时候从数据库获取数据
        if(map==null||map.get(BMDM)==null) {
            System.out.println("进行数据库连接");
            try {
//          创建连接
                conn = JdbcUtils.getConnection();
//          创建语句
                st = conn.createStatement();
                String sql = "select BMDM,BMMC from t_depart";
//                执行查询sql语句
                rs = st.executeQuery(sql);

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
                JdbcUtils.close(rs, st, conn);
            }
        }
//        从map中返回key所对应的value值
         return map.get(BMDM)==null?"无相关部门":map.get(BMDM);
    }


}
