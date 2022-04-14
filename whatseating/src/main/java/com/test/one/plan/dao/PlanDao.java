package com.test.one.plan.dao;

import java.util.List;
import java.util.Map;

import com.test.one.plan.dto.PlanDto;

public interface PlanDao {
	
	public List<PlanDto> storeList(PlanDto dto); //글 목록 
	public int getCount(PlanDto dto); //글의 갯수 
}
