<%@page import="com.bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.customsize {
	height: 100px;
	max-width: none !IMPORTANT;
	width: 100px !IMPORTANT;
	padding-bottom: 30px;
}

.customsize:hover {
	-ms-transform: scale(2.5); / IE 9 /
	-webkit-transform: scale(2.5); / Safari 3-8 /
	transform: scale(2.5);
}
</style>

</head>
<body>
	<div class="super_container">
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="SideMenu.jsp"></jsp:include>
		<jsp:include page="Slider.jsp"></jsp:include>
		<jsp:include page="Category.jsp"></jsp:include>
		<%
			ArrayList<ProductBean> product = (ArrayList<ProductBean>) request.getAttribute("product");
			ProductBean pbmain = product.get(0);
		%>
		<div class="products">
			<div class="section_container">
				<div class="container">
					<div class="row">
						<div class="col-md-9">
							<div class="products_container grid">

								<!-- Product -->
								<div class="product grid-item hot">
									<%
										for (ProductBean pb : product) {
									%>
									<div class="product_inner">
										<div class="product_image">
											<img src="product_images/<%=pb.getProid()%>/main.jpg" alt="">
											<div class="product_tag">hot</div>
										</div>
										<div class="product_content text-center">
											<div class="product_title">
												<a href="#"><%=pb.getProname()%></a>
											</div>
											<div class="product_price"><%=pb.getPrice()%></div>
											<div class="product_price"><%=pb.getProdinfo()%></div>
											<div class="product_price"><%=pb.getOtherinfo()%></div>
											<%
												System.out.println(pb.getProid());
											%>
											<div class="product_button ml-auto mr-auto trans_200">
												<a href="CartController?proid=<%=pb.getProid()%>">add to
													cart</a>
											</div>
										</div>
									</div>
									<%
										}
									%>
								</div>
							</div>
						</div>



						<div class="col-md-3">
							<div class="products_container grid">

								<!-- Product -->
								<div class="product grid-item">
									<div class="product_inner">
										<div class="">
											<img class="customsize"
												src="product_images/<%=pbmain.getProid()%>/main.jpg" alt="">
										</div>
										<div class=" ">
											<img class="customsize"
												src="product_images/<%=pbmain.getProid()%>/front.jpg" alt="">
										</div>

										<div class=" ">
											<img class="customsize"
												src="product_images/<%=pbmain.getProid()%>/back.jpg" alt="">
										</div>

										<div class="">
											<img class="customsize"
												src="product_images/<%=pbmain.getProid()%>/side.jpg" alt="">
										</div>

									</div>
								</div>
							</div>
						</div>





					</div>
				</div>
			</div>
		</div>
		<jsp:include page="NewsLetter.jsp"></jsp:include>
		<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>