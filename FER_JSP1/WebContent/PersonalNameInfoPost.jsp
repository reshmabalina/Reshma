<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService,java.util.List,com.rs.bean.PersonalInfo"%>

<%
	FERService ferservice = new FERServiceImpl();
	String username = session.getAttribute("username").toString();
	PersonalInfo personalinfo = ferservice.getPersonalInfo(username);
	session.setAttribute("personalinfo", personalinfo);
%>

<%
		String firstName = personalinfo.getUser().getFirstName();
		String middleName = personalinfo.getUser().getMiddleName();
		String lastName = personalinfo.getUser().getLastName();
%>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<table border='1' align='center'>
	<tr>
		<td colspan='2' align='center'>Update Name</td>
	</tr>
	<tr>
		<td>First Name</td>
		<td><input type='text' name='firstName' value=<%=firstName%>></td>
	</tr>
	<tr>
		<td>Middle Name</td>
		<td><input type='text' name='middleName' value=<%=middleName%>></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type='text' name='lastName' value=<%=lastName%>></td>
	</tr>
	<tr>
		<td colspan='2' align='center'><input type='button' value='Next'
			onclick='javascript:submitForm("PersonalContactInfoPost.jsp")'></td>
		</td>
	</tr>
	</td>
</table>
<jsp:include page="Footer.jsp"/>