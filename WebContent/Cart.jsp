<%@page import="com.bean.CartBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="super_container">
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="SideMenu.jsp"></jsp:include>
<jsp:include page="Slider.jsp"></jsp:include>
${pStatus}
<%int totalAmount = 0;
ArrayList<CartBean> cartList = (ArrayList<CartBean>)request.getAttribute("cartList");
System.out.println(cartList.size());
for (CartBean cbean : cartList)
{
totalAmount = totalAmount + cbean.getPrice();%>
	<%System.out.println("foor loop"); %>
	<%=cbean.getFname() %>|
	<%=cbean.getProname() %>|
	<%=cbean.getQty() %>|
	<%=cbean.getPrice() %>
	<a href="DeleteCartProductController?cartid=<%=cbean.getCart_id()%>">Delete</a>
	<br>
<% }%>
	<br><br>
	TotalAmount:<%=totalAmount %>
	<a href="CheckOut.jsp">Checkout</a>
<jsp:include page="NewsLetter.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>
<%
session.setAttribute("totalAmount",totalAmount);
%>
</div>
</body>
</html>