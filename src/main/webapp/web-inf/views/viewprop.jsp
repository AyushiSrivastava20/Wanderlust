<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section id="main" class="wrapper">
				<div class="container">
<c:if test="${empty allprops}"> <h4>No Results Found</h4> </c:if>
<div class="table-wrapper">
								<table>
									<thead>
										<tr>
											<th>Name</th>
											<th>Cost</th>
											<th>Address</th>
											<th>Street</th>
											<th>City</th>
											
										</tr>
									</thead>
									<tbody>
									 <c:forEach var="room" items="${allprops}">
									 <tr>
									 <td><c:out value="${room.name}"></c:out></td>
									 <td><c:out value="${room.cost}"></c:out></td>
									 <td><c:out value="${room.address}"></c:out></td>
									 <td><c:out value="${room.street}"></c:out></td>
									 <td><c:out value="${room.city}"></c:out></td>
									 
									 </tr>
									 </c:forEach>	
									</tbody>
									
								</table>
							</div>
							</div>
							</section>
</body>
</html>