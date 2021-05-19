package tdh.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * session中属性的监听
 * @author hanzc
 * @date 2021/4/20
 */
public class MySessionAttributeListener implements HttpSessionAttributeListener {

    /**
     * session中的添加新属性
     * @param httpSessionBindingEvent 事件
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        String name = httpSessionBindingEvent.getName();
        Object value = httpSessionBindingEvent.getValue();
        System.out.println("id为" + session.getId() + "的session中添加了属性，name:" + name + ", value:" + value);
    }

    /**
     * session中的移除属性
     * @param httpSessionBindingEvent 事件
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        String name = httpSessionBindingEvent.getName();
        Object value = httpSessionBindingEvent.getValue();
        System.out.println("id为" + session.getId() + "的session中移除了属性，name:" + name + ", value:" + value);
    }

    /**
     * session中的属性替换
     * @param httpSessionBindingEvent 事件
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        String name = httpSessionBindingEvent.getName();
        Object value = httpSessionBindingEvent.getValue();
        System.out.println("id为" + session.getId() + "的session中替换了属性，name:" + name + ", value:" + value);
    }
}
