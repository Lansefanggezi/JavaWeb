package cn.com.systop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext
 */
@WebServlet("/ServletContext")
public class ServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 或许Servlet上下文
		javax.servlet.ServletContext servletContext = getServletContext();
		
		//设置http响应正文的mime类型和字符编码
		response.setContentType("text/html;charset=gb2312");
		
		//输出HTML文档
		PrintWriter out = response.getWriter();
		
		//根据给定的参数名，返回Web应用范围内的匹配的初始化参数值
		out.println("返回Web应用范围内的匹配的初始化参数值:" 
		+ servletContext.getInitParameter("weburl") + "<br>");
		
		//根据参数指定的虚拟路径，返回文件系统中的一个真实的路径
		out.println("返回文件系统中的一个真实的路径" + 
		servletContext.getRealPath("/WEB-INF") + "<br>");
		
		//返回参数指定的文件中mime类型
		out.print("返回参数指定的文件中mime类型" + 
		servletContext.getMimeType("/WEB-INF/Web.xml") + "<br>");
		
		//返回Servlet容器的Java Servlet API的主版本号
		out.println("Servlet容器的Java Servlet API的主版本号 " + 
		servletContext.getMajorVersion() + "<br>");
		
		//返回Servlet容器的名字和版本
		out.println("返回Servlet容器的名字和版本" +
		servletContext.getServerInfo());
		
		//关闭Print Writer
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

}
