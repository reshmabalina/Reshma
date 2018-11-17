package com.rs.servlet;

import com.rs.bean.Expense;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {
		FERService fer = new FERServiceImpl();

		Expense expense = fer.getExpense(2);
		if (expense != null) {
			System.out.println("Id:" + expense.getId() + " and expenseType:" + expense.getExpenseType());
		} else {

			System.out.println("no expense found for the given input");

		}
	}

}
