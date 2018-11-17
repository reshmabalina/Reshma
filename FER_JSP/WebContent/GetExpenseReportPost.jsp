<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService,java.util.List,java.util.Iterator"%>

<%
FERService ferservice = new FERServiceImpl();

		String expenseType = request.getParameter("expenseType");
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");

		List<Expense> expenses = ferservice.getExpenseReport(expenseType, fromdate, todate);
%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%if (expenses != null) {
	for (Expense expense : expenses) { %>
<table border='1' align='center'>
	<tr>
		<td>Expense Type</td>
		<td>Date</td>
		<td>Price</td>
		<td>Number Of Items</td>
		<td>Total Amount</td>
		<td>By Whom</td>

	</tr>
	<tr>
		<td><%=expense.getExpenseType()%></td>
		<td><%=expense.getFrom_date()%></td>
		<td><%=expense.getPrice()%></td>
		<td><%=expense.getNumberOfItems()%></td>
		<td><%=expense.getTotalAccount()%></td>
		<td><%=expense.getByWhom()%></td>
	</tr>

	<%
	}
	%>
	<% }else {
%>
	<% out.println("no expense found");
}
%>