package com.me.myfinalproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.me.myfinalproject.Dao.BookingDao;
import com.me.myfinalproject.Dao.RoomDao;
import com.me.myfinalproject.pojo.Booking;
import com.me.myfinalproject.pojo.Customer;
import com.me.myfinalproject.pojo.Host;
import com.me.myfinalproject.pojo.Room;
import com.me.myfinalproject.pojo.User;
import com.me.myfinalproject.validator.BookingValidator;


@Controller
public class BookingController {
	
	@Autowired
	@Qualifier("bookingValidator")
	BookingValidator validator;
	
	@Autowired
	@Qualifier("BookingDao")
	BookingDao bookingDao;
	
	@Autowired
	@Qualifier("RoomDao")
	RoomDao roomDao;
	
	 @InitBinder
		private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);
		}

	 

		@RequestMapping(value="booking.htm", method=RequestMethod.GET)
		public String initializeFormroom(@ModelAttribute("booking") Booking booking, HttpServletRequest req, BindingResult result) throws Exception {
			HttpSession session = req.getSession();
			if(session.getAttribute("user")==null){
				return "redirect:login.htm";
			}
			int roomID = Integer.parseInt(req.getParameter("bid"));
			Room r = new Room();
			r = roomDao.findRoom(roomID);
			req.getSession().setAttribute("bookroom",r);
			return "booking";
		}
		
		@RequestMapping(value="book.htm", method=RequestMethod.POST)
        public String book(@ModelAttribute("booking") Booking booking, HttpServletRequest req, BindingResult result) throws Exception {
			HttpSession session = req.getSession();
			if(session.getAttribute("user")==null){
				return "redirect:login.htm";
			}
			
			validator.validate(booking, result);
			if (result.hasErrors()) {
				return "booking";
			}
			User user = (User) req.getSession().getAttribute("user");
			Customer cust = (Customer) req.getSession().getAttribute("user");
			Room roo = (Room)req.getSession().getAttribute("bookroom");
			
			ArrayList<Booking> checkL = new ArrayList<Booking>();
			checkL=bookingDao.checkBooking(booking.getBegin(), booking.getEnd());
			for(Booking b : checkL){
				if(roo.getRoomID()==b.getRoomID()){
					return "error";
				}
			}
			
			

			
			Booking b1 = new Booking();
			b1.setBegin(booking.getBegin());
			b1.setEnd(booking.getEnd());
			b1.setRoomID(roo.getRoomID());
			b1.setCustomer(cust);
			b1.setTotal(booking.getTotal());
			b1.setRoomcity(roo.getCity());
			b1.setRoomname(roo.getName());
			cust.getBookingHistory().add(b1);
			bookingDao.createbooking(b1);
			req.getSession().setAttribute("trip", b1);
			EmailController e1 = new EmailController();
            e1.setRecipient(cust.getEmail());
            e1.sendEmail();
			return "booksuccess";
			
			
		}
		
		



		@RequestMapping(value="trips.htm", method=RequestMethod.POST)
		public String showTrips(@ModelAttribute("booking") Booking booking,HttpServletRequest req, Model model, BindingResult result) throws Exception{
			
			HttpSession session = req.getSession();
			if(session.getAttribute("user")==null){
				return "redirect:login.htm";
			}
			
			User user = (User) req.getSession().getAttribute("user");
			Customer cust = (Customer) req.getSession().getAttribute("user");
			ArrayList<Booking> bookings = new ArrayList<Booking>();
			
			int id = cust.getUserID();
			bookings = bookingDao.showTrips(id);
			model.addAttribute("trip", bookings);
			req.getSession().setAttribute("trips",bookings);
			return "tt";
			
		}
		
		@RequestMapping(value = "report.pdf", method = RequestMethod.GET)
		public ModelAndView createReport(HttpServletRequest req)
		{
			
			View view = new PdfReportView();
			Booking book = (Booking) req.getSession().getAttribute("trip");
			return new ModelAndView(view, "trip", book);
		}
		
		@RequestMapping(value="showue.htm", method=RequestMethod.POST)
		public String showVisits(@ModelAttribute("booking") Booking booking,HttpServletRequest req, Model model, BindingResult result) throws Exception{
			HttpSession session = req.getSession();
			if(session.getAttribute("user")==null){
				return "redirect:login.htm";
			}
			User user = (User) req.getSession().getAttribute("user");
			Host host = (Host) req.getSession().getAttribute("user");
			ArrayList<Room> rooms = new ArrayList<Room>();
			ArrayList<Booking> visits = new ArrayList<Booking>();
			ArrayList<Booking> finallist = new ArrayList<Booking>();
			int hid = host.getUserID();
		   
			rooms = roomDao.viewlist(hid);
		    visits = bookingDao.showVisits();
		    
		    for(Room r : rooms){
		    	for (Booking bb :visits ){
		    		if(bb.getRoomID()==r.getRoomID()){
		    			finallist.add(bb);
		    		}
		    	}
		    }
			
			model.addAttribute("finallist", finallist);
			return "showvisits";
			
			
			
		}
		
		
}
