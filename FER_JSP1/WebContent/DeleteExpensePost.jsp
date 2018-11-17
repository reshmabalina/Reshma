<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService"%>
<% 
        Expense expense = new Expense();
		FERService ferService = new FERServiceImpl();
		String iid = request.getParameter("expenseId");
		int expenseId = Integer.parseInt(iid);
		expense.setId(expenseId);
		boolean deleteExpenseFlag = ferService.deleteExpense(expense);
%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<% 		if (deleteExpenseFlag) {
			out.println("delete successfully");
		} else {
			out.println("delete failed");
		}
%>
<jsp:include page="Footer.jsp" />