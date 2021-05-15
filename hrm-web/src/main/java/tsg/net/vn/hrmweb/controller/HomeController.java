package tsg.net.vn.hrmweb.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tsg.net.vn.hrmweb.model.Users;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof Users) {
		username = ((Users)principal).getUsename();
		} else {
		username = principal.toString();
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(username);
		return "index";
	}
	@GetMapping("/widgets")
	public String widgets() {
		return "/pages/widgets";
	}
	@GetMapping("/calendar")
	public String calendar() {
		return "/pages/calendar";
	}
	@GetMapping("/gallery")
	public String gallery() {
		return "/pages/gallery";
	}
	@GetMapping("/kanban")
	public String kanban() {
		return "/pages/kanban";
	}
	@GetMapping("/home-page")
	public String homePage() {
		Authentication authen =  SecurityContextHolder.getContext().getAuthentication();
		return "home-page";
	}
	
	@Secured("ADMIN")
	@GetMapping("/detail")
	public String detail() {
		return "detail";
	}
}
