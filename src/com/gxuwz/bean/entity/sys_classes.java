package com.gxuwz.bean.entity;

public class sys_classes {
private String classID;
private String className;
private int  stuNum;
private String  grade;
private String speID;
public String getClassID() {
	return classID;
}
public void setClassID(String classID) {
	this.classID = classID;
}
public String getClassName() {
	return className;
}
public sys_classes(String classID, String className) {
	super();
	this.classID = classID;
	this.className = className;
}
public void setClassName(String className) {
	this.className = className;
}
public int getStuNum() {
	return stuNum;
}
public sys_classes(String classID, String className, int stuNum,
		String grade, String speID) {
	super();
	this.classID = classID;
	this.className = className;
	this.stuNum = stuNum;
	this.grade = grade;
	this.speID = speID;
}
public void setStuNum(int classNum) {
	this.stuNum = classNum;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getSpeID() {
	return speID;
}
public void setSpeID(String speID) {
	this.speID = speID;
}

}
