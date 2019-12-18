package com.example.movieservice.json;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MyDateDeserializer extends JsonDeserializer<LocalDate> {

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
        throws DateTimeException, IOException {

        String textualDate = p.getValueAsString();
        LocalDate date = LocalDate.parse(textualDate, formatter);
        return date;
	}

}