package com.test.one.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.one.Repository.AccountDAO;
import com.test.one.Repository.MemberDao;
import com.test.one.Vo.AccountDto;
import com.test.one.mail.SendMail;

@Service("service")
public class AccountSVC {
	
	 @Autowired
	   private AccountDAO accountDAO;
	 @Autowired
	   private SendMail mail;
	 
	 
	   public void loginProcess(AccountDto dto, HttpSession session) {
		   //입력한 정보가 맞는여부
	      boolean isValid=false;
	      String pwd=dto.getCUST_PW();
	      AccountDto result=accountDAO.getData(dto.getCUST_ID());
	      if(result != null) {//만일 존재하는 아이디 라면
	         //비밀번호가 일치하는지 확인한다.
	         String inputPwd2=result.getCUST_PW();//DB 에 저장된 비밀번호 
	         String inputPwd=dto.getCUST_PW();//로그인폼에 입력한 비밀번호
	         System.out.println("inputPwd2" + inputPwd2);
	         //Bcrypt 클래스의 static 메소드를 이용해서 일치 여부를 얻어낸다.
	         isValid=true;
	      }
	      
	      if(isValid) {//만일 유효한 정보이면 
	         //로그인 처리를 한다.
	         session.setAttribute("id", dto.getCUST_ID());
	      }
	   }

	
	public boolean loginCheck(AccountDto dto, HttpSession session) {		
			boolean result = accountDAO.loginCheck(dto);
			if (result == true) {	//true 일경우 세션 등록
				//세션 변수 등록
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
			out.println("alert('가입된 아이디가 없습니다.');");
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
			out.println("alert('가입된 아이디가 없습니다.')");
			out.println("</script>");
			out.close();	
		}else if(!dto.getCUST_EMAIL().equals(accountDAO.getData(dto.getCUST_ID()).getCUST_EMAIL()))
		{
			out.println("<script>");
			out.println("alert('가입된 이메일이 없습니다.');");
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
			 out.println("alert('임시 비밀번호를 발송했습니다.'); location.href='http://localhost:8080/home.do';</script>");
			 out.println("</script>");
			 out.flush();
			 
			
		}
		
	}

}

