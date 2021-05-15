package tsg.net.vn.hrmweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tsg.net.vn.hrmweb.model.Employee;
import tsg.net.vn.hrmweb.model.Position;
import tsg.net.vn.hrmweb.model.PositionEmployee;


@Repository
public interface PositionEmployeeRepository extends JpaRepository<PositionEmployee, Long>{
	List<PositionEmployee> findByEmployee(Employee employee);
	List<PositionEmployee> findByPosition(Position position);
}
