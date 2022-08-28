<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.BrandBean"%>
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
					<h1>Brand</h1>
				</div>
			</div>
		</div>
		<!-- /.container-fluid --> </section>

		<section class="content">
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">List Brand</h3>
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
												<td>Brand Ids</td>
												<td>Brand Name</td>
												<td>Brand site</td>
												<td>Action</td>
											</tr>
										</thead>
										<tbody>
												
														
														<%
														ArrayList<BrandBean> brandList =(ArrayList<BrandBean>)request.getAttribute("brandList"); 
														for (BrandBean b : brandList)
														{ %>
														<tr>
															<td><%=b.getBrand_id()%></td>
															<td><%=b.getBrand_name()%></td>
															<td><%=b.getBrand_site() %></td>
															<td><a href="DeleteBrandController?brand_id=<%=b.getBrand_id()%>">Delete</a>|
																<a href="EditBrandController?brand_id=<%=b.getBrand_id()%>">Update</a></td>
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