package com.test.one.Repository;

import java.util.List;

import com.test.one.Vo.MemberDto;

public interface MemberDao {

	public MemberDto getData(String CUST_ID); //아이디 체크 
	public MemberDto getData2(String CUST_EMAIL, String CUST_EMAIL2); //이메일 체크 
	public boolean loginCheck(MemberDto dto); //아이디&비밀번호 확인 
	public String FindId(String CUST_PHNO); //아이디 찾기 
	public int FindPw(MemberDto dto); // 비밀번호 찾기 
	//public MemberDto sumEmail(MemberDto dto);
	public List<MemberDto> getData3(MemberDto dto);

}
