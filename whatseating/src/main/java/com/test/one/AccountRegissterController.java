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
	
	//ȸ������ Ȯ�� ������
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
	
	//ȸ������ ��� ������
	@RequestMapping(value = "registerForm")
	public String userRegisterForm() {
		
		return "userRegisterForm";
	}
	
	//ȸ�� ����� �Ǹ� ȸ�� �� ���� ��������, ����� ���� ������ ��� �������� ����
	@RequestMapping(value = "userRegister")
	public String userRegister(@ModelAttribute AccountDto accountDTO, HttpServletResponse response) throws Exception {
		
		int insertResult = accountSVC.userRegister(accountDTO);
		if(insertResult == 1) {
			System.out.println("insert ����");
			return "userDetail";
		} else {
			System.out.println("insert ����");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('ȸ�������� ���� �ʾҽ��ϴ�.');");
			out.println("</script>");
			return "registerForm";
		}
		
	}
	
	/*
	 * //id 중복 확인
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "iddbCheck") public String
	 * iddbCheck(@RequestParam("id") String CUST_ID) throws Exception {
	 * 
	 * int iddbCheck = accountSVC.iddbCheck(CUST_ID); return iddbCheck+"";
	 * 
	 * }
	 */
	
	
	//유저 정보
	@ResponseBody
	@RequestMapping(value = "userDetail")
	public Map<String, Object> userDetail(@RequestParam("id") String CUST_ID) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		AccountDto accountDTO = accountSVC.userInfo(CUST_ID);
		
		map.put("accountDTO", accountDTO);
		
		return map;
	}
	
	//ȸ�� ���� //������ �̵� ���� �ʿ�
	@RequestMapping(value = "userDelete")
	public String userDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String CUST_ID = null;
		if(session.getAttribute("CUST_ID") != null) {
			CUST_ID = (String) session.getAttribute("CUST_ID");
		}
		int deleteResult = accountSVC.userDelete(CUST_ID);
		if(deleteResult == 1) {
			System.out.println("delete ����");
			return "�ε��� or �α��� ������";
		} else {
			System.out.println("delete ����");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('ȸ�� ������ ���� �ʾҽ��ϴ�.');");
			out.println("</script>");
			return "������";
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "userModify")
	public Map<String, Object> userModify(@ModelAttribute AccountDto accountDTO) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int updateResult = accountSVC.userUpdate(accountDTO);
		
		map.put("modifyResult", updateResult);
		
		return map;
	}
	
	//id�ߺ�üũ
	@ResponseBody
	@RequestMapping("iddbCheck")
	public Map<String, Integer> userIddbCheck(@RequestParam("id") String CUST_ID){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int idCheck = accountSVC.userIdCheck(CUST_ID);
		map.put("idCheck", idCheck);
		
		return map;
	}
	
	//로그인 기능
	@ResponseBody
	@RequestMapping("login")
	public Map<String, Object> login(@RequestParam("id") String CUST_ID, @RequestParam("pw") String CUST_PW, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		
		int returnValue = 0;
		
		//왜 -1로 나오는지??
		String login = accountSVC.login(CUST_ID);
		if(!CUST_PW.equals(login)) {
			returnValue = -1;
		}else {
			returnValue = 1;
			
		}
		map.put("login", returnValue);
		
		return map;
	}
	
	//회원 서비스 체크 기능
	@ResponseBody
	@RequestMapping("typeCheck")
	public Map<String, Object> typeCheck(@RequestParam("id") String CUST_ID){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String typeCheck = accountSVC.typeCheck(CUST_ID);
		map.put("typeCheck", typeCheck);
		
		return map;
	}
	
	//로그아웃 기능
	@ResponseBody
	@RequestMapping("logoutFunction")
	public int logoutFunction(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		session.removeAttribute("CUST_ID");
		if(session.getAttribute("CUST_ID") != null) {
			return 0;
		}else {
			return 1;
		}
		
	}
	

}
