package tdh.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 容器的上下文相关监听
 * 能够感知到容器的
 * @author hanzc
 * @date 2021/4/20
 */
public class MyListener1 implements ServletContextListener {

    /**
     * 处理容器启动事件
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //可以从事件中获取关心的对象信息
        System.out.println("容器启动");
    }

    /**
     * 处理容器停止事件
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("容器停止");
    }
}
