package com.test.one.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.Vo.PlanDto;

@Repository("PlanDAO")
public class PlanDAO {
	@Autowired
	private SqlSession session;


	public List<PlanDto> storeList(PlanDto dto) {
		return session.selectList("store.storeList", dto);
	}


	public int getCount(PlanDto dto) {
		return session.selectOne("store.getCount", dto);
	}


	public List<Map<String, Object>> storeList2(Map<String, Object> map) {
		return session.selectList("store.storeList2", map);
	}


	public List<Map<String, Object>> detailList2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList("store.detailList", map);

	}
	
	public List<Map<String, Object>> detailList3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("store.detailList", map);
	}

	
}

