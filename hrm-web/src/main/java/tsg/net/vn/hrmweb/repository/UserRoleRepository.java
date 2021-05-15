package tsg.net.vn.hrmweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tsg.net.vn.hrmweb.model.UserRole;



@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
}
