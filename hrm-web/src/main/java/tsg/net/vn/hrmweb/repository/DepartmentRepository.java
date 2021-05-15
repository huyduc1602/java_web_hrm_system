package tsg.net.vn.hrmweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tsg.net.vn.hrmweb.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
