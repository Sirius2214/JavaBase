package com.tdh.zelink.task01;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.*;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  9:27
 */
public class Task02 {


    /**
     * @param
     * @return : void
     * @description:往数据库的t_user表中添加数据
     * @author : Zelink
     * @date : 2021/4/16 9:42
     */
    public void add(User user) {
//        获取Connection连接与Statement资源
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
//          创建连接
            conn = JdbcUtils.getConnection();
            String sql = "insert into T_USER (YHDM, DWDM, YHID, YHXM, YHKL, YHXB, YHBM, CSRQ, DJSJ, PXH) values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//          创建语句
            int i = 1;
            pst=conn.prepareStatement(sql);
            pst.setString(i++, user.getUserCode());
            pst.setString(i++, user.getUnitCode());
            pst.setString(i++, user.getUserId());
            pst.setString(i++, user.getUserName());
            pst.setString(i++, user.getUserPassword());
            pst.setString(i++, user.getSex());
            pst.setString(i++, user.getDepartment());
            pst.setString(i++, user.getBirthday());
            pst.setString(i++, user.getRegistrationTime());
            pst.setString(i++, user.getSort());
            System.out.println(sql);
            //                执行插入的sql语句
            //
            pst.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//                关闭数据库连接
            JdbcUtils.close(rs, pst, conn);
        }

    }

    /**
     * @param
     * @return : void
     * @description:根据YHDM删除数据
     * @author : Zelink
     * @date : 2021/4/16 9:42
     */
    public void delete(String userCode) {
        //        获取Connection连接与Statement资源
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
//          创建连接
            conn = JdbcUtils.getConnection();
//          创建语句

            String sql = "delete from T_USER where YHDM=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,userCode);
            //          执行删除的sql语句
            pst.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //                关闭数据库连接
            JdbcUtils.close(rs, pst, conn);
        }


    }

    /**
     * @param
     * @return : void
     * @description:根据YHDM更新数据
     * @author : Zelink
     * @date : 2021/4/16 9:42
     */
    public void update(String userName,String userCode) {
        //        获取Connection连接与Statement资源
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
//          创建连接
            conn = JdbcUtils.getConnection();
//          创建语句
            String sql = "update T_USER set YHXM=? where YHDM=?";
            int i = 1;
            pst = conn.prepareStatement(sql);
            pst.setString(i++, userName);
            pst.setString(i++, userCode);


            //                执行更新的sql语句
            pst.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //                关闭数据库连接
            JdbcUtils.close(rs, pst, conn);
        }
    }
}

