package com.example.Bean;

public class Entity {

	Long Id; // New comment has been added to verify whether GIT is working or not
	String Name;
	String Password;
	 
	
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}