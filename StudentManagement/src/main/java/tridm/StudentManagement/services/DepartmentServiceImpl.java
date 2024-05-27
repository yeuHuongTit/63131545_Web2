package tridm.StudentManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import tridm.StudentManagement.models.Department;
import tridm.StudentManagement.repositories.DepartmentRepository;

public class DepartmentServiceImpl implements DepartmentService{
    @Autowired DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public void saveDepartment(Department Department) {
		this.departmentRepository.save(Department);
	}

	@Override
	public Department getDepartmentById(Long id) {
		Optional<Department> optional = departmentRepository.findById(id);
		Department Department = null;
		if (optional.isPresent()) {
			Department = optional.get();
		} else {
			throw new RuntimeException(" Department not found for id :: " + id);
		}
		return Department;
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Boolean deleteDepartmentById(Long id) {
		try {
			Department department = this.getDepartmentById(id);
			if (department != null) {
				this.departmentRepository.delete(department);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Department> searchDepartment(String keyword) {
		return this.departmentRepository.searchDepartment(keyword);
	}

	@Override
	public Page<Department> getAllDepartments(Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 3);
		return this.departmentRepository.findAll(pageable);
	}

	@Override
	public Page<Department> searchDepartment(String keyword, Integer pageNo) {
		List list = this.searchDepartment(keyword);
		Pageable pageable = PageRequest.of(pageNo - 1, 2);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) (pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start,end);
		return new PageImpl<Department>(list, pageable, list.size());
	}
}
