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
						<li><strong><a href="logout.htm">Logout</a></strong></li>
						
						
					</ul>
				</nav>
			</header>
			<section id="main" class="wrapper">
			<div class="container">
			<h4><strong>Search Results</strong></h4>
			
			
            
  <c:if test="${empty searchrooms}"> <h4>No Results Found</h4> </c:if>
							<div class="table-wrapper">
								<table>
									<thead>
										<tr>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
									 <c:forEach var="room" items="${searchrooms}">
									 <tr>
									 <td>
									 <div class="feature-grid">
									 <div class="feature">
								     <div class="image rounded"><img src="${room.photoName}" alt="" /></div>
								     <div class="content">
									<header>
										<h4>${room.name}</h4>
										<h4>${room.cost}$</h4>
									</header>
									<p>${room.address}, ${room.city}</p>
									<p>${room.propertytype}</p>
								</div>
							</div>
							</div>
									 
									 </td>
									 <td><a href="detailroom.htm?id=${room.roomID}" class="button small">Book</a></td>
									 </tr>
									 </c:forEach>	
									</tbody>
									
								</table>
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