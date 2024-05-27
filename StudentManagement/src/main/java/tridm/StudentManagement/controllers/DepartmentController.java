package tridm.StudentManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tridm.StudentManagement.models.Department;
import tridm.StudentManagement.models.Student;
import tridm.StudentManagement.services.*;

public class DepartmentController {
    @Autowired
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}

	@GetMapping("/departments")
	public String viewHomePage(Model model, @Param("keyword") String keyword, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
		Page<Department> list = this.departmentService.getAllDepartments(pageNo);

		if(keyword != null) {
			list = this.departmentService.searchDepartment(keyword, pageNo);
			model.addAttribute("keyword", keyword);
		}
		model.addAttribute("totalPages", list.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("departments", list);
		return "student/index";	
	}

	// them
	@GetMapping("/departments/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Student student = new Student();
		student.setGender(true);
		model.addAttribute("student", student);
		return "student/add";
		
	}
	
	@PostMapping("/departments/new")
	public String saveStudent(@ModelAttribute("student") Department department) {
		departmentService.saveDepartment(department);
		return "redirect:/departments";
	}
	
	// sua 
	@GetMapping("/departments/edit/{departmentId}")
	public String editStudentForm(@PathVariable("departmentId") Long departmentId, Model model) {
		Department department = this.departmentService.getDepartmentById(departmentId);
		
		model.addAttribute("department", department);
		return "department/edit";
	}

	@PostMapping("/departments/edit/{departmentId}")
	public String updateDepartment(@PathVariable("departmentId") Long departmentId,
			@ModelAttribute("department") Department department,
			Model model) {
		
		// get student from database by id
		Department existingDepartment = departmentService.getDepartmentById(departmentId);
		existingDepartment.setDepartmentId(departmentId);
		existingDepartment.setName(department.getName());

		
		// save updated student object
		departmentService.updateDepartment(existingDepartment);
		return "redirect:/departments";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/departments/delete/{departmentId}")
	public String deleteStudent(@PathVariable("departmentId") Long departmentId) {
		if (this.departmentService.deleteDepartmentById(departmentId)) {
			return "redirect:/departments";
 
		} else {
			return "redirect:/departments";
		}
	}	
}
