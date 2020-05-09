package com.example.security;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("home")
	public String home() {
		return "welcome.jsp";
	}
	
	/**@RequestMapping("login")
	public String doLogin() {
		return "login.jsp";
	}**/
}
