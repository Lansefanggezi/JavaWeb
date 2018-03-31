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
 * Servlet implementation class ServletForHidden
 */
@WebServlet("/ServletForHidden")
public class ServletForHidden extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForHidden() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符格式
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		//从Cookie取值
		Cookie[] cookies = request.getCookies();
		String nameForCookie = null;
		
		for(int i = 0; i<cookies.length; i++)
		{
			Cookie one = cookies[i];
			if("name".equals(one.getName()))
			{
				nameForCookie = one.getValue();
			}
			out.println(one.getName()+":"+ one.getValue()+"<br>");
		}
		
		//从URL中获取数据
		String nameUrl = request.getParameter("username");
		
		//从隐藏表单域获取数据
		String nameHidden = request.getParameter("username");
		
		out.println("打印Cookie中获取的值：" + nameForCookie + "<br>");
		out.println("打印URL中获取的数据：" + nameUrl + "<br>");
		out.println("打印隐藏表单域获取数据：" + nameHidden + "<br>");
		
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
