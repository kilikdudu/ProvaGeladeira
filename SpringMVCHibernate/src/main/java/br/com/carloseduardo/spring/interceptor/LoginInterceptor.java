package br.com.carloseduardo.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		if (arg0.getRequestURI().compareTo("/SpringMVCHibernate/welcome") != 0 && arg0.getRequestURI().compareTo("/SpringMVCHibernate/login") != 0) {
			if(arg0.getSession().isNew()){
				arg1.sendRedirect(arg0.getContextPath() + "/welcome");
				return false;
			}
			else if((Integer)arg0.getSession().getAttribute("usuario_id") < 0){
				arg1.sendRedirect(arg0.getContextPath() + "/welcome");
				return false;
			}
		}
		return true;
	}
	
}
