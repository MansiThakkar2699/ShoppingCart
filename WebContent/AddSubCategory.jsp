<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>
<%@page import="com.bean.*" %>
<%@page import="com.dao.*" %>
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
					<h1>SubCategory</h1>
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
							<h3 class="card-title">Add Subcategory</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<%ArrayList<CategoryBean> categoryList=new CategoryDao().listCategory();%>
						<form role="form" method="post" action="AddSubCategory">
							<div class="card-body">
								<div class="form-group">
									<label for="exampleInputEmail1">Category</label> 
									<select name="cat_id" class="form-control">
									<% 
									for (CategoryBean b : categoryList){ 
									%>
									  <option value="<%=b.getCat_id()%>"><%=b.getCat_name() %></option>
									 <%
									}
									 %>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Subcategory</label> 
									<input
										type="text" class="form-control" name="subcat_name" id="exampleInputEmail1"
										placeholder="Enter Subcategory">
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