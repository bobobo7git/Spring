package com.ssafy.study_04_bohyung.model.dao;

import java.util.List;

import com.ssafy.study_04_bohyung.model.dto.Member;

public interface MemberDao {
	
	public List<Member> selectAll();
	
	public Member selectOne(int id);
	
	public void insertMember(Member member);
	
	public void deleteMember(int id);
	
}
