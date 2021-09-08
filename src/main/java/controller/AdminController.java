package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/updateAttendance")
	public String updateTheAttendance(HttpServletResponse response, @RequestParam("email") String email

			, HttpServletRequest request, @RequestParam("attendance") String attendanceStatus) throws IOException {
		PrintWriter out = response.getWriter();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		} catch (ParseException e) {
		}

		adminService.updateTheAttendance(email, date, attendanceStatus, out);
		return "admin";
	}

	@PostMapping("/addUser")
	public String addUser(HttpServletResponse response, @RequestParam("name") String name,
			@RequestParam("pass") String password, @RequestParam("email") String email,
			@RequestParam("user") String user) throws IOException {

		adminService.addUser(name, password, email, user);
		return "admin";

	}

	@PostMapping("/display")
	public void displayParticularAttendance(HttpServletResponse response, @RequestParam("email1") String email1

			, @RequestParam("email2") String email2, @RequestParam("email3") String email3,
			@RequestParam("email4") String email4, @RequestParam("email5") String email5,
			@RequestParam("email6") String email6, HttpServletRequest request) throws IOException {

		PrintWriter out = response.getWriter();

		List<String> list = new ArrayList<>();
		list.add(email1);
		list.add(email2);
		list.add(email3);
		list.add(email4);
		list.add(email5);
		list.add(email6);

		list.remove(null);

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		} catch (ParseException e) {
		}

		adminService.displayParticularAttendance(date, list, out);
	}

}
