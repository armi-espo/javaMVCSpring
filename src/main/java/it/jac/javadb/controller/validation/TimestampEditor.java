package it.jac.javadb.controller.validation;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TimestampEditor extends PropertyEditorSupport {

	private static final Logger logger = LoggerFactory.getLogger(TimestampEditor.class);

	public TimestampEditor() {
		super();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text.isEmpty()) {
			setValue(null);
		} else {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			try {
				Date d = dateFormat.parse(text);
				Timestamp time = new Timestamp(d.getTime());
				setValue(time);
				logger.debug(text + " converted to " + getValue());
			} catch (ParseException e) {
				try {
					Timestamp time = new Timestamp(Long.valueOf(text));
					setValue(time);

				} catch (Exception e1) {
					logger.debug(e.toString());

				}
			}
		}
	}

	@Override
	public String getAsText() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		if (getValue() == null)
			return "";
		logger.debug(getValue().toString());
		return dateFormat.format((Timestamp) getValue());
	}
}