package com.test.one.plan.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.test.one.plan.dto.PlanDto;


public interface PlanService{
	public void storeList(HttpServletRequest request); 
	public List<Map<String, Object>> storeList2(PlanDto dto);
}