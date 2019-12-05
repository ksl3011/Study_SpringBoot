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

import com.edu.mapper.MapperTest;

@SpringBootTest
class SpringbootStudy01ApplicationTests {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private MapperTest mt;
	
	@Test
	public void mapperTest2() throws Exception {
		testVO vo = mt.testXml("1");
		System.out.println(vo.toString());
	}
		
	//@Test
	public void mapperTest() throws Exception {
		String result = mt.test("1");
		System.out.println("mapperTest : " + result);
	}
	
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

}
