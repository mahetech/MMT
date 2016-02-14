package com.sbfc.member.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sbfc.member.management.model.Member;
import com.sbfc.member.management.service.MemberService;

@Controller
@RequestMapping("/MemberManagement")
@SessionAttributes("roles")
public class AppController {

	@Autowired
	MemberService memberService;

	@Autowired
	MessageSource messageSource;

	/**
	 * This method will list all existing members.
	 */
	@RequestMapping(value = { "/listMembers" }, method = RequestMethod.GET)
	public String listMembers(ModelMap model) {

		List<Member> members = memberService.findAllMembers();
		model.addAttribute("membes", members);
		return "memberslist";
	}

	/**
	 * This method will provide the medium to add a new member.
	 */
	@RequestMapping(value = { "/newMember" }, method = RequestMethod.GET)
	public String newMember(ModelMap model) {
		Member member = new Member();
		model.addAttribute("member", member);
		model.addAttribute("edit", false);
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving member in database. It also validates the member input
	 */
	@RequestMapping(value = { "/newMember" }, method = RequestMethod.POST)
	public String saveMember(@Valid Member member, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		memberService.saveMember(member);
		model.addAttribute("success", "Member " + member.getMemberNameEnglish() + " created successfully");
		// return "success";
		return "registrationsuccess";
	}

	/**
	 * This method will provide the medium to update an existing member.
	 */
	@RequestMapping(value = { "/edit-member-{ssoId}" }, method = RequestMethod.GET)
	public String editMember(@PathVariable int memberId, ModelMap model) {
		Member member = memberService.findById(memberId);
		model.addAttribute("member", member);
		model.addAttribute("edit", true);
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating member in database. It also validates the member input
	 */
	@RequestMapping(value = { "/edit-member-{ssoId}" }, method = RequestMethod.POST)
	public String updateMember(@Valid Member member, BindingResult result, ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "registration";
		}

		memberService.updateMember(member);

		model.addAttribute("success", "Member " + member.getMemberNameEnglish() + " updated successfully");
		return "registrationsuccess";
	}

}
