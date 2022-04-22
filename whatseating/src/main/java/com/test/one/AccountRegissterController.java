package com.test.one;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.one.Service.AccountSVC;
import com.test.one.Vo.AccountDto;

@Controller
@RequestMapping("/customer/")
public class AccountRegissterController {
	
	@Autowired
	private AccountSVC accountSVC;
	
	//회원가입 확인 페이지
	@RequestMapping(value = "confirm")
	public String userInfo(HttpServletRequest request ,Model model) {
		
		String CUST_ID = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("CUST_ID") != null) {
			CUST_ID = (String) session.getAttribute("CUST_ID");
		}
		
    	AccountDto accountDTO = accountSVC.userInfo(CUST_ID);
		model.addAttribute("accountDTO", accountDTO);
		
		return "accountConfirm";
	}
	
	//회원가입 양식 페이지
	@RequestMapping(value = "registerForm")
	public String userRegisterForm() {
		
		return "userRegisterForm";
	}
	
	//회원 등록이 되면 회원 상세 보기 페이지로, 등록이 되지 않으면 양식 페이지로 보냄
	@RequestMapping(value = "userRegister")
	public String userRegister(@ModelAttribute AccountDto accountDTO, HttpServletResponse response) throws Exception {
		
		int insertResult = accountSVC.userRegister(accountDTO);
		if(insertResult == 1) {
			System.out.println("insert 성공");
			return "userDetail";
		} else {
			System.out.println("insert 실패");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입이 되지 않았습니다.');");
			out.println("</script>");
			return "registerForm";
		}
		
	}
	
	//회원 상세 페이지
	@RequestMapping(value = "userDetail")
	public String userDetail(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String CUST_ID = null;
		if(session.getAttribute("CUST_ID") != null) {
			CUST_ID = (String) session.getAttribute("CUST_ID");
		}
		AccountDto accountDTO = accountSVC.userInfo(CUST_ID);
		model.addAttribute("accountDTO", accountDTO);
		
		return "userDetail";
	}
	
	//회원 삭제 //페이지 이동 설정 필요
	@RequestMapping(value = "userDelete")
	public String userDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String CUST_ID = null;
		if(session.getAttribute("CUST_ID") != null) {
			CUST_ID = (String) session.getAttribute("CUST_ID");
		}
		int deleteResult = accountSVC.userDelete(CUST_ID);
		if(deleteResult == 1) {
			System.out.println("delete 성공");
			return "인덱스 or 로그인 페이지";
		} else {
			System.out.println("delete 실패");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원 삭제가 되지 않았습니다.');");
			out.println("</script>");
			return "전으로";
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "userModify")
	public String userModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String CUST_ID = null;
		if(session.getAttribute("CUST_ID") != null) {
			CUST_ID = (String) session.getAttribute("CUST_ID");
		}
		int updateResult = accountSVC.userUpdate(CUST_ID);
		if(updateResult == 1) {
			System.out.println("userUpdate 성공");
			return "1";
		} else {
			System.out.println("userUpdate 실패");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원 삭제가 되지 않았습니다.');");
			out.println("</script>");
			return "0";
		}

	}
	
	//id중복체크
	@ResponseBody
	@RequestMapping("iddbCheck")
	public Map<String, Integer> userIddbCheck(@RequestParam("id") String CUST_ID){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int idCheck = accountSVC.userIdCheck(CUST_ID);
		map.put("idCheck", idCheck);
		
		return map;
	}
	
	

}
