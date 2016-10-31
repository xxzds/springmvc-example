package com.anjz.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anjz.controller.support.editor.PhoneNumberEditor;
import com.anjz.model.DataBinderTestModel;
import com.anjz.model.PhoneNumberModel;

/**
 * http://localhost:8080/chapter2/dataBinder?username=dingshuai&bool=1&schooInfo.schoolName=安徽建筑大学&hobbyList=1,2,3&map[key1]=value1&map[key2]=value2&phoneNumber=010-12345678&date=2016-10-31%2012:58:12&state=normal
 * @author shuai.ding
 * @date 2016年10月31日下午12:59:59
 */
@Controller
public class DataBinderTestController {
	

	@RequestMapping("/dataBinder")
	public  ModelAndView handle(@ModelAttribute("command") DataBinderTestModel command) throws Exception {
		System.out.println(command);
		return new ModelAndView("bindAndValidate/success");
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
