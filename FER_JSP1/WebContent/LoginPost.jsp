<%@page import="com.rs.service.*,com.rs.bean.User"%>  
<jsp:useBean id="user" class="com.rs.bean.User"/> 
<jsp:setProperty property="*" name="user"/>  

<%
FERService fer = new FERServiceImpl();
String name = request.getParameter("username");
String pwd = request.getParameter("password");
boolean isUserValid = fer.login(name, pwd);
if (isUserValid) {
	session.setAttribute("username", name);
%>
	<jsp:include page="Dashboard.jsp" />
<% } else {
	
%>
	<jsp:include page="Login.html" />
<%	}
%>