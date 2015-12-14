package com.hanains.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> list(){
		System.out.println("데이터 목록");
		List<BoardVo> list = boardDao.getList();
		return list;
	}
	
	public void insert(BoardVo vo){
		System.out.println("데이터 삽입");
		boardDao.insert(vo);
	}
	
	public void delete(BoardVo vo){
		System.out.println("데이터 삭제");
		boardDao.delete(vo);
	}
	
	public void modify(BoardVo vo){
		System.out.println("데이터 수정");
		boardDao.modify(vo);
	}
	
	public BoardVo view(BoardVo vo){
		System.out.println("데이터 보기");
		BoardVo v = boardDao.view(vo);
		return v;
	}
}
