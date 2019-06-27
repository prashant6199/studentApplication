package com.example.demo.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login implements Serializable{
	
	@NotNull
    @Size(min=1, max=10,message="Name Required")
	private String name;
	
	@NotNull(message="Age Required")
	@Min(value=18, message="must be more than 18")  
    @Max(value=45, message="must be equal or less than 45")
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
