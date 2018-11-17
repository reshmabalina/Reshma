<html>
	<head>
		<script>
		     function submitForm(action) {
		  var form=document.DashboardForm;
		  form.action=action;
		  form.submit();
		  }
		</script>
	</head>
	
	<body>
		<form name='DashboardForm'>
			<table border='10' align='center' height='600px' width='800px'>
				<tr height='100px'>
					<td colspan='2' align='center'>Family Expense Report User: ${username }
					</td>
				</tr>