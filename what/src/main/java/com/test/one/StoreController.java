package com.test.one;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
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

import com.test.service.StoreSVC;
import com.test.vo.StoreDTO;

@Controller
@RequestMapping("/manager/store/")
public class StoreController {

	@Autowired
	private StoreSVC storeSVC;
	
	
	//리스트 이외의 값만 변경될 수 있도록 ajax를 통해 보여줄 수 있도록 함
	@ResponseBody
	@RequestMapping(value="reservation", method = RequestMethod.GET)
	public Map<String, Object> reservation(@RequestParam(value = "ST_CODE") int ST_CODE) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		StoreDTO storeDTO = storeSVC.storeInfo(ST_CODE);
		
		map.put("storeInfo", storeDTO);
		
		return map;
	}
	
	//리스트를 ajax로 불러올 수 있도록 함
	@ResponseBody
	@RequestMapping(value="storeList", produces = "application/json; charset=utf-8")
	public Map<String, Object> main(@RequestParam("id") String ST_MANAGER) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreDTO> storeList = storeSVC.storeList(ST_MANAGER);
		int storeCount = storeSVC.storeCount(ST_MANAGER);
		map.put("storeList", storeList);
		map.put("storeCount", storeCount);
		
		return map;
	}
	
	//메인 페이지 //매장 리스트
	@RequestMapping(value="main")
	public String main() {
		
		return "managerIndex";
	}
	
	//메인 페이지 //매장 리스트
//	@RequestMapping(value="main")
//	public String main(HttpServletRequest request,Model model) {
//		
//		String ST_MANAGER = "bum";
//		HttpSession session = request.getSession();
//		if(session.getAttribute("CUST_ID") != null) {
//			ST_MANAGER = (String) session.getAttribute("CUST_ID");
//		}
//		
//		List<StoreDTO> storeList = storeSVC.storeList(ST_MANAGER);
//		model.addAttribute("storeList",storeList);
//		
//		return "managerIndex";
//	}
	
	//매장 상세보기
	@RequestMapping(value="reservationDetail")
	public String reservationDetail(Model model, @RequestParam("ST_CODE") int ST_CODE) {
		
		StoreDTO storeDTO = storeSVC.storeInfo(ST_CODE);
		model.addAttribute(storeDTO);
		return "store_reservationDetail";
	}
	
	//매장 등록
	@ResponseBody
	@RequestMapping(value="storeRegister")
	public Map<String, Object> reservationDetail(@ModelAttribute StoreDTO storeDTO) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int insertResult = storeSVC.storeRegister(storeDTO);
		if(insertResult == 1) {
			System.out.println("storeRegister 성공");
			map.put("insertResult", 1);
			
		} else {
			System.out.println("storeRegister 실패");
			map.put("insertResult", 0);
		}
		return map;
	}
	
	
	//매장 수정 (ajax 통신)
	@ResponseBody
	@RequestMapping(value="storeModify")
	public String storeModify(@ModelAttribute StoreDTO storeDTO, HttpServletResponse response) throws Exception{
		
		int updateResult = storeSVC.storeModify(storeDTO);
		if(updateResult == 1) {
			System.out.println("storeupdate 성공");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("1");
		} else {
			System.out.println("storeupdate 실패");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("0");
		}
		return null;
	}
	
	//매장 삭제 (ajax 통신)
		@ResponseBody
		@RequestMapping(value="storeDelete")
		public Map<String, Object> storeModify(@RequestParam("ST_CODE") int ST_CODE){
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			int deleteResult = storeSVC.storeDelete(ST_CODE);
			map.put("deleteResult", deleteResult);
			
			return map;
		}
	
	
	
	
}
