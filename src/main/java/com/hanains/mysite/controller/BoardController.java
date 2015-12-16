package com.hanains.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
			return "/user/loginretry";
		}
		session.setAttribute("authUser", authUser);
		return "/board/writeform";
	}
	
	@RequestMapping("/write")
	public String write(HttpSession session, 
			@ModelAttribute BoardVo vo,
			@RequestParam("uploadFile")
			MultipartFile multipartFile, 
			Model model
			){
		System.out.println("write 동작");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser==null){
			System.out.println("fail");
			return "/user/loginretry";
		}
		session.setAttribute("authUser", authUser);
		
		Long noStr = authUser.getNo();
		String no = noStr.toString();
		vo.setMemberNo(no);
		boardService.insert(vo);
		return "redirect:/board/listform";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpSession session,@ModelAttribute BoardVo vo){
		System.out.println("delete 동작");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser==null){
			System.out.println("fail");
			return "/user/loginretry";
		}
		Long noStr = vo.getNo();
		String no = noStr.toString();
		Long memberNoStr = authUser.getNo();
		String memberNo = memberNoStr.toString();
		System.out.println(no);
		vo.setMemberNo(memberNo);
		
		boardService.delete(vo);
		return "redirect:/board/listform";
	}
	
	@RequestMapping("/viewform")
	public String viewform(HttpSession session, @ModelAttribute BoardVo vo){
		System.out.println("viewform 동작");
		
		Long noStr = vo.getNo();
		String no = noStr.toString();
		vo.setMemberNo(no);
		BoardVo v = boardService.view(vo);
		session.setAttribute("v", v);
		
		return "/board/viewform";
	}
	
	@RequestMapping("/modifyform")
	public String modifyform(HttpSession session){
		System.out.println("modifyform 동작");
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser==null){
			System.out.println("fail");
			return "/user/loginretry";
		}
		session.setAttribute("authUser", authUser);
		return "/board/modifyform";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpSession session, @ModelAttribute BoardVo vo){
		System.out.println("modify 동작");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser==null){
			System.out.println("fail");
			return "/user/loginretry";
		}
		session.setAttribute("authUser", authUser);

		vo.setTitle(vo.getTitle());
		vo.setContent(vo.getContent());
		vo.setNo(vo.getNo());
		
		boardService.modify(vo);
		return "redirect:/board/listform";
	}
	
}
