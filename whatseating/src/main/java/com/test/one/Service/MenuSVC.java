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
	
	//�޴� ���
	public int menuRegister(MenuDTO menuDTO) {
		int insertResult = menuDAO.menuRegister(menuDTO);
		return insertResult;
	}
	
	//������ ���
		public int menuPicInsert(MenuDTO menuDTO) {
			int insertResult = menuDAO.menuPicInsert(menuDTO);
			return insertResult;
		}
	
	//�޴� ���� ���
	public List<MenuDTO> menuList(int ST_CODE){
		List<MenuDTO> menuList = menuDAO.menuList(ST_CODE);
		
		return menuList;
	}
	
	//�޴� �� ���� ���
	public MenuDTO menuDetail(int MENU_NUM){
		MenuDTO menuDTO = menuDAO.menuDetail(MENU_NUM);
		
		return menuDTO;
	}
	
	//�޴� ���� ���� ���
	public List<FileInfoDTO> picList(int MENU_NUM){
		List<FileInfoDTO> picList = menuDAO.picList(MENU_NUM);
		
		return picList;
	}
	
	//�޴� ����
	public int menuModify(MenuDTO menuDTO) {
		int updateResult = menuDAO.menuModify(menuDTO);
		return updateResult;
	}
	
	//���� ����
	public int menuPicDelete(String SAVEFILE) {
		int deleteResult = menuDAO.menuPicDelete(SAVEFILE);
		return deleteResult;
	}
	
	//�޴� ����
	public int menuDelete(int MENU_NUM) {
		int deleteResult = menuDAO.menuDelete(MENU_NUM);
		return deleteResult;
	}
	
}
