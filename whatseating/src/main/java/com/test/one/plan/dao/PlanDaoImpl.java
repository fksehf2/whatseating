package com.test.one.plan.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.plan.dto.PlanDto;

@Repository
public class PlanDaoImpl implements PlanDao {
	@Autowired
	private SqlSession sql;

	@Override
	public List<PlanDto> storeList(Map<String, Object> map) {
		return sql.selectList("store.storeList", map);
	}

}
