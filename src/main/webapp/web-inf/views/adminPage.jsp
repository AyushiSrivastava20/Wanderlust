<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		
	</head>

<script>
function showuser() {
$.ajax({
                            	type: "POST",
                            	url: "showuser",
                            	success: function(data){
                            		
									
									 $("#displayDiv").html(data);
                            	    }
                            	})
}

function showprop() {
	$.ajax({
	                            	type: "POST",
	                            	url: "showprop",
	                            	success: function(data){
	                            		
										
										 $("#displayDiv").html(data);
	                            	    }
	                            	})
	}
</script>


<body>
<!-- Header -->
			<header id="header" class="skels-layers-fixed">
				<h1><strong><a href="home.htm">Wanderlust</a></strong></h1>
				<nav id="nav">
					<ul>
						<li><Strong><a href="home1.htm">Home</a></Strong></li>
						<li><Strong><a href="updateprofile.jsp">Update Profile</a></Strong></li>
						<li><Strong><a href="logout.htm">Logout</a></Strong></li>
						
						
					</ul>
				</nav>
			</header>
			
			<section id="main" class="wrapper">
				<div class="container">
					
					<h3>Welcome <c:out value="${sessionScope.username1}"></c:out></h3>
					
							
					<ul class="actions">
					<li><button class="button special" onclick="showuser()">View All Users</button></li>
					<li><button class="button special" onclick="showprop()">View All Listings</button></li>
				    </ul>
<div id="displayDiv"></div>
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