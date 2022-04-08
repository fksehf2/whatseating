package com.test.one.plan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.one.plan.dao.PlanDao;
import com.test.one.plan.dto.PlanDto;

@Service
public class PlanServiceImpl implements PlanService {

	 @Autowired private PlanDao dao;

	 @Override
		public List<PlanDto> storeList(int st_code, String st_addressNo) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("st_code", st_code);
			map.put("st_addressNo", st_addressNo);
			
			return dao.storeList(map);
		}
	 

   }