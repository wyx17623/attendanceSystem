package com.gxuwz.bean.vo;

public class listattendanceStatistics {
private String stuID;
private String stuName;
private String className;
private String status;
private String courseName;
private String amount;
public String getStuID() {
	return stuID;
}
public void setStuID(String stuID) {
	this.stuID = stuID;
}
public listattendanceStatistics(String stuID, String stuName, String status,
		String courseName, String amount) {
	super();
	this.stuID = stuID;
	this.stuName = stuName;
	this.status = status;
	this.courseName = courseName;
	this.amount = amount;
}
public String getStuName() {
	return stuName;
}
public void setStuName(String stuName) {
	this.stuName = stuName;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getCourseName() {
	return courseName;
}
public listattendanceStatistics() {
	super();
}
public listattendanceStatistics(String stuID, String stuName, String className,
		String status, String courseName, String amount) {
	super();
	this.stuID = stuID;
	this.stuName = stuName;
	this.className = className;
	this.status = status;
	this.courseName = courseName;
	this.amount = amount;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
}
