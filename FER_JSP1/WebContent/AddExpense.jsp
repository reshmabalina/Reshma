
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<table border='1' align='center'>
	<tr>
		<td>Expense Type</td>
		<td><input type='text' name='expenseType'></td>
	</tr>
	<tr>
		<td>Date</td>
		<td><input type='text' name='from_date'></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input type='text' name='price'></td>
	</tr>
	<tr>
		<td>Number Of Items</td>
		<td><input type='text' name='numberOfItems'></td>
	</tr>
	<tr>
		<td>Total</td>
		<td><input type='text' name='totalAccount'></td>
	</tr>
	<tr>
		<td>By Whom</td>
		<td><input type='text'name='byWhom'></td>
	</tr>
	<tr>
		<td>User Id</td>
		<td><input type='text'name='userid'></td>
	</tr>
	<tr>
		<td colspan='2' align='center'>
			<input type='submit' value='Save' onclick='javascript:submitForm("AddExpensePost.jsp")'>
		</td>
	</tr>
</table>

<jsp:include page="Footer.jsp" />