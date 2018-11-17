<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService"%>

<%
	FERService ferservice = new FERServiceImpl();

	String username = session.getAttribute("username").toString();
	String password = request.getParameter("currentpassword");
	String newPassword = request.getParameter("newpassword");

	boolean resetPasswordFlag = ferservice.resetPassword(username, password, newPassword);
%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
	if (resetPasswordFlag) {
		out.println("Password Updated Successfully");
	} else {
		out.println("Unable to reset Password");
		out.println("<a href=\"javascript:history.go(-1)\">Back</a>");
	}
%>

<jsp:include page="Footer.jsp" />
