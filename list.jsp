<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Employees</title>
</head>
<body>

<c:if test="${sessionScope.error !=null }">
<h2 style="color:red">${error }</h2>
</c:if>


<c:if test="${sessionScope.emplist != null }">
<!-- set to create new reference variable -->
	<c:set var="emplist" value="${sessionScope.emplist }"/>
	<c:if test="${empty emplist}">
		<h2>No Records found, please add one employee</h2>
	</c:if>
	
	<c:if test="${not empty emplist}">
		<table>
			<tr>
			<td>Employee ID</td>
			<td>Name</td>
			<td>Gender</td>
			<td>Designation</td>
			<td>Phone</td>
			<td>EMail</td>
			</tr>
		
		<c:forEach items="${emplist }" var="e">
			<tr>
			<td>${e.empId }</td>
			<td>${e.name }</td>
			<td>${e.gender }</td>
			<td>${e.designation }</td>
			<td>${e.phone }</td>
			<td>${e.email }</td>
			</tr>
			
		</c:forEach>
		</table>
		
	</c:if>
	
</c:if>
</body>
</html>