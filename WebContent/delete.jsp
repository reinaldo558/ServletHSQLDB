<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<script>
			function callDelete(id) {
				document.getElementById("id").value = id;
				document.forms[0].submit();
			}
		</script>
	</head>
	<body>
		<span style="font-colod: blue;font-weight: bold; font-size: x-large;">D</span>elete <br/><br/>
		
		<c:if test="${section == '1'}">
			<form action="/ServletHSQLDB/S1" method="post">
				<input type="hidden" id="param" name="param" value="D2" />
				<input type="hidden" id="id" name="id" value="" />
				
				<table style="border: solid 1px #000;">
					<tr style="text-align: center;">
						<td>Name</td>
						<td>Age</td>
						<td>Code</td>
						<td>&nbsp;</td>
					</tr>
					<c:forEach var="person" step="1" items="${people}">
						<tr>
							<td><c:out value="${person.name}" /><br/></td>
							<td style="text-align: center;"><c:out value="${person.age}" /><br/></td>
							<td><c:out value="${person.cod}" /><br/></td>
							<td>
								<input type="button" value="delete" id="<c:out value='${person.id}' />" onclick="callDelete(this.id)"/>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</c:if>
		<c:if test="${section == '2'}">
			<br/><br/>
			User <c:out value="${name}" /> removed
			<br/><br/><br/>
		</c:if>
		
		<br/><br/>
		
		<form action="/ServletHSQLDB/" method="get">
			<input type="submit" value="back" />
		</form>
		
	</body>
</html>