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
		//��������ַ���ʽ
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/Html");
		
		//�����
		PrintWriter out = response.getWriter();
		
		//����ҳ��
		out.println("<!DOCTYPE html>");
		out.println("<HTML>");
		out.println("<HEAD> <title>��ҳ</title>");

		out.println("<meta http-equiv='content-type' content='text/Html;charset=gb2312'>");
		
		out.println("</HEAD>");
		out.println("<BODY>");
		out.print("����һ��ҳ��<br>");
		out.print("��ӭ������");
		
		//��ȡ�û���
		String name = request.getParameter("userName");
		
		//����Cookie
		Cookie cookie = new Cookie("name", name);
		//URLEncoder.encode(name, "UTF-8");
		
		//��ͻ�������Cookie
		response.addCookie(cookie);
		
		//��ӡ�û���
		out.print("<br>�û���" +name );
		
		//���ر�����
		out.print("<form name='form1' method='post' action='ServletForHidden' >");
		
		//����hidden���͵�name
		out.print("<input name='username' type='hidden' value='"+name+"'>");
		
		//�ύ��ť
		out.print("<input type='submit' name='submit' value='�ύ'>");
		out.print("</form>");
		
		//ͨ��URL���ݲ���
		out.print("<a href=ServletForHidden?username="+ name +" value='url����'>" );
		
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