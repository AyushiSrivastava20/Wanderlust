
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
		
		<title>Wondurlust</title>
		
</head>	
<body>
<!-- Header -->
			
			<h3>My Wishlist</h3>
							
							<div class="table-wrapper">
								<table>
									<thead>
										<tr>
											<th>Name</th>
											<th>City</th>
										</tr>
									</thead>
									<tbody>
									 <#list model["wish"] as wish>
									 <tr>
									 <td>${wish.roomname}</td>
									
									 <td>${wish.roomcity}</td>
								
									 </tr>
									 </#list>	
									</tbody>
									
								</table>
							</div>
		
		
</body>
</html>