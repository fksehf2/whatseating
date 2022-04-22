package com.test.one;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.one.Service.MenuSVC;
import com.test.one.Vo.FileInfoDTO;
import com.test.one.Vo.MenuDTO;

@Controller
@RequestMapping("/manager/store/menu/")
public class MenuController {
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private MenuSVC menuSVC;
	
	//�޴� ��� (DB��� �κ�)
//	@ResponseBody //ajax ������ ó���ϱ� ���� (json)
//	@RequestMapping("menuRegister")
//	public Map<String, Integer> menuRegister(@ModelAttribute MenuDTO menuDTO, HttpServletRequest request, HttpServletResponse response, Model model) throws IllegalStateException, IOException {
//				
//				Map<String, Integer> map = new HashMap<String, Integer>();
//				
//				//���� �� ���̵� ���� �� �ֵ��� ��
//				HttpSession session = request.getSession();
//				String MENU_REGMANAGER = "bum";
//				
//				//���� ���ǰ��� �̿��Ͽ� �Է��� �� �ֵ��� ��
////				if(session.getAttribute("CUST_ID") != null) {
////					MENU_REGMANAGER = (String) session.getAttribute("CUST_ID");
////				}
//				
//				menuDTO.setMENU_REGMANAGER(MENU_REGMANAGER);
//				
//				//������ ��� ������ svc������ ����
//				int insertRegister = menuSVC.menuRegister(menuDTO);
//				if(insertRegister == 1) {
//					System.out.println("�޴���� ����");
//					map.put("menuResult", 1);
//					
//				} else {
//					System.out.println("�޴���� ����");
//					map.put("menuResult", 0);
//				}
//				return map;
//	}
	
	//���� ���� ����, �޴� ���
	@ResponseBody
	@RequestMapping("savePic")
	public Map<String, Object> savePic(@RequestParam("image") MultipartFile[] files, @ModelAttribute MenuDTO menuDTO, HttpServletRequest request) throws Exception, IOException {
		
		//json���ڿ��� ������ ����
		Map<String, Object> map = new HashMap<String, Object>();
		
		//������ ���̵� �̿��� ����� ������ ���� �� �ֵ��� ��
		String MENU_REGMANAGER = "bum";
//		HttpSession session = request.getSession();
//		if(session.getAttribute("CUST_ID") != null) {
//			MENU_REGMANAGER = (String) session.getAttribute("CUST_ID");
//		}
		
		menuDTO.setMENU_REGMANAGER(MENU_REGMANAGER);
		
		// ���� ���ε�, �ٿ�ε��� �⺻ ����
		// ���� ��ġ ��θ� db�� �־� �ҷ��� �� �ֵ��� �ϰ�, ������ ������ ����� ����
		String realPath = servletContext.getRealPath("/resources/upload");
		String today = new SimpleDateFormat("yyyyMMDD").format(new Date());
		String saveFolder = realPath + today;
		
		logger.info(saveFolder);
		logger.debug(saveFolder);
		
		//��ο� ������ �ִ��� Ȯ�� //������ ������ ����
		File folder = new File(saveFolder);
		if(!folder.exists()) {
			folder.mkdir();
		}
		List<FileInfoDTO> fileInfos = new ArrayList<FileInfoDTO>();
		for(MultipartFile picFile : files) {
			FileInfoDTO fileInfoDTO = new FileInfoDTO();
			String originalFileName = picFile.getOriginalFilename();
			//���ϸ��� �ִٸ�
			if(!originalFileName.isEmpty()) {
				//���ϸ� �ߺ��� ���� ���� UUID�� ���
				//���ϸ��� Ȯ���ڸ� ���� ����
				String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf("."));
				fileInfoDTO.setORIGINALFILE(originalFileName);
				fileInfoDTO.setSAVEFILE(saveFileName);
				fileInfoDTO.setSAVEFOLDER(today);
				logger.info(picFile.getOriginalFilename()+" "+saveFileName);
				
				//transferTo�� ���� ���ε� ó�� (��� ������, � �̸�����)
				picFile.transferTo(new File(folder,saveFileName));
				
				//������ ���� DTO�� �迭�� ����
				fileInfos.add(fileInfoDTO);
			}
		}
		
		menuDTO.setMENU_REGDATE(today);
		menuDTO.setFILEINFOS(fileInfos);
		
		int insertResult = 0;
		
		//���� ������ ������ �� �Ǿ��ٸ� db�� ����� �� �� �ֵ��� ��
		if(!fileInfos.isEmpty()) {
			insertResult = menuSVC.menuRegister(menuDTO);
			map.put("insertResult", insertResult);
		} else {
			map.put("insertResult", insertResult);
		}
		
