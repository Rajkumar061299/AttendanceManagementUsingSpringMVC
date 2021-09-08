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
	String userID = (String) request.getSession().getAttribute("userId");

	Key id = KeyFactory.createKey("User", userID);

	System.out.println(userID + "  " + id.toString());

	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	Query query = new Query("AttendanceDetails").setAncestor(id);
	PreparedQuery prepardQuery = datastore.prepare(query);

	Iterator<Entity> lisOfAttendance = prepardQuery.asIterator();

	while (lisOfAttendance.hasNext()) {
		Entity e = lisOfAttendance.next();
	%>
	<b>Date : </b><%=e.getProperty("date")%>&nbsp;&nbsp;
	<b>Attendance Status : </b>
	<%=e.getProperty("attendanceStatus")%>
	<%
	}
	%>

	<br>
	<br>
	<form action="logout" method="post">
		<input type="submit" value="logout">
	</form>
</body>
</html>