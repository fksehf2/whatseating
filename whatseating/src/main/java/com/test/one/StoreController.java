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

import com.test.one.Service.StoreSVC;
import com.test.one.Vo.StoreDTO;

@Controller
@RequestMapping("/manager/store/")
public class StoreController {

	@Autowired
	private StoreSVC storeSVC;
	
	
	//����Ʈ �̿��� ���� ����� �� �ֵ��� ajax�� ���� ������ �� �ֵ��� ��
	@ResponseBody
	@RequestMapping(value="reservation", method = RequestMethod.GET)
	public Map<String, Object> reservation(@RequestParam(value = "ST_CODE") int ST_CODE) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		StoreDTO storeDTO = storeSVC.storeInfo(ST_CODE);
		
		map.put("storeInfo", storeDTO);
		
		return map;
	}
	
	//����Ʈ�� ajax�� �ҷ��� �� �ֵ��� ��
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
	
	//���� ������ //���� ����Ʈ
	@RequestMapping(value="main")
	public String main() {
		
		return "managerIndex";
	}
	
	//���� �󼼺���
	@RequestMapping(value="reservationDetail")
	public String reservationDetail(Model model, @RequestParam("ST_CODE") int ST_CODE) {
		
		StoreDTO storeDTO = storeSVC.storeInfo(ST_CODE);
		model.addAttribute(storeDTO);
		return "store_reservationDetail";
	}
	
	//���� ���
	@ResponseBody
	@RequestMapping(value="storeRegister")
	public Map<String, Object> reservationDetail(@ModelAttribute StoreDTO storeDTO) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int insertResult = storeSVC.storeRegister(storeDTO);
		if(insertResult == 1) {
			System.out.println("storeRegister ����");
			map.put("insertResult", 1);
			
		} else {
			System.out.println("storeRegister ����");
			map.put("insertResult", 0);
		}
		return map;
	}
	
	//���� ���� (ajax ���)
	@ResponseBody
	@RequestMapping(value="storeModify")
	public String storeModify(@ModelAttribute StoreDTO storeDTO, HttpServletResponse response) throws Exception{
		
		int updateResult = storeSVC.storeModify(storeDTO);
		if(updateResult == 1) {
			System.out.println("storeupdate ����");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("1");
		} else {
			System.out.println("storeupdate ����");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("0");
		}
		return null;
	}
	
	//���� ���� (ajax ���)
		@ResponseBody
		@RequestMapping(value="storeDelete")
		public Map<String, Object> storeModify(@RequestParam("ST_CODE") int ST_CODE){
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			int deleteResult = storeSVC.storeDelete(ST_CODE);
			map.put("deleteResult", deleteResult);
			
			return map;
		}
	
	
	
	
}
