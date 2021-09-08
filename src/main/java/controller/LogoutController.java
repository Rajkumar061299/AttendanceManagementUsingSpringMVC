package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

	@PostMapping("/logout")
	public void logout(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('logout Sucessfully');");
		out.println("window.location.replace(\"login.jsp\")");
		out.println("</script>");

	}

}
