package com.gxuwz.bean.vo;

public class managerlist {
 private  String userid;
 private  String fullname;
 private  String telephone;
 private  String password;
public managerlist(String userid, String fullname, String telephone,
		String password) {
	super();
	this.userid = userid;
	this.fullname = fullname;
	this.telephone = telephone;
	this.password = password;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
