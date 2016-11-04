package com.anjz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anjz.bind.annotation.MyParam;
import com.anjz.model.User;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月4日上午9:54:14
 */
@Controller
public class MessageConverterController {
	
	@RequestMapping(value="objectConver")
	@ResponseBody
	public Object returnObject(@MyParam String name){
		
		User user=new User();
		user.setUsername(name);
		user.setPassword("123456");
		
		return user;
	}
	
	@RequestMapping("stringConver")
	@ResponseBody
	public String returnString(){
		return "测试test";
	}
	
	
	@RequestMapping("bytesConver")
	@ResponseBody
	public byte[] returnbytes(){
		return new byte[]{1,2,3};
	}

}
