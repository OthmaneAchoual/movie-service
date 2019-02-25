package com.example.movieservice.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MyDateSerializer extends JsonSerializer<Date> {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public void serialize (Date date, JsonGenerator generator, SerializerProvider provider)
        throws IOException {
        generator.writeString(format.format(date));
    }
} 