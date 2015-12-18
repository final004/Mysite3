package com.hanains.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanains.mysite.service.GuestbookService;
import com.hanains.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	private static final Log LOG = LogFactory.getLog(GuestbookController.class);
	
	@Autowired
	private GuestbookService guestbookservice;
	
	@RequestMapping("/listform")
	public String listform(HttpSession session){
		List<GuestbookVo> list = guestbookservice.list();
		System.out.println(list);
		session.setAttribute("list", list);
		
		LOG.debug("#GuestbookController(listform) - debug log" );
		LOG.info("#GuestbookController(listform) - info log" );
		LOG.warn("#GuestbookController(listform) - warn log" );
		LOG.error("#GuestbookController(listform) - error log" );
		
		return "/guestbook/listform";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestbookVo vo){
		System.out.println(vo);
		if(vo.getName()=="" || vo.getPassword()=="" || vo.getMessage()=="")
		{
			return "redirect:/guestbook/listform";
		}
		guestbookservice.insert(vo);
		
		LOG.debug("#GuestbookController(insert) - debug log" );
		LOG.info("#GuestbookController(insert) - info log" );
		LOG.warn("#GuestbookController(insert) - warn log" );
		LOG.error("#GuestbookController(insert) - error log" );
		
		return "redirect:/guestbook/listform";
	}
	
	@RequestMapping("/deleteform")
	public String deleteform(){
		
		LOG.debug("#GuestbookController(deleteform) - debug log" );
		LOG.info("#GuestbookController(deleteform) - info log" );
		LOG.warn("#GuestbookController(deleteform) - warn log" );
		LOG.error("#GuestbookController(deleteform) - error log" );
		
		return "/guestbook/deleteform";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestbookVo vo){
		guestbookservice.delete(vo);
		
		LOG.debug("#GuestbookController(delete) - debug log" );
		LOG.info("#GuestbookController(delete) - info log" );
		LOG.warn("#GuestbookController(delete) - warn log" );
		LOG.error("#GuestbookController(delete) - error log" );
		
		return "redirect:/guestbook/listform";
	}
	
}
