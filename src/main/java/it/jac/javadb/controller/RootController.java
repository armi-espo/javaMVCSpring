package it.jac.javadb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping(path = "/")
	public ModelAndView root() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/jac/home");
		
		return mav;
	}
	
	@GetMapping(path = "/login")
	public ModelAndView login() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		
		return mav;
	}
	
	@GetMapping(path = "/encodePassword")
	public ModelAndView encodePassword(@RequestParam String pwd) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("encodePassword");

		mav.addObject("encodedPwd", bCryptPasswordEncoder.encode(pwd));
		
		return mav;
	}

}
