package com.web.util;

import org.apache.log4j.Logger;

public class Log {
	
	public static Logger logger = Logger.getLogger("");
	
	public static void info(String msg){
		logger.info(msg);
	}
	
	public static void out(String msg){
		System.out.println(msg);
	}

}
