package com.gxuwz.bean.vo;

public class attendancelistrecord {
 private String classID;
 private String className;
 private String courseName;
 private String attendanceTime;
public String getClassID() {
	return classID;
}
public void setClassID(String classID) {
	this.classID = classID;
}
public attendancelistrecord() {
	super();
}
public attendancelistrecord(String classID, String className,
		String courseName, String attendanceTime) {
	super();
	this.classID = classID;
	this.className = className;
	this.courseName = courseName;
	this.attendanceTime = attendanceTime;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getAttendanceTime() {
	return attendanceTime;
}
public void setAttendanceTime(String attendanceTime) {
	this.attendanceTime = attendanceTime;
}
}
