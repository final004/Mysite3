package com.hanains.mysite.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanains.mysite.service.UserService;
import com.hanains.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Log LOG = LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform(){
		LOG.debug("#UserController(joinform) - debug log" );
		LOG.info("#UserController(joinform) - info log" );
		LOG.warn("#UserController(joinform) - warn log" );
		LOG.error("#UserController(joinform) - error log" );
		
		return "/user/joinform";
	}

	@RequestMapping("/loginform")
	public String loginform(){
		LOG.debug("#UserController(loginform) - debug log" );
		LOG.info("#UserController(loginform) - info log" );
		LOG.warn("#UserController(loginform) - warn log" );
		LOG.error("#UserController(loginform) - error log" );
		
		return "/user/loginform";
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo vo){
		System.out.println(vo);
		if(vo.getEmail().trim().length()==0 || vo.getName().trim().length()==0 || vo.getPassword().trim().length()==0)
		{
			return "redirect:/user/joinform";
		}
		userService.join(vo);
		
		LOG.debug("#UserController(join) - debug log" );
		LOG.info("#UserController(join) - info log" );
		LOG.warn("#UserController(join) - warn log" );
		LOG.error("#UserController(join) - error log" );
		
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess(){
		LOG.debug("#UserController(joinSuccess) - debug log" );
		LOG.info("#UserController(joinSuccess) - info log" );
		LOG.warn("#UserController(joinSuccess) - warn log" );
		LOG.error("#UserController(joinSuccess) - error log" );
		
		return "/user/joinsuccess";
	}
	
	@RequestMapping("/loginretry")
	public String loginRetry(){
		LOG.debug("#UserController(loginRetry) - debug log" );
		LOG.info("#UserController(loginRetry) - info log" );
		LOG.warn("#UserController(loginRetry) - warn log" );
		LOG.error("#UserController(loginRetry) - error log" );
		
		return "/user/loginretry";
	}
}
