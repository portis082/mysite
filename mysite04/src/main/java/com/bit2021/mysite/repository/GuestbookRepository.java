package com.bit2021.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2021.mysite.vo.GuestbookVo;

@Repository
public class GuestbookRepository {
	@Autowired
	private SqlSession sqlSession;

	public boolean delete(GuestbookVo guestbookVo) {
		int count = sqlSession.delete("guestbook.delete", guestbookVo);
		return count == 1;
	}
	
	public List<GuestbookVo> findAll() {
		return sqlSession.selectList("guestbook.findAll");
	}

	public boolean insert(GuestbookVo guestbookVo) {
		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		return count == 1;
	}
}
