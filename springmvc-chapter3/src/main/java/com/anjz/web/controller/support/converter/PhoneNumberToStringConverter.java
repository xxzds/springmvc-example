package com.anjz.web.controller.support.converter;

import org.springframework.core.convert.converter.Converter;

import com.anjz.model.PhoneNumberModel;

//PhoneNumberModel------>String
public class PhoneNumberToStringConverter implements Converter<PhoneNumberModel, String> {

	@Override
	public String convert(PhoneNumberModel source) {
		
		if(source == null) {
			return "";
		}
		
		return new StringBuilder()
					.append(source.getAreaCode()).append("-")
					.append(source.getPhoneNumber()).toString();

	}

}
