package com.test.one;

import java.io.IOException;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.one.Service.AccountSVC;
import com.test.one.Vo.AccountDto;

@Controller
public class AccountController {
	
	@Autowired
	AccountSVC service;
	
    //ajax 濡쒓렇�씤 泥섎━ 
//	@RequestMapping("/ajaxlogin")
//	public String loginCheck(AccountDto dto,HttpSession session) {
//		
//		boolean result = service.loginCheck(dto, session);
//		System.out.println("id" +"--------"+ session.getAttribute("id"));
//		if(result) {
//			System.out.println("status" +"--------"+ dto.getCUST_STATUS());
//			System.out.println("id2"  +"--------"+ dto.getCUST_ID());
//			System.out.println("pw" +"--------"+ dto.getCUST_PW());
//			
//		}else {	
//		}
//		
//		return "ajaxlogin";
//	}
 
    //濡쒓렇�븘�썐 泥섎━ 
    @RequestMapping(value="logout.do", method=RequestMethod.POST)
    @ResponseBody
    public void logout(HttpSession session){
        //�꽭�뀡�뿉�꽌 id �씪�뒗 �궎媛믪쑝濡� ���옣�맂 媛� �궘�젣 
        session.removeAttribute("id");
        //System.out.println("???");
    }
    
    //�븘�씠�뵒&鍮꾨�踰덊샇 李얘린 �뤌
    @RequestMapping("/find_id_pw")
	public String IdCheckform() {
    	return "find_id_pw";
	}
    
    //�븘�씠�뵒 李얘린 
//    @RequestMapping(value="/IdCheck", method=RequestMethod.POST)
//    @ResponseBody
//	public String IdCheck(HttpServletResponse response, @RequestParam("CUST_PHNO") String CUST_PHNO, Model m) throws Exception{
//    	
//		m.addAttribute("id", service.IdCheck(response, CUST_PHNO));
//		return "IdCheck";
//	}
//    
//    //鍮꾨�踰덊샇 李얘린 
//    @RequestMapping(value="/PwChange", method=RequestMethod.POST)
//    @ResponseBody
//    public void PwChange(HttpServletResponse response, @ModelAttribute AccountDto dto) throws IOException {
//    	service.PwChange(response, dto);
// 
//    }
}

