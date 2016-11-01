package com.anjz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anjz.model.UserModel;
import com.anjz.web.controller.support.validator.UserModelValidator;

@Controller
public class SuccessController {

	@RequestMapping("/success")
	public String success() {
		return "success";
	}
	
}
