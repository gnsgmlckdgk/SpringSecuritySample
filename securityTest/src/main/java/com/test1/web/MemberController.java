package com.test1.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test1.domain.MemberBean;
import com.test1.service.MemberService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	MemberService service;
	
	// 회원가입 페이지
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String joinGet() throws Exception {
		logger.info("joinGet");

		return "/member/join";
	}

	// 회원가입 처리
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String joinPost(MemberBean mb) throws Exception {
		logger.info("joinPost");

		service.insertMember(mb);
		
		return "redirect:/home.do";
	}

}
