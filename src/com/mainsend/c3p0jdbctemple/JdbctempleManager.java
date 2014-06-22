package com.mainsend.c3p0jdbctemple;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbctempleManager {
	private static JdbctempleManager instance;
	private static JdbcTemplate jdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public static synchronized JdbctempleManager getInstance(){
		if(instance==null){
			instance=new JdbctempleManager();
		}
		return instance;
	}
	
	public static synchronized final JdbcTemplate getJdbctem(){
		if(jdbcTemplate==null){
			System.out.println("����ԴΪ�գ�");
			return null;}
		else {
		return jdbcTemplate;}
	}

}
