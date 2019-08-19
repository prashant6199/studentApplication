package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.AdminRepositry;
import com.example.demo.StudentRepositry;
import com.example.demo.model.AdminLogin;
import com.example.demo.model.Login;
import com.example.demo.model.Registration;





@Controller
public class RegistrationController {
	
	@Autowired
	StudentRepositry sr;
	
	@Autowired
	AdminRepositry ar;
	
	
	@RequestMapping(value="/")
	public String Index(Model m) {
		
	
		
		return "index";
	}
	
	@RequestMapping(value="/home")
	public String Home(Model m) {
		
	
		
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
		  
		
	List<Registration> ls=	sr.findByNameAndPassword(log.getName(),log.getPassword());
			System.out.println("The login name is"+log.getName());
			System.out.println("The size is"+ls.size());
			if(ls.size()>0) {
				System.out.println("The size is"+ls.size());
				
				Registration r=sr.findData(log.getName(), log.getPassword());
				m.addAttribute("logindata", r);
				System.out.println("The ID is"+r.getSid());
				
				
				return"display";
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
	ModelAndView mav=new ModelAndView("listpage");
	mav.addObject("listdata",r );
	
		/*
		 * Iterator< Registration> i=r.iterator(); while (i.hasNext()) { Registration
		 * registration = (Registration) i.next();
		 * System.out.println("The name is"+registration.getName());
		 * System.out.println("The age is"+registration.getAge()); }
		 */

    	return mav;
    
	}
	
	@RequestMapping(value="/adminlogin")
	public String AdminLogin(Model m) {
		m.addAttribute("admindata",new AdminLogin());
		return"adminlogin";
	}
	
	@RequestMapping(value="/Adminloginvalid", method=RequestMethod.POST)
	public String Adminloginvalid(@Valid @ModelAttribute("admindata") AdminLogin al, BindingResult br, Model m) {
		
		m.addAttribute("name", al.getName());
		
		if(br.hasErrors()) {
			return "adminlogin";
		}
		else {
			List<AdminLogin>l=ar.findByName(al.getName());
			System.out.println("The admin name is"+al.getName());
			if(l.size()>0) {
				      
				     return"redirect:/getalllist";
				
			}else {
				return"codeerror1";
			}
		}
	
	}
	
	@RequestMapping(value="/update")
	public String Update(@RequestParam(value="sid",defaultValue = "") int sid, Model m) {
		Registration r=sr.findOne(sid);
		m.addAttribute("data",r);
		
		return "updatepage";
		
	}
	
	@RequestMapping(value="/UpdateData",method=RequestMethod.POST)
	public String UpdateData(@Valid @ModelAttribute("data") Registration reg, BindingResult br, Model m) {
		
		System.out.println("into updatedata page");
		/*
		 * if(br.hasErrors()) { System.out.println("Into bindingresult"); return
		 * "updatepage"; } else {
		 */
			
			 int i=sr.Update(reg.getSid(), reg.getName(), reg.getAge(),reg.getPercentage(), reg.getTotal_marks());
			  System.out.println("The update status is"+i);
			 
			 
			/*
			 * System.out.println("The name is"+reg.getName()+"The age is"+reg.getAge()
			 * +"The id is"+reg.getSid()); int i=sr.Update(reg.getSid(),reg.getName(),
			 * reg.getAge());
			 * System.out.println("The name is"+reg.getName()+"The age is"+reg.getAge()
			 * +"The id is"+reg.getSid()); System.out.println("The result of update is"+i);
			 */
				     return "redirect:/getalllist";
	
			//}
		
		}
	@RequestMapping(value="/delete")
	public String deleteData(@RequestParam(value="sid") int sid, Model m) {
		
		int i=sr.delete(sid);
		System.out.println("The update status is"+i);
		return "redirect:/getalllist";
		
	}
	@RequestMapping(value="/forgotpassword")
	public String forgotPassword(Model m) {

		m.addAttribute("newpass",new Registration());
		
		return "forgotpassword";
		
	}
	
	@RequestMapping(value="/resetpassword", method=RequestMethod.POST)
	public String resetPassword(@Valid @ModelAttribute("newpass") Registration r, BindingResult br, Model m) {
		
		
			int i= sr.updatePassword(r.getName(), r.getSid(), r.getPassword());
			if(i==1) {
			System.out.println("The Update Reset password value is"+i);
			m.addAttribute("updatemessage", r.getName());
			m.addAttribute("updated", "updated");
			
			}
			else {
				System.out.println("The Update Reset password value is"+i);
				m.addAttribute("updatemessage","Username and id not matched so");
				m.addAttribute("updated", "not updated");
				
			}
				
		return"passwordupdated";
	}
	
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView serach(@RequestParam(value="name") String name, Model m) {
		
		System.out.println("The Search Value is"+name);
		List<Registration> r=   (List<Registration>) sr.findByName(name);
		ModelAndView mav=new ModelAndView("search");
		mav.addObject("listdata",r );
		return mav;
			
	}
	
	@RequestMapping(value="/jsonlistdata",method=RequestMethod.GET)
	public ModelAndView JsonList(Model m) throws Exception {
		
		ModelAndView mav=new ModelAndView("jsonlist");
		
		
		URL url= new URL("http://localhost:1234/jsonvalues");
		
		HttpURLConnection huc=(HttpURLConnection) url.openConnection();
		huc.setRequestMethod("GET");
		huc.setRequestProperty("Accept","application/json");
		huc.connect();
		System.out.println("Into JosonList data");
		
		if (huc.getResponseCode() != 200) {
             throw new RuntimeException("Failed : HTTP Error code : "
                     + huc.getResponseCode());
         }
		else 
		{
         InputStreamReader in = new InputStreamReader(huc.getInputStream());
         BufferedReader br = new BufferedReader(in);
        
         String output;
         while ((output = br.readLine()) != null) 
             {
        	
        	
        	 
             System.out.println("The output data is"+output);
             
             
      
             JSONArray arr = new JSONArray(output);
             
             List<Double> plist1 = new ArrayList<Double>();
            
             List<String> nlist = new ArrayList<String>();
             
             List<Integer> ilist=new ArrayList<Integer>();
             
             List<Integer> tlist=new ArrayList<Integer>();
               
             for(int i = 0; i < arr.length(); i++){
            	 
            	 
            	 System.out.println("The data is->"+arr.getJSONObject(i));
            	 System.out.println("The data is->"+arr.getJSONObject(i).getString("name"));
              
            	 nlist.add(arr.getJSONObject(i).getString("name"));
            	  System.out.println("The  name data is->"+arr.getJSONObject(i).getString("name"));
            
            	 plist1.add(arr.getJSONObject(i).getDouble("percentage"));
             System.out.println("The  Percentage data is->"+arr.getJSONObject(i).getDouble("percentage"));
             
                  ilist.add(arr.getJSONObject(i).getInt("sid"));
                  System.out.println("The  sid data is->"+arr.getJSONObject(i).getInt("sid"));
                  
                  tlist.add(arr.getJSONObject(i).getInt("total_marks"));
                  System.out.println("The  total marks data is->"+arr.getJSONObject(i).getInt("total_marks"));
               
               
               mav.addObject("jsonresultname", nlist);
               mav.addObject("jsonresultpercentage", plist1);
               mav.addObject("jsonresultsid", ilist);
               mav.addObject("jsonresulttotal_marks", tlist);
      
             }
            
         }
   
         huc.disconnect();
		
		return mav;
         }
		
	}
		
	}


