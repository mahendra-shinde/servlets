<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Employee Management Service</h2>
<h3>New employees register here</h3>
<form action="employees" method="post">
	Employee Name : <input type="text" name="name" required /><br/>
	Gender :<input type="radio" name="gender" value="male"/>Male
	<input type="radio" name="gender" value="female" checked />Female<br/>
	Designation : <select name="designation">
					<option value="developer">Developer</option>
					<option value="tester">Tester</option>
					<option value="team-lead">Team lead</option>
					<option value="project-manager">Project Manager</option>
				</select> <br/>
	EMail		: <input type="email" name="email" /><br/>
	Phone number : <input type="text" name="phone" maxlength="10"/><br/>
					
<input type="submit" value="add" name="action"/>
</form>

Existing employees 
	<a href="employees?action=list">show all</a>
</body>
</html>