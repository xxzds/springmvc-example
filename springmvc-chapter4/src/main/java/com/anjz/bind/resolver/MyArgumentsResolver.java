package com.anjz.bind.resolver;

import java.net.URLDecoder;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.anjz.bind.annotation.MyParam;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月4日上午11:44:58
 */
public class MyArgumentsResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		System.out.println("---------------------------------------supportsParameter----------------"+parameter);
		// 指定参数如果被应用MyParam注解，则使用该解析器。
        // 如果直接返回true，则代表将此解析器用于所有参数
		return parameter.hasParameterAnnotation(MyParam.class);
	}

	/**
     * 将request中的请求参数解析到当前Controller参数上
     * @param parameter 需要被解析的Controller参数，此参数必须首先传给{@link #supportsParameter}并返回true
     * @param mavContainer 当前request的ModelAndViewContainer
     * @param webRequest 当前request
     * @param binderFactory 生成{@link WebDataBinder}实例的工厂
     * @return 解析后的Controller参数
     */
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		System.out.println("---------------------------------------resolveArgument----------------");
		 // 解析器中的自定义逻辑——urldecode
	    Object arg = URLDecoder.decode(webRequest.getParameter(parameter.getParameterName()), "UTF-8");

	    // 将解析后的值绑定到对应的Controller参数上，利用DataBinder提供的方法便捷的实现类型转换
		if (binderFactory != null) {

			// 生成参数绑定器，第一个参数为request请求对象，第二个参数为需要绑定的目标对象，第三个参数为需要绑定的目标对象名
			WebDataBinder binder = binderFactory.createBinder(webRequest, null, parameter.getParameterName());

			// 将参数转到预期类型，第一个参数为解析后的值，第二个参数为绑定Controller参数的类型，第三个参数为绑定的Controller参数
			arg = binder.convertIfNecessary(arg, parameter.getParameterType(), parameter);

		}
	    return arg;
	}

}
