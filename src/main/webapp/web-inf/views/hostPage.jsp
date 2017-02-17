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
		
	</head>
	
	<script>
function showall() {
$.ajax({
                            	type: "POST",
                            	url: "showue.htm",
                            	success: function(data){
                            		
									
									 $("#displayDiv").html(data);
                            	    }
                            	})
}
</script>

<body class="landing">
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
			
			<!-- Banner -->
			<section id="banner">
				<h2>Wanderlust</h2>
				<p><i>mi casa es su casa-"my house is your house"</i></p>
				
				<ul class="actions">
					<li><a href="viewlist.htm" class="button special big">View Listing</a></li>
					<li><a href="addroom.htm" class="button special big">Post Listing</a></li>
				</ul>
			</section>
			
			<section class="wrapper style4">
					<h3>Visits</h3>
					<div class="4u$ 12u$(xsmall)">
					
					<ul class="actions fit small">
								<li><button class="button fit small" onclick="showall()">Bookings</button></li>
								
									</ul>
									</div>
               <div id="displayDiv">
               
               </div>
               </section>
			
			<!-- One -->
				<section id="one" class="wrapper style1">
					<div class="container 75%">
						<div class="row 200%">
							<div class="6u 12u$(medium)">
								<header class="major">
									<h2>open new opportunity</h2>
									<p>Earn money sharing your extra space with travellers</p>
								</header>
							</div>
							<div class="6u$ 12u$(medium)">
								<div class="image fit captioned">
									<img src="<c:url value="/resources/images/pic03.jpg"/>" alt="" />
	
								</div>
							</div>
						</div>
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