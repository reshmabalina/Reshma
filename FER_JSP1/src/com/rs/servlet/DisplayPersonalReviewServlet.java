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

public class DisplayPersonalReviewServlet extends HttpServlet {
	
	/*@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("DisplayPersonalReview.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}*/
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		FERService service=new FERServiceImpl();
		PrintWriter out=response.getWriter();
		
		PersonalInfo personalinfo=(PersonalInfo) session.getAttribute("personalinfo");
		
		personalinfo.getAddress().setAddressLine1(request.getParameter("addressLine1"));
		personalinfo.getAddress().setAddressLine2(request.getParameter("addressLine2"));
		personalinfo.getAddress().setCity(request.getParameter("city"));
		personalinfo.getAddress().setState(request.getParameter("state"));
		//personalinfo.getAddress().setZip(request.getParameter("zip"));
		personalinfo.getAddress().setCountry(request.getParameter("country"));
	
		HTMLUtil.displayHeaderAndLeftFrame(out,session.getAttribute("username").toString());
		
		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td>First Name</td>");
		out.println("<td>" +personalinfo.getUser().getFirstName() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Middle Name</td>");
		out.println("<td>"+ personalinfo.getUser().getMiddleName() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Last Name</td>");
		out.println("<td>"+ personalinfo.getUser().getLastName() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Email Id</td>");
		out.println("<td>"+ personalinfo.getUser().geteMail() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Mobile Number</td>");
		out.println("<td>"+ personalinfo.getUser().getMobileNumber() + "</td>");
		out.println("</tr>");
		
		
		out.println("<tr>");
		out.println("<td>AddressLine1</td>");
		out.println("<td>"+ personalinfo.getAddress().getAddressLine1() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>AddressLine2</td>");
		out.println("<td>"+ personalinfo.getAddress().getAddressLine2() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td>"+ personalinfo.getAddress().getCity() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td>"+ personalinfo.getAddress().getState() + "</td>");
		out.println("</tr>");

		/*out.println("<tr>");
		out.println("<td>Zip</td>");
		out.println("<td>"+ personalinfo.getAddress().getZip() + "</td>");
		out.println("</tr>");*/
		
		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("<td>"+ personalinfo.getAddress().getCountry() + "</td>");
		out.println("</tr>");
		



		out.println("<tr>");
		out.println("<td colspan='2'>");
		out.println("<input type='button' value='previous' onclick='javascript:submitForm(\"displayPersonalAddress\");'>");
		out.println("<input type='button' value='update' onclick='javascript:submitForm(\"updatePersonalInfo\");'></td>");
		out.println("</tr>");
		out.println("</table>");
		
		HTMLUtil.displayFooter(out);
	}


}
