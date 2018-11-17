package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.util.HTMLUtil;

public class DisplayResetPasswordServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("DisplayResetPassword.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getSession().getAttribute("username").toString();

		PrintWriter out = response.getWriter();

		HTMLUtil.displayHeaderAndLeftFrame(out, name);
		
		out.println(" <table border='1' align='center'>");
		out.println("<tr colspan='2'>");
		out.println("<td>Current Password</td>");
		out.println("<td><input type='text' name='currentpassword' value=''></td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>New Password</td>");
		out.println("		<td><input type='password' name='newpassword' value=''>");
		out.println("		</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Confirm Password</td>");
		out.println("		<td><input type='password' name='confirmpassword' value=''>");
		out.println("		</td>");
		out.println("	</tr>");
		
		out.println("	<tr>");
		out.println("		<td colspan='2' align='center'><input type='button'");
		out.println("		value='Reset' onclick=\"javascript:submitForm('resetPassword')\"></td>");
		out.println("	</tr>");

		out.println("</table>");
		HTMLUtil.displayFooter(out);

}
}
