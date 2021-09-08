package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.FacultyService;

@Controller
public class FacultyController {

	@Autowired
	FacultyService facultyService;

	@PostMapping("/addAttendance")
	public String addAttendance(HttpServletResponse response, HttpServletRequest request,
			@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("attendance") String attendanceStatus, @RequestParam("id") String studentID)
			throws IOException {

		PrintWriter out = response.getWriter();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		} catch (ParseException e) {
		}

		return facultyService.addAttendance(date, name, email, attendanceStatus, studentID, out);
	}

	@PostMapping("/displayattendance")
	public void display(HttpServletResponse response, @RequestParam("date") String date1) throws IOException {

		PrintWriter out = response.getWriter();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		} catch (ParseException e) {
		}

		facultyService.display(out, date);
	}

}
