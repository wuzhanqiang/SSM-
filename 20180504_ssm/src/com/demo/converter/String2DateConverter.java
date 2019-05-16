package com.demo.converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.core.convert.converter.Converter;

public class String2DateConverter implements Converter<String, Date> {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Date convert(String str) {
		//1.String -> java.util.Date
		java.util.Date temp = null;
		try {
			temp = SDF.parse(str);
		} catch (ParseException e) {
			return null;
		}
		//2.java.util.Date -> java.sql.Date
			if(temp != null) {
				Date date = new Date(temp.getTime());
				return date;
			}else {
				return null;
			}
		
	}
	
}
