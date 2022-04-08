package com.test.one.plan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.one.plan.dto.PlanDto;


public interface PlanService{
	List<PlanDto> storeList(int st_code, String st_addressNo);
	
}