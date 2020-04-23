package com.codegym.formatter;

import com.codegym.model.Nal;
import com.codegym.service.NalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class NalFormatter implements Formatter<Nal> {

    @Autowired
    private NalService nalService;

    @Autowired
    public NalFormatter(NalService nalService) {
        this.nalService = nalService;
    }

    @Override
    public Nal parse(String text, Locale locale) throws ParseException {
        return nalService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Nal object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
