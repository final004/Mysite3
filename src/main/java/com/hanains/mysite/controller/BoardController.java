package com.hanains.mysite.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanains.mysite.annotation.Auth;
import com.hanains.mysite.annotation.AuthUser;
import com.hanains.mysite.service.BoardService;
import com.hanains.mysite.vo.BoardVo;
import com.hanains.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Log LOG = LogFactory.getLog(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/listform")
	public String list(HttpSession session,
			@RequestParam(value="p", required=true, defaultValue="1") Long page,
			Model model
			){

		List<BoardVo> list = boardService.list();
		System.out.println(list);
		session.setAttribute("list", list);
		
		Map<String, Object> map = boardService.listBoard(list, page);
		model.addAttribute("listData", map);
		
		LOG.debug("#BoardController(list) - debug log" );
		LOG.info("#BoardController(list) - info log" );
		LOG.warn("#BoardController(list) - warn log" );
		LOG.error("#BoardController(list) - error log" );
		
		return "/board/listform";
	}

	@Auth
	@RequestMapping("/writeform")
	public String writeform(){
		LOG.debug("#BoardController(writeform) - debug log" );
		LOG.info("#BoardController(writeform) - info log" );
		LOG.warn("#BoardController(writeform) - warn log" );
		LOG.error("#BoardController(writeform) - error log" );
		
		return "/board/writeform";
	}
	
	@Auth
	@RequestMapping("/write")
	public String write(@AuthUser UserVo authUser,
			@ModelAttribute BoardVo vo
			//@RequestParam Long boardNo,
			//@RequestParam("upload") MultipartFile multipartFile, 
			//Model model
			){
		if(vo.getTitle().trim().length()==0 || vo.getContent().trim().length()==0)
		{
			return "redirect:/board/writeform";
		}
		Long noStr = authUser.getNo();
		String no = noStr.toString();
		vo.setMemberNo(no);
		boardService.insert(vo);
		
		LOG.debug("#BoardController(write) - debug log" );
		LOG.info("#BoardController(write) - info log" );
		LOG.warn("#BoardController(write) - warn log" );
		LOG.error("#BoardController(write) - error log" );
		
		return "redirect:/board/listform";
	}

	@Auth
	@RequestMapping("/delete")
	public String delete(@AuthUser UserVo authUser, @ModelAttribute BoardVo vo){
		Long noStr = vo.getNo();
		String no = noStr.toString();
		Long memberNoStr = authUser.getNo();
		String memberNo = memberNoStr.toString();
		System.out.println(no);
		vo.setMemberNo(memberNo);
		boardService.delete(vo);
		
		LOG.debug("#BoardController(delete) - debug log" );
		LOG.info("#BoardController(delete) - info log" );
		LOG.warn("#BoardController(delete) - warn log" );
		LOG.error("#BoardController(delete) - error log" );
		
		return "redirect:/board/listform";
	}
	
	@RequestMapping("/viewform")
	public String viewform(HttpSession session, @ModelAttribute BoardVo vo){
		Long noStr = vo.getNo();
		String no = noStr.toString();
		vo.setMemberNo(no);
		BoardVo v = boardService.view(vo);
		session.setAttribute("v", v);
		
		LOG.debug("#BoardController(viewform) - debug log" );
		LOG.info("#BoardController(viewform) - info log" );
		LOG.warn("#BoardController(viewform) - warn log" );
		LOG.error("#BoardController(viewform) - error log" );
		
		return "/board/viewform";
	}
	
	@Auth
	@RequestMapping("/modifyform")
	public String modifyform(){
		LOG.debug("#BoardController(modifyform) - debug log" );
		LOG.info("#BoardController(modifyform) - info log" );
		LOG.warn("#BoardController(modifyform) - warn log" );
		LOG.error("#BoardController(modifyform) - error log" );
		
		return "/board/modifyform";
	}
	
	@Auth
	@RequestMapping("/modify")
	public String modify(@ModelAttribute BoardVo vo){
		vo.setTitle(vo.getTitle());
		vo.setContent(vo.getContent());
		vo.setNo(vo.getNo());
		boardService.modify(vo);
		
		LOG.debug("#BoardController(modify) - debug log" );
		LOG.info("#BoardController(modify) - info log" );
		LOG.warn("#BoardController(modify) - warn log" );
		LOG.error("#BoardController(modify) - error log" );
		
		return "redirect:/board/listform";
	}
	
}
