package tsg.net.vn.hrmweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tsg.net.vn.hrmweb.model.Department;
import tsg.net.vn.hrmweb.repository.DepartmentRepository;
import tsg.net.vn.hrmweb.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DepartmentRepository departmentRepository;
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("/departments")
	public String getAllDepartment(Model model) {
		List<Department> departmentList = departmentService.getAllDepartment();
		model.addAttribute(departmentList);
		return "departments";
	}

	@RequestMapping(path = {"/departments/add","/departments/update","/departments/update/{id}", "/departments/view/{id}"})
    public String addOrViewDepartment(Model model, @PathVariable("id") Optional<Long> id) 
                            throws Exception {
        if (id.isPresent()) {
        	Department entity = departmentService.getDepartmentById(id.get());
            model.addAttribute("department", entity);
        } else {
            model.addAttribute("department", new Department());
        }
        return "department/department-add-edit";
    }
	@RequestMapping(path = "/createDepartment",method= RequestMethod.POST)
	public String createOrUpdatDepartment(Department department) {
		departmentService.createOrUpdateDepartment(department);
		return "redirect:/departments";	
	}
	@GetMapping("/departments/delete/{departmentId}")
	public String deleteDepartment(@PathVariable("departmentId") Long deId, Model model) {
		Department department = departmentRepository.findById(deId)
				.orElseThrow(() -> new IllegalArgumentException("Mã phòng ban không hợp lệ: " + deId));
		String messDelete = null;
		if(department.getDepartmentEmpList().size() > 0) {
			messDelete = "Phòng ban có nhân viên không thể xóa";
		}else {
			departmentService.deleteDepartmentById(deId);
			messDelete = "Xóa phòng ban thành công";
		}		
		model.addAttribute("departmentList", departmentService.getAllDepartment());
		model.addAttribute(messDelete);
		return "redirect:/departments";
	}
}
