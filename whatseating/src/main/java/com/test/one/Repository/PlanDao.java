package com.test.one.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.one.Vo.PlanDto;

public interface PlanDao {
	
	public List<PlanDto> storeList(PlanDto dto); //글 목록 
	public int getCount(PlanDto dto); //글 갯수
	public List<Map<String, Object>> storeList2(Map<String, Object>map);//글 목록2
	public List<Map<String, Object>> detailList2(Map<String, Object>map);//상세 목록
}
 