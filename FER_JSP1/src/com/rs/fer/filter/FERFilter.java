package com.rs.fer.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FERFilter implements Filter{

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("FERFilter.init()");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FERFilter.doFilter()");
		boolean isSpecialCharAvailable = false;
		String parameterName = null;
		String parameterValue = null;
		
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			parameterName = parameterNames.nextElement();
			parameterValue = request.getParameter(parameterName);
			
			System.out.println(parameterName+" : "+parameterValue);
			
			if(parameterValue.contains("%")) {
				isSpecialCharAvailable = true;
				break;
			}
		}
		
		if(isSpecialCharAvailable) {
			PrintWriter out = response.getWriter();
			out.println("Special character % is not allowed for the input field: "+parameterName);
			out.println("<BR>");
			out.println("Please go <a href='javascript: history.go(-1);'>Back</a> to proceed further...");
		}
		else {
			chain.doFilter(request, response);
		}
		
	}
	
	@Override
	public void destroy() {
		System.out.println("FERFilter.destroy()");
	}

}
