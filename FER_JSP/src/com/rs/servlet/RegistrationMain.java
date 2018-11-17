package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.bean.User;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class RegistrationMain extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("Registration.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RegistrationHttpServlet.doPost()");
		// super.doPost(req, resp);

		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String eMail = request.getParameter("email");
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		
        FERService fer = new FERServiceImpl();
		
		User user = new User();
		// user.setId(2);
		user.setFirstName(firstName);
		user.setMiddleName(middleName);
		user.setLastName(lastName);
		user.seteMail(eMail);
		user.setUserName(name);
		user.setPassword(pwd);
		user.setMobileNumber(mobile);

		boolean isRegistration = fer.registration(user);
		//System.out.println(reg);

		String message = isRegistration ? "<html><body>User Registration Successfully........</body></html>" 
							: "<html><body>User Registration not Successfully...</body></html>";
	    System.out.println(message);
	    
	    PrintWriter out = response.getWriter();
		out.println(message);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(isRegistration ? "Login.html" : "Registration.html");
		requestDispatcher.include(request, response);
		

	}

}
