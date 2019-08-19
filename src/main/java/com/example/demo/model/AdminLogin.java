package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class AdminLogin implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aid;
	
	@NotNull
    @Size(min=1,message="Name Required")
	private String name;
	
	@NotNull
    @Size(min=1,message="password Required and lenght should be less then 10")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
	
	

}
