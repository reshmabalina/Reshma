
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<script>  
		var request;  
		function isExpenseTypeAvailable() {  
			var expenseType = document.AddExpenseForm.expenseType.value;  
			var url="FER_AJAX.jsp?expenseType="+expenseType;  
		  
			//alert('url: '+url);
			if(window.XMLHttpRequest){  
				request=new XMLHttpRequest();
				//alert('XMLHTTPRequest');
			}  
			else if(window.ActiveXObject){  
				request=new ActiveXObject("Microsoft.XMLHTTP");
				//alert('ActiveXObject');
			}  
		  
			try {  
				request.onreadystatechange=displayStatus;  
				request.open("GET",url,true);  
				request.send();  
			}  
			catch(e) {  
				alert("Unable to connect to server");  
			}  
		}  
		  
		function displayStatus(){  
			if(request.readyState==4){  
				var response = request.responseText;
				//alert('Response:'+response+"...");
				//alert('Response:'+response.trim()+"...");
				var statusTdIdObj = document.getElementById('statusId');
				if(response.trim() == 'Y') {
					var str = "Expense is available...";
				    var result = str.fontcolor("green");
					statusTdIdObj.innerHTML= result;
				}
				else {
					var str = "Expense is not available...";
				    var result = str.fontcolor("red");
					statusTdIdObj.innerHTML= result;
				}
				
				document.getElementById('statusTrId').style.display='';
			}  
		}
	
		function vaidateForm() {
			var form = document.AddExpenseForm;
			
			var errorMessages = "";
			
			if(form.expenseType == null || form.expenseType.value == '') {
				errorMessages += "Please enter expenseType<br>";
			}
			if(form.from_date == null || form.from_date.value == '') {
				errorMessages += "Please enter from_date<br>";
			}
			if(form.price == null || form.price.value == '') {
				errorMessages += "Please enter price<br>";
			}
			if(form.numberOfItems == null || form.numberOfItems.value == '') {
				errorMessages += "Please enter numberOfItems<br>";
			}
			if(form.total == null || form.total.value == '') {
				errorMessages += "Please enter total<br>";
			}
			if(form.byWhom == null || form.byWhom.value == '') {
				errorMessages += "Please enter byWhom<br>";
			}
			
			
			if(errorMessages != '') {
				//alert(errorMessages);
				
				var errorIdObj = document.getElementById('errorId');
				errorIdObj.innerHTML = errorMessages.fontcolor('red');
				
				document.getElementById('errorTrId').style.display='';
			}
			else {
				document.getElementById('errorTrId').style.display='none';
				
				form.submit();
			}
		}
	</script>
	<body>
		<form action="AddExpensePost.jsp" method="post" name="AddExpenseForm">

		<table border='1' align='center'>
			<tr id="errorTrId" style='display: none;'>
				<td colspan="2"><span id="errorId"> </span></td>
			</tr>
			<tr>
				<td>Expense Type</td>
				<td><input type='text' name='expenseType'
					onchange="isExpenseTypeAvailable();"></td>
			</tr>
			<tr id="statusTrId" style='display: none;'>
				<td colspan="2"><span id="statusId"> </span></td>
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
				<td><input type='text' name='total'></td>
			</tr>
			<tr>
				<td>By Whom</td>
				<td><input type='text' name='byWhom'></td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit'
					value='Save'  onclick="vaidateForm();"></td><!-- onclick='javascript:submitForm("AddExpensePost.jsp")' -->
			</tr>
		</table>
	</form>
</body>

<jsp:include page="Footer.jsp" />