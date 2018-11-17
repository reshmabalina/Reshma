<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">Reset Password</td>
	</tr>
	<tr>
		<td>Current Password</td>
		<td><input type='text' name='currentpassword' value=''></td>
	</tr>
	<tr>
		<td>New Password</td>
		<td><input type='password' name='newpassword' value=''></td>
	</tr>
	<tr>
		<td>Confirm Password</td>
		<td><input type='password' name='confirmpassword' value=''></td>
	</tr>
	<tr>
		<td colspan='2' align='center'><input type='button' value='Reset'
			onclick='javascript:submitForm("ResetPasswordPost.jsp")'></td>
	</tr>
</table>

<jsp:include page="Footer.jsp" />