package com.demo.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("usernameValidator")
public class UsernameValidator implements Validator{

	public void validate(FacesContext facescontext, UIComponent uicomponent, Object object) throws ValidatorException {
		String username = object.toString();
		if(username.equalsIgnoreCase("abc")) {
			FacesMessage facesMessage = new FacesMessage();
			facesMessage.setSummary("Username is invalid");
			facesMessage.setDetail("Username already exists");
			facesMessage.setSeverity(facesMessage.SEVERITY_ERROR);
			throw new ValidatorException(facesMessage);
		}
		
		
	}
	
}
