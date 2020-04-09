package com.vsked.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.vsked.vskedDbTools.test.BaseTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostgresqlConnect extends BaseTest{
	@Test
	public void query() {
		log.info("----------start postgresql query----------");
		try {
			String driverClassName="org.postgresql.Driver";
			String jdbcUrl="jdbc:postgresql://dev1centos7:5432/postgres";
			String userName="postgres";
			String password="Y4yhl9tbf110";
			Class.forName(driverClassName);//1
			Connection conn = DriverManager.getConnection(jdbcUrl,userName,password);
			String sql = "SELECT * from sysusert";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				log.info(rs.getString(1) + rs.getString(2));
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		log.info("----------end postgresql query----------");
	}

}
