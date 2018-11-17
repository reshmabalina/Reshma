package com.rs.service;

import java.util.List;

import com.rs.bean.Address;
import com.rs.bean.Expense;
import com.rs.bean.PersonalInfo;
import com.rs.bean.User;

public interface FERService {

	public boolean registration(User user);

	public boolean addExpense(Expense expense);

	public boolean editExpense(Expense expense);

	public boolean deleteExpense(Expense expense);

	public boolean login(String userName, String password);

	public boolean resetPassword(String userName, String currentpassword, String newpassword);

	public Expense getExpense(int id);

	public List<Expense> getExpenses();

	public List<Expense> getExpenseReport(String expenseType, String fromDate, String toDate);

	PersonalInfo getPersonalInfo(String username);

	boolean updatePersonalInfo(User user, Address address);

	//public Expense gerExpenseFromId(String id);
	
	boolean isUsernameAvailable(String username);
	
	boolean isExpenseTypeAvailable(String expenseType);
		

}
