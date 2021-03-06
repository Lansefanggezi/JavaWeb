package cn.com.systop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForCookie
 */
@WebServlet("/ServletForCookie")
public class ServletForCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置相关字符格式
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/Html");
		
		//输出类
		PrintWriter out = response.getWriter();
		
		//构建页面
		out.println("<!DOCTYPE html>");
		out.println("<HTML>");
		out.println("<HEAD> <title>次页</title>");

		out.println("<meta http-equiv='content-type' content='text/Html;charset=gb2312'>");
		
		out.println("</HEAD>");
		out.println("<BODY>");
		out.print("这是一个页面<br>");
		out.print("欢迎到来！");
		
		//获取用户名
		String name = request.getParameter("userName");
		
		//创建Cookie
		Cookie cookie = new Cookie("name", name);
		//URLEncoder.encode(name, "UTF-8");
		
		//向客户端添加Cookie
		response.addCookie(cookie);
		
		//打印用户名
		out.print("<br>用户名" +name );
		
		//隐藏表单域
		out.print("<form name='form1' method='post' action='ServletForHidden' >");
		
		//设置hidden类型的name
		out.print("<input name='username' type='hidden' value='"+name+"'>");
		
		//提交按钮
		out.print("<input type='submit' name='submit' value='提交'>");
		out.print("</form>");
		
		//通过URL传递参数
		out.print("<a href=ServletForHidden?username="+ name +" value='url传递'>" );
		
		out.print("</BODY>");
		out.print("</HTML>");
		
		out.flush();
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
