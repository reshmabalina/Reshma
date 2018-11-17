<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService"%>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
String expenseType = request.getParameter("expenseType");
String from_date = request.getParameter("from_date");
String price = request.getParameter("price");
String numberOfItems = request.getParameter("numberOfItems");
String total = request.getParameter("total");
String byWhom = request.getParameter("byWhom");


Expense expense = new Expense();
FERService ferService = new FERServiceImpl();
expense.setId(Integer.parseInt(session.getAttribute("Id").toString()));
expense.setExpenseType(expenseType);
expense.setFrom_date(from_date);
expense.setPrice(Float.parseFloat(price));
expense.setNumberOfItems(Float.parseFloat(numberOfItems));
expense.setTotalAccount(Float.parseFloat(total));
expense.setByWhom(byWhom);


boolean iseditExpense = ferService.editExpense(expense);

if(iseditExpense){ 

out.println("expense has edited successfully..");
}else{
	out.println("expense has edited Failed....");
}
		%>

<jsp:include page="Footer.jsp" />