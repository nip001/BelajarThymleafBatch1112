package com.juaracoding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.juaracoding.model.ContentModel;
import com.juaracoding.model.JudulModel;
import com.juaracoding.model.TestiModel;
import com.juaracoding.model.UserModel;

@Controller
public class WebController {

	JudulModel judul = new JudulModel("Juara","Mantap");
	
	@GetMapping("/")
	private String index(Model model) {

		List<ContentModel> listContent = new ArrayList<ContentModel>();
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
		List<UserModel> listUser  = new ArrayList<UserModel>();
		listUser.add(new UserModel("Kevin", "/img/tessy1.jpg","Review banci bintang 1","seorang tessy wahyuni riwayati mendapatkan bintang 1 dari penggemarnya","2020-11-17"));
		listUser.add(new UserModel("Bintang", "/img/tarno.jpg","Review pesulap bintang 1","seorang Sutarno mendapatkan bintang 1 dari penggemarnya","2021-11-17"));
		listUser.add(new UserModel("Dini", "/img/taylor.png","Review penjahit bintang 1","seorang penjahit mendapatkan bintang 1 dari penggemarnya","2019-11-17"));
		listUser.add(new UserModel("Adrian", "/img/komeng.jpg","Review pejabat bintang 1","seorang pejabat mendapatkan bintang 1 dari penggemarnya","2030-11-17"));
		model.addAttribute("judulModel", judul);
		model.addAttribute("listUser", listUser);
		return "blog";
	}
	
	@GetMapping("/contact")
	private String contact(Model model) {
		model.addAttribute("judulModel", judul);
		return "contact";
	}
}
