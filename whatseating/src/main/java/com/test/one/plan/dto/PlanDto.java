package com.test.one.plan.dto;

public class PlanDto {
	private int ST_CODE; //매장코드
	private String st_manager; //아이디 
	private String ST_NAME; //매장이름
	private String ST_ADDRESSNO; //매장 우편번호
	private String ST_ADDRESSBASIC; //매장 주소 
	private String ST_ADDRESSDETAIL; //주소 상세 
	private String ST_ADDRESSEXTRA; //주소 나머지 
	private String ST_PHNO; //매장 번호
	private String ST_STARTTIME; //매장 시작시간 
	private String ST_ENDTIME; //매장 마감시간
	private String ST_CONTENT; //소개
	private int ST_AVGSCORE; //매장 별점
	private int startRowNum; //시작페이지
	private int endRowNum; //마지막페이지
	private int prevNum; //하단 시작페이지
	private int nextNum; //하단 마지막페이지 
	
	public PlanDto() {}

	public PlanDto(int sT_CODE, String st_manager, String sT_NAME, String sT_ADDRESSNO, String sT_ADDRESSBASIC,
			String sT_ADDRESSDETAIL, String sT_ADDRESSEXTRA, String sT_PHNO, String sT_STARTTIME, String sT_ENDTIME,
			String sT_CONTENT, int sT_AVGSCORE, int startRowNum, int endRowNum, int prevNum, int nextNum) {
		super();
		ST_CODE = sT_CODE;
		this.st_manager = st_manager;
		ST_NAME = sT_NAME;
		ST_ADDRESSNO = sT_ADDRESSNO;
		ST_ADDRESSBASIC = sT_ADDRESSBASIC;
		ST_ADDRESSDETAIL = sT_ADDRESSDETAIL;
		ST_ADDRESSEXTRA = sT_ADDRESSEXTRA;
		ST_PHNO = sT_PHNO;
		ST_STARTTIME = sT_STARTTIME;
		ST_ENDTIME = sT_ENDTIME;
		ST_CONTENT = sT_CONTENT;
		ST_AVGSCORE = sT_AVGSCORE;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
	}

	public int getST_CODE() {
		return ST_CODE;
	}

	public void setST_CODE(int sT_CODE) {
		ST_CODE = sT_CODE;
	}

	public String getSt_manager() {
		return st_manager;
	}

	public void setSt_manager(String st_manager) {
		this.st_manager = st_manager;
	}

	public String getST_NAME() {
		return ST_NAME;
	}

	public void setST_NAME(String sT_NAME) {
		ST_NAME = sT_NAME;
	}

	public String getST_ADDRESSNO() {
		return ST_ADDRESSNO;
	}

	public void setST_ADDRESSNO(String sT_ADDRESSNO) {
		ST_ADDRESSNO = sT_ADDRESSNO;
	}

	public String getST_ADDRESSBASIC() {
		return ST_ADDRESSBASIC;
	}

	public void setST_ADDRESSBASIC(String sT_ADDRESSBASIC) {
		ST_ADDRESSBASIC = sT_ADDRESSBASIC;
	}

	public String getST_ADDRESSDETAIL() {
		return ST_ADDRESSDETAIL;
	}

	public void setST_ADDRESSDETAIL(String sT_ADDRESSDETAIL) {
		ST_ADDRESSDETAIL = sT_ADDRESSDETAIL;
	}

	public String getST_ADDRESSEXTRA() {
		return ST_ADDRESSEXTRA;
	}

	public void setST_ADDRESSEXTRA(String sT_ADDRESSEXTRA) {
		ST_ADDRESSEXTRA = sT_ADDRESSEXTRA;
	}

	public String getST_PHNO() {
		return ST_PHNO;
	}

	public void setST_PHNO(String sT_PHNO) {
		ST_PHNO = sT_PHNO;
	}

	public String getST_STARTTIME() {
		return ST_STARTTIME;
	}

	public void setST_STARTTIME(String sT_STARTTIME) {
		ST_STARTTIME = sT_STARTTIME;
	}

	public String getST_ENDTIME() {
		return ST_ENDTIME;
	}

	public void setST_ENDTIME(String sT_ENDTIME) {
		ST_ENDTIME = sT_ENDTIME;
	}

	public String getST_CONTENT() {
		return ST_CONTENT;
	}

	public void setST_CONTENT(String sT_CONTENT) {
		ST_CONTENT = sT_CONTENT;
	}

	public int getST_AVGSCORE() {
		return ST_AVGSCORE;
	}

	public void setST_AVGSCORE(int sT_AVGSCORE) {
		ST_AVGSCORE = sT_AVGSCORE;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	
	
}
