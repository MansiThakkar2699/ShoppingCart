<%@page import="java.util.*"%>
<%@page import="com.bean.CategoryBean" %>
<%@page import="com.bean.SubCategoryBean" %>
<%@page import="com.dao.CategoryDao" %>
<%@page import="com.dao.SubCategoryDao" %>
<%@page import="com.bean.BrandBean" %>
<%@page import="com.dao.BrandDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).on(
			"change",
			"#cat_id",
			function() {
					cat = document.getElementById("cat_id").value; 
				    var params = {cat_id :cat};

				$.get("GetSubcategoryViaCategory", $.param(params), function(responseJson) {
					var $select = $("#subcat_id");
					$select.find("option").remove();
					$.each(responseJson, function(index, scategory) {
						$("<option>").val(scategory.subcat_id).text(scategory.subcat_name)
								.appendTo($select);
					});

				});
			});
</script>
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
							<h3 class="card-title">Add Product</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<form role="form" method="post" action="AddProductController">
						<%ArrayList<CategoryBean> categoryList=new CategoryDao().listCategory();
						  ArrayList<SubCategoryBean> subcategoryList=new SubCategoryDao().listSubCategory();
						  ArrayList<BrandBean> brandList=new BrandDao().listBrand();
						%>
							<div class="card-body">
								<div class="form-group">
									<label for="exampleInputEmail1">Product Name</label> 
									<input
										type="text" class="form-control" name="proname" id="exampleInputEmail1"
										placeholder="Enter Product name">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Category</label> 
									<select name="cat_id" class="form-control" id="cat_id">
									<option value="-1">Please Select Category</option>
									<%
										for (CategoryBean b : categoryList )
										{%>
											<option value="<%=b.getCat_id()%>"><%=b.getCat_name()%></option>	
									<% }
									%>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Sub Category</label> 
									<select name="subcat_id" class="form-control" id="subcat_id">
									<%
										for (SubCategoryBean s : subcategoryList )
										{%>
											<option value="<%=s.getSubcat_id()%>"><%=s.getSubcat_name()%></option>
									<% 	}
									%>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Brand</label> 
									<select name="brand_id" class="form-control">
									<%
										for (BrandBean b : brandList)
										{%>
											<option value="<%=b.getBrand_id()%>"><%=b.getBrand_name() %></option>
										<%}
									%>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Price</label> 
									<input
										type="number" class="form-control" name="price" id="exampleInputEmail1"
										placeholder="Enter Price">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Quantity</label> 
									<input
										type="number" class="form-control" name="quantity" id="exampleInputEmail1"
										placeholder="Enter Quantity">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Product Information</label> 
									<input
										type="text" class="form-control" name="prodinfo" id="exampleInputEmail1"
										placeholder="Enter Product information">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Other Information</label> 
									<input
										type="text" class="form-control" name="otherinfo" id="exampleInputEmail1"
										placeholder="Enter Other Information">
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