package tridm.StudentManagement.controllers;

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

import tridm.StudentManagement.models.Subject;
import tridm.StudentManagement.services.SubjectService;

@Controller
public class SubjectController {
    @Autowired
	private SubjectService subjectService;

	public SubjectController(SubjectService subjectService) {
		super();
		this.subjectService = subjectService;
	}

	@GetMapping("/subjects")
	public String viewHomePage(Model model, @Param("keyword") String keyword, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
		Page<Subject> list = this.subjectService.getAllSubjects(pageNo);

		if(keyword != null) {
			list = this.subjectService.searchSubject(keyword, pageNo);
			model.addAttribute("keyword", keyword);
		}
		model.addAttribute("totalPages", list.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("subjects", list);
		return "subject/index";	
	}

	// them
	@GetMapping("/subjects/new")
	public String createSubjectForm(Model model) {
		
		// create student object to hold student form data
		Subject subject = new Subject();
		model.addAttribute("subject", subject);
		return "subject/add";
		
	}
	
	@PostMapping("/subjects/new")
	public String saveSubject(@ModelAttribute("subject") Subject subject) {
		subjectService.saveSubject(subject);
		return "redirect:/subjects";
	}
	
	// sua 
	@GetMapping("/subjects/edit/{subjectId}")
	public String edit(@PathVariable("subjectId") Long subjectId, Model model) {
		Subject subject = this.subjectService.getSubjectById(subjectId);
		
		model.addAttribute("subject", subject);
		return "subject/edit";
	}

	@PostMapping("/subjects/edit/{subjectId}")
	public String update(@PathVariable("subjectId") Long subjectId,
			@ModelAttribute("subject") Subject subject,
			Model model) {
		
		// get student from database by id
		Subject existingSubject = subjectService.getSubjectById(subjectId);
		existingSubject.setSubjectId(subjectId);
		existingSubject.setName(subject.getName());

		
		// save updated student object
		subjectService.updateSubject(existingSubject);
		return "redirect:/subjects";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/subjects/delete/{subjectId}")
	public String deleteSubject(@PathVariable("subjectId") Long subjectId) {
		if (this.subjectService.deleteSubjectById(subjectId)) {
			return "redirect:/subjects";
 
		} else {
			return "redirect:/subjects";
		}
	}	
}

