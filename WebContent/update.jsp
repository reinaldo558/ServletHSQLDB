<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.reinaldo.Person" %>

<html>
	<head>
	</head>
	<body>
		<span style="font-colod: blue;font-weight: bold; font-size: x-large;">U</span>pdate <br/><br/>
		
		<% /* #################### FIRST STEP, SHOW LIST FOR SELECTION #################### */ %>
		
		<c:if test="${section == '1'}">
			<form action="/ServletHSQLDB/S1" method="post">
				<input type="hidden" name="param" id="param" value="U2" />
				<table style="width: 400px; border: solid 1px #000;">
					<tr>
						<td>&nbsp;</td>
						<td>Name</td>
						<td>Age</td>
						<td>Code</td>
					</tr>
					<c:forEach var="person" step="1" items="${people}">
						<tr>
							<td> <input type="radio" id="id" name="id" value="<c:out value='${person.id}' />" />  </td>
							<td> <c:out value='${person.name}' /> </td>
							<td> <c:out value='${person.age}' /> </td>
							<td> <c:out value='${person.cod}' /> </td>
						</tr>
					</c:forEach>
				</table> <br/><br/>
				
				<input type="submit" value="NEXT" />
			</form>
		</c:if>
		
		<% /* #################### SECOND STEP, MODIFY FIELDS #################### */ %>
		
		<c:if test="${section == '2'}">
			
			<c:set var="p" value="${person}" />
		
			<form action="/ServletHSQLDB/S1" method="post">
				<input type="hidden" name="param" id="param" value="U3" />
				
				<input type="hidden" name="id" id="id" value="<c:out value='${p.id}'></c:out>" />
				
				<input type="text" name="name" id="name" value="<c:out value='${p.name}'></c:out>" size="40"/> <br/>
				<input type="text" name="age" id="age" value="<c:out value='${p.age}'></c:out>" size="6"/> <br/>
				<input type="text" name="cod" id="cod" value="<c:out value='${p.cod}'></c:out>" size="20"/> <br/><br/>
				
				<input type="submit" value="UPDATE" />
				
			</form>
		</c:if>
		
		<% /* #################### THIRD STEP, SHOW SUCCESS #################### */ %>
		
		<c:if test="${section == '3'}">
			<br/><br/>
			User <c:out value="${name}" /> updated
			<br/><br/><br/><br/>
		</c:if>
		
		
		
		<form action="/ServletHSQLDB/" method="get">
			<input type="submit" value="back" />
		</form>
	</body>
</html>