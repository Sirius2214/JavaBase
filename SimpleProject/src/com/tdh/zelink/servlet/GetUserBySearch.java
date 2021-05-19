package com.tdh.zelink.servlet;

import com.alibaba.fastjson.JSONArray;
import com.tdh.zelink.dao.TableInfoDao;
import com.tdh.zelink.datasource.SortTableInfo;
import com.tdh.zelink.entity.TableInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/26  16:54
 */
public class GetUserBySearch extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        返回中文时的编码要求
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        TableInfoDao tableInfoDao = new TableInfoDao();
//      获取用户名/用户ID
        String name = req.getParameter("name");

        ArrayList<TableInfo> userByNameOrId=null;
//        用户名不为空时
        if(!"".equals(name)){
//            调用根据ID查询的方法,并返回集合数据
            userByNameOrId = tableInfoDao.getUserByNameOrId(name);

        }
        System.out.println(userByNameOrId);
//        将数据进行排序
        SortTableInfo sortTableInfo = new SortTableInfo();
        userByNameOrId = sortTableInfo.sortTableInfo(userByNameOrId);
//        返回数据给前端
        resp.getWriter().write(String.valueOf(JSONArray.toJSON(userByNameOrId)));
    }
}
