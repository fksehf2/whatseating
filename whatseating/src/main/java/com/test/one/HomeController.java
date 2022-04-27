package com.test.one;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
		//home 이동 요청
		@RequestMapping({"/","/home"}) 
		public String home() { 
		 return "home"; 
		}
		
		//로그인 폼 이동 요청
		@RequestMapping("/user/loginform") 
		public String loginform() { 
		 return "/user/loginform"; 
		}
	
		
		
		//store 이동 요청 처리
		@RequestMapping(value = "/store/test", method = RequestMethod.POST)
		public String store() {
		      
		   return "store/test";
		   }
		
			/*
			 * //아이디&비밀번호 찾기 페이지 이동 요청 처리
			 * 
			 * @RequestMapping(value = "account/find_id_pw", method = RequestMethod.GET)
			 * public String Find() {
			 * 
			 * return "find_id_pw"; }
			 */


}