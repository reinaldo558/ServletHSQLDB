<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<script>
			function go(action) {
				document.getElementById("param").value = action;
				document.forms[0].submit();
			}
		</script>
		<style>
			input, button {
				width: 100px;
				text-align: left;
				margin-bottom: 5px;
			}
		</style>
	</head>
	<body>
		<br/><br/>
		
		<form action="/ServletHSQLDB/S1" method="post">
			<input type="hidden" name="param" id="param" value="" />
		
			<input type="button" value="C (create)" onclick="go('C')" /> <br/>
			<input type="button" value="R (read)" onclick="go('R')" /> <br/>
			<input type="button" value="U (update)" onclick="go('U')" /> <br/>
			<input type="button" value="D (delete)" onclick="go('D')" /> <br/>
		</form> 
	
	</body>
</html>