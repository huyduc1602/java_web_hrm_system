package tsg.net.vn.hrmweb.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tsg.net.vn.hrmweb.model.RoleProjection;
import tsg.net.vn.hrmweb.model.Users;


@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = userService.findByUsername(username); //load user tren database
		if (user != null) {
			List<RoleProjection> strRoleList = userService.getListRoleOfUser(user.getUserId());
			Set<String> roleSet = new HashSet();
			for(RoleProjection role : strRoleList) {
				roleSet.add(role.getRoleCode());
			}
			
			//lay danh sach quyen cua user do
			List<GrantedAuthority> authories = roleSet.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
			return new User(user.getUsename(),user.getPassword(),authories);
		}

		return null;
	}

}
