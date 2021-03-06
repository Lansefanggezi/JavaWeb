package cn.com.systop.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.systop.javabean.UserInfo;

/**
 * Servlet implementation class RegisterServletForJavaBean
 */
@WebServlet("/RegisterServletForJavaBean")
public class RegisterServletForJavaBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServletForJavaBean() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置request字符编码格式
		request.setCharacterEncoding("gb2312");
		
		//从请求获得数据
		UserInfo userInfo = new UserInfo();
		
		userInfo.setUserName(request.getParameter("userName"));
		
		userInfo.setPasswold(request.getParameter("password"));;
		
		userInfo.setSex(request.getParameter("sex"));
		
		userInfo.setCountry(request.getParameter("country"));;
		
		
		String[] likes = request.getParameterValues("likes");
		String likeStr = "";
		for(int i = 0; i<likes.length;i++)
		{
			likeStr = likeStr + likes[i];
		}
		userInfo.setLikes(likeStr);
		
		userInfo.setRemark(request.getParameter("remark"));
		
		//把封装的UserInfo类对象，放到request作用域
		request.setAttribute("userInfo", userInfo);
		
		//请求转发
		request.getRequestDispatcher("success.jsp").forward(request, response);
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
