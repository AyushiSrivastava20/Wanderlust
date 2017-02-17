package com.me.myfinalproject.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.myfinalproject.pojo.User;

@Component
public class UserValidator implements Validator {
	
	public boolean supports(Class clazz) {
       
        return User.class.equals(clazz);
    }

   

	public void validate(Object obj1, Errors errors) {
		  User user = (User)obj1;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "validate.firstname", "PLEASE ENTER FIRSTNAME");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "validate.lastname", "PLEASE ENTER LASTNAME");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.password", "PLEASE ENTER PASSWORD");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validate.email", "PLEASE ENTER EMAIL");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "validate.phone", "PLEASE ENTER PHONE");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "validate.username", "PLEASE ENTER USERNAME");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "validate.city", "PLEASE ENTER CITY");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "validate.state", "PLEASE ENTER STATE");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "validate.country", "PLEASE ENTER COUNTRY");
			
			if(user.getPhone().length()<10){
				errors.rejectValue("phone", "phone.required", "Mobile No should be minimum 10 digits");
			}
			
			if(user.getPassword().length()==0){

				errors.rejectValue("password", "password.required", "Password Required");
			}
			
			

	}
    	
    

}
