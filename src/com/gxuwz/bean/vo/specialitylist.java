package com.gxuwz.bean.vo;

public class specialitylist {
private String speID;
private String SpeName;
private String depName;
public specialitylist() {
	super();
}
public specialitylist(String speID, String speName, String depName) {
	super();
	this.speID = speID;
	SpeName = speName;
	this.depName = depName;
}
public String getSpeID() {
	return speID;
}
public void setSpeID(String speID) {
	this.speID = speID;
}
public String getSpeName() {
	return SpeName;
}
public void setSpeName(String speName) {
	SpeName = speName;
}
public String getDepName() {
	return depName;
}
public void setDepName(String depName) {
	this.depName = depName;
}
}
