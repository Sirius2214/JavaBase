package com.tdh.zelink.datasource;

import com.tdh.zelink.entity.User;
import com.tdh.zelink.jdbc.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @author ZeLink
 * @Description 单例模式的方法，使得资源只会加载一次：
 * 使用两个map集合存放部门代码和部门名称的关系
 * @date 2021/4/25  13:23
 */
public class DepartCodeToName {
    /**
     * 存放 部门代码和部门名称关系的集合
     */
    private static HashMap<String, String> departMap = null;
    /**
     * 存放 部门名称和部门代码关系的集合
     */
    private static HashMap<String, String> departCodeMap = null;

    /**
     * @param
     * @return : java.util.HashMap<java.lang.String,java.lang.String>
     * @description: 获取部门代码和部门名称关系的集合
     * @author : Saturn
     * @date : 2021/4/27 22:52
     */

    public static HashMap<String, String> getInstance() {
//        已经存在时，直接返回
        if (departMap != null) {
//            System.out.println("已有的sex");
            return departMap;
        } else {
//            不存在时，进行数据的获取
            getCodeName();
            return departMap;
        }

    }

    /**
     * @param
     * @return : java.util.HashMap<java.lang.String,java.lang.String>
     * @description:获取部门名称和部门代码关系的集合
     * @author : Saturn
     * @date : 2021/4/27 22:53
     */

    public static HashMap<String, String> getCodeInstance() {
//        存在时，返回数据集合
        if (departCodeMap != null) {
//            System.out.println("已有的sex");
            return departCodeMap;
        } else {
//            为空时，进行资源获取
            getCodeName();
            return departCodeMap;
        }
    }

    /**
     * @param
     * @return : void
     * @description:为两个集合获取数据
     * @author : Saturn
     * @date : 2021/4/27 22:54
     */

    private static void getCodeName() {
//        生成新的对象
        departMap = new HashMap<String, String>();
        departCodeMap = new HashMap<String, String>();
        Connection conn = null;
        try {
//            获取连接
            conn = JdbcUtils.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement pst = null;
        ResultSet rs = null;
//        编写sql语句
        String sql = "select BMDM , BMMC from T_DEPART  ";
        try {
            pst = conn.prepareStatement(sql);
            //   执行sql语句
            rs = pst.executeQuery();
            while (rs.next()) {
//                以部门代码和部门名称的方式存放
                departMap.put(rs.getString("BMDM"), rs.getString("BMMC"));
//                以部门名称和部门代码的方式存放
                departCodeMap.put(rs.getString("BMMC"), rs.getString("BMDM"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭资源
            JdbcUtils.close(rs, pst, conn);
        }
    }

    @Test
    public void getDepart() throws SQLException, ClassNotFoundException {
        HashMap<String, String> instance = DepartCodeToName.getCodeInstance();
        System.out.println(instance);
    }

}
