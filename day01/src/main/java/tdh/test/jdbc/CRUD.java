package main.java.tdh.test.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: wangzy
 * @Description: jdbc数据库操作
 * @Project Name:test
 * @File Name: CRUD
 * @Package Name:tdh.test.jdbc
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
public class CRUD {

    /**
     * 主方法
     * @param args 入参
     */
    public static void main(String[] args) {

        try {
            create();
            read();
            // update();
            // delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取数据
     * @throws Exception 异常信息
     */
    static void read() throws Exception {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 2.建立连接
            conn = JdbcUtils.getConnection();
            // conn = JdbcUtilsSing.getInstance().getConnection();
            // 3.创建语句
            st = conn.createStatement();

            // 4.执行语句
            rs = st.executeQuery("select YHDM, YHXM  from t_user");

            // 5.处理结果
            while (rs.next()) {
                System.out.println(rs.getObject("YHDM") + "\t"
                        + rs.getObject("YHXM"));
            }
        } finally {
            JdbcUtils.close(rs, st, conn);
        }
    }

    /**
     * 删除方法
     * @throws Exception 异常信息
     */
    static void delete() throws Exception{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 2.建立连接
            conn = JdbcUtils.getConnection();
            // conn = JdbcUtilsSing.getInstance().getConnection();
            // 3.创建语句
            st = conn.createStatement();

            String sql = "delete from T_USER where YHDM = '320100lar12' ";

            // 4.执行语句
            int i = st.executeUpdate(sql);

            System.out.println("i=" + i);
        } finally {
            JdbcUtils.close(rs, st, conn);
        }
    }

    /**
     * 更新数据
     * @throws Exception 异常信息
     */
    static void update() throws Exception {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 2.建立连接
            conn = JdbcUtils.getConnection();
            // conn = JdbcUtilsSing.getInstance().getConnection();
            // 3.创建语句
            st = conn.createStatement();

            String sql = "update T_USER set DWDM = '320102' ";

            // 4.执行语句
            int i = st.executeUpdate(sql);

            System.out.println("i=" + i);
        } finally {
            JdbcUtils.close(rs, st, conn);
        }
    }

    /**
     * 新增数据
     * @throws Exception 异常信息
     */
    static void create() throws Exception {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 2.建立连接
            conn = JdbcUtils.getConnection();
            // conn = JdbcUtilsSing.getInstance().getConnection();
            // 3.创建语句
            st = conn.createStatement();

            String sql = "insert into T_USER (YHDM, DWDM, YHID, YHXM, YHKL, YHXB, YHBM, CSRQ, DJSJ, PXH) values ('320100lar12', '320100', 'lar1', '立案人1', null, null, '32010001', null, null, 1); ";

            // 4.执行语句
            int i = st.executeUpdate(sql);

            System.out.println("i=" + i);
        } finally {
            JdbcUtils.close(rs, st, conn);
        }
    }

}
