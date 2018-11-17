package com.rs.fer.util;

import java.io.PrintWriter;

public class HTMLUtil {

	public static void displayHeaderAndLeftFrame(PrintWriter out, String username) {
		out.println("<html>");
		out.println("		<head>");
		out.println("			<title>FER-Dashboard</title>");
		out.println("			<script>");
		out.println("				function submitForm(action) {");
		out.println("					var form = document.DashboardForm; ");
		out.println("					form.action = action;");
		out.println("					form.method = 'post';");
		out.println("					form.submit();");
		out.println("				}");
		//out.println("				history.go(1); ");		
		out.println("			</script>");

		out.println("</head>");
		out.println("<body>");
		out.println("<form name='DashboardForm' action=''>");
		out.println("<table border='1' align='center' width='800px' height='600px'>");
		out.println("<tr height='100px'>");
		out.println("<td colspan='2' align='center'>");
		out.println("Family Expense Report");
		out.println("User : " + username);
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width='150px'> ");
		out.println("<a href='javascript: submitForm(\"displayAddExpense\")'>Add Expense</a><br>");
		out.println("<a href='javascript: submitForm(\"displayEditExpenseDropdown\")'>Edit Expense</a><br>");
		out.println("<a href='javascript: submitForm(\"displayDeleteExpenseDropdown\")'>Delete Expense</a><br>");
		out.println("<a href='javascript: submitForm(\"displayGetExpenseReport\")'>Expense Report</a><br>");
		out.println("<a href='javascript: submitForm(\"displayResetPassword\")'>Reset Password</a><br>");
		out.println("<a href='javascript: submitForm(\"displayPersonalName\")'>Update Personal</a><br>");
		out.println("</td>");
		out.println("<td>");
	}

	public static void displayFooter(PrintWriter out) {
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr height='100px'>");
		out.println("<td colspan='2' align='center'>");
		out.println("Footer");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
