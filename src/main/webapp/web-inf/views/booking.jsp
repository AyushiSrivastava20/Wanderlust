<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import= "com.me.myfinalproject.pojo.Room" %>
<%@ page import= "java.util.Date" %>
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
			<link href="<c:url value="/resources/css/style-xlarge.css"/>" rel="stylesheet"/>
			<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
            <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
			
	
	</head>	
<body>

<script>
$(document).ready(function () {

    $("#dt1").datepicker({
        minDate: 0,
        onSelect: function (date) {
            var date2 = $('#dt1').datepicker('getDate');
            date2.setDate(date2.getDate() + 1);
            $('#dt2').datepicker('setDate', date2);
            //sets minDate to dt1 date + 1
            $('#dt2').datepicker('option', 'minDate', date2);
        }
    });
    $('#dt2').datepicker({
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
        
            function calculate(x) {

        	var startDate = $("#dt1").datepicker("getDate");
			var endDate = $("#dt2").datepicker("getDate");

			if(startDate && endDate){
				var diff = Math.round((endDate - startDate)/1000/60/60/24);
				var num=diff*x;
				var ser=0.2*num;
				var tot=num+ser;
				$("#cost").val(num);
				$("#service").val(ser);
				$("#total").val(tot);
			} else {
				$("#cost").val("select proper dates");
			}
        	
        }
    </script>
		
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
			<% Room room = (Room) session.getAttribute("bookroom");%>
			<header>
			<h3>Booking for <%=room.getName()%></h3>
			</header>
			<hr>
			
			 
			 <form:form id="booking" action="book.htm" method="post" commandName="booking">
             <div class="row uniform 50%">
             <div class="6u 12u$(xsmall)">
			 <div class="6u$">
			 <form:label path="end">Check-In</form:label>
			 <form:input type="text" path="begin" id="dt1" name="begin" readonly="readonly" placeholder="check-in"></form:input>
			 <font color="red"><form:errors path="begin"/></font>
			 </div>
			 <br>
			 
			 <div class="6u$">
			 <form:label path="end">Check-Out</form:label>
			 <form:input type="text" path="end" id="dt2" name="end" readonly="readonly" placeholder="check-in"></form:input>
			<font color="red"><form:errors path="end"/></font>
			 </div>
			 <br>
			 <br>
			 <div class="6u$">
			 <input type="button" class="button special" value="Know Your Total" onclick="calculate(<%=room.getCost()%>)"></input>
			 </div>
			 </div>
			 <div class="6u 12u$(xsmall)">
			
			 <ul class="alt">
			 
			 <li>Cost of Room<div class="3u">
			 <input type="text" id="cost"></input>
			 </div>
			 </li>
			 <li>Service
			 <div class="3u$">
			 <input type="text" id="service"></input>
			 </div></li>
			 <li>Total
			 <div class="3u$">
			 <form:input type="text" id="total" path="total" required="true"></form:input>
			 <font color="red"><form:errors path="begin"/></font>
			 </div></li>
			 </ul>
			 <div class="6u$">
	         <input type="submit" value="Book" class="special" />
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