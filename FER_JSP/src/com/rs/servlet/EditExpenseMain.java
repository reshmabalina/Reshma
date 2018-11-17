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

public class EditExpenseMain extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("EditExpense.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String expenseType = request.getParameter("expenseType");
		String from_date = request.getParameter("from_date");
		String price = request.getParameter("price");
		String numberOfItems = request.getParameter("numberOfItems");
		String total = request.getParameter("total");
		String byWhom = request.getParameter("byWhom");

		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, request.getSession().getAttribute("username").toString());
				HttpSession session = request.getSession();
		Expense expense = new Expense();
		FERService ferService = new FERServiceImpl();
		expense.setId(Integer.parseInt(session.getAttribute("Id").toString()));
		expense.setExpenseType(expenseType);
		expense.setFrom_date(from_date);
		expense.setPrice(Float.parseFloat(price));
		expense.setNumberOfItems(Float.parseFloat(numberOfItems));
		expense.setTotalAccount(Float.parseFloat(total));
		expense.setByWhom(byWhom);
		//expense.setId(request.getParameter("id"));

		boolean iseditExpense = ferService.editExpense(expense);
		
		if(iseditExpense){ 

		out.println("expense has edited successfully..");
		}else{
			out.println("expense has edited Failed....");
		}
		HTMLUtil.displayFooter(out);	}


}
