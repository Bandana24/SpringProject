package com.example.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Sequence {

	
	Long Sequence_number;
	@Autowired
	JdbcTemplate jdbctemplate;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public Long getSequence_number() {
		return Sequence_number;
	}

	public void setSequence_number(Long sequence_number) {
		Sequence_number = sequence_number;
	}
	
	public long fetchseqnumber()
	{
		
		String sql = "SELECT MY_SEQ_ENT.NEXTVAL FROM DUAL";
		//String sql = "SELECT "+seqName+".NEXTVAL FROM DUAL";
		Sequence_number = jdbctemplate.queryForObject(sql,new Object[] {} , long.class);
		
		return Sequence_number;
	}
	
	
	

}
