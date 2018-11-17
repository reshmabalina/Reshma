package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.bean.Expense;
import com.rs.bean.User;
import com.rs.fer.util.HTMLUtil;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class RestPasswordMain extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("ResetPasswordMain.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("RestPasswordeHttpServlet.doPost()");

		FERService ferservice = new FERServiceImpl();
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		String password = request.getParameter("currentpassword");
		String newPassword = request.getParameter("newpassword");

		boolean resetPasswordFlag = ferservice.resetPassword(username, password, newPassword);
		
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, request.getSession().getAttribute("username").toString());
		
		if (resetPasswordFlag) {
			out.println("Password Updated Successfully");
		} else {
			out.println("Unable to reset Password");
			out.println("<a href=\"javascript:history.go(-1)\">Back</a>");
		}
		HTMLUtil.displayFooter(out);

	}
}