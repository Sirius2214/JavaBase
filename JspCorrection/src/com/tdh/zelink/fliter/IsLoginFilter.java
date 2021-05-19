package com.tdh.zelink.fliter;


import com.sun.xml.internal.ws.util.StringUtils;
import com.tdh.zelink.entity.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/23  14:51
 */
public class IsLoginFilter implements Filter {
    /**
     * 不需要过滤url的集合
     */
    private ArrayList<String> excludedPageArray;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        String excludedPages = filterConfig.getInitParameter("excludedPages");
//
//        if (!"".equals(excludedPages)) {
//            System.out.println(excludedPages);
//          excludedPageArray = excludedPages.split(",");
//        }
        excludedPageArray = new ArrayList<String>();
//        不许被监听时重定向的数据
        excludedPageArray.add("/");
        excludedPageArray.add("/index.jsp");
        excludedPageArray.add("/login");
        excludedPageArray.add("/js/*");
        excludedPageArray.add("/css/*");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
////        System.out.println("MyFilter1 --before");
//        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
////        获取session的currentUser值，检验是否通过登录
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String requestURI = request.getRequestURI();
////
//        User user = (User) session.getAttribute("currentUser");
//        if (request.getRequestURI().contains(".css") || request.getRequestURI().contains(".js")) {
//            if (request.getRequestURI().contains(".jsp") && !("/index.jsp").equals(request.getRequestURI())) {
//                System.out.println(user);
//                if (user == null) {
////            属于被排除的标志
//                    boolean isExcludedPage = false;
////            遍历排除的url
//                    for (String page : excludedPageArray) {
////                当前的url被排除时，修改标志位，并退出循环
//                        if (page.equals(request.getRequestURI())) {
//                            isExcludedPage = true;
//                            break;
//                        }
//                    }
////            不属于被排除的url并且无用户数据时进行首页的重定向
//                    if (!isExcludedPage) {
//                        System.out.println("重定向1");
//                        ((HttpServletResponse) servletResponse).sendRedirect("/");
//
//                    }
//                }
//            }
//        }
//        else {
//            if (user == null) {
////            属于被排除的标志
//                boolean isExcludedPage = false;
////            遍历排除的url
//                for (String page : excludedPageArray) {
////                当前的url被排除时，修改标志位，并退出循环
//                    if (page.equals(request.getRequestURI())) {
//                        isExcludedPage = true;
//                        break;
//                    }
//                }
////            不属于被排除的url并且无用户数据时进行首页的重定向
//                if (!isExcludedPage) {
//                    System.out.println("重定向2");
//                    ((HttpServletResponse) servletResponse).sendRedirect("/");
//
//                }
//            }
//
//
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
