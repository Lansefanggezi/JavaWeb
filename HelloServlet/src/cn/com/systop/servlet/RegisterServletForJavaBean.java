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
		// ����request�ַ������ʽ
		request.setCharacterEncoding("gb2312");
		
		//������������
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
		
		//�ѷ�װ��UserInfo����󣬷ŵ�request������
		request.setAttribute("userInfo", userInfo);
		
		//����ת��
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