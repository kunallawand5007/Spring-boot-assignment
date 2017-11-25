/**
 * 
 */
package com.intellect.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author admin
 *
 */
@Component
public class CustomLocalDateSerializer extends JsonSerializer<Date> {

	static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider arg2)
			throws IOException, JsonProcessingException {

		String formattedDate = formatter.format(date);
		jsonGenerator.writeString(formattedDate);

	}
}
