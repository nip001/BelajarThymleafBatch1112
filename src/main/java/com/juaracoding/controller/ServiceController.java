package com.juaracoding.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.juaracoding.model.ComfortModel;
import com.juaracoding.repository.ComfortRepository;
import com.juaracoding.utility.FileUtility;

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
	private String saveComfort(@ModelAttribute ComfortModel model,
			@RequestParam(value="file")MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String uploadDir = "comfort-images";
		
		model.setGambar(fileName);
		FileUtility.simpanFile(uploadDir, fileName, file);
		comfortRepository.save(model);
		return "redirect:/services";
	}
}
