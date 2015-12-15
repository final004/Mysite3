package com.hanains.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanains.mysite.service.BoardService;
import com.hanains.mysite.vo.BoardVo;
import com.hanains.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/listform")
	public String list(HttpSession session){
		System.out.println("listform 동작");
		List<BoardVo> list = boardService.list();
		System.out.println(list);
		session.setAttribute("list", list);
		return "/board/listform";
	}
	
	@RequestMapping("/writeform")
	public String writeform(HttpSession session){
		System.out.println("writeform 동작");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser==null){
			System.out.println("fail");
			return "/user/loginform";
		}
		session.setAttribute("authUser", authUser);
		return "/board/writeform";
	}
	
	@RequestMapping("/write")
	public String write(HttpSession session, @ModelAttribute BoardVo vo){
		System.out.println("write 동작");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser==null){
			System.out.println("fail");
			return "/user/loginform";
		}
		session.setAttribute("authUser", authUser);
		
		Long noStr = authUser.getNo();
		String no = noStr.toString();
		vo.setMember_no(no);
		
		boardService.insert(vo);
		return "redirect:/board/listform";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute BoardVo vo){
		System.out.println("delete 동작");
		boardService.delete(vo);
		return "redirect:/board/listform";
	}
	
	@RequestMapping("/viewform")
	public String viewform(HttpSession session, @ModelAttribute BoardVo vo){
		System.out.println("viewform 동작");
		
//		UserVo authUser = (UserVo) session.getAttribute("authUser");
//		session.setAttribute("authUser", authUser);
//		
//		Long noStr = authUser.getNo();
//		String no = noStr.toString();
//		vo.setMember_no(no);
//		BoardVo v = boardService.view(vo);
//		session.setAttribute("v", v);
		
		Long noStr = vo.getNo();
		String no = noStr.toString();
		vo.setMember_no(no);
		BoardVo v = boardService.view(vo);
		session.setAttribute("v", v);
		
		return "/board/viewform";
	}
	
	@RequestMapping("/modifyform")
	public String modifyform(){
		System.out.println("modifyform 동작");
		return "/board/modifyform";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpSession session, @ModelAttribute BoardVo vo){
		System.out.println("modify 동작");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser==null){
			System.out.println("fail");
			return "/user/loginform";
		}
		session.setAttribute("authUser", authUser);

//		System.out.println(vo.getNo() + ":" + vo.getTitle() + ":" + vo.getContent());
		vo.setTitle(vo.getTitle());
		vo.setContent(vo.getContent());
		vo.setNo(vo.getNo());
		
		boardService.modify(vo);
		return "redirect:/board/listform";
	}
	
}
