package tsg.net.vn.hrmweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tsg.net.vn.hrmweb.model.PositionEmployee;
import tsg.net.vn.hrmweb.repository.PositionEmployeeRepository;
@Service
public class PositionEmployeeService {
	@Autowired
	private PositionEmployeeRepository positionEmployeeRepository;
	
	public List<PositionEmployee> getAllPositionEmployee() {
		return positionEmployeeRepository.findAll();
	}
}
