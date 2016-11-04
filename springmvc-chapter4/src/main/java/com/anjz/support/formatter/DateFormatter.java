package com.anjz.support.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.format.Formatter;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月4日下午2:38:50
 */
public class DateFormatter implements Formatter<Date>{
	
	private String pattern;
	
    public DateFormatter(String pattern) {
		this.pattern=pattern;
	}

	@Override
	public String print(Date object, Locale locale) {
		System.out.println("调到日期格式的方法----------------print");
		if(object==null){
			return "";
		}
		
		SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);		
		return dateFormat.format(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		if(StringUtils.isBlank(text)){
			return null;
		}
		
		SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);	
		return dateFormat.parse(text);
	}

}
