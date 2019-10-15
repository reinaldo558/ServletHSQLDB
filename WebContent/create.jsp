<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head></head>
	<body>
		<span style="font-colod: #f55; font-weight: bold; font-size: x-large;">C</span>reate <br/><br/>
		
		<c:if test="${section == '1'}">
			<form action="/ServletHSQLDB/S1" method="post">
				<input type="hidden" id="param" name="param" value="C2" />
				
				<table style="width: 500px; border: solid 1px #000;">
					<tr>
						<td>Name</td><td><input type="text" size="40" name="name" id="name" /></td>
					</tr><tr>
						<td>Age</td><td><input type="text" size="6"  name="age" id="age" /></td>
					</tr><tr>
						<td>Code</td><td><input type="text" size="20" name="cod" id="cod" /></td>
					</tr>
				</table>
				<br/><br/>
				<input type="submit" value="create" />
			</form>
		</c:if>
		<c:if test="${section == '2'}">
			<br/><br/>
			User <c:out value="${name}" /> created
			<br/><br/><br/>
		</c:if>
		
		<form action="/ServletHSQLDB/" method="get">
			<input type="submit" value="back" />
		</form>
	</body>
</html>