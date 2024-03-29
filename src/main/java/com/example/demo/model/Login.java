package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerators;

@Entity
public class Login implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lid;
	
	@NotNull
    @Size(min=1,message="Name Required")
	private String name;
	
	@NotNull
    @Size(min=1, max=10,message="password Required and lenght should be less then 10")
	private String password;
	
	@OneToOne(targetEntity=Registration.class,cascade=CascadeType.ALL)
	@JoinColumn(name="sfkid",referencedColumnName="sid")
	private Registration r;
	
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
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Registration getR() {
		return r;
	}
	public void setR(Registration r) {
		this.r = r;
	}
	

}
