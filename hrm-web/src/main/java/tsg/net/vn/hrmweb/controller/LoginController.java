package tsg.net.vn.hrmweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tsg.net.vn.hrmweb.model.Role;
import tsg.net.vn.hrmweb.model.Users;
import tsg.net.vn.hrmweb.service.RoleService;
import tsg.net.vn.hrmweb.service.UserService;



@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@GetMapping("/login")
	public String login() {
		return "login"; // return page login.html
	}

	@GetMapping("/signup")
	public String signupGet() {
		return "signup"; // return page login.html
	}

	@PostMapping("/signup-post")
	public String signupPost(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("username: " +username);
		System.out.println("password: " + password);
		Users u = new Users();
		u.setUsename(username);
		u.setPassword(password);
		Role role = roleService.findByRoleCode("ADMIN");
//		Role role = new Role();
//		role.setRoleCode("ADMIN");
//		role.setRoleName("Quyen admin");
		if(userService.createUser(u,role) != null) {
			return "redirect:/login";
		}else {
			return "redirect:/signup";
		}
		
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";
	}
}
