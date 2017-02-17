package com.me.myfinalproject;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.myfinalproject.Dao.CommentDao;
import com.me.myfinalproject.pojo.Comments;
import com.me.myfinalproject.pojo.Room;
import com.me.myfinalproject.pojo.User;
import com.me.myfinalproject.validator.CommentValidator;


@Controller
public class CommentController {
	
	@Autowired
	@Qualifier("commentValidator")
	CommentValidator validator;
	
	@Autowired
	@Qualifier("CommentDao")
	CommentDao commentDao;
	
	 @InitBinder
		private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);
		}
	 
	 
	 @RequestMapping(value="postcomment.htm", method=RequestMethod.GET)
		public String postComment(@ModelAttribute("comments") Comments comment,BindingResult result,HttpServletRequest request ) throws Exception {
		 HttpSession session = request.getSession();
			if(session.getAttribute("user")==null){
				return "redirect:login.htm";
			}
			return "postcomment";
			
			
		}

	 @RequestMapping(value="addcomment.htm",method=RequestMethod.POST)
	 public String addComment(@ModelAttribute("comments") Comments comment,BindingResult result, HttpServletRequest request)
	 {
		 HttpSession session = request.getSession();
			if(session.getAttribute("user")==null){
				return "redirect:login.htm";
			}
		 //int roomID = Integer.parseInt(request.getParameter("pid"));
		 User user = (User) request.getSession().getAttribute("user");
		 Room room = (Room) request.getSession().getAttribute("searchroom");
		 String id = String.valueOf(room.getRoomID());
		 System.out.println(user.getFirstname());
		 System.out.println(room.getName());
		 Comments c1 = new Comments();
		 c1.setText(comment.getText());
		 Date d1 = new Date();
		 c1.setDate(d1);
		 c1.setUser(user);
		 c1.setRoom(room);
		 user.getComments().add(c1);
		 room.getCommentList().add(c1);
		 commentDao.addComment(c1);
		 return "postsuccess";
	 }
	 
}
