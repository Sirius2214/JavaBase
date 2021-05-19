package com.tdh.zelink.servlet;

import com.alibaba.fastjson.JSONObject;
import com.tdh.zelink.dao.UserDao;
import com.tdh.zelink.entity.User;
import com.tdh.zelink.jdbc.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/26  12:28
 */
public class GetUserInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        Connection conn=null;
        User user=new User();
//        获取账号ID
        String account = req.getParameter("account");
        try {
            conn = JdbcUtils.getConnection();
            UserDao userDao = new UserDao();
//            根据ID查找用户数据
            user = userDao.getUser(conn, account);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
//            关闭资源连接
            JdbcUtils.close(null,null,conn);
        }
        if(user!=null){
//            数据不为空时,返回JSON格式化后的数据对象
            resp.getWriter().write(String.valueOf((JSONObject) JSONObject.toJSON(user)));
        }

    }
}
