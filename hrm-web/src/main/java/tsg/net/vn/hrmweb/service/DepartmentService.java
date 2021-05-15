package tsg.net.vn.hrmweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tsg.net.vn.hrmweb.model.Department;
import tsg.net.vn.hrmweb.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}

	public Department updateDepartmentById(Long deId, String deName,String deCode,String deDesc) {
		Optional<Department> deOption = departmentRepository.findById(deId);
		if (deOption.isPresent()) {
			Department de = deOption.get();
			de.setDeName(deName);
			de.setDeCode(deCode);
			de.setDeDesc(deDesc);
			departmentRepository.save(de);
			return de;
		}
		return null;
	}
	public Department createOrUpdateDepartment(Department entity) 
    {
        if(entity.getDeId()  == null) 
        {
            entity = departmentRepository.save(entity);
             
            return entity;
        } 
        else
        {
            Optional<Department> department = departmentRepository.findById(entity.getDeId());
             
            if(department.isPresent()) 
            {
            	Department newEntity = department.get();
                newEntity.setDeCode(entity.getDeCode());
                newEntity.setDeDesc(entity.getDeDesc());
                newEntity.setDeName(entity.getDeName());
 
                newEntity = departmentRepository.save(newEntity);
                 
                return newEntity;
            } else {
                entity = departmentRepository.save(entity);
                 
                return entity;
            }
        }
    }
	public Department getDepartmentById(Long id) throws Exception{
        Optional<Department> department = departmentRepository.findById(id);
         
        if(department.isPresent()) {
            return department.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }
	public Boolean deleteDepartmentById(Long deId) {
		Optional<Department> deOption = departmentRepository.findById(deId);
		if (deOption.isPresent()) {
			departmentRepository.delete(deOption.get());
			return true;
		}
		return false;
	}
}
