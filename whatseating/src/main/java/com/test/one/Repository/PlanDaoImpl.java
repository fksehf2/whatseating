package com.test.one.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.Vo.PlanDto;

@Repository
public class PlanDaoImpl implements PlanDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<PlanDto> storeList(PlanDto dto) {
		//System.out.println("storeList" +"--------"+ session.selectList("store.storeList", dto));
		return session.selectList("store.storeList", dto);
	}

	@Override
	public int getCount(PlanDto dto) {
		return session.selectOne("store.getCount", dto);
	}

	@Override
	public List<Map<String, Object>> storeList2(Map<String, Object> map) {
		return session.selectList("store.storeList2", map);
	}

	@Override
	public List<Map<String, Object>> detailList2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList("store.detailList", map);
	}

	
}

