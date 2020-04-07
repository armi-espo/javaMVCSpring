package it.jac.javadb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import it.jac.javadb.entity.Documento;

@Controller
public class TestJspController {

	@GetMapping(path = "/testjsp")
	public ModelAndView testjsp() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("testtaglib");
		
		List<String> list = new ArrayList<>();
		list.add("stringa1");
		list.add("stringa2");
		list.add("stringa3");
		mav.addObject("list", list);

		mav.addObject("numero", 100);
		
		Documento doc = new Documento();
		doc.setCodDoc("cod1");
		doc.setDataDoc(new Date());
		
		mav.addObject("obj", doc);
		
		return mav;
	}	
}
