package com.edu.cmn;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootStudy01ApplicationTests {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataSource ds;
	
	@Test
	void contextLoads() {
		try {
			Connection conn = ds.getConnection();
			LOG.debug("conn =>" + conn);
			assertThat(conn).isInstanceOf(Connection.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
