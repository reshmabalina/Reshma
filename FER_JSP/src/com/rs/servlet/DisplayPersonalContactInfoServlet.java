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
import com.rs.fer.util.HTMLUtil;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class DisplayPersonalContactInfoServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("DisplayPersonalContactInfo.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		FERService service = new FERServiceImpl();
		HttpSession session = request.getSession();
		PersonalInfo personalinfo = (PersonalInfo) session
				.getAttribute("personalinfo");
		PrintWriter out = response.getWriter();

		personalinfo.getUser().setFirstName(request.getParameter("firstName"));
		personalinfo.getUser()
				.setMiddleName(request.getParameter("middleName"));
		personalinfo.getUser().setLastName(request.getParameter("lastName"));

		HTMLUtil.displayHeaderAndLeftFrame(out,
				session.getAttribute("username").toString());

		out.println("<table border='1' align='center'>");

		out.println("<tr>");
		out.println("<td>Emailid</td>");
		out.println("<td><input type='text' name='email' value='"
				+ personalinfo.getUser().geteMail() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Mobile</td>");
		out.println("<td><input type='text' name='Mobile' value='"
				+ personalinfo.getUser().getMobileNumber() + "'></td>");

		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"displayPersonalAddress\");'></td>");
		out.println("</tr>");
		out.println("</table>");
		HTMLUtil.displayFooter(out);

	}

}
