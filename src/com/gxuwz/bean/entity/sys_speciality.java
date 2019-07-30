package com.gxuwz.bean.entity;

public class sys_speciality {
private String speID;
private String speName;
private String depID;
public String getSpeID() {
	return speID;
}
public void setSpeID(String speID) {
	this.speID = speID;
}
public String getSpeName() {
	return speName;
}
public void setSpeName(String speName) {
	this.speName = speName;
}
public String getDepID() {
	return depID;
}
public void setDepID(String depID) {
	this.depID = depID;
}
public sys_speciality(String speID, String speName, String depID) {
	super();
	this.speID = speID;
	this.speName = speName;
	this.depID = depID;
}
public sys_speciality(String speID, String speName) {
	super();
	this.speID = speID;
	this.speName = speName;
}
}
