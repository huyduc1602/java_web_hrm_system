package tsg.net.vn.hrmweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tsg.net.vn.hrmweb.model.Department;
import tsg.net.vn.hrmweb.model.DepartmentEmployee;
import tsg.net.vn.hrmweb.model.Employee;


@Repository
public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, Long>{
	List<DepartmentEmployee> findByEmployee(Employee employee);
	List<DepartmentEmployee> findByDepartment(Department department);
}
