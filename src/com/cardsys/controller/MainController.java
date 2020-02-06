package com.cardsys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController extends BaseController {
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String forMain(ModelMap modelMap, HttpSession session) {
		return "/cardsys/main";
	}
}
