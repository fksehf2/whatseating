package com.test.one.Repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.Vo.AccountDTO;

@Repository("accountDAO")
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public AccountDTO userInfo(String cust_id) {
		AccountDTO accountDTO = sqlSession.selectOne("mappers.userMapper.userInfo",cust_id);
		return accountDTO;
	}
	
	public int userRegister(AccountDTO accountDTO) {
		int insertResult = sqlSession.insert("mappers.userMapper.userRegister", accountDTO);
		return insertResult;
	}
	
	public int userDelete(String CUST_ID) {
		int deleteResult = sqlSession.delete("mappers.userMapper.userDelete",CUST_ID);
		return deleteResult;
	}
	
	public int userUpdate(String CUST_ID) {
		int updateResult = sqlSession.update( "mappers.userMapper.userModify", CUST_ID);
		return updateResult;
	}
	
	//아이디 체크
	public int userIdCheck(String CUST_ID) {
		int idCheck = sqlSession.selectOne("mappers.userMapper.userIdCheck",CUST_ID);
		return idCheck;
	}

}
