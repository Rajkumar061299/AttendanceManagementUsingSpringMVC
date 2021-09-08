<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.google.appengine.api.datastore.*, com.google.appengine.api.datastore.Query.*, java.util.Iterator
, com.google.appengine.api.datastore.Query.Filter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome</h1>


	<%
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	Filter propertyFilter = new FilterPredicate("role", FilterOperator.EQUAL, "student");
	Query query = new Query("User").setFilter(propertyFilter);
	PreparedQuery prepardQuery = datastore.prepare(query);
	Iterator<Entity> listOfStudent = prepardQuery.asIterator();
	while (listOfStudent.hasNext()) {
		Entity e = listOfStudent.next();
	%>
	<form action="addAttendance" method="post">
		<h3>
			Name :
			<%=e.getProperty("name")%></h3>
		<label for="date"><b>Date:</b></label> <input type="date" id="date"
			name="date" required> <input type="radio" id="present"
			name="attendance" value="present">   <label for="present">present</label>
		  <input type="radio" id="absent" name="attendance" value="absent">
		  <label for="absent">absent <input type="hidden" id="id"
			name="id" value=<%=e.getKey().getName().toString()%>> <input
			type="hidden" id="name" name="name"
			value=<%=e.getProperty("name").toString()%>> <input
			type="hidden" id="email" name="email"
			value=<%=e.getProperty("email").toString()%>>


		</label>&nbsp;&nbsp;<input type="submit">
	</form>
	<%
	}
	%>
	<br>
	<br>
	<br>
	<h2>Student Attendance Details</h2>
	<form action="displayattendance" method="post">
		<label for="date"><b>Date:</b></label> <input type="date" id="date"
			name="date" required> <input type="submit">
	</form>
	<br>
	<br>
	<form action="logout" method="post">
		<input type="submit" value="logout">
	</form>

</body>
</html>