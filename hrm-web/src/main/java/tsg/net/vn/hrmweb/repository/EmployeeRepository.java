package tsg.net.vn.hrmweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tsg.net.vn.hrmweb.model.EmpPosProjection;
import tsg.net.vn.hrmweb.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//	@Query("select e from Employee e")
//	List<Employee> getAllEmpJPQL();
//	
	@Query(value="select * from employee", nativeQuery = true)
	List<Employee> getAllEmpNative();
	
	@Query(value = "select e.em_id emId,e.name,e.address,p.pos_code posCode from employee e \r\n"
			+ "join position_employee po on e.em_id = po.em_id\r\n"
			+ "join position p on po.pos_id = p.pos_id",nativeQuery = true)
	List<EmpPosProjection> getEmployPos();
}
