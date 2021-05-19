package com.tdh.zelink.datasource;

import com.tdh.zelink.jdbc.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author ZeLink
 * @Description以单例模式获取性别代码和性别名称对应的集合
 * @date 2021/4/25  13:23
 */
public class UserSexCodeToName {
    /**
     *  存放性别代码-性别名称的map集合
     */
    private static HashMap<String, String> sexMap = null;
    /**
     *  存放性别名称-性别代码的map集合
     */
    private static HashMap<String, String> sexCodeMap = null;
    /**
     *
     * @description:返回性别代码-性别名称的集合
     * @param
     * @return : java.util.HashMap<java.lang.String,java.lang.String>
     * @author : Saturn
     * @date : 2021/4/27 23:01
     *
     */

    public static HashMap<String, String> getInstance() {
//        对象不为空，返回集合
        if (sexMap != null) {
//            System.out.println("已有的sex");
            return sexMap;
        } else {
//            对象为空时进行资源的获取
            getSexCodeName();
            return sexMap;
        }
    }
    public static HashMap<String, String> getCodeName() {
        if (sexCodeMap != null) {
//            System.out.println("已有的sex");
            return sexCodeMap;
        } else {
            getSexCodeName();
            return sexCodeMap;
        }
    }
    /**
     *
     * @description:获取性别代码和性别名称的两个map集合
     * @param
     * @return : void
     * @author : Saturn
     * @date : 2021/4/27 23:02
     *
     */

    private static void getSexCodeName(){
//        生成新的对象
        sexMap = new HashMap<String, String>();
        sexCodeMap = new HashMap<String, String>();
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
        String sql = "select CODE , MC from TS_BZDM  ";
        try {
            pst = conn.prepareStatement(sql);
//            执行sql语句
            rs = pst.executeQuery();
//            遍历资源，并将资源存放到对应的集合中
            while (rs.next()) {
                sexMap.put(rs.getString("CODE"), rs.getString("MC"));
                sexCodeMap.put( rs.getString("MC"),rs.getString("CODE"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭资源
            JdbcUtils.close(rs, pst, conn);
        }
    }

    @Test
    public void getSex() throws SQLException, ClassNotFoundException {
        HashMap<String, String> instance = UserSexCodeToName.getCodeName();
        System.out.println(instance);
    }


}
