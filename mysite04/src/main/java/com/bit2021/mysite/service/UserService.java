package com.bit2021.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2021.mysite.repository.UserRepository;
import com.bit2021.mysite.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public boolean join(UserVo userVo) {
		return userRepository.save(userVo);
	}

	public UserVo getUser(UserVo vo) {
		return userRepository.findByEmailAndPassword(vo);
	}

	public UserVo getUser(Long no) {
		return userRepository.findByNo(no);
	}

	public boolean updateUser(UserVo userVo) {
		return userRepository.update(userVo);
	}
}
