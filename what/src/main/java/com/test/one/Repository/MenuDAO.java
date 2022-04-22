package com.test.one.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.one.Vo.FileInfoDTO;
import com.test.one.Vo.MenuDTO;

@Repository("menuDAO")
public class MenuDAO {

	@Autowired
	private SqlSession sqlSession;
	
	//�޴� ���
	//@Transactional  // ����� �̷������ �ʾҴٸ� �ѹ�
	public int menuRegister(MenuDTO menuDTO) {
		int insertResult = sqlSession.insert("mappers.menuMapper.menuRegister",menuDTO);
		
		List<FileInfoDTO> list = menuDTO.getFILEINFOS();
		
		int picInsertResult = 0;
		
		//�ش� menu��ȣ�� ���� ������ŭ ���� �ִ´�. (�� �޴� �����͵� �þ��..?)
		FileInfoDTO fileInfoDTO = new FileInfoDTO();
		fileInfoDTO.setMENU_NUM(menuDTO.getMENU_NUM());
		
		for(int i=0; i < list.size(); i++) {
			fileInfoDTO.setORIGINALFILE(list.get(i).getORIGINALFILE());
			fileInfoDTO.setSAVEFILE(list.get(i).getSAVEFILE());
			fileInfoDTO.setSAVEFOLDER(list.get(i).getSAVEFOLDER());
			picInsertResult = sqlSession.insert("mappers.menuMapper.menu_picRegister", fileInfoDTO);
		}
		
		if(insertResult == 1 && picInsertResult == 1) {
			return insertResult;
		} else {
			return 0;
		}
	}
	
	//������ ����
	public int menuPicInsert(MenuDTO menuDTO) {
		
		List<FileInfoDTO> list = menuDTO.getFILEINFOS();
		
		int picInsertResult = 0;
		
		//�ش� menu��ȣ�� ���� ������ŭ ���� �ִ´�.
		FileInfoDTO fileInfoDTO = new FileInfoDTO();
		fileInfoDTO.setMENU_NUM(menuDTO.getMENU_NUM());
		
		for(int i=0; i < list.size(); i++) {
			fileInfoDTO.setORIGINALFILE(list.get(i).getORIGINALFILE());
			fileInfoDTO.setSAVEFILE(list.get(i).getSAVEFILE());
			fileInfoDTO.setSAVEFOLDER(list.get(i).getSAVEFOLDER());
			picInsertResult = sqlSession.insert("mappers.menuMapper.menu_picRegister", fileInfoDTO);
		}
		
		if(picInsertResult > 0) {
			return picInsertResult;
		} else {
			return 0;
		}
	}
	
	
	//���� ����
	public int menuPicDelete(String SAVEFILE) {
		int deleteResult = sqlSession.delete("mappers.menuMapper.menu_picDelete",SAVEFILE);
		return deleteResult;
	}
	
	
	//�޴� ���� ���
	public List<MenuDTO> menuList(int ST_CODE){
		List<MenuDTO> menuList = sqlSession.selectList("mappers.menuMapper.menuList", ST_CODE);
		
		return menuList;
	}
	
	//�޴� �� ���� ���
	public MenuDTO menuDetail(int MENU_NUM){
		MenuDTO menuDTO = sqlSession.selectOne("mappers.menuMapper.menuDetail", MENU_NUM);
		
		return menuDTO;
	}
	
	//�޴� ���� ���� ���
	public List<FileInfoDTO> picList(int MENU_NUM){
		List<FileInfoDTO> picList = sqlSession.selectList("mappers.menuMapper.picList", MENU_NUM);
		
		return picList;
	}
	
	//�޴� ����
	public int menuModify(MenuDTO menuDTO) {
		int updateResult = sqlSession.update("mappers.menuMapper.menuModify", menuDTO);
		return updateResult;
	}
	
	//�޴� ����
	public int menuDelete(int MENU_NUM) {
		int deleteResult = sqlSession.delete("mappers.menuMapper.menuDelete",MENU_NUM);
		return deleteResult;
	}
	
	
}
