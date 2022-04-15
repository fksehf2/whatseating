package com.test.one.plan.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.one.plan.dto.PlanDto;

public interface PlanDao {
	
	public List<PlanDto> storeList(PlanDto dto); //글 목록 
	public int getCount(PlanDto dto);
	//List<PlanDto> storeList2(Map<String, Object> map); //글의 갯수
	public List<PlanDto> storeList2(Map map);
}
 