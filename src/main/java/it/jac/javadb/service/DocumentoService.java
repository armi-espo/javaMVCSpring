package it.jac.javadb.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.javadb.dao.DocumentoRepository;
import it.jac.javadb.entity.Documento;

@Service
public class DocumentoService {

	private static final Logger log = LogManager.getLogger(DocumentoService.class);

	@Autowired
	private DocumentoRepository repository;
	
	public String testConnessione() {
		
		log.info("Test connessione");
		
		boolean test = this.repository.testConnection();
		if (test) {
			log.info("Test OK");
		}
		return test ? "ok" : "ko";
	}
	
	public List<Documento> findAll() {
		return IteratorUtils.toList(this.repository.findAll().iterator());
	}
	
	public void creaDocumento(Documento doc) {
		
		doc.setCreationUser("system");
		
		this.repository.save(doc);
	}
	
	public void eliminaDocumento(Documento doc) {
		
		this.repository.delete(doc);
	}

	public Documento findDocumentoById(Integer id) {

		return this.repository.findById(id).get();
	}

	public List<Documento> findOnlyValid() {
		
		return this.repository.findOnlyValid();
	}
	
	public void modificaDocumento(int id, String value) {

		Documento doc = findDocumentoById(id);
		doc.setCodDoc(value);
		
		this.repository.save(doc);
	}
}
