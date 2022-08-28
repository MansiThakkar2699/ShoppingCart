<%@page import="com.bean.AddressBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<AddressBean> listaddress = (ArrayList<AddressBean>) request.getAttribute("addressList");
		for (AddressBean abean : listaddress) {
	%>
	<td><%=abean.getFname()%></td>
	<td><%=abean.getAddress()%></td>
	</tr>
	<%
		}
	%>
	<a href="AddAddress.jsp">AddAddress</a>
</body>
</html>