package tsg.net.vn.hrmweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tsg.net.vn.hrmweb.model.Department;
import tsg.net.vn.hrmweb.model.DepartmentEmployee;
import tsg.net.vn.hrmweb.model.Employee;
import tsg.net.vn.hrmweb.model.Position;
import tsg.net.vn.hrmweb.model.PositionEmployee;
import tsg.net.vn.hrmweb.repository.DepartmentEmployeeRepository;
import tsg.net.vn.hrmweb.repository.DepartmentRepository;
import tsg.net.vn.hrmweb.repository.EmployeeRepository;
import tsg.net.vn.hrmweb.repository.PositionEmployeeRepository;
import tsg.net.vn.hrmweb.repository.PositionRepositoty;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private PositionRepositoty positionRepository;
	@Autowired
	private DepartmentEmployeeRepository departmentEmployeeRepository;
	@Autowired
	private PositionEmployeeRepository positionEmployeeRepository;
	
	public List<Employee> allEmployee() {
		return employeeRepository.getAllEmpNative();
	}
	public Employee getEmployeeById(Long id) throws Exception{
        Optional<Employee> employee = employeeRepository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }
	public Employee createOrUpdateEmployee(Employee employee,List<Long> dId,List<Long> pId) 
    {
        if(employee.getEmId()  == null) 
        {
            employee = employeeRepository.save(employee);
            //Cập nhật bảng DepartmentEmployee
            for (Long id : dId) {
            	  Optional<Department> departmentUpdate =  departmentRepository.findById(id);
            	  if(departmentUpdate.isPresent()) 
                  {
            		  Department department =  departmentUpdate.get();
            		  DepartmentEmployee departmentEmployee = (DepartmentEmployee) departmentEmployeeRepository.findByDepartment(department);
                      departmentEmployee.setDepartment(department);
                      departmentEmployee.setEmployee(employee);
                      departmentEmployeeRepository.save(departmentEmployee);
                  }            	  
			}
          //Cập nhật bảng PositionEmployee
            for (Long id : pId) {
          	  Optional<Position> positionUpdate =  positionRepository.findById(id);
          	  if(positionUpdate.isPresent()) 
                {
          		Position position =  positionUpdate.get();
          		  PositionEmployee positionEmployee = (PositionEmployee) positionEmployeeRepository.findByPosition(position);
          		  positionEmployee.setPosition(position);
          		  positionEmployee.setEmployee(employee);
                    positionEmployeeRepository.save(positionEmployee);
                }            	  
			}
            return employee;
        } 
        else
        {
            Optional<Employee> employeeUpdate = employeeRepository.findById(employee.getEmId());
             
            if(employeeUpdate.isPresent()) 
            {
            	Employee newEmployee = employeeUpdate.get();
            	newEmployee.setName(employee.getName());
            	newEmployee.setBirthday(employee.getBirthday());
            	newEmployee.setAddress(employee.getAddress());
 
            	newEmployee = employeeRepository.save(newEmployee);
                 
            	//Cập nhật bảng DepartmentEmployee
                for (Long id : dId) {
                	  Optional<Department> departmentUpdate =  departmentRepository.findById(id);
                	  if(departmentUpdate.isPresent()) 
                      {
                		  Department department =  departmentUpdate.get();
                		  DepartmentEmployee departmentEmployee = (DepartmentEmployee) departmentEmployeeRepository.findByDepartment(department);
                          departmentEmployee.setDepartment(department);
                          departmentEmployee.setEmployee(employee);
                          departmentEmployeeRepository.save(departmentEmployee);
                      }            	  
    			}
              //Cập nhật bảng PositionEmployee
                for (Long id : pId) {
              	  Optional<Position> positionUpdate =  positionRepository.findById(id);
              	  if(positionUpdate.isPresent()) 
                    {
              		Position position =  positionUpdate.get();
              		  PositionEmployee positionEmployee = (PositionEmployee) positionEmployeeRepository.findByPosition(position);
              		  positionEmployee.setPosition(position);
              		  positionEmployee.setEmployee(employee);
                        positionEmployeeRepository.save(positionEmployee);
                    }            	  
    			}
                 
                return newEmployee;
            } else {
            	employee = employeeRepository.save(employee);
                 
            	//Cập nhật bảng DepartmentEmployee
                for (Long id : dId) {
                	  Optional<Department> departmentUpdate =  departmentRepository.findById(id);
                	  if(departmentUpdate.isPresent()) 
                      {
                		  Department department =  departmentUpdate.get();
                		  DepartmentEmployee departmentEmployee = (DepartmentEmployee) departmentEmployeeRepository.findByDepartment(department);
                          departmentEmployee.setDepartment(department);
                          departmentEmployee.setEmployee(employee);
                          departmentEmployeeRepository.save(departmentEmployee);
                      }            	  
    			}
              //Cập nhật bảng PositionEmployee
                for (Long id : pId) {
              	  Optional<Position> positionUpdate =  positionRepository.findById(id);
              	  if(positionUpdate.isPresent()) 
                    {
              		Position position =  positionUpdate.get();
              		  PositionEmployee positionEmployee = (PositionEmployee) positionEmployeeRepository.findByPosition(position);
              		  positionEmployee.setPosition(position);
              		  positionEmployee.setEmployee(employee);
                        positionEmployeeRepository.save(positionEmployee);
                    }            	  
    			}
                 
                return employee;
            }
        }
    }
//	public List<Department> getListDepartmentByEmployee( Long user_id) throws Exception{
//		Employee emp = employeeService.getEmployeeById(user_id);
//		List<Department> listDe = new ArrayList<Department>();
//		List<DepartmentEmployee> de = departmentEmployeeRepository.findByEmployee(emp);
//		for (DepartmentEmployee departmentEmployee : de) {
//				if(departmentEmployee.getEmployee().getEmId() == user_id) {
//					listDe.add(departmentEmployee.getDepartment());
//				}
//		}
//		return listDe;
//	}
	public boolean deleteAssign(Long id) {
		Optional<DepartmentEmployee> dp = departmentEmployeeRepository.findById(id);
		if(dp.isPresent()) {
			positionEmployeeRepository.deleteById(dp.get().getId());
			return true;
		}else {
			return false;
		}
		
	}
	public boolean DeleteEmployee(Long id) throws Exception {
		Employee e = getEmployeeById(id);
		if(e ==null) return false;
		//Tim gan
		List<DepartmentEmployee> listDe = e.getDepartmentEmpList();
		//xoa gan
		for (DepartmentEmployee de : listDe) {
			deleteAssign(de.getId());
		}
		//xoa phan tu
		List<Employee> list = allEmployee();
		list.remove(id);
		return true;
	}
	
}
