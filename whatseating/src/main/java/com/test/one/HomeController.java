package com.test.one;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.one.Member.Dto.MemberDto;
import com.test.one.Member.Service.MemberService;

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
		
		
		//store 이동 요청 처리
		@RequestMapping(value = "/store/test", method = RequestMethod.POST)
		public String store() {
		      
		   return "store/test";
		   }
	


}