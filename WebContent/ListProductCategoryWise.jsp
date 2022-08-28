<%@page import="com.bean.ProductBean" %>
<%@page import="java.util.ArrayList" %>
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
<jsp:include page="Category.jsp"></jsp:include>
<%ArrayList<ProductBean> products = (ArrayList<ProductBean>)request.getAttribute("products");%>
<div class="products">
		<div class="section_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="products_container grid">
							
							<!-- Product -->
								<div class="product grid-item hot">
								<%for(ProductBean pb : products) 
								{%>
									<div class="product_inner">
										<div class="product_image">
											<img src="product_images/<%=pb.getProid() %>/main.jpg" alt="">
											<div class="product_tag">hot</div>
										</div>
										<div class="product_content text-center">
											<div class="product_title"><a href="ViewProductDetailController?proid=<%=pb.getProid()%>"><%=pb.getProname() %></a></div>
											<div class="product_price"><%=pb.getPrice() %></div>
											<%if(pb.getQuntity() > 0)
											{%>
											<div class="product_button ml-auto mr-auto trans_200"><a href="#">add to cart</a></div>
											<%}else{ %>
											<div class="product_button ml-auto mr-auto trans_200"><a href="#">Out of stock</a></div>
											<%} %>								
											</div>
									</div>	
								<% }  %>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="NewsLetter.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>