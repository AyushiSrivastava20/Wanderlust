package com.me.myfinalproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.myfinalproject.pojo.Booking;


public class BookingValidator implements Validator {
	
	public boolean supports(Class clazz) {
       
        return Booking.class.equals(clazz);
    }

	
	public void validate(Object obj1, Errors errors) {
		 Booking booking = (Booking)obj1;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "begin", "validate.begin", "SELECT BIGIN DATE");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "end", "validate.end", "SELECT BIGIN DATE");
			
	}

}
