package com.anjz.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月7日上午10:53:24
 */
public class Log4jTest {

	@Before
	public void before(){				
		String path= Log4jTest.class.getClassLoader().getResource("log4j.properties").getPath();
		PropertyConfigurator.configure(path);	
	}
	
	/**
	 * 后台输出
	 */
	@Test
	public void console(){
		Logger logger = Logger.getLogger(Log4jTest.class);
		logger.debug("debug!!!");
		logger.info("info!!!");
		logger.warn("warn!!!");
		logger.error("error!!!");
		logger.fatal("fatal!!!");
		
		
	}
}
