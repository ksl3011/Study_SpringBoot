package com.edu.cmn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
class SpringbootStudy01ApplicationTests {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private MockMvc mock;
	
	//@Test
	public void contextLoads() {
		try {
			Connection conn = ds.getConnection();
			LOG.debug("conn =>" + conn);
			assertThat(conn).isInstanceOf(Connection.class);

			
			String sql = "SELECT COUNT(*) as cnt FROM PF_BOARD"; PreparedStatement ps =
			conn.prepareStatement(sql); ResultSet rs = ps.executeQuery();
			while(rs.next()) { System.out.println(rs.getString("cnt")); }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws Exception {
		
		
		MvcResult result = mock.perform(get("/test1").param("msg", "testtesttest"))
							.andExpect(status().isOk())
							.andReturn();
		
		String str = result.getResponse().getContentAsString();
		System.out.println(str);
		
	}
}
