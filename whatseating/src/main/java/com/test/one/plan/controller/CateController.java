package com.test.one.plan.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.one.plan.service.CateService;
import com.test.one.plan.service.PlanService;

@Controller
public class CateController {


@Autowired 
private CateService service;

@RequestMapping("/store/test2")
public String cateList(HttpServletRequest request) {
	
	service.cateList(request);
	
	System.out.println("cateList 진입");
	return "store/test2";
}
	

}
