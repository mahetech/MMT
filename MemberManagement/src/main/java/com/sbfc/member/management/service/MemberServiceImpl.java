package com.sbfc.member.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbfc.member.management.dao.MemberDAO;
import com.sbfc.member.management.model.Member;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from DB and update it with
	 * proper values within transaction. It will be updated in DB once
	 * transaction ends.
	 */
	public void updateMember(Member member) {
		Member entity = dao.findById(member.getMemberId());
		if (entity != null) {
			entity.setAddresses(member.getAddresses());
			entity.setColor(member.getColor());
			entity.setContact(member.getContact());
			entity.setDateOfBirth(member.getDateOfBirth());
			entity.setDateOfJoin(member.getDateOfJoin());
			entity.setDialectRef(member.getDialectRef());
			entity.setGender(member.getGender());
			entity.setIntroducerMemberId(member.getIntroducerMemberId());
			entity.setMemberNameChinese(member.getMemberNameChinese());
			entity.setMemberNameEnglish(member.getMemberNameEnglish());
		}
	}

	@Override
	public Member findById(int memberId) {
		return dao.findById(memberId);
	}

	@Override
	public List<Member> findByName(String englishName) {
		return dao.findByName(englishName);
	}

	@Override
	public void saveMember(Member member) {
		dao.saveMember(member);
	}

	@Override
	public List<Member> findAllMembers() {
		return dao.findAllMembers();
	}

}
