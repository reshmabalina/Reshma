package com.rs.servlet;

import java.util.List;

import com.rs.bean.Expense;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class GetExpensesMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		FERService fer = new FERServiceImpl();

		List<Expense> expenses = fer.getExpenses();
		
		for (Expense expense : expenses) {
			System.out.println(expense.getExpenseType());
			System.out.println(expense.getId());
			System.out.println(expense.getFrom_date());
			System.out.println(expense.getPrice());
			System.out.println(expense.getNumberOfItems());
			System.out.println(expense.getTotalAccount());
			System.out.println(expense.getByWhom());

		}

	}

}
