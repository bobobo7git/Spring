package com.ssafy.study_04_bohyung.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.study_04_bohyung.model.dao.MemberDao;
import com.ssafy.study_04_bohyung.model.dto.Member;
import com.ssafy.study_04_bohyung.model.service.MemberService;

@Controller
public class MemberController {
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/members")
	public String memberlist(Model model) {
		List<Member> members = memberService.getMemberList();
		System.out.println(members);
		model.addAttribute("members", members);
		return "/member/memberlist";
	}
	
	@GetMapping("/member")
	public String memberDetail(Model model, @RequestParam("id")int id) {
		Member member = memberService.viewMember(id);
		System.out.println(member);
		model.addAttribute("member", member);
		return "/member/memberdetail";
	}
	
	@GetMapping("/memberinput")
	public String memberInput() {
		return "/member/memberinput";
	}
	@PostMapping("/memberinput")
	public String addMember(
			@RequestParam("name")String name,
			@RequestParam("jumin")String jumin,
			@RequestParam("age")int age,
			@RequestParam("phone")String phone
			) {
		
		Member member = new Member(name=name, jumin=jumin, age=age, phone=phone);
		memberService.addMember(member);
		
		return "redirect:members";
	}
	@PostMapping("/memberdelete")
	public String deleteMember(@RequestParam("id")int id) {
		memberService.removeMember(id);
		return "redirect:members";
	}
	
}
