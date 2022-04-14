package com.test.one.Member.Service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.one.Member.Dao.MemberDao;
import com.test.one.Member.Dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	 @Autowired
	   private MemberDao dao;
	 
	 @Override
	   public void loginProcess(MemberDto dto, HttpSession session) {
		   //입력한 정보가 맞는여부
	      boolean isValid=false;
	      String pwd=dto.getPw(); 
	      MemberDto result=dao.getData2(dto.getId());
	      if(result != null) {//만일 존재하는 아이디 라면
	         //비밀번호가 일치하는지 확인한다.
	         String inputPwd2=result.getPw(); //DB 에 저장된 비밀번호 
	         String inputPwd=dto.getPw(); //로그인폼에 입력한 비밀번호
	         System.out.println("inputPwd2" + inputPwd2);
	         //Bcrypt 클래스의 static 메소드를 이용해서 일치 여부를 얻어낸다.
	         isValid=true;
	      }
	      
	      if(isValid) {//만일 유효한 정보이면 
	         //로그인 처리를 한다.
	         session.setAttribute("id", dto.getId());
	      }
	   }

	@Override
	public boolean loginCheck(MemberDto dto, HttpSession session) {		
			boolean result = dao.loginCheck(dto);
			if (result == true) {	//true 일경우 세션 등록
				//세션 변수 등록
				session.setAttribute("id", dto.getId());
				session.setAttribute("status", dto.getStatus());
			}		
			return result;
		}
	}

	
