package com.zhide.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhide.constStr.GlobalConst;
import com.zhide.entity.LoginCondition;
import com.zhide.entity.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
//		验证用户是否登陆
		Object user = request.getSession().getAttribute(GlobalConst.USER_SESSION_KEY);
		if (null ==user) {
			response.sendRedirect("/jsp/Index.jsp");
		}
		return true;
	}

}
