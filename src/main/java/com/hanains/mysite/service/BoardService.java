package com.hanains.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;

@Service
public class BoardService {

	private final int LIST_PAGESIZE = 5; 
	private final int LIST_BLOCKSIZE = 5; 

	@Autowired
	private BoardDao boardDao;

	public Map<String, Object> listBoard(List<BoardVo> listCnt, Long page){

		int totalPageCnt = listCnt.size();
		long pageCount = (long)Math.ceil( (double)totalPageCnt / LIST_PAGESIZE );
		long blockCount = (long)Math.ceil( (double)pageCount / LIST_BLOCKSIZE );
		long currentBlock = (long)Math.ceil( (double)page / LIST_BLOCKSIZE ); 
		
		if( page < 1 ) {
			page = 1L;
			currentBlock = 1;
		} else if( page > pageCount ) {
			page = pageCount;
			currentBlock = (int)Math.ceil( (double)page / LIST_BLOCKSIZE );
		}
		
		long startPage = (currentBlock == 0 ) ? 1 : ( currentBlock - 1 ) * LIST_BLOCKSIZE + 1;
		long endPage = ( startPage - 1 ) + LIST_BLOCKSIZE;
		long prevPage = ( currentBlock > 1 ) ? ( currentBlock - 1 ) * LIST_BLOCKSIZE : 0;
		long nextPage = ( currentBlock < blockCount ) ? currentBlock * LIST_BLOCKSIZE + 1 : 0;

		List<BoardVo> list = boardDao.getList(page, LIST_PAGESIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "list", list );
		map.put( "firstItemIndex", totalPageCnt - ( page - 1 ) * LIST_PAGESIZE );
		map.put( "currentPage", page );
		map.put( "startPage", startPage );
		map.put( "endPage", endPage );
		map.put( "pageCount", pageCount );
		map.put( "prevPage", prevPage );
		map.put( "nextPage", nextPage );
		
		return map;
	}

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
