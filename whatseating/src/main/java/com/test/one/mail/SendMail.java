package com.test.one.mail;

import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.one.Vo.AccountDto;

@Service("mail")
public class SendMail{

	public void Sendpw(AccountDto dto){
		SendpwService(dto);
		
	}
	
	private void SendpwService(AccountDto dto) {
		SimpleEmail mail = new SimpleEmail();
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");
	
		mail.setAuthentication("fksehfs@naver.com", "zjvlwhdk12@");
		mail.setSSLOnConnect(true);
		try {
		mail.setFrom("fksehfs@naver.com", "관리자");
		String mail2=dto.getCUST_EMAIL()+dto.getCUST_EMAIL2();
		System.out.println("앞"+dto.getCUST_EMAIL());
		System.out.println("뒤"+dto.getCUST_EMAIL2());
		System.out.println(dto.getCUST_EMAIL()+dto.getCUST_EMAIL2());
		System.out.println(mail2);
		mail.addTo(mail2, dto.getCUST_ID()); 

		mail.setSubject("오늘 뭐먹지? 임시 비밀번호입니다."); //메일 제목
		StringBuilder msg= new StringBuilder();
		msg.append(dto.getCUST_ID() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.");
		msg.append("임시 비밀번호는" + dto.getCUST_PW());
		msg.append("입니다. ");
		mail.setMsg(msg.toString());
		
		mail.send(); //메일 발송 
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}

	
	
	
}
}
	
	
