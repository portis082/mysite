package com.bit2021.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2021.mysite.repository.GuestbookRepository;
import com.bit2021.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	@Autowired
	GuestbookRepository guestbookRepository;

	public List<GuestbookVo> getMessageList() {
		return guestbookRepository.findAll();
	}

	public boolean writeMessage(GuestbookVo guestbookVo) {
		return guestbookRepository.insert(guestbookVo);
	}

	public boolean deleteMessage(GuestbookVo guestbookVo) {
		return guestbookRepository.delete(guestbookVo);
	}
}
