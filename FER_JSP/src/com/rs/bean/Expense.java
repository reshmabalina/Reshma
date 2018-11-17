package com.rs.bean;

public class Expense {
	
	private int id;
	private String expenseType;
	private String from_date;
	private float price;
	private float numberOfItems;
	private float totalAccount;
	private String byWhom;
	private int userid;
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(float numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public float getTotalAccount() {
		return totalAccount;
	}
	public void setTotalAccount(float totalAccount) {
		this.totalAccount = totalAccount;
	}
	public String getByWhom() {
		return byWhom;
	}
	public void setByWhom(String byWhom) {
		this.byWhom = byWhom;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

}
