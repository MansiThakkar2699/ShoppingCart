<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.CategoryBean"%>
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
					<h1>Category</h1>
				</div>
			</div>
		</div>
		<!-- /.container-fluid --> </section>

		<section class="content">
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">List Category</h3>
					</div>

					<div class="card-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper dt-bootstrap4">

							<div class="row">
								<div class="col-sm-12">
									<table id="listdata"
										class="table table-bordered table-striped dataTable dtr-inline">
										<thead>
											<tr>
												<td>Category Id</td>
												<td>Category Name</td>
												<td>Action</td>
											</tr>
										</thead>
										<tbody>
												
														<tr>
														<%
														ArrayList<CategoryBean> categoryList = (ArrayList<CategoryBean>) request.getAttribute("categoryList");
														for (CategoryBean bean : categoryList)  
														{
														%>
															<td><%=bean.getCat_id()%></td>
															<td><%=bean.getCat_name()%></td>
															<td><a href="DeleteCategoryController?cat_id=<%=bean.getCat_id()%>">Delete</a>|
																<a href="EditCategoryController?cat_id=<%=bean.getCat_id()%>">Update</a></td>
														</tr>
													<%
													}
													%>
												</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>

	</div>
	<jsp:include page="AdminFooter.jsp"></jsp:include>
</body>
</html>