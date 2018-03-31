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
		// �����ַ���ʽ
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		//��Cookieȡֵ
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
		
		//��URL�л�ȡ����
		String nameUrl = request.getParameter("username");
		
		//�����ر����ȡ����
		String nameHidden = request.getParameter("username");
		
		out.println("��ӡCookie�л�ȡ��ֵ��" + nameForCookie + "<br>");
		out.println("��ӡURL�л�ȡ�����ݣ�" + nameUrl + "<br>");
		out.println("��ӡ���ر����ȡ���ݣ�" + nameHidden + "<br>");
		
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
