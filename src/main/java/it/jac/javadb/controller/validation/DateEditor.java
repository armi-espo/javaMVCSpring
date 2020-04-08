package it.jac.javadb.controller.validation;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DateEditor extends PropertyEditorSupport {

	private static final Logger logger = LoggerFactory.getLogger(DateEditor.class);

	public DateEditor() {
		super();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text.isEmpty()) {
			setValue(null);
		} else {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date d = dateFormat.parse(text);
				setValue(d);
				logger.debug(text + " converted to " + getValue());
			} catch (ParseException e) {
				try {
					Date d = new Date(Long.valueOf(text));
					setValue(d);

				} catch (Exception e1) {
					logger.debug(e.toString());

				}
			}
		}
	}

	@Override
	public String getAsText() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		if (getValue() == null)
			return "";
		logger.debug(getValue().toString());
		return dateFormat.format((Timestamp) getValue());
	}
}