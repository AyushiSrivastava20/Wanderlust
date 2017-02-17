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
			<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
            <script src="//code.jquery.com/jquery-1.10.2.js"></script>
            <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
		
	</head>
	
	<body>
<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
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
							<h3>Sign-up</h3>
							<form:form action="sign.htm" method="post" commandName="user" id ="sign">
								<div class="row uniform 50%">
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="firstname" name="firstname" id="firstname" pattern="[a-zA-Z]*"  maxlength="25" title="Enter a valid First name" placeholder="Firstname" />
										<font color="red"><form:errors path="firstname"/></font>
									</div>
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="lastname" name="lastname" id="lastname" pattern="[a-zA-Z]*"  maxlength="25" title="Enter a valid Last name" placeholder="Lastname" />
										<font color="red"><form:errors path="lastname"/></font>
									</div>
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="phone" name="phone" id="phone" pattern="[0-9]{10}" title="Enter a  valid Phone Number 10 digits only" placeholder="Phoneno" />
										<font color="red"><form:errors path="phone"/></font>
									</div>
									
									<div class="6u$ 12u$(xsmall)">
										<form:input type="email" path="email" name="email" id="email" value="" placeholder="Email" />
										<font color="red"><form:errors path="email"/></font>
									</div>
									
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="username" name="username" id="username" onblur="checkUnique()" pattern="[a-z0-9_-]{6,18}" maxlength="25" title="Enter a valid username should be minimum 6 length" placeholder="Username" />
										<font color="red"><form:errors path="username"/></font>
									</div>
									
									
									<div class="6u$ 12u$(xsmall)">
										<form:input type="password" path="password" name="password" id="password" pattern="[a-z0-9_-]{6,18}" title="Min password length should be 6 and should not have special characters" placeholder="Password" />
									</div>
									
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="city" name="city" id="city" value="" placeholder="City" pattern="[a-zA-Z]*" title="Enter a valid City"/>
										<font color="red"><form:errors path="city"/></font>
									</div>
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="state" name="state" id="state" value="" placeholder="State"  pattern="[a-zA-Z]*" title="Enter a valid State"/>
										<font color="red"><form:errors path="state"/></font>
									</div>
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="country" name="country" id="country" value="" placeholder="Country" title="Enter a valid Country"/>
										<font color="red"><form:errors path="country"/></font>
									</div>
									<div class="6u$ 12u$(xsmall)">
	                                        <div class="select-wrapper">
											<form:select path="role" name="role" id="role">
												<form:option value="">- Role -</form:option>
											    <form:option value="h">Host</form:option>
												<form:option value="c">Customer</form:option>>
											</form:select>
		                                    </div>
	 
	                                 </div>
									
									<ul class="alt">
							        
							        <li>By signing up, I agree to Terms of Service, Payments Terms of Service, Privacy Policy 
							          and Host Guarantee Terms.</li>
										
									</ul>
									
									<div class="12u$">
										<ul class="actions">
											<li><input type="submit" value="signup" class="special" /></li>
										    <li><input type="reset" value="Reset" /></li>
										</ul>
									</div>
								</div>
							</form:form>
							<ul class="alt">
							<li></li>
							<li>Already have an account ? <a href="login.htm">Log-In</a></li></li>
										
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