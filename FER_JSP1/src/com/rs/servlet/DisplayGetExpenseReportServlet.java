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
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class DisplayGetExpenseReportServlet extends HttpServlet {
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("DisplayGetExpenseReport.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		FERService ferservice= new FERServiceImpl();
		PrintWriter out=response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		
		out.println("<table border='10' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Get Expense</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td><input type='text' name='expenseType'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>FromDate</td>");
		out.println("<td><input type='text' name='fromdate'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>ToDate</td>");
		out.println("<td><input type='text' name='todate'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button'");
		out.println("value='Get Report' onclick=\"javascript:submitForm('getExpenseReport')\"></td>");
		out.println("</tr>");
		out.println("</table>");
		
		HTMLUtil.displayFooter(out);
	}


}
