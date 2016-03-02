package com.sbfc.member.management.service;

import java.util.List;

import com.sbfc.member.management.model.Member;

public interface IMemberService {

	/** ********** ADDRESS ********************/

	/** ********** PAYMENT ********************/

	/** ********** MEMBER ********************/
	public List<Member> getMembersByIdOrName(String searchStr);

	public List<Member> getAllMembers();

}
