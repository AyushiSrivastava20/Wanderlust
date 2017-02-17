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
					
					    <li><strong>Welcome <c:out value="${sessionScope.username1}"></c:out></strong></li>
						<li><strong><a href="home1.htm">Home</a></strong></li>
						<li></strong><a href="logout.htm">Logout</a></strong></li>
						
						
					</ul>
				</nav>
			</header>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="container">
					
					<!-- Form -->
						<section>
							<h3>List your space</h3>
							<form:form action="addroom.htm" method="post" commandName="room" id ="addroom" enctype="multipart/form-data">
								<div class="row uniform 50%">
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="name" name="name" id="name" value="" placeholder="Name" />
										<font color="red"><form:errors path="name"/></font>
									</div>
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="address" name="address" id="address" value="" placeholder="Address" />
										<font color="red"><form:errors path="address"/></font>
									</div>
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="street" name="street" id="street" value="" placeholder="Street" />
										<font color="red"><form:errors path="street"/></font>
									</div>
									
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="city" name="city" id="city" value="" placeholder="City" />
										<font color="red"><form:errors path="city"/></font>
									</div>
									
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="state" name="state" id="state" value="" placeholder="State" />
										<font color="red"><form:errors path="state"/></font>
									</div>
									
									<div class="6u$ 12u$(xsmall)">
	                                        <div class="select-wrapper">
											<form:select path="propertytype" name="propertytype" id="propertytype">
												<form:option value="">- PropertyType -</form:option>
											    <form:option value="Bed Breakfast">Bed Breakfast</form:option>
												<form:option value="Apartment">Apartment</form:option>
												<form:option value="Home">Home</form:option>
											</form:select>
		                                    </div>
	 
	                                 </div>
									
									
									<div class="6u$ 12u$(xsmall)">
	                                        <div class="select-wrapper">
											<form:select path="roomtype" name="roomtype" id="roomtype">
												<form:option value="">- RoomType -</form:option>
											    <form:option value="1">Single</form:option>
												<form:option value="2">Double</form:option>
												<form:option value="4">Suit-4ppl</form:option>
											</form:select>
		                                    </div>
	 
	                                 </div>
	                                 
	                                 <div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="aminities" name="aminities" id="aminities" value="" placeholder="aminities" />
											<font color="red"><form:errors path="aminities"/></font>
									</div>
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="rules" name="rules" id="rules" value="" placeholder="Rules" />
											<font color="red"><form:errors path="rules"/></font>
									</div>
									
									<div class="6u$ 12u$(xsmall)">
										<form:input type="text" path="cost" name="cost" id="cost" value="" placeholder="Cost" />
									</div>
									<div class="6u$ 12u$(xsmall)">
										<form:input type="file" path="photo" name="photo" id="photo"  />
									</div>
									
									<div class="6u$">
										<form:textarea name="description" path="description" id="description" placeholder="Enter your description" rows="6"></form:textarea>
											<font color="red"><form:errors path="description"/></font>
									</div>
									
									
									<div class="12u$">
										<ul class="actions">
											<li><input type="submit" value="Post" class="special" /></li>
										    <li><input type="reset" value="Reset" /></li>
										</ul>
									</div>
								</div>
							</form:form>
							
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