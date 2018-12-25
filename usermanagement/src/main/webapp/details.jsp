<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="user" class="nure.itkn.malyk.usermanagement.User"
	scope="session" />
<html>
<head>
<title>User management/Details</title>
</head>
<body>
	<table>
	<tr>
	<td>ID</td>
	<td>First Name</td>
	<td>Last Name</td>
	<td>Date Of Birth</td>
	</tr>
	<tr>
	<td>${user.id}</td>
	<td>${user.firstName}</td>
	<td>${user.lastName}</td>
	<td>${user.dateOfBirth}</td>
	</tr>
	</table>
	<form action="<%=request.getContextPath()%>/details" method="post">
		<input type="submit" name="okButton" value="Ok"> <input
			type="submit" name="okButton" value="Cancel">
	</form>
	<c:if test="$(requestScope.error != null)">
		<script>
			alert('$(requestScope.error')
		</script>
	</c:if>
</body>
</html>