package com.example.carservice.json;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
// import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MyDateDeserializer extends StdDeserializer<Date> {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public MyDateDeserializer() {
        this(null);
    }

    public MyDateDeserializer(Class<?> vc) {
        super(vc);
    }

	@Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

        String textualDate = p.getValueAsString();
        Date date = null;

        try {
            date = format.parse(textualDate);
        } catch (ParseException e) {
            
        }
        return date;
	}

}