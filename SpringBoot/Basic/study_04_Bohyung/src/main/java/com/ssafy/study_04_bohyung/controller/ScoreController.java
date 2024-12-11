package com.ssafy.study_04_bohyung.controller;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ScoreController {
	@GetMapping("/score")
	public String scoreInput() {
		return "scoreinput";
	}
	@PostMapping("/score")
	public ModelAndView scoreOutput(HttpServletRequest request) {
		String name = request.getParameter("name");
		String korean = request.getParameter("korean");
		String english = request.getParameter("english");
		String math = request.getParameter("math");
		
		int korScore = Integer.parseInt(korean);
		int engScore = Integer.parseInt(english);
		int mathScore = Integer.parseInt(math);
		int sumScore = korScore + engScore + mathScore;
		int avgScore = sumScore / 3;
		
		String korGrade;
		String engGrade;
		String mathGrade;
		
		if (korScore >= 90) korGrade = "A";
		else if (korScore >= 80) korGrade = "B";
		else if (korScore >= 70) korGrade = "C";
		else if (korScore >= 60) korGrade = "D";
		else korGrade = "F";
		if (engScore >= 90) engGrade = "A";
		else if (engScore >= 80) engGrade = "B";
		else if (engScore >= 70) engGrade = "C";
		else if (engScore >= 60) engGrade = "D";
		else engGrade = "F";
		if (mathScore >= 90) mathGrade = "A";
		else if (mathScore >= 80) mathGrade = "B";
		else if (mathScore >= 70) mathGrade = "C";
		else if (mathScore >= 60) mathGrade = "D";
		else mathGrade = "F";
		
		
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("scoreoutput");
		mav.addObject("name", name);
		mav.addObject("korScore", korScore);
		mav.addObject("engScore", engScore);
		mav.addObject("mathScore", mathScore);
		mav.addObject("avgScore", avgScore);
		mav.addObject("sumScore", sumScore);
		mav.addObject("korGrade", korGrade);
		mav.addObject("engGrade", engGrade);
		mav.addObject("mathGrade", mathGrade);
		
		return mav;
	}
	
}
