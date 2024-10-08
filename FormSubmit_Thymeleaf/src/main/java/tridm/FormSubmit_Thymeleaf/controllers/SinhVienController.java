package tridm.FormSubmit_Thymeleaf.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tridm.FormSubmit_Thymeleaf.models.DTOSinhVien;

@Controller
public class SinhVienController {
	@GetMapping("/themMoiSV")
	public String showForm(Model mm) {
        DTOSinhVien sinhvienNull = new DTOSinhVien();
        mm.addAttribute("svDTO", sinhvienNull);
        return "themSinhVien_form";
    }
	@PostMapping("/themMoiSV")
	public String submitForm(@ModelAttribute("svDTO") DTOSinhVien sv) {
	    return "themSinhVien_OK";
	}
	 
}