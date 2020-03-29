package it.jac.javadb.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GenericErrorController {
	
	@ExceptionHandler(AccessDeniedException.class)
	public ModelAndView handleAccessDeniedException(AccessDeniedException ex) {

		return new ModelAndView("accessDenied");
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {

		return new ModelAndView("genericError");
	}

}
