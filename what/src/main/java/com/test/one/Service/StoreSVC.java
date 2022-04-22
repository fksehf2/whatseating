package com.test.one.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.one.Repository.StoreDAO;
import com.test.one.Vo.StoreDTO;

@Service("storeSVC")
public class StoreSVC {

	@Autowired
	private StoreDAO storeDAO;
	
	//매장 정보
	public StoreDTO storeInfo(int ST_CODE) {
		StoreDTO storeDTO = storeDAO.storeInfo(ST_CODE);
		return storeDTO;
	}
	//매장 수정
	public int storeModify(StoreDTO storeDTO) {
		int updateResult = storeDAO.storeModify(storeDTO);
		return updateResult;
	}
	
	//매장 등록
	public int storeRegister(StoreDTO storeDTO) {
		int insertResult = storeDAO.storeRegister(storeDTO);
		return insertResult;
	}
	
	//매장 리스트
	public List<StoreDTO> storeList(String ST_MANAGER) {
		List<StoreDTO> storeList = storeDAO.storeList(ST_MANAGER);
		return storeList;
	}
	
	//매장 카운트
	public int storeCount(String ST_MANAGER) {
		int storeCount = storeDAO.storeCount(ST_MANAGER);
		return storeCount;
	}
	
	//매장 삭제
	public int storeDelete(int ST_CODE) {
		int deleteResult = storeDAO.storeDelete(ST_CODE);
		return deleteResult;
	}
}
