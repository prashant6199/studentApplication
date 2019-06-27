package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.StudentRepositry;
import com.example.demo.model.Login;
import com.example.demo.model.Registration;


@Controller
public class RegistrationController {
	
	@Autowired
	StudentRepositry sr;
	
	
	@RequestMapping(value="/")
	public String Register(Model m) {
		
	
		
		return "home";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String RegisterPage(Model m) {
		
		m.addAttribute("reg",new Registration());
		
		return "register";
		
	}
	
	@RequestMapping(value="/addRegister", method=RequestMethod.POST)
	public String addRegister(@Valid @ModelAttribute("reg") Registration reg,BindingResult br, Model m ) {
		
		
		m.addAttribute("message", reg.getName());
		 if(br.hasErrors())  
	        {  
	            return "register";  
	        }  
	        else  
	        {  
	        	
	       sr.save(reg);
	       System.out.println("Registered Sucessfully"+ reg.getName());
	        return "welcome";  
	        } 
	}
	

	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String LoginPage(Model m) {
		m.addAttribute("login",new Login());
		return "login";
	}
	
	@RequestMapping(value="/loginvalid",method=RequestMethod.POST)
	public String LoginValidate(@Valid @ModelAttribute("login") Login log,BindingResult br,Model m) {
		
		m.addAttribute("lmessage",log.getName());
	
		if(br.hasErrors()) {
		return "login";
	}
	else {
		         
			//List<Registration>ls=sr.findByName(log.getName());
		
	List<Registration> ls=	sr.findByNameAndAge(log.getName(),log.getAge());
			System.out.println("The login name is"+log.getName());
			System.out.println("The size is"+ls.size());
			if(ls.size()>0) {
				System.out.println("The size is"+ls.size());
				return"mainpage";
			}
			else {
				return "codeerror";
			}
		}
		
	}
	@RequestMapping(value="/getall")
	public List<Registration> getList(Model m) {
	
		List<Registration> ls= (List<Registration>) sr.findAll();
		m.addAttribute("listdata", ls);
		
    	return (List<Registration>) sr.findAll();
	}
	
	@RequestMapping(value="/getalllist")
	public ModelAndView getAllList() {
		
	List<Registration> r=   (List<Registration>) sr.findAll();
	   
	Iterator< Registration> i=r.iterator();
	while (i.hasNext()) {
		Registration registration = (Registration) i.next();
		System.out.println("The name is"+registration.getName());
		System.out.println("The age is"+registration.getAge());
	}
	
	
		ModelAndView mav=new ModelAndView("listpage");
	
		mav.addObject("listdata", r.toString());
		
    	return mav;
    
	}

}
