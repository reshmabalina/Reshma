<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService"%>

<%
       FERService ferService = new FERServiceImpl();

		String id = request.getParameter("expenseId");
		int idinfo=Integer.parseInt(id);
		session.setAttribute("Id", id); 
		Expense expense = ferService.getExpense(idinfo);
		if (expense != null) {
		%>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<table border='1' align='center'>
	<tr>
		<td colspan='2' align='center'>Edit Expense</td>
	</tr>
	<tr>
		<td>Expense Type</td>
		<td><input type='text' name='expensetype'
			value=<%=expense.getExpenseType()%>></td>
		</td>
	</tr>
	<tr>
		<td>Date</td>
		<td><input type='text' name='from_date'
			value=<%=expense.getFrom_date()%>></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input type='text' name='price' value=<%=expense.getPrice()%>></td>
	</tr>
	<tr>
		<td>Number Of Items</td>
		<td><input type='text' name='numberOfItems'
			value=<%=expense.getNumberOfItems()%>></td>
	</tr>
	<tr>
		<td>Total</td>
		<td><input type='text' name='total'
			value=<%=expense.getTotalAccount()%>></td>
	</tr>
	<tr>
		<td>By Whom</td>
		<td><input type='text' name='byWhom'
			value=<%=expense.getByWhom()%>></td>
	</tr>
	<tr>
		<td colspan='1' align='center'>
		<td><input type='submit' value='Save'
			onclick='javascript:submitForm("EditExpensePostStatus.jsp")'></td>
		</td>
	</tr>
</table>
<jsp:include page="Footer.jsp" />
<%}%>