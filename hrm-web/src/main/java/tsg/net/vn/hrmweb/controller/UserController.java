package tsg.net.vn.hrmweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tsg.net.vn.hrmweb.model.Role;
import tsg.net.vn.hrmweb.model.Users;
import tsg.net.vn.hrmweb.service.RoleService;
import tsg.net.vn.hrmweb.service.UserService;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@GetMapping("/users")
	public String getAllUser(Model model) {
		List<Users> usersList = userService.getAllUser();
		/* model.addAttribute("usersList",usersList); */
		List<Users> list = new ArrayList<Users>();
		for (Users users : usersList) {
			list.add(users);
		}
		model.addAttribute("userName",list.get(0).getUsename());
		model.addAttribute("password",list.get(0).getPassword());
		
		return "users";
	}
	
	@GetMapping("/user-add")
	public String createUser() {
		return "user/user-add"; 
	}
	@PostMapping("/user-add")
	public String createNewUser(Model model,@RequestParam("username") String userName,@RequestParam("password") String password,@RequestParam("role") String userRole) {
		Users user = new Users();
		user.setUsename(userName);
		user.setPassword(password);
		Role role = roleService.findByRoleCode(userRole);
		userService.createUser(user,role);
		List<Users> userList = userService.getAllUser();
		model.addAttribute(userList);
		return "redirect:users";
	}
	@PutMapping("/users/{users}")
	public String updateUser(
			@PathVariable("userId") Long uId,
			@RequestParam("username") String userName,@RequestParam("password") String password,@RequestParam("role") String userRole) {
		
		Users user = userService.updateUserById(uId, userName,password,userRole);
		
		return "redirect:users";
	}
	
	@DeleteMapping("/users/{users}")
	public String deleteUser(@PathVariable("userId") Long uId) {
		
		Boolean isDelete = userService.deleteUserById(uId);
		
		return "redirect:users";
	}
}
