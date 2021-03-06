package com.test.one.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.Vo.CateDto;

@Repository
public class CateDaoImpl implements CateDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<CateDto> cateList(CateDto dto) {
		return session.selectList("cate.cateList", dto);
	}


}
