package it.jac.javadb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView root() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/jac/home");
		
		return mav;
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		
		return mav;
	}
	
	@RequestMapping(path = "/encodePassword", method = RequestMethod.GET)
	public ModelAndView encodePassword(@RequestParam String pwd) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("encodePassword");

		mav.addObject("encodedPwd", bCryptPasswordEncoder.encode(pwd));
		
		return mav;
	}

}
