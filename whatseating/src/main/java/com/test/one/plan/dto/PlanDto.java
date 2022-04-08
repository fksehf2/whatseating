package com.test.one.plan.dto;

public class PlanDto {
	private int num; //번호
	private int st_code; //매장코드
	private String st_name; //매장이름
	private String st_menu; //메뉴
	private String st_content; //소개
	private String st_addressNo; //주소1
	private String st_addressBasic; //주소2
	private String st_addressDetail; //주소3
	private String st_addressExtra; //주소4
	private String st_PHNO; //번호
	private String st_startTime; //오픈
	private String st_endTime; //마감
	private String st_avgScore; //별점
	
	public PlanDto() {}

	public PlanDto(int num, int st_code, String st_name, String st_menu, String st_content, String st_addressNo,
			String st_addressBasic, String st_addressDetail, String st_addressExtra, String st_PHNO,
			String st_startTime, String st_endTime, String st_avgScore) {
		super();
		this.num = num;
		this.st_code = st_code;
		this.st_name = st_name;
		this.st_menu = st_menu;
		this.st_content = st_content;
		this.st_addressNo = st_addressNo;
		this.st_addressBasic = st_addressBasic;
		this.st_addressDetail = st_addressDetail;
		this.st_addressExtra = st_addressExtra;
		this.st_PHNO = st_PHNO;
		this.st_startTime = st_startTime;
		this.st_endTime = st_endTime;
		this.st_avgScore = st_avgScore;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSt_code() {
		return st_code;
	}

	public void setSt_code(int st_code) {
		this.st_code = st_code;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getSt_menu() {
		return st_menu;
	}

	public void setSt_menu(String st_menu) {
		this.st_menu = st_menu;
	}

	public String getSt_content() {
		return st_content;
	}

	public void setSt_content(String st_content) {
		this.st_content = st_content;
	}

	public String getSt_addressNo() {
		return st_addressNo;
	}

	public void setSt_addressNo(String st_addressNo) {
		this.st_addressNo = st_addressNo;
	}

	public String getSt_addressBasic() {
		return st_addressBasic;
	}

	public void setSt_addressBasic(String st_addressBasic) {
		this.st_addressBasic = st_addressBasic;
	}

	public String getSt_addressDetail() {
		return st_addressDetail;
	}

	public void setSt_addressDetail(String st_addressDetail) {
		this.st_addressDetail = st_addressDetail;
	}

	public String getSt_addressExtra() {
		return st_addressExtra;
	}

	public void setSt_addressExtra(String st_addressExtra) {
		this.st_addressExtra = st_addressExtra;
	}

	public String getSt_PHNO() {
		return st_PHNO;
	}

	public void setSt_PHNO(String st_PHNO) {
		this.st_PHNO = st_PHNO;
	}

	public String getSt_startTime() {
		return st_startTime;
	}

	public void setSt_startTime(String st_startTime) {
		this.st_startTime = st_startTime;
	}

	public String getSt_endTime() {
		return st_endTime;
	}

	public void setSt_endTime(String st_endTime) {
		this.st_endTime = st_endTime;
	}

	public String getSt_avgScore() {
		return st_avgScore;
	}

	public void setSt_avgScore(String st_avgScore) {
		this.st_avgScore = st_avgScore;
	}

	

}
