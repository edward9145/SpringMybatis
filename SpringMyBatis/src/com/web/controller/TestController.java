package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.domain.Test;


@Controller
public class TestController {
	
	@RequestMapping("/test")
	public ModelAndView test() {
		String message = "Hello, the path of this page is WEB-INF/jsp/test.jsp";
		return new ModelAndView("test", "message", message);
	}
	
	@RequestMapping("/test.json")
	@ResponseBody
	public Test testJson(Integer i, Float f, String str) {
		Test test = new Test();
		test.setI( i!=null ? i : 1);
		test.setF( f!=null ? f : 2.0f);
		test.setStr( str!=null ? str : "test");
		return test;
	}
	
}
