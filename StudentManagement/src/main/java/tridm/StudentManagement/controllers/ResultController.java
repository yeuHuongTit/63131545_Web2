package tridm.StudentManagement.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import tridm.StudentManagement.models.Mail;
import tridm.StudentManagement.models.Result;
import tridm.StudentManagement.models.Student;
import tridm.StudentManagement.models.Subject;
import tridm.StudentManagement.services.EmailService;
import tridm.StudentManagement.services.ResultService;
import tridm.StudentManagement.services.StudentService;
import tridm.StudentManagement.services.SubjectService;

@Controller
public class ResultController {
    @Autowired
	private ResultService resultService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

	@Autowired
    private EmailService emailService;

	public ResultController(ResultService resultService) {
		super();
		this.resultService = resultService;
	}

	@GetMapping("/results")
	public String viewHomePage(Model model, @Param("keyword") String keyword, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
		Page<Result> list = this.resultService.getAllResults(pageNo);

		if(keyword != null) {
			list = this.resultService.searchResult(keyword, pageNo);
			model.addAttribute("keyword", keyword);
		}
		model.addAttribute("totalPages", list.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("results", list);
		return "result/index";	
	}

	// them
	@GetMapping("/results/new")
	public String createResultForm(Model model) {
		
		// create student object to hold student form data
		Result result = new Result();
		model.addAttribute("result", result);

        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
		return "result/add";
		
	}
	
	@PostMapping("/results/new")
	public String saveResult(@ModelAttribute("result") Result result) {
		resultService.saveResult(result);
		return "redirect:/results";
	}
	
	// sua 
	@GetMapping("/Results/edit/{ResultId}")
	public String editResultForm(@PathVariable("ResultId") Long resultId, Model model) {
		Result result = this.resultService.getResultById(resultId);
		model.addAttribute("result", result);

        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
		return "result/edit";
	}

	@PostMapping("/results/edit/{ResultId}")
	public String updateResult(@PathVariable("resultId") Long resultId,
			@ModelAttribute("result") Result result,
			Model model) {
		
		// get student from database by id
		Result existingResult = resultService.getResultById(resultId);
		existingResult.setResultId(resultId);

		existingResult.setTerm(result.getTerm());
		existingResult.setYear(result.getYear());
		existingResult.setMark(result.getMark());

		existingResult.setResultId(resultId);

		
		// save updated student object
		resultService.updateResult(existingResult);
		return "redirect:/results";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/result/delete/{resultId}")
	public String deleteResult(@PathVariable("resultId") Long resultId) {
		if (this.resultService.deleteResultById(resultId)) {
			return "redirect:/results";
 
		} else {
			return "redirect:/results";
		}
	}	

	@GetMapping("/results/sendAllEmail")
    public String sendAllResultsEmail() {
        List<Result> results = resultService.getAllResults();

        // Tạo nội dung email với toàn bộ kết quả
        String to = "miinhtri1310@gmail.com";
        String subject = "All Student Results";
        String text = results.stream()
                .map(result -> "Student: " + result.getStudentId().getName() +
                        "\nSubject: " + result.getSubjectId().getName() +
                        "\nTerm: " + result.getTerm() +
                        "\nYear: " + result.getYear() +
                        "\nMark: " + result.getMark() + "\n\n")
                .collect(Collectors.joining());

        Mail mail = new Mail(subject, text);
        emailService.sendSimpleEmail(to, mail);

        return "redirect:/results";
    }

}
