package com.me.myfinalproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.myfinalproject.pojo.Room;

public class RoomValidator implements Validator {
	
	public boolean supports(Class clazz) {
       
        return Room.class.equals(clazz);
    }

	
	public void validate(Object obj1, Errors errors) {
		 Room room = (Room)obj1;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.name", "PLEASE ENTER NAME");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "validate.address", "PLEASE ENTER ADDRESS");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "validate.street", "PLEASE ENTER STREET");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "validate.city", "PLEASE ENTER CITY");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "validate.state", "PLEASE ENTER STATE");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aminities", "validate.aminities", "PLEASE ENTER AMENITIES");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rules", "validate.rules", "PLEASE ENTER RULES");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "validate.description", "PLEASE ENTER DESCRIPTION");
			
	}
}
	
	
