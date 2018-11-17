<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<table border='1' align='center'>
<tr>
		<td colspan='2' align='center'>Expense Report</td>
	</tr>
	<tr>
		<td>Expense Type</td>
		<td><input type='text' name='expenseType'></td>
	</tr>
	<tr>
		<td>FromDate</td>
		<td><input type='text' name='fromdate'></td>
	</tr>
	<tr>
		<td>ToDate</td>
		<td><input type='text' name='todate'></td>
	</tr>
	<tr>
		<td colspan='2' align='center'><input type='button'
			value='Get Report' onclick='javascript:submitForm("GetExpenseReportPost.jsp")'></td>
	</tr>

</table>
<jsp:include page="Footer.jsp" />