package com.example.demo;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SampleController {
	
	@GetMapping({"/","/main"})
	public String page1(Model model) {
		model.addAttribute("today", new Date());
		model.addAttribute("name", "홍길동");
		return "main";
	}
	
	
}
