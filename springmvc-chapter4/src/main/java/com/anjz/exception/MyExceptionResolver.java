package com.anjz.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常处理类
 * 
 * @author ding.shuai
 * @date 2016年8月14日上午10:42:53
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
	
	private static final Logger log = LoggerFactory.getLogger(MyExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("error");
		log.error(ex.getMessage());
		ex.printStackTrace();

		return mv;
	}

}