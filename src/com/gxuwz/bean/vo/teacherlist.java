package com.gxuwz.bean.vo;

public class teacherlist {
  private  String teacherID;
  private  String teacherName;
  private  String  sex;
  private  String telephone;
  private  String depName;
  private  String resSec;
public teacherlist(String teacherID, String teacherName, String sex,
		String telephone, String depName, String resSec) {
	super();
	this.teacherID = teacherID;
	this.teacherName = teacherName;
	this.sex = sex;
	this.telephone = telephone;
	this.depName = depName;
	this.resSec = resSec;
}
public String getTeacherID() {
	return teacherID;
}
public void setTeacherID(String teacherID) {
	this.teacherID = teacherID;
}
public String getTeacherName() {
	return teacherName;
}
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getDepName() {
	return depName;
}
public void setDepName(String depName) {
	this.depName = depName;
}
public String getResSec() {
	return resSec;
}
public void setResSec(String resSec) {
	this.resSec = resSec;
}
}
