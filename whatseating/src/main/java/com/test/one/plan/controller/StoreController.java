package com.test.one.plan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.one.plan.dto.PlanDto;

@Controller
public class StoreController {
	    @RequestMapping("/test/ajax")
	    @ResponseBody
	    public Map<String, Object> testAjax(PlanDto dto){
	        
	        Map<String, Object> result = new HashMap<String, Object>();
	        System.out.println(dto.getST_CODE());
	        result.put("code", "0000");
	        
	        return result;
}
}
