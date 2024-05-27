package tridm.StudentManagement.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import tridm.StudentManagement.models.Department;

@Service
public interface DepartmentService {
    List<Department> getAllDepartments();
	
	// Student saveStudent(Student student);

	void saveDepartment(Department department);
	
	Department getDepartmentById(Long id);
	
	Department updateDepartment(Department department);
	
	Boolean deleteDepartmentById(Long id);

	List<Department> searchDepartment(String keyword);

	Page<Department> getAllDepartments(Integer pageNo);

	Page<Department> searchDepartment(String keyword, Integer pageNo);
}
