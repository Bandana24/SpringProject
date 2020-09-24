package com.example.controller;
//import org.apache.log4j.Logger; 

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bean.Entity;
import com.example.Bean.EntityDao;
import com.example.Bean.WrapperObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api")

public class BaseController {
	
	private static final Logger log = LogManager.getLogger(BaseController.class);

	
    @Autowired
    EntityDao edao;
    
  //  static Logger log = Logger.getLogger(BaseController.class.getName());  
    
	@GetMapping("/ping")
	public String test() {
		
		log.info("Received ping request");

		return "pong";

	}

	@GetMapping("users")
     
	public List<Entity> FetchEntityDetails()

	{
        
		List<Entity> Entitylist = edao.FetchAllEntity();
		System.out.println("I am FetchEntityDetails >>>>>>>>>>>>>Bandana");
		return Entitylist;

	}
	
	@GetMapping("/user/{name}")    
	public WrapperObject FetchEntityofOne(@PathVariable String name )

	{
				
		//	log.info("Name is null for the service call FetchEntityofOne"); 
		
		WrapperObject response = new WrapperObject();
		
        Entity entity = edao.FetchEntityofOne(name);
		System.out.println("I am FetchEntityDetails >>>>>>>>>>>>>Bandana");
		response.setSuccess(entity);
		response.setFailure("Faileeeeed");
		return response;

	}
	
	@PostMapping("/user")    
	public Boolean CreateEntityforall(@RequestBody Entity entity)

	{
		System.out.println("I am CreateEntityforall >>>>>>>>>>>>>Bandana" + entity.getName());
		Boolean T;
		T = edao.CreateEntity(entity);
		System.out.println("I am CreateEntityforall >>>>>>>>>>>>>Bandana");
	    return T;
	}
	

}
