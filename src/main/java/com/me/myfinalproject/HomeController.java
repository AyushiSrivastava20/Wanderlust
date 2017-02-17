package com.me.myfinalproject;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.myfinalproject.Dao.RoomDao;
import com.me.myfinalproject.Dao.UserDao;
import com.me.myfinalproject.exception.AdUException;
import com.me.myfinalproject.pojo.Customer;
import com.me.myfinalproject.pojo.Host;
import com.me.myfinalproject.pojo.Room;
import com.me.myfinalproject.pojo.User;
import com.me.myfinalproject.pojo.Wishlist;
import com.me.myfinalproject.validator.RoomValidator;
import com.me.myfinalproject.validator.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator uservalidator;

    @Autowired
	@Qualifier("UserDao")
	UserDao userDao;
  
    
    @InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(uservalidator);
	}
    
   
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String doService() {
    
    	return "home";
    }
    
    @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String doService1() {
    
    	return "home";
    }
    
    @RequestMapping(value = "/home1.htm", method = RequestMethod.GET)
   	public String roleHome(HttpServletRequest request) {
    	HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:login.htm";
		}
    	String role = (String) request.getSession().getAttribute("role");
    	if(role.equalsIgnoreCase("a")){
			return "adminPage";
			 
		}
		else if(role.equalsIgnoreCase("c")){
			return "redirect:customerpage";
			 
		}
	
		else {
			return "hostPage";
			
		}
       	
       }
    
    @RequestMapping(value="/login.htm", method=RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "Login";
		
		
	}
	
	
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public String doSubmitAction(@ModelAttribute("user") User user, HttpServletRequest request,HttpServletResponse response, BindingResult result, Model model){
		
		if(result.hasErrors()) {
			
			return "loginError";
		}
		
		
		//  if(request.getParameter("rememberMe").equals("yes")){
			//Date date = new Date();
			//Cookie cookieName = new Cookie("cookieUserName", user.getUsername());
			
			//Cookie cookieCurrentDate = new Cookie("cookieDate",date.toString());
			//response.addCookie(cookieName);
		    //response.addCookie(cookieCurrentDate);
		//}

			try {
				
				
				User user1 = userDao.querybyNamePassword(user.getUsername(), user.getPassword());

				HttpSession session = request.getSession();
				
				if(user1!=null){
					
					model.addAttribute("username", user.getUsername());
					session.setAttribute("user",user1);
					session.setAttribute("username1", user.getUsername());
					session.setAttribute("role", user1.getRole());
					if(user1.getRole().equalsIgnoreCase("a")){
						return "adminPage";
						 
					}
					else if(user1.getRole().equalsIgnoreCase("c")){
						return "redirect:customerpage";
						 
					}
				
					else {
						return "hostPage";
						
					}
					
				
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			
		}
		
			return "loginError";
	}
	
	
	@RequestMapping(value="/sign.htm", method=RequestMethod.GET)
	public String signupForm(@ModelAttribute("user") User user, BindingResult result) {
		System.out.println("test");
		return "Sign";
	}
	
	@RequestMapping(value="/sign.htm", method=RequestMethod.POST)
	public String SubmitAction(@ModelAttribute("user") User user, HttpServletRequest request, BindingResult result,@RequestParam("role") String role) throws Exception{

		uservalidator.validate(user, result);
		if (result.hasErrors()) {
			return "Sign";
		}
		
		String username = user.getUsername();
		
	    boolean flag = userDao.userUnique(username);
		
		if (flag==false){
			return "usererror";
		}
		
		if(role.equalsIgnoreCase("c")){
			Customer cust = new Customer();
			cust.setFirstname(user.getFirstname());
			cust.setLastname(user.getLastname());
		    cust.setAge(0);
			cust.setEmail(user.getEmail());
			cust.setPhone(user.getPhone());
			cust.setPassword(user.getPassword());
			cust.setUsername(user.getUsername());
			cust.setRole(role);
			cust.setCity(user.getCity());
			cust.setState(user.getState());
			cust.setCountry(user.getCountry());
			cust.setUserStatus("Active");
			
			try{
			userDao.createCustomer(cust);
			
			
			}catch(Exception e) {
				
				System.out.print("Error in adding Customer");
			}
		}
		
		if(role.equalsIgnoreCase("h")){
			Host host = new Host();
			host.setFirstname(user.getFirstname());
			host.setLastname(user.getLastname());
			host.setAge(0);
			host.setEmail(user.getEmail());
			host.setPhone(user.getPhone());
			host.setPassword(user.getPassword());
			host.setUsername(user.getUsername());
			host.setRole(role);
			host.setCity(user.getCity());
			host.setState(user.getState());
			host.setCountry(user.getCountry());
			host.setUserStatus("Active");
			
			try{
			userDao.createHost(host);
			
			}catch(Exception e) {
				
				System.out.print("Error in adding Host");
			}
		}
		
			
			return "Signupsuccess";

}
	
	
	@RequestMapping(value="/logout.htm", method=RequestMethod.GET)
	public String logout(Model model,HttpServletRequest req ) {
		req.getSession().invalidate();
		return "home";
		
	}
	
	@RequestMapping(value="showuser", method=RequestMethod.POST)
	public String showuser(@ModelAttribute("user") User user, Model model,HttpServletRequest req, BindingResult result) throws Exception {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null){
			return "login";
		}
	
		ArrayList<User> users = new ArrayList<User>();
		users = userDao.allUsers();
		System.out.println(users.size());
		model.addAttribute("allusers", users);
		return "viewuser";
	}
	
	
	

	
	
	
	
}
