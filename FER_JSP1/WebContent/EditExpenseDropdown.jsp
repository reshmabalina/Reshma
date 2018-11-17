<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService,java.util.List,java.util.Iterator"%>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
	FERService ferService = new FERServiceImpl();
	List<Expense> expenses = ferService.getExpenses();

	if (expenses != null && !expenses.isEmpty()) {
		out.println("ExpenseId:");
		out.println("<select name='expenseId'>");

		for (Expense expense : expenses) {
%>
<option value=<%=expense.getId()%>>
	<%=expense.getId()%>,<%=expense.getExpenseType()%>,<%=expense.getFrom_date()%>,<%=expense.getPrice()%>,<%=expense.getNumberOfItems()%>
	<%=expense.getTotalAccount()%>,<%=expense.getByWhom()%></option>
<%
	}
%>

<input type='button' value='Edit Expense'
	onclick='javascript:submitForm("EditExpensePost.jsp")'>
</select>
<%
	} else {
%>
<%
	out.println("No Expense Available to Edit");
	}
%>
<jsp:include page="Footer.jsp"></jsp:include>