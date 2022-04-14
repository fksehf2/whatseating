package com.test.one.Member.Dto;

public class MemberDto {
	private String id; //회원아이디
	private String pw; //비밀번호
	private String gender; //성별 
	private String email; //이메일
	private String email2; //이메일2
	private String addressNo; //주소1
	private String addressBasic; //주소2
	private String addressDetail; //주소3 
	private String status; //점주 구분 
	private String noshow; //노쇼관련 
	
  public MemberDto() {}

public MemberDto(String id, String pw, String gender, String email, String email2, String addressNo,
		String addressBasic, String addressDetail, String status, String noshow) {
	super();
	this.id = id;
	this.pw = pw;
	this.gender = gender;
	this.email = email;
	this.email2 = email2;
	this.addressNo = addressNo;
	this.addressBasic = addressBasic;
	this.addressDetail = addressDetail;
	this.status = status;
	this.noshow = noshow;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPw() {
	return pw;
}

public void setPw(String pw) {
	this.pw = pw;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getEmail2() {
	return email2;
}

public void setEmail2(String email2) {
	this.email2 = email2;
}

public String getAddressNo() {
	return addressNo;
}

public void setAddressNo(String addressNo) {
	this.addressNo = addressNo;
}

public String getAddressBasic() {
	return addressBasic;
}

public void setAddressBasic(String addressBasic) {
	this.addressBasic = addressBasic;
}

public String getAddressDetail() {
	return addressDetail;
}

public void setAddressDetail(String addressDetail) {
	this.addressDetail = addressDetail;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getNoshow() {
	return noshow;
}

public void setNoshow(String noshow) {
	this.noshow = noshow;
}
  
  
}
