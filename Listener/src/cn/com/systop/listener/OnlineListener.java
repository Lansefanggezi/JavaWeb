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
     * @see ����Http�ػ��е���������
     */
    public void attributeAdded(HttpSessionBindingEvent event)  {
    	//����һ���û�
         UserList.addUser(String.valueOf(event.getValue()));
         print("Session��" + event.getSession().getId()+"��������"
        		 + "���֣�"+ event.getName() + "ֵ" + event.getValue());
    }

	/**
     * @see ����Http�ػ��е������Ƴ�
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
        //�Ƴ�һ���û�
    	UserList.removeUser(String.valueOf(event.getValue()));
    	print("session:" + event.getSession().getId() + "�Ƴ�����" 
    			+ "����" + event.getName() + "ֵ" +event.getValue());
    }
    
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         print("Servlet ��ʼ��");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         print("Session������");
    }

	/**
     * @see ����Http�����е����Ը��Ĳ���
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	//Http���Ա��滻֮ǰ��ֵ
    	String oldValue = String.valueOf(event.getValue());
    	
    	//�滻֮���ֵ
    	String newValue = String.valueOf(event.getSession().getAttribute(event.getName()));
    	UserList.removeUser(oldValue);
    	UserList.addUser(newValue);
    	print("Session:" + event.getSession().getId() + "����" + event.getName() 
    	+"��ֵ"+ oldValue+"���滻Ϊ" + newValue);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         print("Session������");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	print("ServletContext������");
    }
	//��message�ַ�����Ϣ�����txt�ļ�
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