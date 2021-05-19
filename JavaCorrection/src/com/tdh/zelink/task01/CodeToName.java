package com.tdh.zelink.task01;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author ZeLink
 * @Description
 * @date 2021/5/14  15:38
 */
public class CodeToName {
    /**
     * 存放 部门代码和部门名称关系的集合
     */
    private static HashMap<String, String> departMap = null;
    /**
     *  存放性别代码-性别名称的map集合
     */
    private static HashMap<String, String> sexMap = null;

    public static HashMap<String,String> getDepartMap(){
        if(departMap==null){
            getDepartCodeName();
        }

        return departMap;
    }
    public static HashMap<String,String> getSexMap(){
        if(sexMap==null){
            getSexCodeName();
        }
        return sexMap;
    }

    /**
     *
     * @description: 获取部门代码和部门名称Map集合
     * @param
     * @return : void
     * @author : ZeLink
     * @date : 2021/5/14 15:43
     *
     */

    private static void getDepartCodeName() {
//        生成新的对象
        departMap = new HashMap<String, String>();
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
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭资源
            JdbcUtils.close(rs, pst, conn);
        }
    }
    /**
     *
     * @description:获取性别代码和名称的Map集合
     * @param
     * @return : void
     * @author : ZeLink
     * @date : 2021/4/27 23:02
     *
     */
    private static void getSexCodeName(){
//        生成新的对象
        sexMap = new HashMap<String, String>();
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
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭资源
            JdbcUtils.close(rs, pst, conn);
        }
    }

}
