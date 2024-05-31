package tridm.StudentManagement.controllers;

import org.springframework.stereotype.Controller;

import java.util.List;

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
import tridm.StudentManagement.models.Teacher;
import tridm.StudentManagement.services.DepartmentService;
import tridm.StudentManagement.services.TeacherService;

@Controller
public class TeacherController {
    @Autowired
	private TeacherService teacherService;

	@Autowired
	private DepartmentService departmentService;

	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}

	@GetMapping("/teachers")
	public String viewHomePage(Model model, @Param("keyword") String keyword, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
		Page<Teacher> list = this.teacherService.getAllTeachers(pageNo);

		if(keyword != null) {
			list = this.teacherService.searchTeacher(keyword, pageNo);
			model.addAttribute("keyword", keyword);
		}
		model.addAttribute("totalPages", list.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("teachers", list);
		return "teacher/index";	
	}

	// them
	@GetMapping("/teachers/new")
	public String createTeacherForm(Model model) {
		
		// create Teacher object to hold Teacher form data
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);

		List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
		return "teacher/add";
		
	}
	
	@PostMapping("/teachers/new")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
	}
	
	// sua 
	@GetMapping("/teachers/edit/{teacherId}")
	public String editTeacherForm(@PathVariable("teacherId") Long teacherId, Model model) {
		Teacher teacher = this.teacherService.getTeacherById(teacherId);
		model.addAttribute("teacher", teacher);
		
		List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
		return "teacher/edit";
	}

	@PostMapping("/teachers/edit/{teacherId}")
	public String updateTeacher(@PathVariable("teacherId") Long teacherId,
			@ModelAttribute("teacher") Teacher teacher,
			Model model) {
		
		// get Teacher from database by id
		Teacher existingTeacher = teacherService.getTeacherById(teacherId);
		existingTeacher.setTeacherId(teacherId);
		existingTeacher.setName(teacher.getName());
        existingTeacher.setDepartment(teacher.getDepartment());
		// save updated Teacher object
		teacherService.updateTeacher(existingTeacher);
		return "redirect:/teachers";		
	}
	
	// handler method to handle delete Teacher request
	
	@GetMapping("/teachers/delete/{teacherId}")
	public String deleteTeacher(@PathVariable("teacherId") Long teacherId) {
		if (this.teacherService.deleteTeacherById(teacherId)) {
			return "redirect:/teachers";
 
		} else {
			return "redirect:/teachers";
		}
	}	

	
}