		return map;
	}
	
	//������ ����
	@ResponseBody
	@RequestMapping("savePic2")
	public Map<String, Object> savePic2(@RequestParam("image") MultipartFile[] files, @RequestParam("MENU_NUM") int MENU_NUM, @ModelAttribute MenuDTO menuDTO, HttpServletRequest request) throws Exception, IOException {
		
		//json���ڿ��� ������ ����
		Map<String, Object> map = new HashMap<String, Object>();
		
		// ���� ���ε�, �ٿ�ε��� �⺻ ����
		// ���� ��ġ ��θ� db�� �־� �ҷ��� �� �ֵ��� �ϰ�, ������ ������ ����� ����
		String realPath = servletContext.getRealPath("/resources/upload");
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String saveFolder = realPath + today;
		logger.info(saveFolder);
		
		
		//��ο� ������ �ִ��� Ȯ�� //������ ������ ����
		File folder = new File(saveFolder);
		if(!folder.exists()) {
			folder.mkdir();
		}
		List<FileInfoDTO> fileInfos = new ArrayList<FileInfoDTO>();
		for(MultipartFile picFile : files) {
			FileInfoDTO fileInfoDTO = new FileInfoDTO();
			String originalFileName = picFile.getOriginalFilename();
			//���ϸ��� �ִٸ�
			if(!originalFileName.isEmpty()) {
				//���ϸ� �ߺ��� ���� ���� UUID�� ���
				//���ϸ��� Ȯ���ڸ� ���� ����
				String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf("."));
				fileInfoDTO.setORIGINALFILE(originalFileName);
				fileInfoDTO.setSAVEFILE(saveFileName);
				fileInfoDTO.setSAVEFOLDER(today);
				logger.info(picFile.getOriginalFilename()+" "+saveFileName);
				//transferTo�� ���� ���ε� ó�� (��� ������, � �̸�����)
				picFile.transferTo(new File(folder,saveFileName));
				
				//������ ���� DTO�� �迭�� ����
				fileInfos.add(fileInfoDTO);
			}
		}
		menuDTO.setFILEINFOS(fileInfos);
		menuDTO.setMENU_NUM(MENU_NUM);
		
		int insertResult = 0;
		
		//���� ������ ������ �� �Ǿ��ٸ� db�� ����� �� �� �ֵ��� ��
		if(!fileInfos.isEmpty()) {
			insertResult = menuSVC.menuPicInsert(menuDTO);
			map.put("insertResult", insertResult);
		} else {
			map.put("insertResult", insertResult);
		}
		
		return map;
	}
	
	
	//���� ����
	@ResponseBody
	@RequestMapping("menuPicDelete")
	public String menuDelete(@RequestParam("SAVEFILE") String SAVEFILE) {
		
		int deleteResult = menuSVC.menuPicDelete(SAVEFILE);
		if(deleteResult > 0) {
			System.out.println("menuDelete ����");
			return "1";
		} else {
			System.out.println("menuDelete ����");
			return "0";
		}
	}
		
	
	//�޴� ���� ���
	@ResponseBody
	@RequestMapping("menuList")
	public Map<String, Object> menuList(@RequestParam("ST_CODE") int ST_CODE){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MenuDTO> menuList = menuSVC.menuList(ST_CODE);
		map.put("menuList", menuList);
		
		return map;
	}
	
	//�޴� �� ���� ���
	@ResponseBody
	@RequestMapping("menuDetail")
	public Map<String, Object> menuDetail(@RequestParam("MENU_NUM") int MENU_NUM){
		Map<String, Object> map = new HashMap<String, Object>();
		
		MenuDTO menuDTO = menuSVC.menuDetail(MENU_NUM);
		map.put("menuDetail", menuDTO);
		
		return map;
	}
	
	//�޴� ���� ���� ���
	@ResponseBody
	@RequestMapping("picList")
	public Map<String, Object> picList(@RequestParam("MENU_NUM") int MENU_NUM){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<FileInfoDTO> picList = menuSVC.picList(MENU_NUM);
		map.put("picList", picList);
		
		return map;
	}
	
	//�޴� ����
	@ResponseBody
	@RequestMapping("menuModify")
	public String menuModify(@ModelAttribute MenuDTO menuDTO, HttpServletRequest request){
		
		//���� ���� ������ �ٲ� �� �ֵ��� ��
		String MENU_UPDMANAGER = "bum";
//		HttpSession session = request.getSession();
//		if(session.getAttribute("CUST_ID") != null) {
//			MENU_UPDMANAGER = (String) session.getAttribute("CUST_ID");
//		}
		
		String today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		menuDTO.setMENU_UPDMANAGER(MENU_UPDMANAGER);
		menuDTO.setMENU_UPDDATE(today);
		
		int updateResult = menuSVC.menuModify(menuDTO);
		
		if(updateResult == 1) {
			System.out.println("menuModify ����");
			return "1";
		} else {
			System.out.println("menuModify ����");
			return "0";
		}
	}
	
	//�޴� ����
	@ResponseBody
	@RequestMapping("menuDelete")
	public String menuDelete(@RequestParam("MENU_NUM") int MENU_NUM) {
		
		int deleteResult = menuSVC.menuDelete(MENU_NUM);
		if(deleteResult == 1) {
			System.out.println("menuDelete ����");
			return "1";
		} else {
			System.out.println("menuDelete ����");
			return "0";
		}
		
	}

	
}
