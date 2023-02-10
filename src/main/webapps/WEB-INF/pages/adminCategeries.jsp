<DOCTTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>adminCategery</title>
	</head>
	<body>
		<table>
			<tr>
				<th>SNo</th>
				<th>CategeryName</th>
				<th>CategeryCode</th>
				<th>CategeryDescription</th>
			</tr>
			<c:forEach items="${ categeries}" var="cat" varStatus="st">
				<tr>
					<td>${st.count}</td>
					<td>${cat.count}</td>
					<td>${cat.categeryName}</td>
					<td>${cat.categeryDescription}</td>
					<td>
						<a href="editcategery?categeryId=${categery.categeryId}">Edit</a>
						<a href="deletecategery?categeryId=${categery.categeryId }">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>