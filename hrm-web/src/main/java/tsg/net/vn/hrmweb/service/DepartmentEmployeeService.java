package tsg.net.vn.hrmweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tsg.net.vn.hrmweb.model.Department;
import tsg.net.vn.hrmweb.model.DepartmentEmployee;
import tsg.net.vn.hrmweb.repository.DepartmentEmployeeRepository;
@Service
public class DepartmentEmployeeService{
	@Autowired
	private DepartmentEmployeeRepository departmentEmployeeRepository;
	
	public List<DepartmentEmployee> getAllDepartmentEmployee() {
		return departmentEmployeeRepository.findAll();
	}
}
