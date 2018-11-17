<%@page import="com.rs.service.*"%>

<%
	FERService fer = new FERServiceImpl();
	
	String name = request.getParameter("username");
	String pwd = request.getParameter("password");
	
	boolean isUserValid = fer.login(name, pwd);
	String message = "<html><body>Incorrect username/password</body></html>";
	
	if (isUserValid) {
		session.setAttribute("username", name);
%>
		<jsp:include page="Dashboard.jsp" />
<% } else {
		out.println(message);
%>
		<jsp:include page="Login.html" />
<%	}
%>