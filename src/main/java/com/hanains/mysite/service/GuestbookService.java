package com.hanains.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.mysite.dao.GuestbookDao;
import com.hanains.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> list(){
		System.out.println("데이터 목록");
		List<GuestbookVo> guestbookVo = guestbookDao.list();
		return guestbookVo;
	}
	
	public void insert(GuestbookVo vo){
		System.out.println("데이터 삽입");
		guestbookDao.insert(vo);
	}
	
	public void delete(GuestbookVo vo){
		System.out.println("데이터 삭제");
		guestbookDao.delete(vo);
	}
}
