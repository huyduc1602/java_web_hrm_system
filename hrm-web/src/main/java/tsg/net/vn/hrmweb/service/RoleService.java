package tsg.net.vn.hrmweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tsg.net.vn.hrmweb.model.Role;
import tsg.net.vn.hrmweb.model.Users;
import tsg.net.vn.hrmweb.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	public Role findByRoleCode(String roleCode) {
		return roleRepository.findByRoleCode(roleCode);
	}
}
