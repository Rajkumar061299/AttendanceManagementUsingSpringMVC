package service;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class FacultyService {

	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

	public void display(PrintWriter out, Date date) {

		Filter propertyFilter = new FilterPredicate("date", FilterOperator.EQUAL, date);
		Query query = new Query("AttendanceDetails").setFilter(propertyFilter);
		PreparedQuery prepardQuery = datastore.prepare(query);
		Iterator<Entity> listOfStudent = prepardQuery.asIterator();
		while (listOfStudent.hasNext()) {
			Entity e = listOfStudent.next();
			out.print("<b>Name : </b>" + e.getProperty("name") + "     ");
			out.print("<b>Attendance Status : </b>" + e.getProperty("attendanceStatus"));
			out.print("<br>");

		}

	}

	public String addAttendance(Date date, String name, String email, String attendanceStatus, String studentID,
			PrintWriter out) {

		String studentAttendance_id = UUID.randomUUID().toString();

		Key key = KeyFactory.createKey("User", studentID);
		Entity e = new Entity("AttendanceDetails", studentAttendance_id, key);

		e.setProperty("name", name);
		e.setProperty("date", date);
		e.setProperty("email", email);
		e.setProperty("attendanceStatus", attendanceStatus);

		Filter propertyFilter = new FilterPredicate("date", FilterOperator.EQUAL, date);
		Filter propertyFilter1 = new FilterPredicate("name", FilterOperator.EQUAL, name);

		Filter compositeFilter = CompositeFilterOperator.and(propertyFilter, propertyFilter1);

		Query query = new Query("AttendanceDetails").setFilter(compositeFilter);
		PreparedQuery prepardQuery = datastore.prepare(query);

		Entity result = prepardQuery.asSingleEntity();
		if (result == null) {
			datastore.put(e);
//			out.println("<script type=\"text/javascript\">");
//			out.println("alert('attendance updated');");
//			out.println("location='faculty.jsp';");
//			out.println("</script>");
			return "faculty";
		} else {
//			out.println("<script type=\"text/javascript\">");
//			out.println("alert('attendance already updated');");
//			out.println("location='faculty.jsp';");
//			out.println("</script>");
			return "faculty";
		}

	}
}
