package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.bean.Expense;
import com.rs.fer.util.HTMLUtil;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

import sun.font.SunFontManager.FamilyDescription;

public class DisplayEditExpenseServlet extends HttpServlet {

	FERService ferService = new FERServiceImpl();
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("DisplayEditExpense.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();

		FERService ferService = new FERServiceImpl();

		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		String id = request.getParameter("expenseID");
		int idinfo=Integer.parseInt(id);
		session.setAttribute("Id", id);
		Expense expense = ferService.getExpense(idinfo);
		if (expense != null) {
			out.println("<table border='1' align='center'>");
			out.println("	<tr>");
			out.println("<td colspan='2' align='center'>Edit Expense</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Expense Type</td>");
			out.println("<td><input type='text' name='expenseType' value="+expense.getExpenseType()+"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Date</td>");
			out.println("<td><input type='text' name='from_date' value="+expense.getFrom_date()+"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Price</td>");
			out.println("<td><input type='text' name='price' value="+expense.getPrice()+"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Number Of Items</td>");
			out.println("<td><input type='text' name='numberOfItems' value="+expense.getNumberOfItems()+"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Total</td>");
			out.println("<td><input type='text' name='total' value="+expense.getTotalAccount()+"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>By Whom</td>");
			out.println("<td><input type='text' name='byWhom' value="+expense.getByWhom()+"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td colspan='1' align='center'>");
			// out.println("<!-- <a href='editExpenseStatus.html'>Save</a>
			// -->");
			out.println(
					"<td><input type='submit' value='Save' onclick='javascript: submitForm(\"editExpense\")'></td>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");

			HTMLUtil.displayFooter(out);

		}

	}
}