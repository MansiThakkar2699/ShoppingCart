<%@page import="com.bean.UserBean"%>
<%@page import="com.dao.AddressDao"%>
<%@page import="com.bean.AddressBean"%>
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
<form action="CheckoutController" method="POST">
<%
//AddressBean abean = new AddressBean();
UserBean ubean = (UserBean)session.getAttribute("userBean");
int id = ubean.getId();
//System.out.println("id from addressbean" + id);
ArrayList<AddressBean> addresslist = new AddressDao().ListAddress(id);
int orderAmount = (Integer)session.getAttribute("totalAmount");
System.out.println(orderAmount);
int delCharge = 0;
if(orderAmount < 5000)
{
	delCharge = 100; 
}%>
DebitCardNo:-<input type="text" name="cardno"/><br/>
Cvv:<input type="text" name="cvv"/><br/>
OrderAmount:<input type="text" name="oamt" value = "<%=orderAmount %>" /><br/>
DeliveryCharge:<input type="text" name="dcharge" value = "<%= delCharge%>" /><br/>
TotalAmount:<input type="text" name="tamt"  value = "<%=orderAmount+ delCharge%>" /><br/>
ShippingAddress:<select name="add_id">
<%
	for (AddressBean ab : addresslist)
{%>
<option value="<%=ab.getAdd_id()%>"><%=ab.getAddress()%></option>
<% 
} 
%>
</select><br/>
ExpDate:<input type="text" name="exdate"/><br/>
Promocode:<input type="text" name="promocode"/><br/>
<input type="submit" value="Submit"/>
</form>
</body>
</html>