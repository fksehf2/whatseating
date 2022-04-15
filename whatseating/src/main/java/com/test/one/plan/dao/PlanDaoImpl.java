package com.test.one.plan.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.plan.dto.PlanDto;

@Repository
public class PlanDaoImpl implements PlanDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<PlanDto> storeList(PlanDto dto) {
		return session.selectList("store.storeList", dto);
	}

	@Override
	public int getCount(PlanDto dto) {
		return session.selectOne("store.getCount", dto);
	}

	@Override
	public List<PlanDto> storeList2(Map map) {
		// TODO Auto-generated method stub
		return session.selectList("store.storeList2", map);
	}

}
