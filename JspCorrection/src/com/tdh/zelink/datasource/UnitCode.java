package com.tdh.zelink.datasource;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ZeLink
 * @Description 单例模式：获取部门代码
 * @date 2021/4/26  15:34
 */
public class UnitCode {
    private static ArrayList<String> unitCodeList = null;

    public static ArrayList<String> getInstance() {
        if (unitCodeList == null) {
            Connection coon = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            unitCodeList = new ArrayList<String>();
            try {
//                获取资源
                coon = JdbcUtils.getConnection();
//               编写sql语句
                String sql = " SELECT DWDM FROM T_DEPART GROUP BY DWDM";
                pst = coon.prepareStatement(sql);
//                执行查询
                rs = pst.executeQuery();
//                遍历集合，将单位代码存放入集合
                while (rs.next()){
                    unitCodeList.add(rs.getString("DWDM"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
//                关闭连接
                JdbcUtils.close(rs, pst, coon);
            }

        }
//      返回集合数据
        return unitCodeList;
    }
}
