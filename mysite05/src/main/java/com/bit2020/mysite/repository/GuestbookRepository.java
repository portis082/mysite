package com.bit2020.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2020.mysite.vo.GuestbookVo;

@Repository
public class GuestbookRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestbookVo> findAll() {
		return sqlSession.selectList("guestbook.findAll");
	}	
	
	public int delete( GuestbookVo vo ) {
		return sqlSession.delete( "guestbook.delete", vo );
	}
	
	public int save( GuestbookVo vo ) {
		return sqlSession.insert( "guestbook.save", vo );
	}
}