package com.sbfc.member.management.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbfc.member.management.dao.IMemberDao;
import com.sbfc.member.management.model.Member;

@Service("memberService")
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private IMemberDao memberDao;

	@Override
	public Member getMemberById(String memberId) {
		Member member = memberDao.getMemberById(memberId);
		System.out.println("memberService >> getMemberById >> " + member);
		return member;
	}
}
