package com.me.myfinalproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.myfinalproject.pojo.Comments;


public class CommentValidator implements Validator {
	
	public boolean supports(Class clazz) {
       
        return Comments.class.equals(clazz);
    }

	
	public void validate(Object obj1, Errors errors) {
		 Comments comment = (Comments)obj1;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "validate.text", "PLEASE ENTER COMMENT");
			
	}
}
