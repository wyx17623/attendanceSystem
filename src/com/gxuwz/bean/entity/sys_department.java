package com.gxuwz.bean.entity;

public class sys_department {
       private String  depID;
       private String  depName;
	public sys_department(String depID, String depName) {
		super();
		this.depID = depID;
		this.depName = depName;
	}
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
}
