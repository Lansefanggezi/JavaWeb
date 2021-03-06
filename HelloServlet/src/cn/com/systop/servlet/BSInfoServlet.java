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
 * Servlet implementation class BSInfoServlet
 */
@WebServlet("/BSInfoServlet")
public class BSInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BSInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符格式
		response.setContentType("text/Html;charset=gb2312");
		
		PrintWriter out = response.getWriter();
		
		//返回发出请求客户端的IP地址
		out.println("发出请求客户端的IP地址:" + request.getRemoteAddr() + "<br>");
		
		//返回发出请求的客户端的完整主机名
		out.println("发出请求的客户端的完整主机名:" + request.getRemoteHost() + "<br>");
		
		//返回发出请求的客户端所使用的网络接口的端口号
		out.println("出请求的客户端所使用的网络接口的端口号:" + request.getRemotePort() + "<br>");
		
		//返回Web服务器上接收当前请求的网络接口的IP地址
		out.println("Web服务器上接收当前请求的网络接口的IP地址:" + request.getLocalAddr() + "<br>");
		
		//返回Web服务器上接受当前请求的网络接口的IP地址所对应的主机名
		out.println("Web服务器上接受当前请求的网络接口的IP地址所对应的主机名:" + request.getLocalName() + "<br>");
		
		//返回Web服务器上接受当前请求的网络接口的端口号
		out.println("Web服务器上接受当前请求的网络接口的端口号:" + request.getLocalPort() + "<br>");
		
		//返回当前请求所指向的主机名
		out.println("当前请求所指向的主机名:" + request.getServerName() + "<br>");
		
		//返回当前请求所连接的服务器端口号
		out.println("当前请求所连接的服务器端口号:" + request.getServerPort() + "<br>");
		
		//返回请求的协议名
		out.println("请求的协议名:" + request.getScheme());
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
