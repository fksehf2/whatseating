package com.test.one.Member.Controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.test.one.Member.Dto.MemberDto;
import com.test.one.Member.Service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	//로그인 처리 
	/*
	 * @RequestMapping("/login") public ModelAndView login(ModelAndView mView,
	 * MemberDto dto,
	 * 
	 * @RequestParam String url, HttpSession session) {
	 * 
	 * service.loginProcess(dto, session);
	 * 
	 * String encodedUrl=URLEncoder.encode(url); mView.addObject("url", url);
	 * mView.addObject("encodedUrl", encodedUrl);
	 * 
	 * mView.setViewName("login"); return mView; }
	 */
	
	
    //ajax 로그인 처리 
	@RequestMapping("/ajaxlogin")
	public String loginCheck(MemberDto dto,HttpSession session) {
		
		boolean result = service.loginCheck(dto, session);
		System.out.println("id" +"--------"+ session.getAttribute("id"));
		if(result) {
			System.out.println("status" +"--------"+ dto.getCUST_STATUS());
			System.out.println("id2"  +"--------"+ dto.getCUST_ID());
			System.out.println("pw" +"--------"+ dto.getCUST_PW());
		}else {	
		}
		
		return "ajaxlogin";
	}
 
    //로그아웃 처리 
    @RequestMapping(value="logout.do", method=RequestMethod.POST)
    @ResponseBody
    public void logout(HttpSession session) {
       //세션에서 id 라는 키값으로 저장된 값 삭제 
       session.removeAttribute("id");
       System.out.println("???");
    }
    


}
