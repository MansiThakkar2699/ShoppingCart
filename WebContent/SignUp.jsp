<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String fnameError=(String)request.getAttribute("fnameError"); 
String lnameError=(String)request.getAttribute("lnameError");
String genderError=(String)request.getAttribute("genderError");
String emailError=(String)request.getAttribute("emailError");
String passwordError=(String)request.getAttribute("passwordError");
String securityqueError=(String)request.getAttribute("securityqueError");
String securityansError=(String)request.getAttribute("securityansError");%>
<form action="SignUpController" method="POST">
FirstName:<input type="text" name="fname">
<%
	if(fnameError!=null)
	{
		out.print(fnameError);
	}
%><br>
LastName:<input type="text" name="lname">
<% 
	if(lnameError!=null)
	{
		out.print(lnameError);
	}
%><br>
Gender:<input type="radio" name="gender" value="M">Male<input type="radio" name="gender" value="F">Female
<% 
	if(genderError!=null)
	{
		out.print(genderError);
	}
%><br>
Email:<input type="email" name="email">
<% 
	if(emailError!=null)
	{
		out.print(emailError);
	}
%><br>
Password:<input type="password" name="password">
<% 
	if(passwordError!=null)
	{
		out.print(passwordError);
	}
%><br>
SecurityQue:<select name="securityque">
<option>What is your favourite color?</option>
<option>Which is your First School?</option>
<option>What is your name?</option>
</select>
<br/>
SecurityAns:<input type="text" name="securityans"/>
<br/>
<input type="submit" value="Submit">
</form>
</body>
</html>