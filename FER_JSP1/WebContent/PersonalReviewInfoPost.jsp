<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService,java.util.List,com.rs.bean.PersonalInfo"%>

<%

FERService service=new FERServiceImpl();
PersonalInfo personalinfo=(PersonalInfo) session.getAttribute("personalInfo");
personalinfo.getAddress().setAddressLine1(request.getParameter("addressLine1"));
personalinfo.getAddress().setAddressLine2(request.getParameter("addressLine2"));
personalinfo.getAddress().setCity(request.getParameter("city"));
personalinfo.getAddress().setState(request.getParameter("state"));
personalinfo.getAddress().setCountry(request.getParameter("country"));
%>

<jsp:include page="Header.jsp"/>
<jsp:include page="LeftFrame.jsp"/>

<table border='1' align='center'>
	<tr>
		<td colspan='2' align='center'>Personal Info</td>
	</tr>

	<tr>
		<td>First Name</td>
		<td><%=personalinfo.getUser().getFirstName()%></td>
	</tr>

	<tr>
		<td>Last Name</td>
		<td><%=personalinfo.getUser().getLastName() %></td>
	</tr>

	<tr>
		<td>Email</td>
		<td><%= personalinfo.getUser().geteMail()%></td>
	</tr>

	<tr>
		<td>Mobile Number</td>
		<td><%= personalinfo.getUser().getMobileNumber()%></td>
	</tr>
	<tr>
		<td>Address Line1</td>
		<td><%=personalinfo.getAddress().getAddressLine1()%></td>
	</tr>
	<tr>
		<td>Address Line2</td>
		<td><%=personalinfo.getAddress().getAddressLine2() %></td>
	</tr>
	<tr>
		<td>City</td>
		<td><%=personalinfo.getAddress().getCity()%></td>
	</tr>
	<tr>
		<td>State</td>
		<td><%= personalinfo.getAddress().getState()%></td>
	</tr>

	<tr>
		<td>Country</td>
		<td><%= personalinfo.getAddress().getCountry()%></td>
	</tr>
	<tr>
		<td colspan='2'><input type='button' value='previous'
			onclick='javascript:submitForm("PersonalAddressInfoPost.jsp")'>
			<input type='button' value='update'
			onclick='javascript:submitForm("UpdatePersonalInfoStatus.jsp")'></td>
	</tr>
</table>
<jsp:include page="Footer.jsp"/>
