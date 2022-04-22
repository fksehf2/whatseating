package com.test.one.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.one.Repository.AccountDAO;
import com.test.one.Vo.AccountDto;
import com.test.one.mail.SendMail;

@Service("service")
public class AccountSVC {
	
	 @Autowired
	   private AccountDAO accountDAO;
	 @Autowired
	   private SendMail mail;
	 
	 
	   public void loginProcess(AccountDto dto, HttpSession session) {
		   //�엯�젰�븳 �젙蹂닿� 留욌뒗�뿬遺�
	      boolean isValid=false;
	      String pwd=dto.getCUST_PW();
	      AccountDto result=accountDAO.getData(dto.getCUST_ID());
	      if(result != null) {//留뚯씪 議댁옱�븯�뒗 �븘�씠�뵒 �씪硫�
	         //鍮꾨�踰덊샇媛� �씪移섑븯�뒗吏� �솗�씤�븳�떎.
	         String inputPwd2=result.getCUST_PW();//DB �뿉 ���옣�맂 鍮꾨�踰덊샇 
	         String inputPwd=dto.getCUST_PW();//濡쒓렇�씤�뤌�뿉 �엯�젰�븳 鍮꾨�踰덊샇
	         System.out.println("inputPwd2" + inputPwd2);
	         //Bcrypt �겢�옒�뒪�쓽 static 硫붿냼�뱶瑜� �씠�슜�빐�꽌 �씪移� �뿬遺�瑜� �뼸�뼱�궦�떎.
	         isValid=true;
	      }
	      
	      if(isValid) {//留뚯씪 �쑀�슚�븳 �젙蹂댁씠硫� 
	         //濡쒓렇�씤 泥섎━瑜� �븳�떎.
	         session.setAttribute("id", dto.getCUST_ID());
	      }
	   }

	
	public boolean loginCheck(AccountDto dto, HttpSession session) {		
			boolean result = accountDAO.loginCheck(dto);
			if (result == true) {	//true �씪寃쎌슦 �꽭�뀡 �벑濡�
				//�꽭�뀡 蹂��닔 �벑濡�
				session.setAttribute("id", dto.getCUST_ID());
				session.setAttribute("status", dto.getCUST_STATUS());
			}		
			return result;
		}

	
	public String IdCheck(HttpServletResponse response, String CUST_PHNO) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id=accountDAO.FindId(CUST_PHNO);
		if(id == null) {
			out.println("<script>");
			out.println("alert('媛��엯�맂 �븘�씠�뵒媛� �뾾�뒿�땲�떎.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		}else {
			return id;
		}
	}

	
	public void PwChange(HttpServletResponse response, AccountDto dto) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("id" +"--------"+ dto.getCUST_ID());
		String email1=dto.getCUST_EMAIL()+dto.getCUST_EMAIL2();
		System.out.println("email" +"--------"+ email1);
		if(accountDAO.getData(dto.getCUST_ID()) == null) {
			out.println("<script>");
			out.println("alert('媛��엯�맂 �븘�씠�뵒媛� �뾾�뒿�땲�떎.')");
			out.println("</script>");
			out.close();	
		}else if(!dto.getCUST_EMAIL().equals(accountDAO.getData(dto.getCUST_ID()).getCUST_EMAIL()))
		{
			out.println("<script>");
			out.println("alert('媛��엯�맂 �씠硫붿씪�씠 �뾾�뒿�땲�떎.');");
			out.println("</script>");
			out.close();	
			
		}else {
			String pw = "";
			for (int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			
			dto.setCUST_PW(pw); 
			System.out.println("newpw" +"--------"+ dto.getCUST_PW());
			System.out.println("email" +"--------"+ dto.getEmail());
			accountDAO.FindPw(dto);
			mail.Sendpw(dto);
			
			
			 out.println("<script>");
			 out.println("alert('�엫�떆 鍮꾨�踰덊샇瑜� 諛쒖넚�뻽�뒿�땲�떎.'); location.href='http://localhost:8080/home.do';</script>");
			 out.println("</script>");
			 out.flush();
			 
			
		}
		
	}
	
	public AccountDto userInfo(String cust_id) {
		AccountDto accountDTO = accountDAO.userInfo(cust_id);
		return accountDTO;
	}
	
	public int userRegister(AccountDto accountDTO) {
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

