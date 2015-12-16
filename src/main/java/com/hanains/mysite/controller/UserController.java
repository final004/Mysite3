package com.hanains.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanains.mysite.service.UserService;
import com.hanains.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform(){
		System.out.println("joinform 동작");
		return "/user/joinform";
	}

	@RequestMapping("/loginform")
	public String loginform(){
		System.out.println("loginform 동작");
		return "/user/loginform";
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo vo){
		System.out.println(vo);
		if(vo.getEmail()=="" || vo.getName()=="" || vo.getPassword()=="")
		{
			return "redirect:/user/joinform";
		}
		userService.join(vo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess(){
		
		return "/user/joinsuccess";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, @ModelAttribute UserVo vo){
		UserVo authUser = userService.login(vo);
		System.out.println(authUser);
		if(authUser==null){
			System.out.println("fail");
			return "/user/loginretry";
		}
		session.setAttribute("authUser", authUser);
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	
}
