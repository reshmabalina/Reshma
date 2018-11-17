<%@page import="com.rs.service.FERServiceImpl"%>
<%
	String username = request.getParameter("username"); 
    String expenseType = request.getParameter("expenseType");

	boolean isUsernameAvailabe = new FERServiceImpl().isUsernameAvailable(username);
	boolean isExpenseTypeAvailable = new FERServiceImpl().isExpenseTypeAvailable(expenseType);
	
	out.println(isExpenseTypeAvailable ? "Y" : "N");
%>