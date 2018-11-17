package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

public class DeleteExpenseMain extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("DeleteExpenseMain.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("DeleteExpenseHttpServlet.doPost()");

		Expense expense = new Expense();
		FERService ferService = new FERServiceImpl();
		HttpSession session = request.getSession();
		String iid = request.getParameter("expenseId");
		int expenseId = Integer.parseInt(iid);
		expense.setId(expenseId);
		boolean deleteExpenseFlag = ferService.deleteExpense(expense);
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());

		if (deleteExpenseFlag) {
			out.println("delete successfully");
		} else {
			out.println("delete failed");
		}
		HTMLUtil.displayFooter(out);

	}
}
