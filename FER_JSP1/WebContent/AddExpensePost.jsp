<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService"%>
<jsp:useBean id="expense" class="com.rs.bean.Expense"/> 
<jsp:setProperty property="*" name="expense"/>  

<%
/* String expenseType = request.getParameter("expenseType");
String from_date = request.getParameter("from_date");
String price = request.getParameter("price");
String numberOfItems = request.getParameter("numberOfItems");
String total = request.getParameter("totalAccount");
String byWhom = request.getParameter("byWhom");
String userid = request.getParameter("userid");  */

	FERService fer = new FERServiceImpl();
	boolean isAddExpense = fer.addExpense(expense);
	String message = isAddExpense ? "Expense Added Successfully........" : "Expenses add failed...";
	session.setAttribute("ADD_EXPENSE_STATUS", message);
%>

<jsp:include page="AddExpenseStatus.jsp" />