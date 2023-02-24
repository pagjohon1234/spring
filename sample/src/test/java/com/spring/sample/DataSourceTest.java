package com.spring.sample;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJunit4ClassRunner.calss)
@ContextConfiguation(locations = {"file:src/main/webpp/WEB=INF/spring/*xml"})

public class DataSourceTest {
	@Inject

private DataSource ds;
	
	@Test
	public void testConnection() throws Exception {
		try(Connection con = ds.getConnection()) {
			System.out.println(con);
		}catch (Exception e ) {
			e.printStackTrace();
			
		}
		}
	}
