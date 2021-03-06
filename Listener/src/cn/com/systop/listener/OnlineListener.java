package cn.com.systop.listener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineListener
 *
 */
@WebListener
public class OnlineListener implements HttpSessionAttributeListener, HttpSessionListener, ServletContextListener {

    /**
     * Default constructor. 
     */
    public OnlineListener() {
        // TODO Auto-generated constructor stub
    }


	/**
     * @see 监听Http回话中的属性添加
     */
    public void attributeAdded(HttpSessionBindingEvent event)  {
    	//增加一个用户
         UserList.addUser(String.valueOf(event.getValue()));
         print("Session：" + event.getSession().getId()+"增加属性"
        		 + "名字："+ event.getName() + "值" + event.getValue());
    }

	/**
     * @see 监听Http回话中的属性移除
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
        //移除一个用户
    	UserList.removeUser(String.valueOf(event.getValue()));
    	print("session:" + event.getSession().getId() + "移除属性" 
    			+ "名字" + event.getName() + "值" +event.getValue());
    }
    
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         print("Servlet 初始化");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         print("Session被创建");
    }

	/**
     * @see 监听Http请求中的属性更改操作
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	//Http属性被替换之前的值
    	String oldValue = String.valueOf(event.getValue());
    	
    	//替换之后的值
    	String newValue = String.valueOf(event.getSession().getAttribute(event.getName()));
    	UserList.removeUser(oldValue);
    	UserList.addUser(newValue);
    	print("Session:" + event.getSession().getId() + "属性" + event.getName() 
    	+"的值"+ oldValue+"，替换为" + newValue);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         print("Session被销毁");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	print("ServletContext被销毁");
    }
	//将message字符串信息输出到txt文件
    private void print(String  message)
    {
    	PrintWriter out = null;
    	try {
			out = new PrintWriter(new FileOutputStream("G:\\JavaWeb\\log.txt"));
			out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
					+ "   " + message);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
