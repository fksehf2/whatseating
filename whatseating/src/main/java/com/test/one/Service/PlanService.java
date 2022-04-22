package com.test.one.Service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.test.one.Vo.PlanDto;

//여기다 만들면 꼭 구현 해야됨ㅋㅋ..
public interface PlanService{
	public void storeList(HttpServletRequest request); //글 목록 
	public List<Map<String, Object>> GetstoreList2(Map<String, Object> map); //글 목록 ajax
	public List<Map<String, Object>> GetdetailList2(Map<String, Object> map); //상세 목록 
}