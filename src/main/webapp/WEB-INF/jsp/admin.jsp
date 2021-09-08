<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="/script/admin.js" />"></script>
</head>

<body>

	<form action="addUser" method="post">

		<h2>Add User</h2>
		User<br> <input type="radio" id="student" name="user"
			value="student">   <label for="student">Student</label>  <input
			type="radio" id="faculty" name="user" value="faculty">   <label
			for="faculty">Faculty</label><br> Name<br> <input
			type="text" name="name" required><br> E-mail<br> <input
			type="text" name="email"><br> Password<br> <input
			type="password" name="pass" required><br> <br> <input
			type="submit" value="add"><br>

	</form>
	<br>
	<h2>Update the Student attendance</h2>

	<form action="updateAttendance" method="post">
		<label for="email"><b>Enter an Email</b></label> <input type="text"
			placeholder="Enter an Email" name="email" required> <label
			for="date"><b>Date:</b></label> <input type="date" id="date"
			name="date"> <input type="radio" id="present"
			name="attendance" value="present">   <label for="present">present</label>
		  <input type="radio" id="absent" name="attendance" value="absent">
		  <label for="absent">absent</label>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit">
	</form>

	<br>



	<h2>Student Attendance Details</h2>
	<form action="display" method="post">
		<label for="email">Enter an Email<br></label> <input type="text"
			placeholder="Enter an Email" name="email1"> <label
			for="email"></label> <input type="text" placeholder="Enter an Email"
			name="email2"> <label for="email"></label> <input type="text"
			placeholder="Enter an Email" name="email3"> <label
			for="email"></label> <input type="text" placeholder="Enter an Email"
			name="email4"> <label for="email"></label> <input type="text"
			placeholder="Enter an Email" name="email5"> <label
			for="email"></label> <input type="text" placeholder="Enter an Email"
			name="email6"> <br> <br> <label for="date"><b>Date:</b></label>
		<input type="date" id="date" name="date" required>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit">

	</form>






	<br>
	<br>
	<form action="logout" method="post">
		<input type="submit" value="logout">
	</form>

</body>
</html>