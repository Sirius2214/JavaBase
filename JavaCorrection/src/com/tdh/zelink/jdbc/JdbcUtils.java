package com.tdh.zelink.jdbc;

import java.sql.*;

/**
 *
 * @description:
 * @return :
 * @author : ZeLink
 * @date : 2021/5/14 15:10
 *
 */

public final class JdbcUtils {
    /**
     * 数据量url
     */
    private static String url = "jdbc:mysql://127.0.0.1:3306/tdh?useUnicode=true&characterEncoding=UTF-8";
    /**
     * 数据库用户名
     */
    private static String user = "root";
    /**
     * 数据库密码
     */
    private static String password = "1713001043";

    /**
     * 获取数据库连接
     *
     * @return Connection 数据库连接
     * @throws SQLException           异常信息
     * @throws ClassNotFoundException 异常信息
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 关闭数据库资源
     *
     * @param rs   ResultSet
     * @param pst   PreparedStatement
     * @param conn Connection
     */
    public static void close(ResultSet rs, PreparedStatement pst, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

