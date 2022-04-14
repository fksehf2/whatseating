package com.test.one.plan.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.test.one.plan.service.PlanService;

@Controller
public class CateController {


@Autowired 
private PlanService service;

@RequestMapping("/store/100")
public String StoreList(HttpServletRequest request) {
	
	service.storeList(request);
	
	System.out.println("cateList 진입");
	return "store/100";
}
	

}
