package com.hanains.mysite.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	private static final Log LOG = LogFactory.getLog(MainController.class );
	
	@RequestMapping("/")
	public String index(){
		LOG.debug("#MainController(index) - debug log" );
		LOG.info("#MainController(index) - info log" );
		LOG.warn("#MainController(index) - warn log" );
		LOG.error("#MainController(index) - error log" );
		
		return "/main/index";
	}
	
}
