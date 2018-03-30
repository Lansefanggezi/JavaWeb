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
		// ����Servlet������
		javax.servlet.ServletContext servletContext = getServletContext();
		
		//����http��Ӧ���ĵ�mime���ͺ��ַ�����
		response.setContentType("text/html;charset=gb2312");
		
		//���HTML�ĵ�
		PrintWriter out = response.getWriter();
		
		//���ݸ����Ĳ�����������WebӦ�÷�Χ�ڵ�ƥ��ĳ�ʼ������ֵ
		out.println("����WebӦ�÷�Χ�ڵ�ƥ��ĳ�ʼ������ֵ:" 
		+ servletContext.getInitParameter("weburl") + "<br>");
		
		//���ݲ���ָ��������·���������ļ�ϵͳ�е�һ����ʵ��·��
		out.println("�����ļ�ϵͳ�е�һ����ʵ��·��" + 
		servletContext.getRealPath("/WEB-INF") + "<br>");
		
		//���ز���ָ�����ļ���mime����
		out.print("���ز���ָ�����ļ���mime����" + 
		servletContext.getMimeType("/WEB-INF/Web.xml") + "<br>");
		
		//����Servlet������Java Servlet API�����汾��
		out.println("Servlet������Java Servlet API�����汾�� " + 
		servletContext.getMajorVersion() + "<br>");
		
		//����Servlet���������ֺͰ汾
		out.println("����Servlet���������ֺͰ汾" +
		servletContext.getServerInfo());
		
		//�ر�Print Writer
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
