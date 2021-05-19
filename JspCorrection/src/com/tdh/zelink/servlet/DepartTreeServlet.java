package com.tdh.zelink.servlet;

import com.alibaba.fastjson.JSONArray;
import com.tdh.zelink.dao.DepartTreeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/25  14:28
 */
public class DepartTreeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        返回中文时，进行中文的字符编码要求
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        DepartTreeDao departTreeDao = new DepartTreeDao();
//        获取部门树的列表
        List<String> departTree = departTreeDao.getDepartTree();
//        存入session
        req.getSession().setAttribute("departTree",departTree);
//        返回部门树json化后的数据
        resp.getWriter().write(String.valueOf(JSONArray.toJSON(departTree)));

    }
}
