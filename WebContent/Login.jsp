<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginController" method="POST">
Email:<input type="email" name="email"><br/>
Password:<input type="password" name="password"><br/>
<input type="submit" value="Submit"><br/>
<a href="forgotpassword.jsp">ForgotPassword</a>
<a href="SignUp.jsp">SignUp</a>
</form>
${loginError}
</body>
</html>