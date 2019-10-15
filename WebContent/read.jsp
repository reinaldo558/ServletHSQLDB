<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head></head>
	<body>
		<span style="font-colod: blue;font-weight: bold; font-size: x-large;">R</span>ead <br/><br/>
		
		<table style="width: 400px; border: solid 1px #000;">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Age</td>
				<td>Code</td>
			</tr>
			<c:forEach var="person" step="1" items="${people}">
				<tr>
					<td><c:out value="${person.id}" /><br/></td>
					<td><c:out value="${person.name}" /><br/></td>
					<td><c:out value="${person.age}" /><br/></td>
					<td><c:out value="${person.cod}" /><br/></td>
				</tr>
			</c:forEach>
		</table> <br/><br/>
		
		<form action="/ServletHSQLDB/" method="get">
			<input type="submit" value="back" />
		</form>
		
		
	</body>
</html>