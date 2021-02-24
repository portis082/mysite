package com.bit2021.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2021.mysite.exception.UserRepositoryException;
import com.bit2021.mysite.vo.UserVo;

@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;

	public boolean save(UserVo vo){
		int count = sqlSession.insert("user.save", vo);
		return count == 1;
	}
	
	public UserVo findByEmailAndPassword(UserVo vo) {
		return sqlSession.selectOne("user.findByEmailAndPassword", vo);
	}
	
	public UserVo findByNo(Long no) throws UserRepositoryException {
		return sqlSession.selectOne("user.findByNo", no);
	}

	public boolean update(UserVo vo) {
		int count = sqlSession.insert("user.update", vo);
		return count == 1;
	}

	public Object findByEmail(String email) {
		return sqlSession.selectOne("user.findByEmail", email);
	}
}
