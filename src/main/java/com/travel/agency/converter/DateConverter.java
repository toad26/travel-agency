package com.travel.agency.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(arg0);
		} catch (ParseException e) {
			try {
				return new SimpleDateFormat("MM/dd/yy").parse(arg0);
			} catch (ParseException e2){
				e2.printStackTrace();
				return null;
			}
		}  
	}
}
