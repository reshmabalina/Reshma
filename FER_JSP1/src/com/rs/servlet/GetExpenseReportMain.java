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

public class GetExpenseReportMain extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("GetExpenseReportMain.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FERService ferservice = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String expenseType = request.getParameter("expenseType");
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");

		List<Expense> expenses = ferservice.getExpenseReport(expenseType, fromdate, todate);

		if (expenses != null) {
			for (Expense expense : expenses) {
				HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());

				out.println("<table border='1' align='center'><tr>");
				out.println("<td hight=20px>Expense Type </td><td>Date</td><td>Price</td><td>Number Of Items</td><td>Total</td><td>By Whom</td></tr>"); 
				
				out.println("<tr><td>" +expense.getExpenseType()+"</td><td>"+ expense.getFrom_date() + "</td><td>"+expense.getPrice()+"</td><td>"+expense.getNumberOfItems()
				+"</td><td>"+expense.getTotalAccount()+"</td><td>"+expense.getByWhom()+"</td></tr></table>");

				HTMLUtil.displayFooter(out);
			}

		} else {
			out.println("no expense found");
		}

	}


	

}
