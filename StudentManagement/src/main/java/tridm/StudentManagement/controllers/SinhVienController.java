package tridm.StudentManagement.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tridm.StudentManagement.models.SinhVien;
import tridm.StudentManagement.services.SinhVienService;

public class SinhVienController {
    private SinhVienService svService;

    public SinhVienController(SinhVienService svService) {
        super();
        this.svService = svService;
    }
    
    @GetMapping("/sinhViens")
	public String listStudents(Model model) {
		model.addAttribute("sinhViens", svService.getAllSinhVien());
		return "sinhViens";
	}

    @GetMapping("/sinhViens/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		SinhVien sv = new SinhVien();
		model.addAttribute("sinhVien", sv);
		return "create_sv";
		
	}

    @GetMapping("/sinhViens/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("sinhVien", svService.getSinhVienById(id));
		return "edit_sv";
	}

    @PostMapping("/sinhViens/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") SinhVien sv,
			Model model) {
		
		// get student from database by id
		SinhVien existingStudent = svService.getSinhVienById(id);
		existingStudent.setId(id);
        existingStudent.setMSSV(sv.getMSSV());
		existingStudent.setTen(sv.getTen());
		existingStudent.setGioiTinh(sv.getGioiTinh());
		existingStudent.setDiaChi(sv.getDiaChi());
		existingStudent.setDienThoai(sv.getDienThoai());
		existingStudent.setMaKhoa(sv.getMaKhoa());
		// save updated student object
		svService.updateSinhVien(existingStudent);
		return "redirect:/sinhViens";		
	}
}
