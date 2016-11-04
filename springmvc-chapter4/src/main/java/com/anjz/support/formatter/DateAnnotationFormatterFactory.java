package com.anjz.support.formatter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月4日下午2:43:57
 */
public class DateAnnotationFormatterFactory implements AnnotationFormatterFactory<DateCusm>{

	private final Set<Class<?>> fieldTypes;
	
	public DateAnnotationFormatterFactory() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(Date.class);
		this.fieldTypes	= set;
	}
	
	
	@Override
	public Set<Class<?>> getFieldTypes() {
		return fieldTypes;
	}

	@Override
	public Printer<?> getPrinter(DateCusm annotation, Class<?> fieldType) {
		
		return new DateFormatter(annotation.value());
	}

	@Override
	public Parser<?> getParser(DateCusm annotation, Class<?> fieldType) {
		return new DateFormatter(annotation.value());
	}

}
