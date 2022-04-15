package com.test.one.Member.Service;

import javax.servlet.http.HttpSession;

import com.test.one.Member.Dto.MemberDto;

public interface MemberService {
	public void loginProcess(MemberDto dto, HttpSession session); //로그인 처리 
	public boolean loginCheck(MemberDto dto,HttpSession session); //ajax로그인

}
