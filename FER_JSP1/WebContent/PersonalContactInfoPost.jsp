<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService,java.util.List,com.rs.bean.PersonalInfo"%>

<%
	FERService service = new FERServiceImpl();
	PersonalInfo personalinfo = (PersonalInfo) session.getAttribute("personalinfo");
	personalinfo.getUser().setFirstName(request.getParameter("firstName"));
	personalinfo.getUser().setMiddleName(request.getParameter("middleName"));
	personalinfo.getUser().setLastName(request.getParameter("lastName"));
	String username = session.getAttribute("username").toString();
	String email = personalinfo.getUser().geteMail();
	String mobileNumber = personalinfo.getUser().getMobileNumber();
%>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<table border='1' align='center'>
	<tr>
		<td colspan='2' align='center'>Contact Information</td>
	</tr>
	<tr>
		<td>Emailid</td>
		<td><input type='text' name='email' value=<%=email%>></td>
	</tr>
	<tr>
		<td>Mobile</td>
		<td><input type='text' name='Mobile' value=<%=mobileNumber%>></td>
	</tr>
	<tr>
		<td colspan='2' align='center'><input type='button' value='Next'
			onclick='javascript:submitForm("PersonalAddressInfoPost.jsp")'></td>
	</tr>
</table>
<jsp:include page="Footer.jsp"/>