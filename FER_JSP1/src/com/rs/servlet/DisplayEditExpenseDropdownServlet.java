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

public class DisplayEditExpenseDropdownServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("DisplayEditExpenseDropdown.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		FERService ferservice = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		List<Expense> expenses = ferservice.getExpenses();

		if (expenses != null && !expenses.isEmpty()) {
			out.println("Expense ID: ");

			out.println("<select name='expenseID'>");

			for (Expense expense : expenses) {
				out.println("<option value=" + expense.getId() + ">");
				out.println("  " + expense.getId() + ","
						+ expense.getExpenseType() + "," + expense.getFrom_date()
						+ "," + expense.getPrice() + ","
						+ expense.getNumberOfItems() + "," + expense.getTotalAccount()
						+ "," + expense.getByWhom());
				out.println("</option>");
			}
			out.println("</select>");
			out.println("<input type='button' value='Edit Expense' onclick=\"javascript:submitForm('displayEditExpense')\">");
		} else {
			out.println("No Expense Available to Edit");
		}
		HTMLUtil.displayFooter(out);

	
}


}
