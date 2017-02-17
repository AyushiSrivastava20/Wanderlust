<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>Wanderlust</title>
</head>
<body>
			<section id="main" class="wrapper">
				<div class="container">
					<h3>Bookings</h3>
							 <c:if test="${empty finallist}"> <h4>No Results Found</h4> </c:if>
							<div class="table-wrapper">
								<table>
									<thead>
										<tr>
											<th>Customer Name</th>
											<th>Customer PhoneNo</th>
											<th>Start Date</th>
											<th>End Date</th>
											<th>Total</th>
											
										</tr>
									</thead>
									<tbody>
									 <c:forEach var="visit" items="${finallist}">
									 <tr>
									 <td><c:out value="${visit.customer.firstname}"></c:out></td>
									 <td><c:out value="${visit.customer.phone}"></c:out></td>
									 <fmt:formatDate value="${visit.begin}" pattern="yyyy-dd-MM" var="begin" />
									 <td><c:out value="${begin}"></c:out></td>
									 <fmt:formatDate value="${visit.end}" pattern="yyyy-dd-MM" var="end" />
									 <td><c:out value="${end}"></c:out></td>
									 <td><c:out value="${visit.total}"></c:out></td>
									
									 </tr>
									 </c:forEach>	
									</tbody>
									
								</table>
							</div>
					

				</div>
			</section>
</body>
</html>