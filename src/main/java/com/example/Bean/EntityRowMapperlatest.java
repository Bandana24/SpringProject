package com.example.Bean;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EntityRowMapperlatest implements RowMapper<Entity> {
	
	public Entity mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		System.out.println("Inside EntityRowMapperlatest>>>>>>>>>>>>>>>>>Bandana");
	        Entity entity = new Entity();
	        entity.Id= rs.getLong("Id");
		    entity.Name = rs.getString("name");
			entity.Password = rs.getString("password");
			return entity;
		
	}

	

}
