package com.ssafy.study_04_bohyung.model.service;

import java.util.List;

import com.ssafy.study_04_bohyung.model.dto.Member;

public interface MemberService {
	public List<Member> getMemberList();
	
	public Member viewMember(int id);
	
	public void addMember(Member member);
	
	public void removeMember(int id);
}
