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
	
	//ȸ�� �� ������
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
	public String userModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String CUST_ID = null;
		if(session.getAttribute("CUST_ID") != null) {
			CUST_ID = (String) session.getAttribute("CUST_ID");
		}
		int updateResult = accountSVC.userUpdate(CUST_ID);
		if(updateResult == 1) {
			System.out.println("userUpdate ����");
			return "1";
		} else {
			System.out.println("userUpdate ����");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('ȸ�� ������ ���� �ʾҽ��ϴ�.');");
			out.println("</script>");
			return "0";
		}

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
	
	

}
