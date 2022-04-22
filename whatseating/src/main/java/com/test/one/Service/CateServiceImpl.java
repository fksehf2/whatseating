package com.test.one.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.one.Repository.CateDao;
import com.test.one.Vo.CateDto;


@Service
public class CateServiceImpl implements CateService {

	 @Autowired private CateDao dao;

	@Override
	public void cateList(HttpServletRequest request) {
		CateDto dto=new CateDto();
		//글 목록 얻어오기 
		  List<CateDto> cateList=dao.cateList(dto);
		
		  //view page 에서 필요한 값을 request 에 담아준다. 
			request.setAttribute("cateList", cateList);

			}
}