package com.juaracoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juaracoding.model.ComfortModel;
import com.juaracoding.repository.ComfortRepository;

@Controller
@RequestMapping("/services")
public class ServiceController {
	@Autowired
	ComfortRepository comfortRepository;

	@GetMapping("/input")
	private String inputComfort(Model model) {
		model.addAttribute("objekBaruComfortModel", new ComfortModel());
		return "input_comfort";
	}
	
	@PostMapping("/input")
	private String saveComfort(@ModelAttribute ComfortModel model) {
		comfortRepository.save(model);
		return "redirect:/services";
	}
}
