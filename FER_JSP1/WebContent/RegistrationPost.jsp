<%@page import="com.rs.service.*,com.rs.bean.User"%>  
<jsp:useBean id="user" class="com.rs.bean.User"/> 
<jsp:setProperty property="*" name="user"/>  

<%
FERService fer = new FERServiceImpl();
boolean isRegistration = fer.registration(user);
if (isRegistration) {
	out.print("You are successfully registered");
%>
<jsp:include page="Login.html" />
<%
	} else {
%>
<jsp:include page="Registration.html" />
<%
	}
%>