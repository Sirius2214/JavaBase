package com.tdh.zelink.servlet;

import com.alibaba.fastjson.JSONObject;
import com.tdh.zelink.dao.UserDao;
import com.tdh.zelink.entity.ResultMessage;
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
 * @Description 执行删除用户
 * @date 2021/4/25  17:30
 */
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

//        获取删除账号的ID
        String account = (String) req.getParameter("account");
        System.out.println(account);
        UserDao userDao = new UserDao();
        Connection conn = null;
        ResultMessage resultMessage = new ResultMessage();
        try {
            conn = JdbcUtils.getConnection();
//            调用对应dao层删除用户的方法
            userDao.deleteUser(conn, account);
            resultMessage.setResultMessage("删除成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            resultMessage.setCode(100);
            resultMessage.setResultMessage("删除失败");
            e.printStackTrace();
        } finally {
//            关闭连接
            JdbcUtils.close(null, null, conn);
        }
        resp.getWriter().write(String.valueOf(JSONObject.toJSON(resultMessage)));
    }
}
