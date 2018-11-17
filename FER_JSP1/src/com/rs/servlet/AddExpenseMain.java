package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.bean.Expense;
import com.rs.fer.util.HTMLUtil;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class AddExpenseMain extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("AddExpenseMain.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AddExpenseHttpServlet.doPost()");

		String expenseType = request.getParameter("expenseType");
		String from_date = request.getParameter("from_date");
		String price = request.getParameter("price");
		String numberOfItems = request.getParameter("numberOfItems");
		String total = request.getParameter("total");
		String byWhom = request.getParameter("byWhom");

		FERService fer = new FERServiceImpl();
		
		Expense expense=new Expense();
		
		expense.setExpenseType(expenseType);
		expense.setFrom_date(from_date);
		expense.setPrice(Float.parseFloat(price));
		expense.setNumberOfItems(Float.parseFloat(numberOfItems));
		expense.setTotalAccount(Float.parseFloat(total));
		expense.setByWhom(byWhom);
		expense.setUserid(1);
		
		boolean isAddExpense = fer.addExpense(expense);
		
		String message = isAddExpense ? "Expense Added Successfully........" : "Expense add failed...";

		System.out.println(message);

		PrintWriter out = response.getWriter();
		
		HTMLUtil.displayHeaderAndLeftFrame(out, request.getSession().getAttribute("username").toString());
		
		out.println(message);
		
		HTMLUtil.displayFooter(out);

	}
}
