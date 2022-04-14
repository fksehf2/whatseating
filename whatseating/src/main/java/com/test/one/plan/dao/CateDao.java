package com.test.one.plan.dao;

import java.util.List;
import java.util.Map;

import com.test.one.plan.dto.CateDto;
import com.test.one.plan.dto.PlanDto;

public interface CateDao {
	
	public List<CateDto> cateList(CateDto dto); //글 목록 
}
