package com.juaracoding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.juaracoding.model.ContentModel;
import com.juaracoding.model.JudulModel;
import com.juaracoding.model.TestiModel;

@Controller
public class WebController {

	JudulModel judul = new JudulModel("Juara","Mantap");
	List<ContentModel> listContent = new ArrayList<ContentModel>();
	
	@GetMapping("/")
	private String index(Model model) {

		//Ini adalah pelajaran array
		ContentModel model1 = new ContentModel("Judul ini asik", "keasikan judul ini adalah judul asik");
		listContent.add(model1);
		ContentModel model2 = new ContentModel("Judul ini gaasik", "gaasik karna ga rame");
		listContent.add(model2);
		ContentModel model3 = new ContentModel("Judul ini mantap", "mantap karna memang mantap");
		listContent.add(model3);
		
		model.addAttribute("listContent", listContent);
		
		//Ini akhir dari pelajaran array
		
		
		
		TestiModel testi = new TestiModel("Banci sukses", "PT Banci Sejahtera", 
				"Tessy Wahyuni Riwayati", "/img/tessy1.jpg");

		model.addAttribute("tulisanJudul", "Memantapkan hidup seperti leri");
		
		// attribute objek
		model.addAttribute("testiObjek", testi);
		model.addAttribute("judulModel", judul);
		
		model.addAttribute("button", "Info lebih");
		return "index";
	}
	
	@GetMapping("/about")
	private String about(Model model) {
		model.addAttribute("judulModel", judul);
		return "about";
	}
	
	@GetMapping("/services")
	private String services(Model model) {
		model.addAttribute("judulModel", judul);
		return "services";
	}
	
	@GetMapping("/blog")
	private String blog(Model model) {
		model.addAttribute("judulModel", judul);
		return "blog";
	}
	
	@GetMapping("/contact")
	private String contact(Model model) {
		model.addAttribute("judulModel", judul);
		return "contact";
	}
}
