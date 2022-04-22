package com.test.one.Repository;

import java.util.List;

import com.test.one.Vo.CateDto;

public interface CateDao {
	
	public List<CateDto> cateList(CateDto dto); //글 목록 
}
