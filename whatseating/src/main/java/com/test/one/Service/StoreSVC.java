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
	
	//���� ����
	public StoreDTO storeInfo(int ST_CODE) {
		StoreDTO storeDTO = storeDAO.storeInfo(ST_CODE);
		return storeDTO;
	}
	//���� ����
	public int storeModify(StoreDTO storeDTO) {
		int updateResult = storeDAO.storeModify(storeDTO);
		return updateResult;
	}
	
	//���� ���
	public int storeRegister(StoreDTO storeDTO) {
		int insertResult = storeDAO.storeRegister(storeDTO);
		return insertResult;
	}
	
	//���� ����Ʈ
	public List<StoreDTO> storeList(String ST_MANAGER) {
		List<StoreDTO> storeList = storeDAO.storeList(ST_MANAGER);
		return storeList;
	}
	
	//���� ī��Ʈ
	public int storeCount(String ST_MANAGER) {
		int storeCount = storeDAO.storeCount(ST_MANAGER);
		return storeCount;
	}
	
	//���� ����
	public int storeDelete(int ST_CODE) {
		int deleteResult = storeDAO.storeDelete(ST_CODE);
		return deleteResult;
	}
}
