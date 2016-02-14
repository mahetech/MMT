package com.sbfc.member.management.service;

import java.util.List;

import com.sbfc.member.management.model.Member;

public interface MemberService {

	/**
	 * To find the member using member id.
	 * 
	 * @param memberId
	 * @return {@link Member}
	 */
	public Member findById(int memberId);

	/**
	 * To find the member using member's English name.
	 * 
	 * @param englishName
	 * @return {@link List} of {@link Member}
	 */
	public List<Member> findByName(String englishName);

	/**
	 * To update the existing member object.
	 * 
	 * @param member
	 *            {@link Member}
	 */
	public void updateMember(Member member);
	
	/**
	 * To update the input member object.
	 * 
	 * @param member
	 *            {@link Member}
	 */
	public void saveMember(Member member);

	/**
	 * To get the list of available members.
	 * 
	 * @return {@link List} of {@link Member}
	 */
	public List<Member> findAllMembers();

}
