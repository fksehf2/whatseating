package com.test.one.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.Vo.StoreDTO;

@Repository("storeDAO")
public class StoreDAO {

	@Autowired
	private SqlSession session;
	
	//매장 정보를 불러옴
	public StoreDTO storeInfo(int ST_CODE) {
		StoreDTO storeDTO = session.selectOne("mappers.storeMapper.storeInfo",ST_CODE);
		return storeDTO;
	}
	//매장 수정
	public int storeModify(StoreDTO storeDTO) {
		int updateResult = session.update("mappers.storeMapper.storeModify",storeDTO);
		return updateResult;
	}
	//매장 등록
	public int storeRegister (StoreDTO storeDTO) {
		int insertResult = session.insert("mappers.storeMapper.storeRegister",storeDTO);
		return insertResult;
	}
	
	//매장 리스트
	public List<StoreDTO> storeList(String ST_MANAGER) {
		List<StoreDTO> storeList = session.selectList("mappers.storeMapper.storeList",ST_MANAGER);
		return storeList;
	}
	
	//매장 카운트 
	public int storeCount (String ST_MANAGER) {
		int storeCount = session.selectOne("mappers.storeMapper.storeCount",ST_MANAGER);
		return storeCount;
	}
	
	//매장 삭제
	public int storeDelete (int ST_CODE) {
		int deleteResult = session.delete("mappers.storeMapper.storeDelete",ST_CODE);
		return deleteResult;
	}
	
	
	
}
