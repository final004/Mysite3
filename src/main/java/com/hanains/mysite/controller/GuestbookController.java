package com.hanains.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hanains.mysite.service.GuestbookService;
import com.hanains.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookservice;
	
	@RequestMapping("/listform")
	public String listform(HttpSession session){
		System.out.println("listform 동작");
		List<GuestbookVo> list = guestbookservice.list();
		System.out.println(list);
		session.setAttribute("list", list);
		return "/guestbook/listform";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestbookVo vo){
		guestbookservice.insert(vo);
		return "redirect:/guestbook/listform";
	}
	
	@RequestMapping("/deleteform")
	public String deleteform(){
		return "/guestbook/deleteform";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestbookVo vo){
		guestbookservice.delete(vo);
		return "redirect:/guestbook/listform";
	}
	
}
