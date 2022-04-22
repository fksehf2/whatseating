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
import com.test.one.Repository.PlanDao;
import com.test.one.Vo.PlanDto;

@Service
public class PlanServiceImpl implements PlanService {

	 @Autowired private PlanDao dao;

	@Override
	public void storeList(HttpServletRequest request) {
	
		//�븳 �럹�씠吏��뿉 紐뉕컻�뵫 �몴�떆�븷 寃껋씤吏�
		final int PAGE_ROW_COUNT=5;
		//�븯�떒 �럹�씠吏�瑜� 紐뉕컻�뵫 �몴�떆�븷 寃껋씤吏�
		final int PAGE_DISPLAY_COUNT=5;
				
		//蹂댁뿬以� �럹�씠吏��쓽 踰덊샇瑜� �씪�떒 1�씠�씪怨� 珥덇린媛� 吏��젙
		int pageNum=1;
		//�럹�씠吏� 踰덊샇媛� �뙆�씪誘명꽣濡� �쟾�떖�릺�뒗吏� �씫�뼱�� 蹂몃떎.
		String strPageNum=request.getParameter("pageNum");
		//留뚯씪 �럹�씠吏� 踰덊샇媛� �뙆�씪誘명꽣濡� �꽆�뼱 �삩�떎硫�
		if(strPageNum != null){
		//�닽�옄濡� 諛붽퓭�꽌 蹂댁뿬以� �럹�씠吏� 踰덊샇濡� 吏��젙�븳�떎.
		pageNum=Integer.parseInt(strPageNum);
		}
				
		//蹂댁뿬以� �럹�씠吏��쓽 �떆�옉 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//蹂댁뿬以� �럹�씠吏��쓽 �걹 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
				
		/*
			[ 寃��깋 �궎�썙�뱶�뿉 愿��젴�맂 泥섎━ ]
			 -寃��깋 �궎�썙�뱶媛� �뙆�씪誘명꽣濡� �꽆�뼱�삱�닔�룄 �엳怨� �븞�꽆�뼱 �삱�닔�룄 �엳�떎.		
		*/
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		//留뚯씪 �궎�썙�뱶媛� �꽆�뼱�삤吏� �븡�뒗�떎硫� 
		if(keyword==null){
			//�궎�썙�뱶�� 寃��깋 議곌굔�뿉 鍮� 臾몄옄�뿴�쓣 �꽔�뼱以��떎. 
			//�겢�씪�씠�뼵�듃 �쎒釉뚮씪�슦���뿉 異쒕젰�븷�븣 "null" �쓣 異쒕젰�릺吏� �븡寃� �븯湲� �쐞�빐�꽌  
			keyword="";
			condition=""; 
			}

		//�듅�닔湲고샇瑜� �씤肄붾뵫�븳 �궎�썙�뱶瑜� 誘몃━ 以�鍮꾪븳�떎. 
		String encodedK=URLEncoder.encode(keyword);
					
		//CafeDto 媛앹껜�뿉 startRowNum 怨� endRowNum �쓣 �떞�뒗�떎.
			PlanDto dto=new PlanDto();
			dto.setStartRowNum(startRowNum);
			dto.setEndRowNum(endRowNum);

		//留뚯씪 寃��깋 �궎�썙�뱶媛� �꽆�뼱�삩�떎硫� 
			if(!keyword.equals("")){
				//寃��깋 議곌굔�씠 臾댁뾿�씠�깘�뿉 �뵲�씪 遺꾧린 �븯湲�
				if(condition.equals("ST_NAME")){//媛�寃뚯씠由� 寃��깋�씤 寃쎌슦
					//寃��깋 �궎�썙�뱶瑜� dto �뿉 �떞�븘�꽌 �쟾�떖�븳�떎.
					dto.setST_NAME(keyword);
		    	  }else if(condition.equals("ST_ADDRESSDETAIL")){ //二쇱냼 寃��깋�씤 寃쎌슦
						dto.setST_ADDRESSDETAIL(keyword);
		    	  }
			}
		//湲� 紐⑸줉 �뼸�뼱�삤湲� 
		  List<PlanDto> list=dao.storeList(dto);
		//�쟾泥닿��쓽 媛��닔
		  int totalRow=dao.getCount(dto);
				
		//�븯�떒 �떆�옉 �럹�씠吏� 踰덊샇 
		  int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//�븯�떒 �걹 �럹�씠吏� 踰덊샇
		  int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
				

		//�쟾泥� �럹�씠吏��쓽 媛��닔
		  int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//�걹 �럹�씠吏� 踰덊샇媛� �쟾泥� �럹�씠吏� 媛��닔蹂대떎 �겕�떎硫� �옒紐삳맂 媛믪씠�떎.
		  if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; //蹂댁젙�빐 以��떎.
			}
		  //view page �뿉�꽌 �븘�슂�븳 媛믪쓣 request �뿉 �떞�븘以��떎. 
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

	@Override
	public List<Map<String, Object>> GetstoreList2(Map<String, Object> map) {
	
		return dao.storeList2(map);
	}

	@Override
	public List<Map<String, Object>> GetdetailList2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.detailList2(map);
	}

	}
