package tsg.net.vn.hrmweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tsg.net.vn.hrmweb.model.RoleProjection;
import tsg.net.vn.hrmweb.model.UserRole;
import tsg.net.vn.hrmweb.model.Users;
import tsg.net.vn.hrmweb.model.Role;
import tsg.net.vn.hrmweb.repository.RoleRepository;
import tsg.net.vn.hrmweb.repository.UserRepository;
import tsg.net.vn.hrmweb.repository.UserRoleRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Create user
	 * 
	 * @param user
	 * @return
	 */
	public Users createUser(Users user, Role role) {
		if (user.getUsename() != null && role.getRoleName() != null) {
			if (isExistUserByUsername(user)) {
				return null;
			}
			if (!isExistRoleByRoleName(role)) {
				return null;
			}
			Users u = new Users();
			u.setUsename(user.getUsename().trim());
			u.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(u);

//			Role r = new Role();
//			r.setRoleCode(role.getRoleCode().trim());
//			r.setRoleName(role.getRoleName());
//			roleRepository.save(r);

			UserRole userRole = new UserRole();
			userRole.setUser(u);
			userRole.setRole(role);
			userRoleRepository.save(userRole);

			return u;
		}
		return null;
	}
	public List<Users> getAllUser() {
		return userRepository.findAll();
	}
	public boolean isExistUserByUsername(Users u) {
		Users user = userRepository.findByUsename(u.getUsename().trim());
		if (user != null) {
			return true;
		}
		return false;
	}
	public boolean isExistRoleByRoleName(Role r) {
		Role role = roleRepository.findByRoleName(r.getRoleName().trim());
		if (role != null) {
			return true;
		}
		return false;
	}

	public Users findByUsername(String username) {
		return userRepository.findByUsename(username);
	}
	
	public List<RoleProjection> getListRoleOfUser(Long userId){	
		return userRepository.getRoleOfUser(userId);
	}

	public Users updateUserById(Long userId, String username,String password,String roleCode) {
		Optional<Users> userOption = userRepository.findById(userId);
		if (userOption.isPresent()) {
			Users u = userOption.get();
			u.setUsename(username);
			u.setPassword(password);
			
			userRepository.save(u);
			return u;
		}
		return null;
	}

	public Boolean deleteUserById(Long userId) {
		Optional<Users> userOption = userRepository.findById(userId);
		if (userOption.isPresent()) {
			userRepository.delete(userOption.get());
			return true;
		}
		return false;
	}
}
