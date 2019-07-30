package com.gxuwz.bean.vo;

public class attendancelist {
	private String stuID;
	private String className;
	private String stuName;
	private String status;
	public attendancelist(String stuID,String stuName, String className,String status) {
		super();
		this.stuID = stuID;
		this.className = className;
		this.stuName = stuName;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public attendancelist(String stuID, String stuName, String className) {
		super();
		this.stuID = stuID;
		this.className = className;
		this.stuName = stuName;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
}
