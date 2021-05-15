package tsg.net.vn.hrmweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tsg.net.vn.hrmweb.model.Employee;
import tsg.net.vn.hrmweb.model.Position;
import tsg.net.vn.hrmweb.model.PositionEmployee;
import tsg.net.vn.hrmweb.repository.EmployeeRepository;
import tsg.net.vn.hrmweb.repository.PositionEmployeeRepository;
import tsg.net.vn.hrmweb.repository.PositionRepositoty;



@RestController
@RequestMapping("/api")
public class PosEmpController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private PositionRepositoty positionRepositoty;
	@Autowired
	private PositionEmployeeRepository posEmpRepository;
	
	@GetMapping("/assign-emp")
	public void assignPostionForEmp() {
		Optional<Position> nv = positionRepositoty.findById(3L);
		Optional<Position> gd = positionRepositoty.findById(4L);
		
		Optional<Employee> e1 = employeeRepository.findById(1L);
		PositionEmployee pe1 = new PositionEmployee();
		pe1.setEmployee(e1.get());
		pe1.setPosition(nv.get());
		posEmpRepository.save(pe1);
		
		Optional<Employee> e2 = employeeRepository.findById(2L);
		PositionEmployee pe2 = new PositionEmployee();
		pe2.setEmployee(e2.get());
		pe2.setPosition(nv.get());
		posEmpRepository.save(pe2);
		
		Optional<Employee> e3 = employeeRepository.findById(3L);
		PositionEmployee pe3 = new PositionEmployee();
		pe3.setEmployee(e3.get());
		pe3.setPosition(nv.get());
		posEmpRepository.save(pe3);
		
		Optional<Employee> e4 = employeeRepository.findById(4L);
		PositionEmployee pe4 = new PositionEmployee();
		pe4.setEmployee(e4.get());
		pe4.setPosition(gd.get());
		posEmpRepository.save(pe4);
		
	}
	
	@GetMapping("/delete-assign")
	public void deleteAssign() {
		Optional<PositionEmployee> po = posEmpRepository.findById(1L);
		if(po.isPresent()) {
			posEmpRepository.deleteById(po.get().getId());
		}
	}
//	xoa vi tri cua ho.=> xoa position_employee, giu nguyen: employee, possition
//	xoa nhan vien => xoa employee, xoa position_employee
}
