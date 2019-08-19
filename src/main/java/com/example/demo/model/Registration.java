package com.example.demo.model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement
@Entity
public class Registration implements Serializable{
     
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	
	@NotNull
     @Size(min=1,message="Name Required")
	private String name;
	
	@NotNull(message="Age Required")
	@Min(value=18, message="must be more than 18")  
    @Max(value=45, message="must be equal or less than 45")
	private int age;
	
	
	@NotNull(message="marks Required")
	@Min(value=1, message="must be more than 1")  
    @Max(value=600, message="must be equal or less than 600")
    private int total_marks;
	
	@NotNull(message="Enter the Percentage")
	@Min(value=0, message="must be more then 0")
	@Max(value=100,message ="must not be more then 100")
	private double percentage;
	
	@NotNull
    @Size(min=1, max=10,message="password Required and lenght should be less then 10")
	private String password;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
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
	public int getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
