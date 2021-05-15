package tsg.net.vn.hrmweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tsg.net.vn.hrmweb.model.RoleProjection;
import tsg.net.vn.hrmweb.model.Users;



@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	Users findByUsename(String usename);
	
	@Query(value = "select r.role_code roleCode from user u\r\n"
			+ "join user_role ul on u.user_id = ul.user_id\r\n"
			+ "join role r on ul.role_id = r.role_id\r\n"
			+ "where u.user_id= :userId",nativeQuery = true)
	List<RoleProjection> getRoleOfUser(@Param("userId") Long userId);
}
