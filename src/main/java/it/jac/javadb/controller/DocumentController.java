package it.jac.javadb.controller;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.jac.javadb.controller.validation.DateEditor;
import it.jac.javadb.controller.validation.DocumentoValidator;
import it.jac.javadb.controller.validation.TimestampEditor;
import it.jac.javadb.dto.DocumentoDTO;
import it.jac.javadb.entity.Documento;
import it.jac.javadb.service.DocumentoService;

@Controller
@RequestMapping("/jac")
@Secured("ROLE_USER")
public class DocumentController {

	private Logger log = LoggerFactory.getLogger(DocumentController.class);
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(new DocumentoValidator());
		binder.registerCustomEditor(Timestamp.class, new TimestampEditor());
		binder.registerCustomEditor(java.util.Date.class, new DateEditor());
	}
	
	@Autowired
	private DocumentoService service;
	
	@GetMapping(path = "/home")
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		
		return mav;
	}	
	
	@Secured("ROLE_EDIT")
	@GetMapping(path = "/insert")
	public ModelAndView pageInsert() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insert");
		
		DocumentoDTO dto = new DocumentoDTO();
		mav.addObject("dto", dto);
		
		return mav;
	}

	@Secured("ROLE_EDIT")
	@PostMapping(path = "/insert")
	public ModelAndView sendDocumentInfo(
			@ModelAttribute("dto") @Validated DocumentoDTO dto, 
			BindingResult bindingResult) {
		
		log.debug("coddoc {}", dto.getCodDoc());
		log.debug("datadoc {}", dto.getDataDoc());

		ModelAndView mav = new ModelAndView();

		if (bindingResult.hasErrors()) {
			
			log.warn("Errore nel binding dei parametri");
			mav.setViewName("insert");
			
		} else {
			
			// bind parametri corretto
			// posso procedere con il salvataggio dei dati su DB
			mav.setViewName("redirect:/jac/list");
			
			Documento doc = new Documento();
			BeanUtils.copyProperties(dto, doc);
			
			service.creaDocumento(doc);
		}
		
		return mav;
	}

	@Secured("ROLE_EDIT")
	@PostMapping(path = "/update")
	public ModelAndView updateDocumentInfo(
			@ModelAttribute("dto") @Validated DocumentoDTO dto, 
			BindingResult bindingResult) {
		
		log.debug("coddoc {}", dto.getCodDoc());
		log.debug("datadoc {}", dto.getDataDoc());

		ModelAndView mav = new ModelAndView();

		if (bindingResult.hasErrors()) {
			
			log.warn("Errore nel binding dei parametri");
			mav.setViewName("update");
			
		} else {
			
			// bind parametri corretto
			// posso procedere con il salvataggio dei dati su DB
			mav.setViewName("redirect:/jac/list");
			
			Documento doc = new Documento();
			BeanUtils.copyProperties(dto, doc);
			
			service.creaDocumento(doc);
		}
		
		return mav;
	}

	@Secured("ROLE_EDIT")
	@GetMapping(path = "/update")
	public ModelAndView pageUpdate(@RequestParam(name = "docId") String parId) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("update");
		
		Documento documento = service.findDocumentoById(Integer.parseInt(parId));
		if (documento != null) {
			
			DocumentoDTO dto = new DocumentoDTO();
			BeanUtils.copyProperties(documento, dto);
			
			mav.addObject("dto", dto);
			
		} else {
			
			throw new IllegalArgumentException("Document id " + parId + " is not valid");
			
		}
		return mav;
	}
	
	@GetMapping(path = "/list")
	public ModelAndView pageList() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		
		List<Documento> list = service.findAll();
		mav.addObject("list", list);
		
		return mav;
	}	

	@GetMapping(path = "/detail")
	public ModelAndView pageDetail(@RequestParam(name = "docId") String parId) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("detail");
		
		Documento documento = service.findDocumentoById(Integer.parseInt(parId));
		if (documento != null) {
			
			DocumentoDTO dto = new DocumentoDTO();
			// utilità
			BeanUtils.copyProperties(documento, dto);
			
			mav.addObject("dto", dto);
			
		} else {
			
			throw new IllegalArgumentException("Document id " + parId + " is not valid");
			
		}
		return mav;
	}
}
