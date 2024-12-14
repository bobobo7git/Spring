package com.ssafy.study_04_bohyung.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {
	ResourceLoader resourceLoader;
	public ProductController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	
	@GetMapping("/product")
	public String productInput() {
		return "productinput";
	}
	@PostMapping("/product")
	public String productOutput(
			@RequestParam("product") String product,
			@RequestParam("price")String price,
			@RequestParam("category")String category,
			@RequestParam("file")MultipartFile file,
			Model model
			) throws IllegalStateException, IOException {
		
		// System.out.println(product + " " + price + " "+ category);
		// System.out.println(file.getOriginalFilename());
		
		
		model.addAttribute("product", product);
		model.addAttribute("price", price);
		model.addAttribute("category", category);
		if (file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			model.addAttribute("file", fileName);
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			file.transferTo(new File(resource.getFile(), fileName));
		}
		else model.addAttribute("file", "No file selected");
		return "productoutput";
		
	}
}
