package com.test.one.plan.dao;

import java.util.List;

import com.test.one.plan.dto.CateDto;

public interface CateDao {
	
	public List<CateDto> cateList(CateDto dto); //글 목록 
}
