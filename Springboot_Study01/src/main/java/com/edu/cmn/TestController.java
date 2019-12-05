package com.edu.cmn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping(value = "/test1")
	@ResponseBody
	public String testPage(String msg) {
		return msg;
	}
	
	@RequestMapping(value = "/testpage")
	public String testPage(HttpServletRequest re, HttpServletResponse res) {
		re.setAttribute("msg", "jsp페이지 테스트");
		return "testpage";
	}
}
	