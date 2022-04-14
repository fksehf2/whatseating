package com.test.one.Member.Dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.Member.Dto.MemberDto;

@Repository
public class MemberDaoImpl  implements MemberDao{
	
	 @Autowired
	 private SqlSession session;

	@Override
	public MemberDto getData2(String id) {
		
		 return session.selectOne("member.getData2", id);
	}

	@Override
	public boolean loginCheck(MemberDto dto) {
		String name = session.selectOne("member.loginCheck",dto);
		// 검색이 안되면 0을 반환해주기 때문에 0과 비교해서 참이면 false, 틀리면 true를 반환
		return (Integer.parseInt(name)==0)?false:true;
		}
	}


