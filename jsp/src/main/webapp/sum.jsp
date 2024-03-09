<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="sum.jsp">
			<table>
				<tr>
					<td>Num1</td>
					<td><input type="text" name="num1"></td>
				</tr>
				<tr>
					<td>Num2</td>
					<td><input type="text" name="num2"></td>
				</tr>
			</table>
			<input type="submit" value="Add">
		</form>
	</div>
	<%!int num1, num2, sum;%>
	<%
	String input1 = request.getParameter("num1");
	String input2 = request.getParameter("num2");
	if (input1 != null && input2 != null) {
		num1 = Integer.parseInt(input1);
		num2 = Integer.parseInt(input2);
		sum = num1 + num2;
	%>
	<div align="center">
		<h4>
			Sum of
			<%=num1%>
			and
			<%=num2%>
			is
			<%=sum%></h4>
	</div>
	<%
	}
	%>

</body>
</html>