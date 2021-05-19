package com.tdh.zelink.servlet;

import com.alibaba.fastjson.JSONObject;
import com.tdh.zelink.dao.UserDao;
import com.tdh.zelink.entity.ResultMessage;
import com.tdh.zelink.entity.User;
import com.tdh.zelink.jdbc.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/23  14:07
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        UserDao userDao = new UserDao();
        User user = new User();
        User currentUser = null;
//        获取用户账号和密码
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String saveAccount =  req.getParameter("saveAccount");
        String savePassword = req.getParameter("savePassword");
//        存入对象中
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
//            进行账号的验证
            currentUser = userDao.Login(conn, user);
            System.out.println(currentUser);
//            验证失败
            if (currentUser == null) {
                req.setAttribute("error", "您输入的用户名或口令不正确");
//          9
//                req.getRequestDispatcher("index.jsp").forward(req, resp);
//                用信息对象存入相关信息
                ResultMessage resultMessage = new ResultMessage();
                resultMessage.setCode(100);
                resultMessage.setResultMessage("您输入的用户名或口令不正确");
                System.out.println(resultMessage);
                System.out.println(resultMessage);
//                对象JSON化后返回给前端
                resp.getWriter().write(String.valueOf((JSONObject) JSONObject.toJSON(resultMessage)));
//                req.getRequestDispatcher("/index.jsp").forward(req, resp);
//                resp.sendRedirect("/index.jsp");


            } else {
//                out.println(currentUser);
                HttpSession session = req.getSession();
                //设置请求的编译为UTF-8
                //获取用户名
                String cookieUserName = URLEncoder.encode(userName, "UTF-8");
                //获取密码
                String cookiePassword = URLEncoder.encode(userPassword, "UTF-8");
                //创建并实例化cookie对象
                Cookie cookie = new Cookie("userName", cookieUserName);
                //设置cookie有效期30天
                if ("on".equals(saveAccount)) {
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                } else {
                    cookie.setMaxAge(0);
                }
//                添加到Coolies中
                resp.addCookie(cookie);
                cookie = new Cookie("userPassword", cookiePassword);
                if ("on".equals(savePassword)) {
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                } else {
                    cookie.setMaxAge(0);
                }
                resp.addCookie(cookie);
//                用户对象存放入session中
                session.setAttribute("currentUser", currentUser);
                session.setAttribute("user", "user");
//                进行页面的重定向
                resp.sendRedirect("/tableInfo.jsp");
//                req.setAttribute("currentUser", );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//            关闭资源
            JdbcUtils.close(null, null, conn);
        }

    }
}
