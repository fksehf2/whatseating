package com.test.one.plan.dao;

import java.util.List;
import java.util.Map;

import com.test.one.plan.dto.PlanDto;

public interface PlanDao {
	
	List<PlanDto> storeList(Map<String, Object> map);

}
