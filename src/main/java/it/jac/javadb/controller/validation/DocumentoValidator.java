package it.jac.javadb.controller.validation;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.jac.javadb.dto.DocumentoDTO;

public class DocumentoValidator implements Validator {

	private Logger log = LoggerFactory.getLogger(DocumentoValidator.class);
			
	@Override
	public boolean supports(Class<?> clazz) {
		return DocumentoDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		log.debug("Validate object Documento");
		
		DocumentoDTO dto = (DocumentoDTO) target;
		
		if (StringUtils.isEmpty(dto.getCodDoc()) || dto.getCodDoc().length() < 3) {
			errors.rejectValue("codDoc", "codDoc.notValid");
		}
	}

}
