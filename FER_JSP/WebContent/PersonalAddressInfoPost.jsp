<%@page import="com.rs.bean.Expense"%>
<%@page import="com.rs.service.FERServiceImpl"%>
<%@page import="com.rs.service.FERService,java.util.List,com.rs.bean.PersonalInfo"%>

<%
	FERService service = new FERServiceImpl();
	PersonalInfo personalinfo = (PersonalInfo) session.getAttribute("personalinfo");
	personalinfo.getUser().seteMail(request.getParameter("email"));
	personalinfo.getUser().setMobileNumber(request.getParameter("Mobile"));
	
	String addressLine1 = personalinfo.getAddress().getAddressLine1();
	String addressLine2 = personalinfo.getAddress().getAddressLine2();
	String city = personalinfo.getAddress().getCity();
	String state = personalinfo.getAddress().getState();
	String country = personalinfo.getAddress().getCountry();
	int userId=personalinfo.getAddress().getUserid();
	
%>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<table border='1' align='center'>
		<tr>
		<td colspan='2' align='center'>UpdateAddress</td>
		</tr>
		<tr>
		<td>AddressLine1</td>
		<td><input type='text' name= 'addressLine1' value=<%= addressLine1 %>></td>
		</tr>
		<tr>
		<td>AddressLine2</td>
		<td><input type='text' name='addressLine2' value= <%=addressLine2 %>></td>
		</tr>
		<tr>
		<td>City</td>
		<td><input type='text' name='city' value= <%=city %>></td>
		</tr>
		</tr>
		<td>State</td>
		<td><input type='text' name='state' value= <%=state%>></td>
		</tr>
		<tr>
		<td>Country</td>
		<td><input type='text' name='country' value= <%= country%>></td>
		</tr>
	<tr>
		<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm("PersonalReviewInfoPost.jsp")'></td>
	</tr>
</table>
<jsp:include page="Footer.jsp"/>