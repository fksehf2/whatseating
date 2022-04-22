package com.test.one.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.one.Repository.AccountDAO;
import com.test.one.Vo.AccountDTO;

@Service("accountSVC")
public class AccountSVC {

	@Autowired
	private AccountDAO accountDAO;
	
	public AccountDTO userInfo(String cust_id) {
		AccountDTO accountDTO = accountDAO.userInfo(cust_id);
		return accountDTO;
	}
	
	public int userRegister(AccountDTO accountDTO) {
		int insertResult = accountDAO.userRegister(accountDTO);
		return insertResult;
	}
	
	public int userDelete(String CUST_ID) {
		int deleteResult = accountDAO.userDelete(CUST_ID);
		return deleteResult;
	}
	
	public int userUpdate(String CUST_ID) {
		int updateResult = accountDAO.userUpdate(CUST_ID);
		return updateResult;
	}
	
	//아이디체크
	public int userIdCheck(String CUST_ID) {
		int idCheck = accountDAO.userIdCheck(CUST_ID);
		return idCheck;
	}
}
