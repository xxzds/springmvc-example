package com.anjz.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anjz.model.DataBinderTestModel;

@Controller
public class ErrorController {
	
	@RequestMapping("error")
	public  ModelAndView handle(@ModelAttribute("command") DataBinderTestModel command,BindingResult errors) {
		//全局错误消息
		//表示用户名不为空
		errors.reject("username.not.empty");
		//带有默认错误消息
		errors.reject("username.not.empty1", "用户名不能为空1");
		//带有参数和默认错误消息		
		errors.reject("username.length.error", new Object[]{5, 10}, "用户名长度不合法");
		
		//得到错误相关的模型数据
		Map model = errors.getModel();
		return new ModelAndView("bindAndValidate/error", model);
	}
	
//	@InitBinder
//	public  void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
//		//注册自定义的属性编辑器
//		//1、日期
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
//		//表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换
//		binder.registerCustomEditor(Date.class, dateEditor);
//		
//		//自定义的电话号码编辑器
//		binder.registerCustomEditor(PhoneNumberModel.class, new PhoneNumberEditor());
//	}
}
