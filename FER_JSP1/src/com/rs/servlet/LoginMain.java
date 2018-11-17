package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.bean.User;
import com.rs.fer.util.HTMLUtil;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class LoginMain extends HttpServlet implements SingleThreadModel{

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("Login.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("LoginHttpServlet.doPost()");
		FERService fer = new FERServiceImpl();
		
		// super.doPost(req, resp);

		String name = request.getParameter("username");
		String pwd = request.getParameter("password");

		boolean isUserValid = fer.login(name, pwd);
		
		String message = isUserValid ? "<html><body>Welcome to the user........</body></html>" 
				: "<html><body>Incorrect username/password. Please try again with the valid credentials...</body></html>";
		System.out.println(message);
		
		PrintWriter out = response.getWriter();
		out.println(message);
		
		if(isUserValid) {
			request.getSession().setAttribute("username", name);
			
			HTMLUtil.displayHeaderAndLeftFrame(out, name);
			out.print(message);
			HTMLUtil.displayFooter(out);
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");
			requestDispatcher.include(request, response);
		}
	}

}
