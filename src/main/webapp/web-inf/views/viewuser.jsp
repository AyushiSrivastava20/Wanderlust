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
				<c:if test="${empty allusers}"> <h4>No Results Found</h4> </c:if>
<div class="table-wrapper">
								<table>
									<thead>
										<tr>
											<th>Firstname</th>
											<th>Lastname</th>
											<th>Role</th>
											<th>City</th>
											<th>State</th>
											<th>Country</th>
											<th>Status</th>
											
										</tr>
									</thead>
									<tbody>
									 <c:forEach var="user" items="${allusers}">
									 <tr>
									 <td><c:out value="${user.firstname}"></c:out></td>
									 <td><c:out value="${user.lastname}"></c:out></td>
									 <td><c:out value="${user.role}"></c:out></td>
									 <td><c:out value="${user.city}"></c:out></td>
									 <td><c:out value="${user.state}"></c:out></td>
									 <td><c:out value="${user.country}"></c:out></td>
									 <td><c:out value="${user.userStatus}"></c:out></td>
									
									 </tr>
									 </c:forEach>	
									</tbody>
									
								</table>
							</div>
							</div>
							</section>
</body>
</html>