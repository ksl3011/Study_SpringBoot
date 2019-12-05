package com.edu.cmn;

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
}
