package com.me.myfinalproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.me.myfinalproject.Dao.RoomDao;
import com.me.myfinalproject.exception.AdUException;
import com.me.myfinalproject.pojo.Customer;
import com.me.myfinalproject.pojo.Host;
import com.me.myfinalproject.pojo.Room;
import com.me.myfinalproject.pojo.User;
import com.me.myfinalproject.pojo.Wishlist;
import com.me.myfinalproject.validator.RoomValidator;




@Controller
public class RoomController {
	
	@Autowired
	@Qualifier("roomValidator")
	RoomValidator validator;
	

    @Autowired
    ServletContext servletContext;

	@Autowired
	@Qualifier("RoomDao")
	RoomDao roomDao;
	
	 @InitBinder("room")
		private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);
		}
	
	@RequestMapping(value="/addroom.htm", method=RequestMethod.GET)
	public String initializeFormroom(@ModelAttribute("room") Room room, BindingResult result, HttpServletRequest req) {

		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:login.htm";
		}
		return "addroom";
	}
	
	@RequestMapping(value="/addroom.htm", method=RequestMethod.POST)
	public String SubmitAction(@ModelAttribute("room") Room room,@RequestParam("photo") MultipartFile photoFile, HttpServletRequest request, BindingResult result) throws AdUException, IOException{

		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:login.htm";
		}
		validator.validate(room, result);
	    if (result.hasErrors()) {
			return "addroom";
		}
	    
	   
		
	    User user = (User) request.getSession().getAttribute("user");
	    Host host = (Host) request.getSession().getAttribute("user");

		room.setHost(host);
		room.setOwner(user.getFirstname());
		room.setState("Active");
		host.getListings().add(room);
		
		   File file;
	       String check = File.separator; 
	       String path = null;
	       if(check.equalsIgnoreCase("\\")) {
	           
	        path = servletContext.getRealPath("").replace("build\\",""); 
	    }
	    
	        if(check.equalsIgnoreCase("/")) {
	            
	       path = servletContext.getRealPath("").replace("build/","");
	       
	       path += "/resources/images/"; 

	    }
	        path+="resources\\images\\";
	        
	        if(room.getPhoto() != null){
	            
	            String fileNameWithExt = System.currentTimeMillis() + photoFile.getOriginalFilename();

	            file = new File(path+fileNameWithExt);
	            
	            String context = servletContext.getContextPath();
	            
	            photoFile.transferTo(file);
	            
	            String photoName= context + "/resources/images/" +fileNameWithExt; 
	            room.setPhotoName(photoName);
	            

	        }
		  
		
		try{
			roomDao.createRoom(room);
			
			}catch(Exception e) {
				
				System.out.print("Error in listing room");
			}
		
		
		return "successlist";
		
	}
	
	
	@RequestMapping(value="/viewlist.htm", method=RequestMethod.GET)
	public String viewList(@ModelAttribute("room") Room room, Model model, HttpServletRequest req, BindingResult result) throws Exception {

		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:login.htm";
		}
		ArrayList<Room> roomList = new ArrayList<Room>();
		
		
	    User user = (User) req.getSession().getAttribute("user");
	    System.out.println(user.getEmail());
	    int id = user.getUserID();
		roomList = roomDao.viewlist(id);
		System.out.println(roomList.size());
		model.addAttribute("roomlist", roomList);
		return "viewlist";
	}
	
	
	@RequestMapping(value="showprop", method=RequestMethod.POST)
	public String showuser(@ModelAttribute("room") Room room, Model model,HttpServletRequest req, BindingResult result) throws Exception {

		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:login.htm";
		}
		
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms = roomDao.showprop();
		
		model.addAttribute("allprops", rooms);
		return "viewprop";
	}
	
	@RequestMapping(value="/customerpage", method=RequestMethod.GET)
	public String signupForm(@ModelAttribute("room") Room room, BindingResult result, HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:login.htm";
		}
		return "customerPage";
	}
	
	@RequestMapping(value="/search.htm", method=RequestMethod.POST)
	public String search(@ModelAttribute("room") Room room, Model model,HttpServletRequest req, BindingResult result,
			@RequestParam("city") String city,@RequestParam("roomtype") String roomtype,
			@RequestParam("begin") Date begin, @RequestParam("end") Date end) throws Exception {

		
	    HttpSession session = req.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:login.htm";
		}
		ArrayList<Room> searchrooms = new ArrayList<Room>();
		System.out.println(begin);
		System.out.println(end);
		searchrooms = roomDao.searchrooms(city,roomtype,begin,end);
		
		model.addAttribute("searchrooms", searchrooms);
		return "searchrooms";
	}
	
	
	@RequestMapping(value="/detailroom.htm", method=RequestMethod.GET)
	public String detailRoom(@ModelAttribute("room") Room room,HttpServletRequest req, BindingResult result) throws Exception {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:login.htm";
		}
		int roomID = Integer.parseInt(req.getParameter("id"));
		System.out.println(roomID);
		Room searchroom = new Room();
		searchroom = roomDao.findRoom(roomID);
		 
		session.setAttribute("searchroom", searchroom);
		
		return "detailrooms";
	}
	
	
	@RequestMapping(value="/addwish.htm", method=RequestMethod.GET)
	public String addWish(@ModelAttribute("room") Room room, HttpServletRequest req, BindingResult result) throws Exception{
		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:login.htm";
		}
		int roomID = Integer.parseInt(req.getParameter("id"));
		Room r2 = new Room();
		r2 = roomDao.findRoom(roomID);
		User user = (User) req.getSession().getAttribute("user");
		Customer cust = (Customer) req.getSession().getAttribute("user");
		Wishlist w1 = new Wishlist();
		w1.setCust(cust);
		w1.setRoomID(r2.getRoomID());
		w1.setRoomname(r2.getName());
		w1.setRoomcity(r2.getCity());
		roomDao.saveWishList(w1);
	    System.out.println("Added to wishlist");
	    return "wishsuccess";
		
	}
	
	
	@RequestMapping(value="/wish.htm", method=RequestMethod.POST)
	public String showWishlist(@ModelAttribute("model")ModelMap model,HttpServletRequest req){
		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:login.htm";
		}
		User u1 = (User) req.getSession().getAttribute("user");
		Customer cust = (Customer) req.getSession().getAttribute("user");
		List<Wishlist> wish = new ArrayList<Wishlist>();
		try {
			wish = roomDao.viewwishlist(cust.getUserID());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("wish", wish);
		return "my";
	}
	
	

}
