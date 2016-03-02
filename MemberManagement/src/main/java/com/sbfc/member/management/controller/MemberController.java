package com.sbfc.member.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbfc.member.management.model.Member;
import com.sbfc.member.management.service.IMemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

	@Autowired
	private IMemberService memberService;

	@RequestMapping(value = "/loadAllMembers", method = RequestMethod.GET)
	public @ResponseBody List<Member> loadAllMembers() {
		System.out.println("Member Controller :: loadAllMembers");
		return memberService.getAllMembers();
	}

	@RequestMapping(value = "/searchMember/{searchStr}", method = RequestMethod.GET)
	public @ResponseBody List<Member> searchMember(@PathVariable("searchStr") String searchStr) {
		System.out.println("Member Controller :: searchMember :: searchStr :: " + searchStr);
		return memberService.getMembersByIdOrName(searchStr);
	}

	@RequestMapping("/layout")
	public String getMemberPartialPage() {
		return "members/layout";
	}
}
