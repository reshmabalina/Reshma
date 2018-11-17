package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.bean.Expense;
import com.rs.fer.util.HTMLUtil;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class DisplayDeleteExpenseDropdownServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("DeleteExpenseDropdown.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FERService ferService = new FERServiceImpl();

		HttpSession session = request.getSession();
		// String username = session.getAttribute("Username").toString();

		List<Expense> expenses = ferService.getExpenses();

		PrintWriter out = response.getWriter();

		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());

		if (expenses != null && !expenses.isEmpty()) {
			out.println("ExpenseId:");
			out.println("<select name='expenseId'>");
			for (Expense expense : expenses) {
				out.println("<option value=" + expense.getId() + ">");
				out.println(" " + expense.getId() + ", " + expense.getExpenseType() + ", " + expense.getTotalAccount()
						+ ", " + expense.getByWhom());
				out.println("</option>");
			}
			out.println("</select>");
			out.println(
					"<input type='button' value='delete' onclick=\"javascript:submitForm('deleteExpenseHS')\" ></td>");
		} else {
			out.println("No Expenses are Available To DELETE");
		}
		HTMLUtil.displayFooter(out);

	}
}
