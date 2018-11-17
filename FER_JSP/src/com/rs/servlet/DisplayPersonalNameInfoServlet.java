package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.bean.PersonalInfo;
import com.rs.bean.User;
import com.rs.fer.util.HTMLUtil;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class DisplayPersonalNameInfoServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("DisplayPersonalNameInfo.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		FERService ferservice = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();

		// String userId = request.getParameter("id");
		// int id = Integer.parseInt(userId);
		PersonalInfo personalinfo = ferservice.getPersonalInfo(username);

		session.setAttribute("personalinfo", personalinfo);

		HTMLUtil.displayHeaderAndLeftFrame(out,
				session.getAttribute("username").toString());
		
	
		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>UpdateName</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>FirstName</td>");
		out.println("<td><input type='text' name='firstName' value='"
				+ personalinfo.getUser().getFirstName() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>MiddleName</td>");
		out.println("<td><input type='text' name='middleName' value='"
				+ personalinfo.getUser().getMiddleName() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>LastName</td>");
		out.println("<td><input type='text' name='lastName' value='"
				+ personalinfo.getUser().getLastName() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"displayPersonalContact\");'></td>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</td>");
		out.println("</table>");
		HTMLUtil.displayFooter(out);
	}
}
