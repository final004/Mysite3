package com.hanains.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hanains.mysite.dao.UserDao;
import com.hanains.mysite.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void join(UserVo vo){
		System.out.println("회원 가입");
		userDao.insert(vo);
	}
	
	public UserVo login(UserVo vo){
		System.out.println("로그인");
		UserVo authUser = userDao.get(vo);
		return authUser;
	}

	public UserVo getUser(String email) {
		System.out.println("회원 리스트 - email");
		UserVo vo = userDao.getUser(email);
		return vo;
	}
}
