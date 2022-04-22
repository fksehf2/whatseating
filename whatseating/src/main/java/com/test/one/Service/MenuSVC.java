package com.test.one.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.one.Repository.MenuDAO;
import com.test.one.Vo.FileInfoDTO;
import com.test.one.Vo.MenuDTO;

@Service("menuSVC")
public class MenuSVC {
	
	@Autowired
	private MenuDAO menuDAO;
	
	//메뉴 등록
	public int menuRegister(MenuDTO menuDTO) {
		int insertResult = menuDAO.menuRegister(menuDTO);
		return insertResult;
	}
	
	//사진만 등록
		public int menuPicInsert(MenuDTO menuDTO) {
			int insertResult = menuDAO.menuPicInsert(menuDTO);
			return insertResult;
		}
	
	//메뉴 정보 출력
	public List<MenuDTO> menuList(int ST_CODE){
		List<MenuDTO> menuList = menuDAO.menuList(ST_CODE);
		
		return menuList;
	}
	
	//메뉴 상세 정보 출력
	public MenuDTO menuDetail(int MENU_NUM){
		MenuDTO menuDTO = menuDAO.menuDetail(MENU_NUM);
		
		return menuDTO;
	}
	
	//메뉴 사진 정보 출력
	public List<FileInfoDTO> picList(int MENU_NUM){
		List<FileInfoDTO> picList = menuDAO.picList(MENU_NUM);
		
		return picList;
	}
	
	//메뉴 수정
	public int menuModify(MenuDTO menuDTO) {
		int updateResult = menuDAO.menuModify(menuDTO);
		return updateResult;
	}
	
	//사진 삭제
	public int menuPicDelete(String SAVEFILE) {
		int deleteResult = menuDAO.menuPicDelete(SAVEFILE);
		return deleteResult;
	}
	
	//메뉴 삭제
	public int menuDelete(int MENU_NUM) {
		int deleteResult = menuDAO.menuDelete(MENU_NUM);
		return deleteResult;
	}
	
}
