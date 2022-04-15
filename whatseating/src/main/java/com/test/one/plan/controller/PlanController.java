package com.test.one.plan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.one.plan.dto.PlanDto;
import com.test.one.plan.service.PlanService;

@Controller
public class PlanController {

	@Autowired
	private PlanService service;

	@RequestMapping("/store/test")
	public String GetStoreList(HttpServletRequest request) {

		service.storeList(request);

		System.out.println("storeList 진입");
		return "store/test";
	}


	/*
	 * @RequestMapping("/api/list")
	 * 
	 * @ResponseBody public void storeList2(Map<String, Object> map){
	 * 
	 * }
	 */

	
	@RequestMapping("/api/list")
	@ResponseBody 
	public Map<String, Object> testAjax(PlanDto dto){
        
        Map<String, Object> result = new HashMap<String, Object>();
        
        // 응답 데이터 셋팅
        result.put("code", "0000");
        
        return result;
        
    }
}
		

