package com.tdh.zelink.dao;

import com.tdh.zelink.datasource.DepartCodeToName;
import com.tdh.zelink.datasource.SortTableInfo;
import com.tdh.zelink.datasource.UserSexCodeToName;
import com.tdh.zelink.entity.TableInfo;
import com.tdh.zelink.entity.User;
import com.tdh.zelink.jdbc.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/25  13:14
 */
public class TableInfoDao {
    /**
     *调用静态方法获得（部门代码:部门名称）map集合
     */
    private HashMap<String, String> departMap = DepartCodeToName.getInstance();
    /**
     *调用静态方法，获得性别代码和性别相关的map集合
     */
    private HashMap<String, String> sexMap = UserSexCodeToName.getInstance();
    /**
     *
     * @description: 返回所有的用户数据
     * @param conn
     * @return : java.util.ArrayList<com.tdh.zelink.entity.TableInfo>
     * @author : Saturn
     * @date : 2021/4/27 22:23
     *
     */

    public ArrayList<TableInfo> getTableInfo(Connection conn) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        /*
         *用于存放用户数据的集合
         */
        ArrayList<TableInfo> tableInfos = new ArrayList<TableInfo>();
//        查询的sql语句
        String sql = "select PXH,YHXM,YHID,YHBM,YHXB from T_USER ";
        try {
//            获得pst资源
            pst = conn.prepareStatement(sql);
//            执行sql语句，并返回数据
            rs = pst.executeQuery();
//            遍历数据，将数据对应属性的值存入对象所对应的属性中
            while (rs.next()) {
                TableInfo tableInfo = new TableInfo();
                tableInfo.setSort(Integer.parseInt(rs.getString("PXH")));
                tableInfo.setUserName(rs.getString("YHXM"));
                tableInfo.setAccount(rs.getString("YHID"));
//                部门属性，寻找编码对应的名称
                tableInfo.setDepartment(departMap.get(rs.getString("YHBM")));
//                性别属性，寻找性别代码所对应的值
                tableInfo.setSex(sexMap.get(rs.getString("YHXB")));
//                将对象加入到集合中
                tableInfos.add(tableInfo);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭资源
            JdbcUtils.close(rs, pst, conn);
        }

//        返回集合数据
        return tableInfos;
    }
    /**
     *
     * @description: 根据名称或者ID返回对应的数据集合
     * @param nameOrId
     * @return : java.util.ArrayList<com.tdh.zelink.entity.TableInfo>
     * @author : Saturn
     * @date : 2021/4/27 22:29
     *
     */

    public ArrayList<TableInfo> getUserByNameOrId(String nameOrId){
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection conn=null;
        /*
         *存放数据的集合
         */
        ArrayList<TableInfo> tableInfos = new ArrayList<TableInfo>();
//        编写sql语句
        String sql = "select PXH,YHXM,YHID,YHBM,YHXB from T_USER where YHXM=? or YHID=?";
        try {
            conn=JdbcUtils.getConnection();
            pst = conn.prepareStatement(sql);
//            存入所需的值
            pst.setString(1,nameOrId);
            pst.setString(2,nameOrId);
//            执行查询语句
            rs = pst.executeQuery();
//            遍历集合，处理数据，以对象的形式存入集合
            while (rs.next()) {
                TableInfo tableInfo = new TableInfo();
                tableInfo.setSort(Integer.parseInt(rs.getString("PXH")));
                tableInfo.setUserName(rs.getString("YHXM"));
                tableInfo.setAccount(rs.getString("YHID"));
//                需将编码格式转化为名称存入对象中
                tableInfo.setDepartment(departMap.get(rs.getString("YHBM")));
                tableInfo.setSex(sexMap.get(rs.getString("YHXB")));
//                加入到集合中
                tableInfos.add(tableInfo);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//            关闭连接
            JdbcUtils.close(rs, pst, conn);
        }

//        System.out.println(tableInfos);
//        返回数据
        return tableInfos;
    }
    /**
     *
     * @description:根据部门名称获得相关用户的数据
     * @param depart
     * @return : java.util.ArrayList<com.tdh.zelink.entity.TableInfo>
     * @author : Saturn
     * @date : 2021/4/27 22:34
     *
     */

    public ArrayList<TableInfo> getTableInfoByDepart(String depart) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection conn=null;
//        存放数据的集合
        ArrayList<TableInfo> tableInfos = new ArrayList<TableInfo>();
//        编写sql语句
        String sql = "select PXH,YHXM,YHID,YHBM,YHXB from T_USER where YHBM = ?";
        try {
//            获得数据库连接资源
            conn=JdbcUtils.getConnection();
            pst = conn.prepareStatement(sql);
//            对sql语句的参数赋值
            pst.setString(1,DepartCodeToName.getCodeInstance().get(depart));
//            执行查询语句
            rs = pst.executeQuery();
//            遍历资源，并存入到集合中
            while (rs.next()) {
                TableInfo tableInfo = new TableInfo();
                tableInfo.setSort(Integer.parseInt(rs.getString("PXH")));
                tableInfo.setUserName(rs.getString("YHXM"));
                tableInfo.setAccount(rs.getString("YHID"));
                tableInfo.setDepartment(departMap.get(rs.getString("YHBM")));
                tableInfo.setSex(sexMap.get(rs.getString("YHXB")));
                tableInfos.add(tableInfo);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//            关闭连接
            JdbcUtils.close(rs, pst, conn);
        }

//        System.out.println(tableInfos);
//        返回数据集合
        return tableInfos;



    }
//    测试方法
    @Test
    public void getDepart(){
        ArrayList<TableInfo> by = getTableInfoByDepart("业务庭");
        SortTableInfo sortTableInfo = new SortTableInfo();
        sortTableInfo.sortTableInfo(by);
        System.out.println(by);
    }

}
