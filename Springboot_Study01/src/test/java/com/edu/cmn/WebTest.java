package com.edu.cmn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(TestController.class)
// or @WebMvcTest()
public class WebTest {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MockMvc mock;

	@Test
	public void test() throws Exception {
		MvcResult result = mock.perform(get("/test1").param("msg", "testtesttest"))
							.andExpect(status().isOk())
							.andReturn();
		
		String str = result.getResponse().getContentAsString();
		System.out.println(str);
		
	}
}
