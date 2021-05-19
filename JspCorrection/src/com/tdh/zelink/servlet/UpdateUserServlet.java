package com.tdh.zelink.servlet;

import com.tdh.zelink.dao.UserDao;
import com.tdh.zelink.datasource.DepartCodeToName;
import com.tdh.zelink.datasource.UserSexCodeToName;
import com.tdh.zelink.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/26  12:23
 */
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        System.out.println("更新");
//        获取相关的数据,并存放到对象对应的属性中
        user.setUserName(req.getParameter("userName"));
        user.setAccount(req.getParameter("userId"));
        user.setUserPassword(req.getParameter("userPassword"));
        String depart = null;
//        不是必填的属性要注意null的判定
        try {
            depart = req.getParameter("depart");
            System.out.println(depart);
            depart=DepartCodeToName.getCodeInstance().get(depart);
        } catch (Exception e) {
            depart=null;
        }
        String sex = null;
        try {
            sex = req.getParameter("sex");
            System.out.println(sex);
            sex=UserSexCodeToName.getCodeName().get(sex);
        } catch (Exception e) {
            sex=null;
        }
        String birthday = null;
        try {
            birthday = req.getParameter("birthday");
        } catch (Exception e) {
            birthday=null;
        }
        String isDisable = null;
        try {
            isDisable = String.valueOf("on".equals(req.getParameter("isDisable")) ? 1 : 0);
        } catch (Exception e) {
           isDisable="0";
        }
        Integer sort = null;
        try {
            sort = Integer.valueOf(req.getParameter("sort"));
        } catch (NumberFormatException e) {
            sort=0;
        }
//        根据模式的值,判断时更新还是新增
        System.out.println("isDisable"+isDisable);
        System.out.println(depart);
        System.out.println(sex);
        String model = req.getParameter("model");
        user.setDepartment(depart);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setIsDisable(isDisable);
        user.setSort(sort);
        System.out.println(user);
//          新增的结果下,进行添加用户方法的调用
        if("add".equals(model)){
            UserDao userDao = new UserDao();
            userDao.addUser(user);
        }
//        更新的结果下,进行更新方法的调用
        else{
            System.out.println("访问");
            System.out.println(user);
            UserDao userDao = new UserDao();
            userDao.updateUser(user);
        }
//        String url = "/updateUser.jsp?account="+user.getAccount();
//        System.out.println(url);
//        resp.sendRedirect(url);

    }

}
