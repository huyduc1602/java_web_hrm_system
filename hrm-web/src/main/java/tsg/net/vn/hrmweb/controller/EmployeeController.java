package tsg.net.vn.hrmweb.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tsg.net.vn.hrmweb.dto.DepartmentDTO;
import tsg.net.vn.hrmweb.dto.PositionDTO;
import tsg.net.vn.hrmweb.model.ClientWithDepartmentListWrapper;
import tsg.net.vn.hrmweb.model.ClientWithPositionListWrapper;
import tsg.net.vn.hrmweb.model.Department;
import tsg.net.vn.hrmweb.model.DepartmentEmployee;
import tsg.net.vn.hrmweb.model.Employee;
import tsg.net.vn.hrmweb.model.Position;
import tsg.net.vn.hrmweb.model.PositionEmployee;
import tsg.net.vn.hrmweb.repository.DepartmentEmployeeRepository;
import tsg.net.vn.hrmweb.repository.PositionEmployeeRepository;
import tsg.net.vn.hrmweb.service.DepartmentEmployeeService;
import tsg.net.vn.hrmweb.service.DepartmentService;
import tsg.net.vn.hrmweb.service.EmployeeService;
import tsg.net.vn.hrmweb.service.PositionEmployeeService;
import tsg.net.vn.hrmweb.service.PositionService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private DepartmentEmployeeRepository deRepository;
	@Autowired
	private PositionEmployeeRepository peRepository;
	@Autowired
	private DepartmentEmployeeService departmentEmployeeService;
	@Autowired
	private PositionEmployeeService positionEmployeeService;
	@GetMapping("/employees")
	public String allEmployees(Model model) {
		model.addAttribute("departmentList", departmentService.getAllDepartment());
		model.addAttribute("positionList", positionService.getAllPosition());
		model.addAttribute("employeeList", employeeService.allEmployee());
		List<Employee> list = employeeService.allEmployee();

		return "employees"; 
	}
	 private ArrayList<DepartmentDTO> allClientsWithDepartment = new ArrayList<DepartmentDTO>();
	 private ArrayList<PositionDTO> allClientsWithPosition = new ArrayList<PositionDTO>();
	 private void GetListSelect(Employee entity) {
		 //Làm rỗng
		 allClientsWithDepartment.clear();
		 allClientsWithPosition.clear();
		//Lấy ra được danh sách phòng ban và có liên kết select = true
		 //Khởi tạo danh sách
		 List<DepartmentDTO> departmentList =  new ArrayList<DepartmentDTO>();
		 //Thêm vào các phòng được liên kết
		 for (Department deAll : departmentService.getAllDepartment()) {
			 	int dem = 0;
			 	DepartmentDTO departmentDTO =  new DepartmentDTO();
			 	departmentDTO.setDeId(deAll.getDeId());
				departmentDTO.setDeName(deAll.getDeName());
				departmentDTO.setDeCode(deAll.getDeCode());
				departmentDTO.setDeDesc(deAll.getDeDesc());
				for (DepartmentEmployee de : entity.getDepartmentEmpList()) {
					if(de.getDepartment().getDeId() == deAll.getDeId()) {
						dem++;
					}
				}
				if(dem >0) {
					departmentDTO.setSelected(true);
				}else {
					departmentDTO.setSelected(false);
				}
				allClientsWithDepartment.add(departmentDTO);
		}
		//Lấy ra được danh sách chức vụ và có liên kết select = true
		 //Khởi tạo danh sách
		 List<PositionDTO> positionList =  new ArrayList<PositionDTO>();
		 //Thêm vào các chức vụ được liên kết
		 for (Position peAll : positionService.getAllPosition()) {
			 	int dem = 0;
			 	PositionDTO positionDTO =  new PositionDTO();
			 	positionDTO.setPosId(peAll.getPosId());
			 	positionDTO.setPosName(peAll.getPosName());
			 	positionDTO.setPosCode(peAll.getPosCode());
			 	positionDTO.setPosDesc(peAll.getPosDesc());
				for (PositionEmployee pe : entity.getPositionEmpList()) {
					if(pe.getPosition().getPosId() == peAll.getPosId()) {
						dem++;
					}
				}
				if(dem >0) {
					positionDTO.setSelected(true);
				}else {
					positionDTO.setSelected(true);
				}
				allClientsWithPosition.add(positionDTO);
		}
	 }
	@RequestMapping(path = {"/employees/update/{id}"},method= RequestMethod.GET)
	public String ViewEditEmployee(@PathVariable("id") Optional<Long> id, Model model) throws Exception {
		Employee entity = employeeService.getEmployeeById(id.get());
		GetListSelect(entity);
		 
		//Đẩy danh sách phòng ban
		 ClientWithDepartmentListWrapper departmentWrapper = new ClientWithDepartmentListWrapper();
		 departmentWrapper.setClientList(allClientsWithDepartment);
	      model.addAttribute("departmentWrapper", departmentWrapper);
	      
	    //Đẩy danh sách chức vụ
			 ClientWithPositionListWrapper positionWrapper = new ClientWithPositionListWrapper();
			 positionWrapper.setClientList(allClientsWithPosition);
		      model.addAttribute("positionWrapper", positionWrapper);
		      
	      //end test
		
		model.addAttribute("employee", entity);
		return "employee/employee-edit";
	}
	@PostMapping("/employees/update/{id}")
	public String CreateOrUpdateEmployee(@PathVariable("id") Optional<Long> id, Model model,
			@ModelAttribute ClientWithDepartmentListWrapper departmentWrapper,
			@ModelAttribute ClientWithPositionListWrapper positionWrapper,@RequestParam("name") String name, 
			@RequestParam("birthday") String birthday,@RequestParam("genaral") Long genaral,
			@RequestParam("major") String major,@RequestParam("language") String language,
			@RequestParam("it") String it,@RequestParam("startDate") String startDate,
			@RequestParam("address") String address,@RequestParam("endDate") String endDate,
			@RequestParam("result") String result) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setBirthday((java.util.Date) formatter.parse(birthday));
		employee.setGeneral(genaral);
		employee.setMajor(major);
		employee.setLanguage(language);
		employee.setIt(it);
		employee.setStartDate((java.util.Date) formatter.parse(startDate));
		employee.setAddress(address);
		employee.setEndDate((java.util.Date) formatter.parse(endDate));
		employee.setResult(result);
		if(departmentWrapper.getClientList() == null || positionWrapper.getClientList() == null) {
			return "employees";
		}
		 System.out.println(departmentWrapper.getClientList() != null ? departmentWrapper.getClientList().size() : "Department null list");
		 //Lấy danh sách Id phòng ban
	     List<Long> listIdDepartment = new ArrayList<Long>();
	     for (DepartmentDTO departmentDTO : departmentWrapper.getClientList()) {
	    	 listIdDepartment.add(departmentDTO.getDeId());
	     }
	     //Lấy danh sách Id Chức vụ
	     List<Long> listIdPosition = new ArrayList<Long>();
	     for (PositionDTO positionDTO : positionWrapper.getClientList()) {
	    	 listIdPosition.add(positionDTO.getPosId());
	     }
	     //Thực hiện thêm hoặc cập nhật
	     try {
				employeeService.createOrUpdateEmployee(employee,listIdDepartment,listIdPosition);
				return "redirect:/employees";
			} catch (Exception e) {
				model.addAttribute("employee", employee);
				return "employee/employee-edit";	
			}

	}
	@RequestMapping(path = {"/employees/add","/employees/update","/employees/view/{id}"})
    public String addOrViewEmployee(@PathVariable("id") Optional<Long> id, Model model) throws Exception {
		
		if (id.isPresent()) {
        	Employee entity = employeeService.getEmployeeById(id.get());
//        	get list Department for Employee
        	List<DepartmentEmployee> listDe = entity.getDepartmentEmpList();
        	
        	List<Department> departmenEmptList = new ArrayList<Department>();
        	for (DepartmentEmployee departmentEmployee : listDe) {
        		departmenEmptList.add(departmentEmployee.getDepartment());
			}
        	model.addAttribute("departmenEmptList", departmenEmptList);
//        	get list Position for Employee        	
        	List<PositionEmployee> listPe = entity.getPositionEmpList();
        	
        	List<Position> positionEmptList = new ArrayList<Position>();
        	for (PositionEmployee positionEmployee : listPe) {
        		positionEmptList.add(positionEmployee.getPosition());
			}
        	model.addAttribute("positionEmptList", departmenEmptList);
        	//
            model.addAttribute("employee", entity);
        } else {
            model.addAttribute("employee", new Employee());
        }
        model.addAttribute("departmentList", departmentService.getAllDepartment());
		model.addAttribute("positionList", positionService.getAllPosition());
        return "employee/employee-add-edit";
    }

	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long empId) throws Exception {
		employeeService.DeleteEmployee(empId);
		return "redirect:employees";
	}
//	@GetMapping("/emp-pos")
//	public void getEmployPos(){
//		List<EmpPosProjection> emList = employeeRepository.getEmployPos();
//		for(EmpPosProjection ep : emList) {
//			System.out.println("Name: "+ep.getName()+" Address: "+ep.getAddress()+" Vi tri: "+ep.getPosCode());
//		}
//	}
//	
//	@GetMapping("/employee/update/{id}")
//	public String getDetailEmployee(@PathVariable("empId") Long classId) {
//		return "employee/employee-detail";
//	}

//	@GetMapping("/employee/update/{id}")
//	public String updateEmployee(@PathVariable("id") Long empId) {
//		return "employee/employee-edit";
//	}
//
	
}
