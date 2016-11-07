package com.anjz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anjz.model.User;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月4日下午3:14:10
 */
@Controller
public class ConverterAndFormatController {
	
	@RequestMapping("string2date")
	public String convertString2Date(User user,Model model){
		
		model.addAttribute("user", user);
		return "test";
	}
	
	
	@RequestMapping(value="testform",method=RequestMethod.GET)
	public String totTestForm(Model model){
		if(!model.containsAttribute("user")){
			model.addAttribute("user", new User());
		}
		
		return "testform";
	}
	
	
	@RequestMapping(value="testform",method=RequestMethod.POST)
	public String testForm(@ModelAttribute User user,BindingResult bindingResult,Model model){
		if(bindingResult.hasErrors()){	
//			DefaultMessageCodesResolver
			//全局错误
			bindingResult.reject("1001", null, "测试全局错误");
			
			
			return totTestForm(model);
		}
		
		return "testform";
	}
}
