package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.util.HTMLUtil;

public class DisplayAddExpenseServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("AddExpenseDropdown.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getSession().getAttribute("username").toString();

		PrintWriter out = response.getWriter();

		HTMLUtil.displayHeaderAndLeftFrame(out, name);

		out.println("<table border='1' align='center'>");
		out.println("	<tr>");
		out.println("<td colspan='2' align='center'>Add Expense</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td><input type='text' name='expenseType'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td><input type='text' name='from_date'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Price</td>");
		out.println("<td><input type='text' name='price'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Number Of Items</td>");
		out.println("<td><input type='text' name='numberOfItems'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Total</td>");
		out.println("<td><input type='text' name='total'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>By Whom</td>");
		out.println("<td><input type='text' name='byWhom'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='1' align='center'>");
		out.println("<!-- <a href='AddExpenseStatus.html'>Save</a> -->");
		out.println("<td><input type='submit' value='Save' onclick='javascript: submitForm(\"addExpenseHS\")'></td>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(out);

	}

}
