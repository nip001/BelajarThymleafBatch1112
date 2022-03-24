package com.juaracoding.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.juaracoding.model.ContentModel;
import com.juaracoding.model.JudulModel;
import com.juaracoding.model.TestiModel;
import com.juaracoding.model.UserModel;
import com.juaracoding.repository.ComfortRepository;
import com.juaracoding.repository.UserRepository;
import com.juaracoding.utility.FileUtility;

@Controller
public class WebController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ComfortRepository comfortRepository;

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
		model.addAttribute("listComfort", comfortRepository.findAll());
		model.addAttribute("judulModel", judul);
		return "services";
	}
	
	@GetMapping("/blog")
	private String blog(Model model, @RequestParam(value = "huruf",defaultValue = "")String huruf
			,@RequestParam(value="tanggal",defaultValue = "")String tangggal) {
		model.addAttribute("listUser", userRepository.findByTanggalContainingAndNamaContaining(tangggal, huruf));
		
//		if(huruf.equalsIgnoreCase("")) {
			model.addAttribute("listUser", userRepository.findAll());
//		}else {
//			model.addAttribute("listUser", userRepository.getUserByName(huruf));
//		}
		model.addAttribute("judulModel", judul);
		return "blog";
	}
	

	
	@GetMapping("/blog/{huruf}")
	private String blogg(Model model, @PathVariable("huruf") String huruf) {
		model.addAttribute("listUser", userRepository.getUserByName(huruf));
		model.addAttribute("judulModel", judul);
		return "blog";
	}
	
	@GetMapping("/contact")
	private String contact(Model model) {
		model.addAttribute("judulModel", judul);
		return "contact";
	}
	
	
	@GetMapping("/blog/input")
	private String inputBlog(Model model) {
		model.addAttribute("userModel", new UserModel());
		return "input";
	}
	
	
	@PostMapping("/blog/input")
	private String saveBlog(@ModelAttribute UserModel data,
			@RequestParam(value="file")MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String uploadDir = "user-images";
		
//		cara membaca image yang pertama data.setGambar("/"+uploadDir+"/"+fileName);

		data.setGambar(fileName);
		FileUtility.simpanFile(uploadDir, fileName, file);
		userRepository.save(data);
		return "redirect:/blog";
	}
	
}
