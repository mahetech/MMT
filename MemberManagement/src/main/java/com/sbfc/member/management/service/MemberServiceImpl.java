package com.sbfc.member.management.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbfc.member.management.dao.IMemberDao;
import com.sbfc.member.management.model.Member;

@Service("memberService")
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private IMemberDao memberDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberService#getAllMembers()
	 */
	@Override
	public List<Member> getAllMembers() {
		List<Member> memList = memberDao.getAllMembers();
		System.out.println("memberService >> getAllMembers >> " + memList);
		return memList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberService#getMembersByIdOrName()
	 */
	@Override
	public List<Member> getMembersByIdOrName(String searchStr) {
		List<Member> memList = null;
		System.out.println("memberService >> getMembersByIdOrName >> searchStr >> " + searchStr);

		if (StringUtils.isNotBlank(searchStr)) {
			memList = memberDao.getMembersByIdOrName(searchStr.trim());
		} else {
			System.err.println("Invalid Search String: " + searchStr);
		}
		return memList;
	}
}
