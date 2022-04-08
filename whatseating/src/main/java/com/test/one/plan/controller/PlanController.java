package com.test.one.plan.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.one.plan.dto.PlanDto;
import com.test.one.plan.service.PlanService;

@Controller
public class PlanController {


@Autowired 
private PlanService service;

	
    @RequestMapping(value = "/store/{st_code}", method = RequestMethod.GET)
	public String store(@PathVariable int st_code, String st_addressNo, Model model) {
		System.out.println("st_code" + st_code);
		List<PlanDto> storeList = service.storeList(st_code, st_addressNo);
		model.addAttribute("storeList", storeList);
		return "store/store";
	}
}
