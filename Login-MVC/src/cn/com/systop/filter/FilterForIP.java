package cn.com.systop.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterForIP
 */
@WebFilter("/FilterForIP")
public class FilterForIP implements Filter {

    /**
     * Default constructor. 
     */
    public FilterForIP() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 获取当前请求IP地址
		String ip = request.getRemoteAddr();
		
		//截取IP地址前三位
		String ipBegin = ip.substring(0, 3);
		
		//判断IP地址前三位是不是192
		if("192".equals(ipBegin))
//		if(true)
		{
			request.setAttribute("errorip", "ip地址不正确 不能登陆");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
