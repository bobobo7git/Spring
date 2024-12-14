package com.ssafy.files.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	// 스프링에서 파일이나 클래스 등등 리소스를 로드할 때 사용하는 인터페이스 
	private ResourceLoader resourceLoader;
	
	// @Autowired가 없어도 생성자가 하나만 있어서 들어있는 것과 같다.
	public FileController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	@GetMapping("/singleFileForm")
	public String singleFileForm() {
		
		return "singleFileForm";
	}
	
	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file")MultipartFile file, Model model) throws IllegalStateException, IOException {
		// 파일이 있는지 확인
		if (file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			// tomcat에 저장
			// src/main/resources/static/img
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			file.transferTo(new File(resource.getFile(), fileName));
			
			model.addAttribute("fileName", fileName);
		}
		
		
		return "result";
	}
	
}
