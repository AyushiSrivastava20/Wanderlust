<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import= "com.me.myfinalproject.pojo.Room" %>
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
						<li><strong><a href="logout.htm">Logout</a></strong></li>
						
						
					</ul>
				</nav>
			</header>
			<section id="main" class="wrapper">
			<div class="container">
			<% Room room = (Room) session.getAttribute("searchroom");%>
			<header>
			<h2><%=room.getName()%></h2>
			</header>
			 <form:form id="comment" action="addcomment.htm" method="post" commandName="comments" >
			 <div class="row uniform 50%">
			 <div class="12u$">
			 <form:textarea name="comment" path="text" id="comment" placeholder="Enter your comment" rows="4"></form:textarea>
			 <font color="red"><form:errors path="text"/></font>
			 </div>
			 
	         <div class="12u$">
			 <ul class="actions">
			 <li><input type="submit" value="Post Comment" class="special" /></li>
			 <li><input type="reset" value="Reset" /></li>
			 </ul>
			 </div>
			 </div>
</form:form>
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