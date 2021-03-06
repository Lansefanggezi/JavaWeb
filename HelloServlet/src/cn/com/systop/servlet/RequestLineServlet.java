package cn.com.systop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestLineServlet
 */
@WebServlet("/RequestLineServlet")
public class RequestLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestLineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设定字符集
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		//返回HTTP请求消息中的请求方式
		out.println("请求消息中的请求方式" + request.getMethod() + "<br>");
		
		//返回请求行中的资源名部分
		out.println("请求行中的资源名部分" + request.getRequestURI() + "<br>");
		
		//返回请求行中的参数部分
		out.println("请求行中的参数部分" + request.getQueryString() + "<br>");
		
		//返回请求行中的协议名和版本
		out.print("请求行中的协议名和版本" + request.getProtocol() + "<br>");
		
		//返回请求URL所属于的Web应用程序的路径
		out.println("请求URL所属于的Web应用程序的路径" + request.getContextPath() + "<br>");
		
		//返回请求URL中的额外路径信息
		out.println("请求URL中的额外路径信息" + request.getPathInfo() + "<br>");
		
		//返回Servlet的名称或Servlet所映射的路径
		out.println("Servlet的名称或Servlet所映射的路径" + request.getServletPath() + "<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
