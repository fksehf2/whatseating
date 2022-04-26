package com.test.one.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.Vo.AccountDto;
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
		// 寃��깋�씠 �븞�릺硫� 0�쓣 諛섑솚�빐二쇨린 �븣臾몄뿉 0怨� 鍮꾧탳�빐�꽌 李몄씠硫� false, ��由щ㈃ true瑜� 諛섑솚
		return (Integer.parseInt(name)==0)?false:true;
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
	
	public int userUpdate(AccountDto accountDTO) {
		int updateResult = session.update( "mappers.userMapper.userModify", accountDTO);
		return updateResult;
	}
	
	//아이디 체크
	public int userIdCheck(String CUST_ID) {
		int idCheck = session.selectOne("mappers.userMapper.userIdCheck",CUST_ID);
		return idCheck;
	}
	
	//아이디 더블 체크
	public int iddbCheck(String CUST_ID) {
		int iddbCheck = session.selectOne("mappers.userMapper.iddbCheck",CUST_ID);
		return iddbCheck;
	}
	
	//로그인
	public String login(String CUST_ID) {
		String login = session.selectOne("mappers.userMapper.login",CUST_ID);
		return login;
	}
	
	//회원 서비스 체크
	public String typeCheck(String CUST_ID) {
		String typeCheck = session.selectOne("mappers.userMapper.typeCheck",CUST_ID);
		return typeCheck;
	}




}

