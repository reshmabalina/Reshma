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

public class DisplayPersonalAddressInfoServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("DisplayPersonalAddressInfo.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		FERService service=new FERServiceImpl();
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		PersonalInfo personalinfo=(PersonalInfo) session.getAttribute("personalinfo");
		
		personalinfo.getUser().seteMail(request.getParameter("email"));
		personalinfo.getUser().setMobileNumber(request.getParameter("Mobile"));
		
		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		
		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>UpdateAddress</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>AddressLine1</td>");
		out.println("<td><input type='text' name='addressLine1' value='"
				+ personalinfo.getAddress().getAddressLine1() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>AddressLine2</td>");
		out.println("<td><input type='text' name='addressLine2' value='"
				+ personalinfo.getAddress().getAddressLine2() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='text' name='city' value='"
				+ personalinfo.getAddress().getCity()+ "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='text' name='state'  value='"
				+ personalinfo.getAddress().getState() + "'></td>");
		/*out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Zip</td>");
		out.println("<td><input type='text' name='zip' value='"
				+ personalinfo.getAddress().getZip() + "'></td>");*/
		
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("<td><input type='text' name='country' value='"
				+ personalinfo.getAddress().getCountry() + "'></td>");
		
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"dispalyPersonalReview\");'></td>");
		out.println("</tr>");
		out.println("</table>");
		
		HTMLUtil.displayFooter(out);
	}

}
