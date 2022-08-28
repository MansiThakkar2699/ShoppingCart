<%@page import="com.bean.ProductBean"%>
<%@page import="com.dao.ProductDao"%>
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
<form action ="AddProductImageController" method="POST" enctype="multipart/form-data">
<% ArrayList<ProductBean> productlist = new ProductDao().listProduct();%>
Product:<select name="productId">
<% 
for(ProductBean pb : productlist) 
{%>
<option value ="<%=pb.getProid()%>"><%=pb.getProname()%></option>
<% } %>
</select><br/>
Image:<input type="file" name = "img"/><br/>
<input type="submit" value="Submit"/>
</form>
${message}
</body>
</html>