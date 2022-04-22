package com.test.one.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.Vo.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	 @Autowired
	 private SqlSession session;

	@Override
	public MemberDto getData(String CUST_ID) {
		// TODO Auto-generated method stub
		return session.selectOne("member.getData", CUST_ID);
		}


	@Override
	public MemberDto getData2(String CUST_EMAIL, String CUST_EMAIL2) {
		// TODO Auto-generated method stub
		return session.selectOne("member.getData", CUST_EMAIL);
		}

	@Override
	public List<MemberDto> getData3(MemberDto dto) {
		// TODO Auto-generated method stub
		return session.selectList("member.getData", dto);
		}



	@Override
	public boolean loginCheck(MemberDto dto) {
		String name = session.selectOne("member.loginCheck",dto);
		// 검색이 안되면 0을 반환해주기 때문에 0과 비교해서 참이면 false, 틀리면 true를 반환
		return (Integer.parseInt(name)==0)?false:true;
		}

	@Override
	public String FindId(String CUST_PHNO) {
		// TODO Auto-generated method stub
		return session.selectOne("member.findId", CUST_PHNO);
		
	}

	@Override
	public int FindPw(MemberDto dto) {
		return session.update("member.findPw", dto);
	}


	/*
	 * @Override public String sumEmail(MemberDto dto) { System.out.println("dao :"+
	 * dto.getEmail()); return session.selectOne("member.sumEmail", dto); }
	 */



}


