package com.test.one;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.test.one.Service.PlanService;
import com.test.one.Vo.PlanDto;

@Controller
public class PlanController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PlanController.class);

	@Autowired
	private PlanService service;

	@RequestMapping("/store/test")
	public String GetStoreList(HttpServletRequest request) {

		service.storeList(request);

		System.out.println("storeList 진입");
		return "store/test";
	}

	/*
	 * @RequestMapping("/api/list")
	 * 
	 * @ResponseBody public void storeList2(Map<String, Object> map){
	 * 
	 * }
	 */

	@RequestMapping("/api/list")
	@ResponseBody
	public List<Map<String, Object>> GetStoreList2(Map<String, Object> map, HttpServletRequest request) {
		List<Map<String, Object>> list =service.GetstoreList2(map);
		System.out.println("AJAX" +"--------"+ map );
		/*
		 * //List<Map<String, Object>> list2=service.storeList3(map);
		 * //System.out.println("list" +"--------"+ list); //System.out.println("map"
		 * +"--------"+ map); //List<Map> collection = new Vector<Map>(); //응답 데이터 셋팅
		 * for(int i=0; i<list.size(); i++){ HashMap<String, Object> result=new
		 * HashMap<String,Object>(); PlanDto dto = new PlanDto(); result.put("ST_CODE",
		 * dto.getST_CODE()); result.put("ST_NAME", dto.getST_NAME());
		 * result.put("ST_CONTENT", dto.getST_CONTENT()); result.put("ST_ADDRESSBASIC",
		 * dto.getST_ADDRESSBASIC()); result.put("ST_ADDRESSDETAI",
		 * dto.getST_ADDRESSDETAIL()); result.put("ST_ADDRESSEXTRA",
		 * dto.getST_ADDRESSEXTRA()); result.put("ST_PHNO", dto.getST_PHNO());
		 * result.put("ST_STARTTIME", dto.getST_STARTTIME()); result.put("ST_ENDTIME",
		 * dto.getST_ENDTIME()); result.put("ST_AVGSCORE", dto.getST_AVGSCORE());
		 * //System.out.println("result" +"--------"+ result); //list.add(result);
		 * 
		 * //System.out.println("result" +"--------"+ result);
		 */
		// }
		//System.out.println("result" +"--------"+ result);
		return list;
	}

	@RequestMapping("/api/detail") 
	@ResponseBody
	public List<Map<String, Object>> GetdetailList2(Map<String, Object>map, HttpServletRequest request) { 
		List<Map<String, Object>> detail=service.GetdetailList2(map); 
		//Set<Map<String, Object>> detail2 = newHashSet<Map<String, Object>>(detail);

		System.out.println("AJAX" +"--------"+ detail.get(2).get("ST_NAME"));
		logger.info("허허허?");
		return detail;

	}

	
}