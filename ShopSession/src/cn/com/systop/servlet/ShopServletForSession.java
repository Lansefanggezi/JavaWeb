package cn.com.systop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShopServletForSession
 */
@WebServlet("/ShopServletForSession")
public class ShopServletForSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServletForSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符格式
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("gb2312");
		
		//获取Session
		HttpSession session =  request.getSession();
		Integer itemCount = (Integer)session.getAttribute("itemCount");
		
		//判断是否为空
		if(null == itemCount)
		{
			itemCount = new Integer(0);
		}
		
		//获取输出对象
		PrintWriter out = response.getWriter();
		
		//接受传过来的参数
		String[] itemSelected ;
		String itemName;
		itemSelected = request.getParameterValues("item");
		if(itemSelected != null)
		{
			for(int i = 0; i<itemSelected.length; i++)
			{
				itemName = itemSelected[i];
				
				//在Session中传入Bug对象
				session.setAttribute("item" + i, itemName);
			}
			
			//Buy对象总数
			itemCount = itemSelected.length;
			session.setAttribute("itemCount", itemCount);
			session.setAttribute("itemList", itemSelected);
		}
		
		request.getRequestDispatcher("Message.jsp").forward(request, response);
//		out.println("<HTML>");
//		out.print("<HEAD>");
//		out.print("<TITLE>Item List</TITLE>");
//		out.print("</HEAD>");
//		out.print("<BODY>");
//		out.print("<h4>Session List</h4>");
//		out.print("<br><br><br><br>");
//		
//		out.print("总数：${sessionScope.itemCount}");
//		
//		out.print("</BODY>");
//		out.println("</HTML>");
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
