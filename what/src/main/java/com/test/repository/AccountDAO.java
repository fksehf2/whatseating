package com.test.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.vo.AccountDTO;

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
	
	//세션 값 체크
	public boolean loginCheck(MemberDto dto) {
	      String name = session.selectOne("member.loginCheck",dto);
	      // 검색이 안되면 0을 반환해주기 때문에 0과 비교해서 참이면 false, 틀리면 true를 반환
	      return (Integer.parseInt(name)==0)?false:true;
	      }
	
	

}
