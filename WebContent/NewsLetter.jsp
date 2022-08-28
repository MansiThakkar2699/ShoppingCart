<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="newsletter">
		<div class="parallax_background parallax-window" data-parallax="scroll" data-image-src="resources/images/newsletter.jpg" data-speed="0.8"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2">
					<div class="newsletter_content text-center">
						<div class="newsletter_title_container">
							<div class="newsletter_title">subscribe to our newsletter</div>
							<div class="newsletter_subtitle">we won't spam, we promise!</div>
						</div>
						<div class="newsletter_form_container">
							<form action="NewsLetterController" id="newsletter_form" class="newsletter_form" method="post">
								<input type="text" class="newsletter_input" placeholder="your e-mail here" required="required" name="email"/>
								<input type="submit" class="newsletter_button" value="Submit"/>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>