package com.test.one.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.Vo.AccountDto;

@Repository("accountDAO")
public class AccountDAO {
	
	 @Autowired
	 private SqlSession session;

	
	public AccountDto getData(String CUST_ID) {
		// TODO Auto-generated method stub
		return session.selectOne("member.getData", CUST_ID);
		}


	
	public AccountDto getData2(String CUST_EMAIL, String CUST_EMAIL2) {
		// TODO Auto-generated method stub
		return session.selectOne("member.getData", CUST_EMAIL);
		}

	
	public List<AccountDto> getData3(AccountDto dto) {
		// TODO Auto-generated method stub
		return session.selectList("member.getData", dto);
		}



	
	public boolean loginCheck(AccountDto dto) {
		String name = session.selectOne("member.loginCheck",dto);
		// 검색이 안되면 0을 반환해주기 때문에 0과 비교해서 참이면 false, 틀리면 true를 반환
		return (Integer.parseInt(name)==0)?false:true;
		}

	
	public String FindId(String CUST_PHNO) {
		// TODO Auto-generated method stub
		return session.selectOne("member.findId", CUST_PHNO);
		
	}

	
	public int FindPw(AccountDto dto) {
		return session.update("member.findPw", dto);
	}




}

