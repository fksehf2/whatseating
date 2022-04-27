package com.test.one.Repository;


import java.util.Map;

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
	
	public boolean loginCheck(AccountDto dto) {
		String name = session.selectOne("member.loginCheck",dto);
		// 검색이 안되면 0을 반환해주기 때문에 0과 비교해서 참이면 false, 틀리면 true를 반환
		return (Integer.parseInt(name)==0)?false:true;
		}
	public AccountDto login(Map<String,Object> map) {
		return session.selectOne("member.loginCheck", map);
	}
	public String FindId(String CUST_PHNO) {
		// TODO Auto-generated method stub
		return session.selectOne("member.findId", CUST_PHNO);
	}
	
	public int FindPw(AccountDto dto) {
		return session.update("member.findPw", dto);
	}
	
	public AccountDto userInfo(String cust_id) {
		AccountDto accountDTO = session.selectOne("mappers.userMapper.userInfo",cust_id);
		return accountDTO;
	}
	
	public int userRegister(AccountDto accountDTO) {
		int insertResult = session.insert("mappers.userMapper.userRegister", accountDTO);
		return insertResult;
	}
	
	public int userDelete(String CUST_ID) {
		int deleteResult = session.delete("mappers.userMapper.userDelete",CUST_ID);
		return deleteResult;
	}
	
	public int userUpdate(String CUST_ID) {
		int updateResult = session.update( "mappers.userMapper.userModify", CUST_ID);
		return updateResult;
	}
	
	//아이디 체크
	public int userIdCheck(String CUST_ID) {
		int idCheck = session.selectOne("mappers.userMapper.userIdCheck",CUST_ID);
		return idCheck;
	}




}

