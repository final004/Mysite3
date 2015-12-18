package com.hanains.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import com.hanains.mysite.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestbookVo> list(){
	
		List<GuestbookVo> guestbookVo = sqlSession.selectList("guestbook.list");

		return guestbookVo;
	}
	
	public void insert(GuestbookVo vo){
		sqlSession.insert("guestbook.insert", vo);
	}
	
	public void delete(GuestbookVo vo){
		sqlSession.delete("guestbook.delete", vo);	
	}
}
