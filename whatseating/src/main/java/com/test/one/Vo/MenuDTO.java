package com.test.one.Vo;

import java.util.List;

public class MenuDTO {
	
	private int MENU_NUM;
	private int ST_CODE;
	private String MENU_NAME;
	private int MENU_PRICE;
	private String MENU_CONTENT;
	private String MENU_REGMANAGER;
	private String MENU_REGDATE;
	private String MENU_UPDMANAGER;
	private String MENU_UPDDATE;
	private List<FileInfoDTO> FILEINFOS;
	
	
	public int getMENU_NUM() {
		return MENU_NUM;
	}
	public void setMENU_NUM(int mENU_NUM) {
		MENU_NUM = mENU_NUM;
	}
	public int getST_CODE() {
		return ST_CODE;
	}
	public void setST_CODE(int sT_CODE) {
		ST_CODE = sT_CODE;
	}
	public String getMENU_NAME() {
		return MENU_NAME;
	}
	public void setMENU_NAME(String mENU_NAME) {
		MENU_NAME = mENU_NAME;
	}
	public int getMENU_PRICE() {
		return MENU_PRICE;
	}
	public void setMENU_PRICE(int mENU_PRICE) {
		MENU_PRICE = mENU_PRICE;
	}
	public String getMENU_CONTENT() {
		return MENU_CONTENT;
	}
	public void setMENU_CONTENT(String mENU_CONTENT) {
		MENU_CONTENT = mENU_CONTENT;
	}
	public String getMENU_REGMANAGER() {
		return MENU_REGMANAGER;
	}
	public void setMENU_REGMANAGER(String mENU_REGMANAGER) {
		MENU_REGMANAGER = mENU_REGMANAGER;
	}
	public String getMENU_REGDATE() {
		return MENU_REGDATE;
	}
	public void setMENU_REGDATE(String mENU_REGDATE) {
		MENU_REGDATE = mENU_REGDATE;
	}
	public String getMENU_UPDMANAGER() {
		return MENU_UPDMANAGER;
	}
	public void setMENU_UPDMANAGER(String mENU_UPDMANAGER) {
		MENU_UPDMANAGER = mENU_UPDMANAGER;
	}
	public String getMENU_UPDDATE() {
		return MENU_UPDDATE;
	}
	public void setMENU_UPDDATE(String mENU_UPDDATE) {
		MENU_UPDDATE = mENU_UPDDATE;
	}
	public List<FileInfoDTO> getFILEINFOS() {
		return FILEINFOS;
	}
	public void setFILEINFOS(List<FileInfoDTO> fILEINFOS) {
		FILEINFOS = fILEINFOS;
	}
	
}
