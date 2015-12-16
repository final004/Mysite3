package com.hanains.mysite.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> getList() {
		List<BoardVo> list = sqlSession.selectList("board.list");
		return list;
	}

	public BoardVo view(BoardVo vo) {
		BoardVo v = sqlSession.selectOne("board.view", vo);
		sqlSession.update("viewCnt", vo);
		return v;
	}

	public void insert(BoardVo vo) {
		sqlSession.insert("board.insert", vo);	
	}

	public void delete(BoardVo vo) {
		sqlSession.delete("board.delete", vo);	
	}

	public void modify(BoardVo vo) {
		sqlSession.update("board.modify", vo);	
	}
}