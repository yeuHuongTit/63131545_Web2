package tridm.StudentManagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tridm.StudentManagement.Models.Student;
import tridm.StudentManagement.Services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/")
	public String home() {
		return "Index";
	}

	@GetMapping("/students")
	public String viewHomePage(Model model, @Param("keyword") String keyword, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
		Page<Student> list = this.studentService.getAllStudents(pageNo);

		if(keyword != null) {
			list = this.studentService.searchStudent(keyword, pageNo);
			model.addAttribute("keyword", keyword);
		}
		model.addAttribute("totalPages", list.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("students", list);
		return "student/index";	
	}

	// them
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Student student = new Student();
		student.setGender(true);
		model.addAttribute("student", student);
		return "student/add";
		
	}
	
	@PostMapping("/students/new")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	// sua 
	@GetMapping("/students/edit/{studentId}")
	public String editStudentForm(@PathVariable("studentId") Long studentId, Model model) {
		Student student = this.studentService.getStudentById(studentId);
		
		model.addAttribute("student", student);
		return "student/edit";
	}

	@PostMapping("/students/edit/{studentId}")
	public String updateStudent(@PathVariable("studentId") Long studentId,
			@ModelAttribute("student") Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(studentId);
		existingStudent.setStudentId(studentId);
		existingStudent.setName(student.getName());
		existingStudent.setGender(student.isGender());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setPhone(student.getPhone());

		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/students/delete/{studentId}")
	public String deleteStudent(@PathVariable("studentId") Long studentId) {
		if (this.studentService.deleteStudentById(studentId)) {
			return "redirect:/students";
 
		} else {
			return "redirect:/students";
		}
	}	

	
}