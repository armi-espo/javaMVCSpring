package it.jac.javadb.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenericErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping(path = "/error")
	public ModelAndView handleError () {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("genericError");
		
		return mav;
	}
}
