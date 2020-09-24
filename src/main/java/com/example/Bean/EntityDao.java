package com.example.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.example.Bean.EntityRowMapperlatest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Repository
public class EntityDao {
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Autowired
	Sequence seq;
	
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		    System.out.println("I am inside Edao");
			this.jdbctemplate = jdbctemplate;
	}

	public List<Entity> FetchAllEntity()
	{
		System.out.println("Inside EntityDao>>>>>>>>>>>>>>>>>Bandana");

        String sql;
        sql = "Select * from ENTITY" ;
        EntityRowMapperlatest entityrowmap = new EntityRowMapperlatest();
		List <Entity> EntityList = jdbctemplate.query(sql,entityrowmap);
		return EntityList;
	
	}
	
	public Entity FetchEntityofOne(String name)
	{
		String sql= "SELECT * FROM ENTITY WHERE NAME = ?";
	    EntityRowMapperlatest entityrowmap = new EntityRowMapperlatest();
		Entity entity= jdbctemplate.queryForObject(sql, new Object[] {name}, entityrowmap );
		System.out.println("Inside EntityDao....FetchEntityofOne>>>>>>>>>>>>>>>>>Bandana");
		return entity ;
	}
	
	public Boolean CreateEntity(Entity entity)
	{
		String sql= "INSERT INTO ENTITY VALUES (?,?,?)";
		System.out.println("Inside CreateEntity>>>>>>>>>edao>>>>>>Bandana"); 
		long seq_number;
		seq_number =seq.fetchseqnumber();
	    return jdbctemplate.execute(sql, new PreparedStatementCallback <Boolean>()
	    		{
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
			{
				System.out.println("Inside doInPreparedStatement>>>>>>Bandana");
				 ps.setLong(1, seq_number);
				ps.setString(2, entity.getName());
				System.out.println("Inside doInPreparedStatement>>>>>>"+  entity.getName());
				System.out.println("Inside doInPreparedStatement>>>>>> " +  entity.getPassword());
				ps.setString(3, entity.getPassword());
				return ps.execute();
				
			}
			
		});
		
		
	}
	
	
	
	

}
