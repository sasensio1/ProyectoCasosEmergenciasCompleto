package com.casosemergencias.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.casosemergencias.model.HerokuUser;


public class UserFilter implements Filter {

	final static Logger logger = Logger.getLogger(UserFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("UserFilter -- inicio");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		HerokuUser user = (HerokuUser) session.getAttribute("user");
	         
	        if (user == null){
	        	logger.debug("UserFilter -- usuario NO esta en sesion");

	        	//Si la url contiene /casosEmergencias, estamos trabajando en local. En caso contrario estamos trabajando en Heroku y no tenemos el path
	    		StringBuffer url = req.getRequestURL();
	    		if(url.indexOf("/casosEmergencias")>0){
	    			resp.sendRedirect("/casosEmergencias");
	    		}else{
	    			resp.sendRedirect("/");
	    		}
	    		
	        }else{
	        	logger.debug("UserFilter -- usuario esta en sesion");
	        	chain.doFilter(request, response);
	        }

		logger.info("UserFilter -- fin");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}