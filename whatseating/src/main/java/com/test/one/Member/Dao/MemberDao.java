package com.test.one.Member.Dao;

import com.test.one.Member.Dto.MemberDto;

public interface MemberDao {

	public MemberDto getData2(String CUST_ID);
	public boolean loginCheck(MemberDto dto);


}
