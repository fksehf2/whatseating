package com.test.one;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.one.Service.CateService;
import com.test.one.Service.PlanService;

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
