<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<title>Wanderlust</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		
		<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
		<script src="<c:url value="/resources/js/skel.min.js"/>"></script>
		<script src="<c:url value="/resources/js/skel-layers.min.js"/>"></script>
		<script src="<c:url value="/resources/js/init.js"/>"></script>

			<link href="<c:url value="/resources/css/skel.css"/>" rel="stylesheet"/>
			<link href="<c:url value="/resources/css/style.css"/>"  rel="stylesheet"/>
			<link href="<c:url value="/resources/css/style-xlarge.css"/>" rel="stylesheet"/>
		
	</head>
	<body>

		<!-- Header -->
			<header id="header" class="skels-layers-fixed">
				<h1><strong><a href="home.htm">Wanderlust</a></strong></h1>
				<nav id="nav">
					<ul>
						<li><a href="home.htm">Home</a></li>
						
					</ul>	
				</nav>
			</header>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="container">
					
					<!-- Form -->
						<section>
							<h3>Log-In with your Username</h3>
							<form:form  action="login.htm" method="post"  commandName="user" id ="login">
								<div class="row uniform 50%">
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="username" name="username" id="username" value="" placeholder="Username" />
										<form:errors path="username"/>
									</div>
									<div class="6u$ 12u$(xsmall)">
										<form:input type="password" path="password" name="password" id="password" value="" placeholder="Password" />
										<form:errors path="password"/>
									</div>
									
									
									<div class="12u$">
										<ul class="actions">
											<li><input type="submit" value="login" class="special" /></li>
										
										</ul>
									</div>
								</div>
							</form:form>
							<ul class="alt">
							<li></li>
							<li>Don't have an account ?  &nbsp<a href="sign.htm">Sign Up</a></li></li>
										
									</ul>
						</section>

				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="container">
					<ul class="icons">
						<li><a href="#" class="icon fa-facebook"></a></li>
						<li><a href="#" class="icon fa-twitter"></a></li>
						<li><a href="#" class="icon fa-instagram"></a></li>
					</ul>
					<ul class="copyright">
						<li>&copy; TEMPLATED</li>
						
					</ul>
				</div>
			</footer>

	</body>
</html>