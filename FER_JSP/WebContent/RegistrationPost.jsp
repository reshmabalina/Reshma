<%@page import="com.rs.bean.User, com.rs.service.*"%>

<%
	String firstName = request.getParameter("firstName");
	String middleName = request.getParameter("middleName");
	String lastName = request.getParameter("lastName");
	String eMail = request.getParameter("email");
	String name = request.getParameter("username");
	String pwd = request.getParameter("password");
	String mobile = request.getParameter("mobile");

	User user = new User();

	user.setFirstName(firstName);
	user.setMiddleName(middleName);
	user.setLastName(lastName);
	user.seteMail(eMail);
	user.setUserName(name);
	user.setPassword(pwd);
	user.setMobileNumber(mobile);

	FERService fer = new FERServiceImpl();
	boolean isRegistration = fer.registration(user);
	//System.out.println(reg);

	String message = isRegistration ? "<html><body>User Registration Successfully........</body></html>"
			: "<html><body>User Registration not Successfully...</body></html>";
	System.out.println(message);

	out.println(message);

	if (isRegistration) {
%>
<jsp:include page="Login.html" />
<%
	} else {
%>
<jsp:include page="Registration.html" />
<%
	}
%>