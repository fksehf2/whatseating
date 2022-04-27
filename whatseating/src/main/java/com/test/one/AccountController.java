package com.test.one;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.one.Service.AccountSVC;
import com.test.one.Vo.AccountDto;

@Controller
public class AccountController {
	
	@Autowired
	AccountSVC service;
	
	
	
	/*
	 * @RequestMapping("/user/login.do") public String loginCheck(AccountDto
	 * dto,HttpSession session, HttpServletResponse response) throws IOException {
	 * response.setContentType("text/html;charset=utf-8"); PrintWriter out =
	 * response.getWriter(); boolean result = service.loginCheck(dto, session);
	 * if(result == false) { out.println("<script>");
	 * out.println("alert('맞게 입력했는지 확인해주세요.')"); out.println("history.go(-1);");
	 * out.println("</script>"); } else { session.setAttribute("CUST_ID",
	 * dto.getCUST_ID()); session.setAttribute("CUST_PW", dto.getCUST_PW());
	 * session.setAttribute("CUST_TYPE", dto.getCUST_TYPE()); } return "header"; }
	 */
	
	@RequestMapping(value="user/loginck")
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest request, HttpSession session)throws Exception{
		String result ="f";
		try {
			Map<String,Object>param=new HashMap<String, Object>();
			param.put("CUST_ID", request.getParameter("CUST_ID"));
			param.put("CUST_PW", request.getParameter("CUST_PW"));
			param.put("CUST_TYPE", request.getParameter("CUST_TYPE"));
			System.out.println(param);
			if(service.login(param) !=null){
				if(!request.getParameter("CUST_PW").equals(service.login(param).getCUST_PW()) 
						&& request.getParameter("CUST_TYPE").equals(service.login(param).getCUST_TYPE())){
					result="N";
					throw new Exception("비밀번호 틀림");
				}else{
						result ="S";
					}
				}else{
					result="N";
					throw new Exception("아이디 틀림");
				}
		   }catch(Exception e) {
			System.out.println("login error:" + e );
			
		}
		session.setAttribute("CUST_ID", request.getParameter("CUST_ID"));
		Map<String,Object> jsonresult= new HashMap<String, Object>();
		jsonresult.put("result", result);
		return jsonresult;
	}
 
	 //로그아웃 처리 
    @RequestMapping(value="logout.do", method=RequestMethod.POST)
    @ResponseBody
    public void logout(HttpSession session){
    	//세션에서 CUST_ID 라는 키값으로 저장된 값 삭제 
        session.removeAttribute("CUST_ID");
        //System.out.println("???");
    }
    
    //아이디&비밀번호 찾기 폼
    @RequestMapping("user/find_id_pw")
	public String IdCheckform() {
    	return "user/find_id_pw";
	}
    
    //아이디 찾기 
    @RequestMapping(value="IdCheck", method=RequestMethod.POST)
    //@ResponseBody
	public String IdCheck(HttpServletResponse response, @RequestParam("CUST_PHNO") String CUST_PHNO, Model m) throws Exception{
    	
		m.addAttribute("id", service.IdCheck(response, CUST_PHNO));
		return "user/IdCheck";
	}
    
    //비밀번호 찾기 
    @RequestMapping(value="PwChange", method=RequestMethod.POST)
    @ResponseBody
    public void PwChange(HttpServletResponse response, @ModelAttribute AccountDto dto) throws IOException {
    	service.PwChange(response, dto);
 
    }
}

