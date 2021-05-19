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
 * @date 2021/4/27  16:01
 */
public class GetUserInfoByDepart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
//        获取部门名称
        String depart = req.getParameter("depart");
//        对编码后的数据进行解码
        depart = java.net.URLDecoder.decode(depart, "UTF-8");
        System.out.println(depart);
        TableInfoDao tableInfoDao = new TableInfoDao();
        ArrayList<TableInfo> tableInfoByDepart=null;
//        部门名称不为空时，进行数据查询
        if(!"".equals(depart)){
            tableInfoByDepart = tableInfoDao.getTableInfoByDepart(depart);
        }
//        数据有序化
        SortTableInfo sortTableInfo = new SortTableInfo();
        tableInfoByDepart = sortTableInfo.sortTableInfo(tableInfoByDepart);
        req.getSession().setAttribute("tableInfo",tableInfoByDepart);

//        返回数据
        resp.getWriter().write(String.valueOf(JSONArray.toJSON(tableInfoByDepart)));

    }
}
