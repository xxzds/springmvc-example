package com.anjz.test;

import org.apache.log4j.net.SocketServer;
import org.junit.Test;

public class Log4jServer {
	
	@Test
	public void startServer(){
		String path= Log4jTest.class.getClassLoader().getResource("log4jServer.properties").getPath();		
		SocketServer.main(new String[]{"5001",path,"E:\\socketConfig"});
	}

}
