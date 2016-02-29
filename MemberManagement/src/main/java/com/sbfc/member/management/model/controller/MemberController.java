package com.sbfc.member.management.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbfc.member.management.model.Member;
import com.sbfc.member.management.model.service.IMemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

	@Autowired
	private IMemberService memberService;

	@RequestMapping(value = "/searchMember/{searchStr}", method = RequestMethod.GET)
	public @ResponseBody Member searchMember(@PathVariable("searchStr") String searchStr) {
		System.out.println("Member Controller :: xx :: searchStr :: " + searchStr);
		return memberService.getMemberById(searchStr);
	}

	@RequestMapping("/layout")
	public String getMemberPartialPage() {
		return "members/layout";
	}
}
