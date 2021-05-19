package com.tdh.zelink.dao;

import com.tdh.zelink.datasource.DepartCodeToName;
import com.tdh.zelink.datasource.UnitCode;
import com.tdh.zelink.datasource.UserSexCodeToName;
import com.tdh.zelink.entity.TableInfo;
import com.tdh.zelink.entity.User;
import com.tdh.zelink.jdbc.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/23  14:23
 */
public class UserDao {
    /**
     *
     * @description: 根据传入的用户数据，验证当前用户是否存在
     * @param conn
     * @param user
     * @return : com.tdh.zelink.entity.User
     * @author : Saturn
     * @date : 2021/4/27 22:37
     *
     */

    public User Login(Connection conn, User user) {
        PreparedStatement pst = null;
        ResultSet rs = null;
//        结果对象用来存放正确查出的数据
        User resultUser = null;
//        编写sql语句
        String sql = "select YHID , YHKL from T_USER where YHID = ? and YHKL = ? ";
        try {

            pst = conn.prepareStatement(sql);
//            赋值相关参数
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getUserPassword());
//            执行查询语句
            rs = pst.executeQuery();
//            遍历资源，并把对应的属性值放入到新的对象中
            while (rs.next()) {
                resultUser = new User();
                resultUser.setUserName(rs.getString("YHID"));
                resultUser.setUserPassword(rs.getString("YHKL"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭资源
            JdbcUtils.close(rs, pst, conn);
        }
//        返回查询出来的对象
        return resultUser;
    }
    /**
     *
     * @description: 根据用户的账号ID删除当前账号
     * @param conn
 * @param account
     * @return : void
     * @author : Saturn
     * @date : 2021/4/27 22:41
     *
     */

    public void deleteUser(Connection conn, String account) {
        PreparedStatement pst = null;
        ResultSet rs = null;
//        编写sql语句
        String sql = "delete from T_USER where YHID = ?";
        try {
            pst = conn.prepareStatement(sql);
//            相关参数赋值
            pst.setString(1, account);
//            执行sql语句
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭资源
            JdbcUtils.close(rs, pst, conn);
        }
    }
    /**
     *
     * @description:更具账号ID查询相关用户的详细信息
     * @param conn
 * @param account
     * @return : com.tdh.zelink.entity.User
     * @author : Saturn
     * @date : 2021/4/27 22:42
     *
     */

    public User getUser(Connection conn, String account) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        /*
         *用于存放用户详细信息
         */
        User user = new User();
//        编写sql语句
        String sql = "select YHID, YHKL,YHXM,YHXB,YHBM,CSRQ,PXH,SFJY from T_USER where YHID = ? ";
        try {
            pst = conn.prepareStatement(sql);
//            为sql语句的条件参数赋值
            pst.setString(1, account);
//            执行sql查询语句
            rs = pst.executeQuery();
//            遍历数据，将对应属性值赋值到对象对应的属性中
            while (rs.next()) {
                user.setAccount(rs.getString("YHID"));
                user.setUserPassword(rs.getString("YHKL"));
                user.setUserName(rs.getString("YHXM"));
//                特殊格式的要进行转化
                user.setSex(UserSexCodeToName.getInstance().get(rs.getString("YHXB")));
                user.setDepartment(DepartCodeToName.getInstance().get(rs.getString("YHBM")));
                user.setBirthday(rs.getString("CSRQ"));
                user.setSort(rs.getInt("PXH"));
                user.setIsDisable(rs.getString("SFJY"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭连接
            JdbcUtils.close(rs, pst, conn);
        }
//        返回用户的详细对象数据
        return user;
    }
    /**
     *
     * @description: 根据用户代码实现数据的更新
     * @param user
     * @return : void
     * @author : Saturn
     * @date : 2021/4/27 22:45
     *
     */

    public void updateUser(User user) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
//            获取连接
            conn = JdbcUtils.getConnection();
//            编写sql语句
            String sql = "update T_USER set YHID = ? , YHKL=? , YHXM=? , YHXB=? , YHBM=? , CSRQ=?, PXH=? , SFJY=? where YHDM=?";
            pst = conn.prepareStatement(sql);
//            对sql语句的参数进行赋值
            int i=1;
            pst.setString(i++, user.getAccount());
            pst.setString(i++, user.getUserPassword());
            pst.setString(i++, user.getUserName());
            pst.setString(i++, user.getSex());
            pst.setString(i++, user.getDepartment());
            pst.setString(i++, user.getBirthday());
            pst.setInt(i++, user.getSort());
            pst.setString(i++, user.getIsDisable());
//            用户代码由单位代码和用户ID组成
            pst.setString(i++, UnitCode.getInstance().get(0)+user.getAccount());
//            执行sql语句
            pst.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//            关闭连接
            JdbcUtils.close(null, pst, conn);
        }
    }
    /**
     *
     * @description: 插入新的数据
     * @param user
     * @return : void
     * @author : Saturn
     * @date : 2021/4/27 22:48
     *
     */

    public void addUser(User user){
        Connection conn = null;
        PreparedStatement pst = null;
        try {
//            获得数据库连接
            conn = JdbcUtils.getConnection();
//            编写sql语句
            String sql = "insert T_USER (YHDM,DWDM,YHID,YHKL,YHXM,YHXB,YHBM,CSRQ,SFJY,PXH) values (?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            int i=1;
//            相应的参数进行赋值
//            用户代码由单位代码和用户ID组成
            pst.setString(i++, UnitCode.getInstance().get(0)+user.getAccount());
            pst.setString(i++, UnitCode.getInstance().get(0));
            pst.setString(i++, user.getAccount());
            pst.setString(i++, user.getUserPassword());
            pst.setString(i++, user.getUserName());
            pst.setString(i++, user.getSex());
            pst.setString(i++, user.getDepartment());
            pst.setString(i++, user.getBirthday());
            pst.setString(i++, user.getIsDisable());
            pst.setInt(i++, user.getSort());
//          执行sql语句
            pst.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//            关闭资源
            JdbcUtils.close(null, pst, conn);
        }
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        Connection connection = JdbcUtils.getConnection();
        deleteUser(connection, "1");
    }

    @Test
    public void testGetUser() throws SQLException, ClassNotFoundException {
        Connection connection = JdbcUtils.getConnection();
        User user = getUser(connection, "123");
        System.out.println(user);
    }

}
