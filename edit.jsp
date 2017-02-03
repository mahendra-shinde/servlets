<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editing Employee # ${requestScope.emp.empId }</title>
</head>
<body>
<c:set var="e" value="${requestScope.emp }"/>


<form action="employees" method="post">
	Employee Name : <input type="text" name="name"  value="${e.name}" /><br/>
	Gender :<input type="radio" name="gender" value="male" <c:if test="${e.gender=='male'}">checked</c:if>    />Male
	<input type="radio" name="gender" value="female" <c:if test="${e.gender=='female'}">checked</c:if>  />Female<br/>
	Designation : <select name="designation">
					<option value="developer"  <c:if test="${e.designation=='developer'}">selected</c:if> >Developer</option>
					<option value="tester" <c:if test="${e.designation=='tester'}">selected</c:if> >Tester</option>
					<option value="team-lead" <c:if test="${e.designation=='team-lead'}">selected</c:if> >Team lead</option>
					<option value="project-manager" <c:if test="${e.designation=='project-manager'}">selected</c:if> >Project Manager</option>
				</select> <br/>
	EMail		: <input type="email" name="email" value="${e.email }"  /><br/>
	Phone number : <input type="text" name="phone" maxlength="10" value="${e.phone }" /><br/>
					
	<input type="hidden" name="empid" value="${e.empId }"/>
	<input name="action" value="update" type="submit">
</form>

</body>
</html>