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
		
		
		//store 이동 요청 처리
		@RequestMapping(value = "/store/store-li", method = RequestMethod.POST)
		public String store() {
		      
		   return "store/store-li";
		   }
	
}