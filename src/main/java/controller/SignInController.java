package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.SignInService;

@Controller
public class SignInController {

	@PostMapping("/signin")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password,

			HttpServletRequest request, HttpServletResponse response) throws IOException {

		SignInService signInService = new SignInService();
		return signInService.validate(email, password, request, response);

	}

}
