<%@page import="com.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="AdminHeader.jsp"></jsp:include>
	<jsp:include page="AdminSideMenu.jsp"></jsp:include>

	<div class="content-wrapper" style="min-height: 324px;">
		<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Product</h1>
				</div>
			</div>
		</div>
		<!-- /.container-fluid --> </section>

		<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6">
					<!-- general form elements -->
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Edit Product</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<form role="form" method="post" action="UpdateProductController">
							<div class="card-body">
							<input type="hidden" name="proid" value="${pbean.proid}"/>
								<div class="form-group">
									<label for="exampleInputEmail1">Product Name</label> 
									<input
										type="text" class="form-control" name="proname" id="exampleInputEmail1"
										value="${pbean.proname}">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Category</label>
									<input type="text" class="form-control" name="cat_id" value="${pbean.cat_id}"/>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Sub Category</label> 
									<input type="text" class="form-control" name="subcat_id" value="${pbean.subcat_id}"/>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Brand</label> 
									<input type="text" class="form-control" name="brand_id" value="${pbean.brand_id}"/>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Price</label> 
									<input
										type="number" class="form-control" name="price" id="exampleInputEmail1"
										value="${pbean.price}">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Quantity</label> 
									<input
										type="number" class="form-control" name="quantity" id="exampleInputEmail1"
										value="${pbean.price}">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Product Information</label> 
									<input
										type="text" class="form-control" name="prodinfo" id="exampleInputEmail1"
										value="${pbean.prodinfo}">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Other Information</label> 
									<input
										type="text" class="form-control" name="otherinfo" id="exampleInputEmail1"
										value="${pbean.otherinfo}">
								</div>
							</div>
							<!-- /.card-body -->

							<div class="card-footer">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
					</div>
					<!-- /.card -->
				</div>
			</div>
		</div>
		</section>
	</div>
	<jsp:include page="AdminFooter.jsp"></jsp:include>
</body>
</html>