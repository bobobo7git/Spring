package com.ssafy.study_04_bohyung.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.study_04_bohyung.model.dao.MemberDao;
import com.ssafy.study_04_bohyung.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	private final MemberDao memberDao;
	
	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		return memberDao.selectAll();
	}

	@Override
	public Member viewMember(int id) {
		// TODO Auto-generated method stub
		return memberDao.selectOne(id);
	}

	@Override
	public void addMember(Member member) {
		// TODO Auto-generated method stub
		memberDao.insertMember(member);
	}

	@Override
	public void removeMember(int id) {
		// TODO Auto-generated method stub
		memberDao.deleteMember(id);
	}

}
