package com.bohyung.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bohyung.mvc.model.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		// 지금은 sevice를 구현하지 않아서 id를 냅다 넣음
		session.setAttribute("loginUser", user.getId());
		System.out.println(user);
		return "redirect:hello";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1. session에서 유저 속성 지우기
		session.removeAttribute("loginUser");
		//2. session 초기화
		session.invalidate();
		
		return "redirect:/";
	}
}
