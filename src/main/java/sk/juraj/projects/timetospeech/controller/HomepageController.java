package sk.juraj.projects.timetospeech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
	
	@GetMapping("/home")
	public String serveHomepage(Model model) {
		return "home";
	}

}
