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
	
	//메뉴 등록 (DB등록 부분)
//	@ResponseBody //ajax 파일을 처리하기 위해 (json)
//	@RequestMapping("menuRegister")
//	public Map<String, Integer> menuRegister(@ModelAttribute MenuDTO menuDTO, HttpServletRequest request, HttpServletResponse response, Model model) throws IllegalStateException, IOException {
//				
//				Map<String, Integer> map = new HashMap<String, Integer>();
//				
//				//세션 값 아이디도 담을 수 있도록 함
//				HttpSession session = request.getSession();
//				String MENU_REGMANAGER = "bum";
//				
//				//추후 세션값을 이용하여 입력할 수 있도록 함
////				if(session.getAttribute("CUST_ID") != null) {
////					MENU_REGMANAGER = (String) session.getAttribute("CUST_ID");
////				}
//				
//				menuDTO.setMENU_REGMANAGER(MENU_REGMANAGER);
//				
//				//파일이 담긴 내용을 svc단으로 전달
//				int insertRegister = menuSVC.menuRegister(menuDTO);
//				if(insertRegister == 1) {
//					System.out.println("메뉴등록 성공");
//					map.put("menuResult", 1);
//					
//				} else {
//					System.out.println("메뉴등록 실패");
//					map.put("menuResult", 0);
//				}
//				return map;
//	}
	
	//사진 파일 저장, 메뉴 등록
	@ResponseBody
	@RequestMapping("savePic")
	public Map<String, Object> savePic(@RequestParam("image") MultipartFile[] files, @ModelAttribute MenuDTO menuDTO, HttpServletRequest request) throws Exception, IOException {
		
		//json문자열을 보내기 위함
		Map<String, Object> map = new HashMap<String, Object>();
		
		//세션의 아이디를 이용해 등록자 내용을 넣을 수 있도록 함
		String MENU_REGMANAGER = "bum";
//		HttpSession session = request.getSession();
//		if(session.getAttribute("CUST_ID") != null) {
//			MENU_REGMANAGER = (String) session.getAttribute("CUST_ID");
//		}
		
		menuDTO.setMENU_REGMANAGER(MENU_REGMANAGER);
		
		// 파일 업로드, 다운로드의 기본 개념
		// 파일 위치 경로를 db에 넣어 불러올 수 있도록 하고, 실제로 폴더를 만들어 넣음
		String realPath = servletContext.getRealPath("/resources/upload");
		String today = new SimpleDateFormat("yyyyMMDD").format(new Date());
		String saveFolder = realPath + today;
		
		logger.info(saveFolder);
		logger.debug(saveFolder);
		
		//경로에 파일이 있는지 확인 //없으면 파일을 만듬
		File folder = new File(saveFolder);
		if(!folder.exists()) {
			folder.mkdir();
		}
		List<FileInfoDTO> fileInfos = new ArrayList<FileInfoDTO>();
		for(MultipartFile picFile : files) {
			FileInfoDTO fileInfoDTO = new FileInfoDTO();
			String originalFileName = picFile.getOriginalFilename();
			//파일명이 있다면
			if(!originalFileName.isEmpty()) {
				//파일명 중복을 막기 위해 UUID를 사용
				//파일명은 확장자를 빼서 저장
				String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf("."));
				fileInfoDTO.setORIGINALFILE(originalFileName);
				fileInfoDTO.setSAVEFILE(saveFileName);
				fileInfoDTO.setSAVEFOLDER(today);
				logger.info(picFile.getOriginalFilename()+" "+saveFileName);
				
				//transferTo로 파일 업로드 처리 (어느 폴더에, 어떤 이름으로)
				picFile.transferTo(new File(folder,saveFileName));
				
				//파일을 담은 DTO를 배열로 저장
				fileInfos.add(fileInfoDTO);
			}
		}
		
		menuDTO.setMENU_REGDATE(today);
		menuDTO.setFILEINFOS(fileInfos);
		
		int insertResult = 0;
		
		//사진 파일이 저장이 잘 되었다면 db에 등록이 될 수 있도록 함
		if(!fileInfos.isEmpty()) {
			insertResult = menuSVC.menuRegister(menuDTO);
			map.put("insertResult", insertResult);
		} else {
			map.put("insertResult", insertResult);
		}
		
		return map;
	}
	
	//사진만 저장
	@ResponseBody
	@RequestMapping("savePic2")
	public Map<String, Object> savePic2(@RequestParam("image") MultipartFile[] files, @RequestParam("MENU_NUM") int MENU_NUM, @ModelAttribute MenuDTO menuDTO, HttpServletRequest request) throws Exception, IOException {
		
		//json문자열을 보내기 위함
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 파일 업로드, 다운로드의 기본 개념
		// 파일 위치 경로를 db에 넣어 불러올 수 있도록 하고, 실제로 폴더를 만들어 넣음
		String realPath = servletContext.getRealPath("/resources/upload");
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String saveFolder = realPath + today;
		logger.info(saveFolder);
		
		
		//경로에 파일이 있는지 확인 //없으면 파일을 만듬
		File folder = new File(saveFolder);
		if(!folder.exists()) {
			folder.mkdir();
		}
		List<FileInfoDTO> fileInfos = new ArrayList<FileInfoDTO>();
		for(MultipartFile picFile : files) {
			FileInfoDTO fileInfoDTO = new FileInfoDTO();
			String originalFileName = picFile.getOriginalFilename();
			//파일명이 있다면
			if(!originalFileName.isEmpty()) {
				//파일명 중복을 막기 위해 UUID를 사용
				//파일명은 확장자를 빼서 저장
				String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf("."));
				fileInfoDTO.setORIGINALFILE(originalFileName);
				fileInfoDTO.setSAVEFILE(saveFileName);
				fileInfoDTO.setSAVEFOLDER(today);
				logger.info(picFile.getOriginalFilename()+" "+saveFileName);
				//transferTo로 파일 업로드 처리 (어느 폴더에, 어떤 이름으로)
				picFile.transferTo(new File(folder,saveFileName));
				
				//파일을 담은 DTO를 배열로 저장
				fileInfos.add(fileInfoDTO);
			}
		}
		menuDTO.setFILEINFOS(fileInfos);
		menuDTO.setMENU_NUM(MENU_NUM);
		
		int insertResult = 0;
		
		//사진 파일이 저장이 잘 되었다면 db에 등록이 될 수 있도록 함
		if(!fileInfos.isEmpty()) {
			insertResult = menuSVC.menuPicInsert(menuDTO);
			map.put("insertResult", insertResult);
		} else {
			map.put("insertResult", insertResult);
		}
		
		return map;
	}
	
	
	//사진 삭제
	@ResponseBody
	@RequestMapping("menuPicDelete")
	public String menuDelete(@RequestParam("SAVEFILE") String SAVEFILE) {
		
		int deleteResult = menuSVC.menuPicDelete(SAVEFILE);
		if(deleteResult > 0) {
			System.out.println("menuDelete 성공");
			return "1";
		} else {
			System.out.println("menuDelete 실패");
			return "0";
		}
	}
		
	
	//메뉴 정보 출력
	@ResponseBody
	@RequestMapping("menuList")
	public Map<String, Object> menuList(@RequestParam("ST_CODE") int ST_CODE){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MenuDTO> menuList = menuSVC.menuList(ST_CODE);
		map.put("menuList", menuList);
		
		return map;
	}
	
	//메뉴 상세 정보 출력
	@ResponseBody
	@RequestMapping("menuDetail")
	public Map<String, Object> menuDetail(@RequestParam("MENU_NUM") int MENU_NUM){
		Map<String, Object> map = new HashMap<String, Object>();
		
		MenuDTO menuDTO = menuSVC.menuDetail(MENU_NUM);
		map.put("menuDetail", menuDTO);
		
		return map;
	}
	
	//메뉴 사진 정보 출력
	@ResponseBody
	@RequestMapping("picList")
	public Map<String, Object> picList(@RequestParam("MENU_NUM") int MENU_NUM){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<FileInfoDTO> picList = menuSVC.picList(MENU_NUM);
		map.put("picList", picList);
		
		return map;
	}
	
	//메뉴 수정
	@ResponseBody
	@RequestMapping("menuModify")
	public String menuModify(@ModelAttribute MenuDTO menuDTO, HttpServletRequest request){
		
		//추후 세션 값으로 바꿀 수 있도록 함
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
			System.out.println("menuModify 성공");
			return "1";
		} else {
			System.out.println("menuModify 실패");
			return "0";
		}
	}
	
	//메뉴 삭제
	@ResponseBody
	@RequestMapping("menuDelete")
	public String menuDelete(@RequestParam("MENU_NUM") int MENU_NUM) {
		
		int deleteResult = menuSVC.menuDelete(MENU_NUM);
		if(deleteResult == 1) {
			System.out.println("menuDelete 성공");
			return "1";
		} else {
			System.out.println("menuDelete 실패");
			return "0";
		}
		
	}

	
}
