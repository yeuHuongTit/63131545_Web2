package tridm.CSS_JS_IMAGE_Bootrap_63131545.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String Index() {
		return "index";
	}
}