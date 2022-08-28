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
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6">
					<!-- general form elements -->
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Edit Brand</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<form role="form" method="post" action="UpdateBrandController">
							<input type="hidden" name="brand_id" value="${b.brand_id}"/>
							<div class="card-body">
								<div class="form-group">
									<label for="exampleInputEmail1">Brand Name</label> 
									<input
										type="text" class="form-control" name="brand_name" id="exampleInputEmail1"
										value="${b.brand_name}">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Brand Site</label> 
									<input
										type="text" class="form-control" name="brand_site" id="exampleInputEmail1"
										value="${b.brand_site}">
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