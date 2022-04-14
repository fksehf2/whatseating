package com.test.one.plan.dto;

public class CateDto {
	private int CA_CODE; //카테고리 분류 
	private String CA_NAME; //카테고리 이름
	private String ETC_1; //카테고리 이미지 
	
	public CateDto() {}

	public CateDto(int cA_CODE, String cA_NAME, String eTC_1) {
		super();
		CA_CODE = cA_CODE;
		CA_NAME = cA_NAME;
		ETC_1 = eTC_1;
	}

	public int getCA_CODE() {
		return CA_CODE;
	}

	public void setCA_CODE(int cA_CODE) {
		CA_CODE = cA_CODE;
	}

	public String getCA_NAME() {
		return CA_NAME;
	}

	public void setCA_NAME(String cA_NAME) {
		CA_NAME = cA_NAME;
	}

	public String getETC_1() {
		return ETC_1;
	}

	public void setETC_1(String eTC_1) {
		ETC_1 = eTC_1;
	}
	
	

}
