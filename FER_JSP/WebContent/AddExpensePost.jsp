<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService"%>

<%
	String expenseType = request.getParameter("expenseType");
	String from_date = request.getParameter("from_date");
	String price = request.getParameter("price");
	String numberOfItems = request.getParameter("numberOfItems");
	String total = request.getParameter("total");
	String byWhom = request.getParameter("byWhom");

	FERService fer = new FERServiceImpl();
	Expense expense = new Expense();

	expense.setExpenseType(expenseType);
	expense.setFrom_date(from_date);
	expense.setPrice(Float.parseFloat(price));
	expense.setNumberOfItems(Float.parseFloat(numberOfItems));
	expense.setTotalAccount(Float.parseFloat(total));
	expense.setByWhom(byWhom);
	expense.setUserid(1);

	boolean isAddExpense = fer.addExpense(expense);

	String message = isAddExpense ? "Expense Added Successfully........" : "Expenses add failed...";
	session.setAttribute("ADD_EXPENSE_STATUS", message);
%>

<jsp:include page="AddExpenseStatus.jsp" />