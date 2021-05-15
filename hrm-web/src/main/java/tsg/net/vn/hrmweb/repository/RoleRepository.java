package tsg.net.vn.hrmweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tsg.net.vn.hrmweb.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRoleName(String roleName);
	Role findByRoleCode(String roleCode);
}
