package com.test1.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inithome(Locale locale, Model model) {
		logger.info("Welcome inithome!");
		
		return "/home";
	}
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home!");
		
		return "/home";
	}
	
	@RequestMapping(value = "/intro/introduction.do", method = RequestMethod.GET)
	public String introduction(Locale locale, Model model) {
		logger.info("Welcome Introduction!");
		
		return "/intro/introduction";
	}
}
