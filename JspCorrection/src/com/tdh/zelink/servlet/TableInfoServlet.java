package com.tdh.zelink.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tdh.zelink.dao.TableInfoDao;
import com.tdh.zelink.datasource.SortTableInfo;
import com.tdh.zelink.entity.TableInfo;
import com.tdh.zelink.jdbc.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/25  13:14
 */
public class TableInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        TableInfoDao tableInfoDao = new TableInfoDao();
        Connection conn = null;
        try {
//            System.out.println("列表数据");
            conn = JdbcUtils.getConnection();
//            获取table所需要的用户数据
            ArrayList<TableInfo> tableInfo = tableInfoDao.getTableInfo(conn);
//            System.out.println(tableInfo);
//            存入到session中
            req.getSession().setAttribute("tableInfo",tableInfo);
//            数据进行排序
            SortTableInfo sortTableInfo = new SortTableInfo();
            tableInfo = sortTableInfo.sortTableInfo(tableInfo);
//            返回json化的数据
            resp.getWriter().write(String.valueOf(JSONArray.toJSON(tableInfo)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//            关闭资源
            JdbcUtils.close(null, null,conn );
        }
    }
}
