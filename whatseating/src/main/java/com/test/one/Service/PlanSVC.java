package com.test.one.Service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.one.Repository.PlanDAO;
import com.test.one.Vo.PlanDto;

@Service
public class PlanSVC {

	 @Autowired private PlanDAO dao;

	
	 public void storeList(HttpServletRequest request) {
			
			//한 페이지에 몇개씩 표시할 것인지
			final int PAGE_ROW_COUNT=5;
			//하단 페이지를 몇개씩 표시할 것인지
			final int PAGE_DISPLAY_COUNT=5;
					
			//보여줄 페이지의 번호를 일단 1이라고 초기값 지정
			int pageNum=1;
			//페이지 번호가 파라미터로 전달되는지 읽어와 본다.
			String strPageNum=request.getParameter("pageNum");
			//만일 페이지 번호가 파라미터로 넘어 온다면
			if(strPageNum != null){
				//숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum=Integer.parseInt(strPageNum);
				}
					
			//보여줄 페이지의 시작 ROWNUM
			int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
			//보여줄 페이지의 끝 ROWNUM
			int endRowNum=pageNum*PAGE_ROW_COUNT;
					
			/*
				[ 검색 키워드에 관련된 처리 ]
				 -검색 키워드가 파라미터로 넘어올수도 있고 안넘어 올수도 있다.		
			 */
			String keyword=request.getParameter("keyword");
			String condition=request.getParameter("condition");
			//만일 키워드가 넘어오지 않는다면 
			if(keyword==null){
				//키워드가 없으면 null이 되지 않게 공백 처리를 해준다 
				keyword="";
				condition=""; 
				}

			//특수기호를 인코딩한 키워드를 미리 준비한다. 
			String encodedK=URLEncoder.encode(keyword);
						
			//Dto 객체에 startRowNum 과 endRowNum 을 담는다.
				PlanDto dto=new PlanDto();
				dto.setStartRowNum(startRowNum);
				dto.setEndRowNum(endRowNum);

			//만일 검색 키워드가 넘어온다면 
				if(!keyword.equals("")){
					//검색 조건이 무엇이냐에 따라 분기 하기
					if(condition.equals("ST_NAME")){//가게 이름인 경우 
						//검색 키워드를 Dto 에 담아서 전달한다.
						dto.setST_NAME(keyword);
			    	  }else if(condition.equals("ST_ADDRESSDETAIL")){ //주소인 경우 
							dto.setST_ADDRESSDETAIL(keyword);
			    	  }
				}
			 //글 목록 얻어오기 
			 List<PlanDto> list=dao.storeList(dto);
			
			//전체 글의 개수 
			 int totalRow=dao.getCount(dto);
					
			//하단 시작 페이지 번호 
			  int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
			//하단 끝 페이지 번호
			  int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
					

			//전체 페이지의 갯수
			  int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
			//끝 페이지 번호가 전체 페이지 갯수보다 크다면 잘못된 값이다.
			  if(endPageNum > totalPageCount){
				endPageNum=totalPageCount; //보정해준다
				}
			  //view page 에서 필요한 값을 request 에 담아준다. 
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("startPageNum", startPageNum);
				request.setAttribute("endPageNum", endPageNum);
				request.setAttribute("condition", condition);
				request.setAttribute("keyword", keyword);
				request.setAttribute("encodedK", encodedK);
				request.setAttribute("totalPageCount", totalPageCount);
				request.setAttribute("list", list);
				request.setAttribute("totalRow", totalRow);
			}

	
	public List<Map<String, Object>> GetstoreList2(Map<String, Object> map) {
	
		return dao.storeList2(map);
	}

	
	public List<Map<String, Object>> GetdetailList2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.detailList2(map);
	}
	
	public List<Map<String, Object>> GetdetailList3(Map<String, Object> map, String ST_CODE) {
		// TODO Auto-generated method stub
		return dao.detailList3(map);
	}

	}
