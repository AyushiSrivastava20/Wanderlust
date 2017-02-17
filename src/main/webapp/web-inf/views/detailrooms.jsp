<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import= "com.me.myfinalproject.pojo.Room" %>
<%@ page import= "com.me.myfinalproject.pojo.Comments" %>
<html>
<head>
		<title>Wanderlust</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
			<p><%=room.getDescription() %></p>
			</header>
			<hr>
			<div class="box alt">
			<div class="row 50% uniform">
			<div class="4u">
			<h4>Room Type : <%=room.getPropertytype()%>   & Occupancy : <%=room.getRoomtype()%> </h4>
			<h4>Cost : <%=room.getCost()%>$</h4>
			<h4><%=room.getAddress()%>, <%=room.getCity()%></h4>
			<h4>Amenities</h4>
			<blockquote><%=room.getAminities()%></blockquote>
			<h4>Rules</h4>
			<blockquote><%=room.getRules()%></blockquote>
			<h4><a href="addwish.htm?id=<%=room.getRoomID()%>"><img src="<c:url value="/resources/images/heart.png"/>" alt="" /></a>  Add to Wishlist </h4>
			</div>
		    <div class="8u$">
			<span class="image fit"><img class="img-responsive" alt="myimage" src="<%=room.getPhotoName()%>" /></span>
			</div>
			
			</div>
			</div>
			
			<hr>
			<div class="table-wrapper">
								<table>
									<thead>
										<tr>
											<th>Comments</th>
											<th>Posted By</th>
										</tr>
									</thead>
									<tbody>
									<%for(Comments c : room.getCommentList()){%>
									<tr>
									<td><%=c.getText() %></td>
									<td><%=c.getUser().getFirstname() %></td>
									</tr>
									
										
									<%} %>
									</tbody>
									</table>
									</div>
									
									<div class="12u$(xsmall)">
									<ul class="actions fit small">
										<li><a href="postcomment.htm?pid=<%=room.getRoomID()%>" class="button fit small">Post Comment</a></li>
										
										<li><a href="booking.htm?bid=<%=room.getRoomID()%>" class="button fit small">Book</a></li>
									</ul>
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