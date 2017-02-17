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
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

			<link href="<c:url value="/resources/css/skel.css"/>" rel="stylesheet"/>
			<link href="<c:url value="/resources/css/style.css"/>"  rel="stylesheet"/>
	        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
            <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
			<link href="<c:url value="/resources/css/style-xlarge.css"/>" rel="stylesheet"/>
		    
	</head>
	<script>
function show() {
$.ajax({
                            	type: "POST",
                            	url: "wish.htm",
                            	success: function(data){
                            		
									
									 $("#displayDiv").html(data);
                            	    }
                            	})
}

function showtrip() {
	$.ajax({
	                            	type: "POST",
	                            	url: "trips.htm",
	                            	success: function(data){
	                            		
										
										 $("#displayDiv").html(data);
	                            	    }
	                            	})
	}
</script>

<body class="landing">

<script>
$(document).ready(function () {

    $("#dt1").datepicker({
        
        minDate: 0,
        required: true,
        onSelect: function (date) {
            var date2 = $('#dt1').datepicker('getDate');
            date2.setDate(date2.getDate() + 1);
            $('#dt2').datepicker('setDate', date2);
            //sets minDate to dt1 date + 1
            $('#dt2').datepicker('option', 'minDate', date2);
        }
    });
    $('#dt2').datepicker({
       
        required: true,
        onClose: function () {
            var dt1 = $('#dt1').datepicker('getDate');
            var dt2 = $('#dt2').datepicker('getDate');
            //check to prevent a user from entering a date below date of dt1
            if (dt2 <= dt1) {
                var minDate = $('#dt2').datepicker('option', 'minDate');
                $('#dt2').datepicker('setDate', minDate);
            }
        }
    });
});
</script>


<!-- Header -->
			<header id="header" class="skels-layers-fixed">
				<h1><strong><a href="home.htm">Wanderlust</a></strong></h1>
				<nav id="nav">
					<ul>
					    <li><strong>Welcome <c:out value="${sessionScope.username1}"></c:out></strong></li>
						<li><strong><a href="home1.htm">Home</a></strong></li>
						
						<li><strong><a href="updateprofile.jsp">Update Profile</a></strong></li>
						<li><strong><a href="logout.htm">Logout</a></strong></li>
						
						
					</ul>
				</nav>
			</header>
			
			<!-- Banner -->
			<section id="banner">
				<h2>Wanderlust</h2>
				<p><i>mi casa es su casa-"my house is your house"</i></p>
				
				
			</section>
			
			<!-- search -->
			 <br>
   <br>
			<section class="wrapper style4">
   
    <h3>Find Your trip</h3>
    <form:form id="search" action="search.htm" method="post" commandName="room" style="display:inline;" >

         <div class="row uniform 50%">
	     <div class="3u 12u$(xsmall)">
	     <form:input type="text" name="city" path="city" style="display:inline;" id="city" placeholder="Where do you want to go?"  required="true"/>
	     
	    </div>
		<div class="1u 12u$(xsmall)">
	       <div class="select-wrapper">
											<form:select name="guest" id="guest" path="roomtype" required="true">
												<form:option value="">- Guest -</form:option>
												<form:option value="1">1 Guest</form:option>
												<form:option value="2">2 Guest</form:option>
												<form:option value="4">4 Guest</form:option>
												

											</form:select>
		  </div>
	 
	 </div>
	 
	         <div class="3u 12u$(xsmall)">
			 
			 <input type="text" id="dt1" name="begin" placeholder="check-in" readonly="readonly"></input>
			 </div>
			 
			 <div class="3u 12u$(xsmall)">
			 
			 <input type="text" id="dt2" name="end" placeholder="check-out" readonly="readonly"></input>
			 </div>
	    
	  <div class="2u 12u$(xsmall)">
	
	  <input type="submit" style="display:inline; value="Post" class="button special small"></input>
	
																		
	  </div>
	  </div>
</form:form>
</section>
        
<br>
<br>
<br>
<br>
               <hr>
					<section class="wrapper style4">
					<h3>From Your Previous Visits</h3>
					<div class="6u$ 12u$(xsmall)">
					
					<ul class="actions fit small">
								<li><button class="button fit small" onclick="show()">WishList</button></li>
								<li><button class="button fit small" onclick="showtrip()">Booking History</button></li>		
									</ul>
									</div>
               <div id="displayDiv">
               
               </div>
               </section>
               

<!-- Two -->
				<section id="two" class="wrapper style2 special">
					<div class="container">
						<header class="major">
							
							<h2>Discover new places close to your home, Just like home</h2>
							<p>Destinations for weekends, holidays, vacations and much more</p>
						</header>
						<div class="row 150%">
							<div class="6u 12u$(xsmall)">
								<div class="image fit captioned">
									<img src="<c:url value="/resources/images/po.jpg"/>" alt="" />
									<h3>Portland</h3>
								</div>
							</div>
							<div class="6u$ 12u$(xsmall)">
								<div class="image fit captioned">
									<img src="<c:url value="/resources/images/sf1.jpg"/>" alt="" />
									<h3>San Francisco</h3>
								</div>
							</div>
						</div>
						<ul class="actions">
							<li><a href="#" class="button special big">See all destinations</a></li>
							
						</ul>
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