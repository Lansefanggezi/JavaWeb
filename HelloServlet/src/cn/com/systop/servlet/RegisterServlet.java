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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setContentType("text/Html;charset=gb2312");
		request.setCharacterEncoding("gb2312");
		String charset = request.getCharacterEncoding();
		
		//从请求获取数据
		
		String userName = request.getParameter("userName");
		
		String password = request.getParameter("password");
		
		String sex = request.getParameter("sex");
		
		String country = request.getParameter("country");
		
		String[] likes = request.getParameterValues("likes");
		
		String remark = request.getParameter("remark");
		
		//设置response的字符集
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		out.println(userName + "<br>");
		out.println(password + "<br>");
		out.println(sex + "<br>");
		out.println(country + "<br>");
		for(int i = 0; i<likes.length;i++){
			out.println(likes[i] + "<br>");
		}
		out.println(remark + "<br>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
