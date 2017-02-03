<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Import ALL tags from jstl/core library
	 And, to identify them, use prefix "c" -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee added!</title>
</head>
<body>
<!-- Inform JSP Engine, that following tag is NOT HTML, but part of library -->
	<c:if test="${sessionScope.error != null}"> <!-- EL Expression Language -->
		<h3>Some Error Occurred!</h3>
		<h4>${sessionScope.error }</h4> <!-- EL to get session attribute 'error' -->
	</c:if>

	<c:if test="${sessionScope.emp != null}">
		<h3>Your request was successful</h3>
		<p>
			ID : ${sessionScope.emp.empId}<br/>
			Name : ${sessionScope.emp.name }<br/>	<!-- EL depends on JavaBeans conventions -->
			Gender: ${sessionScope.emp.gender }<br/>
			Designation : ${sessionScope.emp.designation }
		</p>
	</c:if>
</body>
</html>