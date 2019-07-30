package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_classes;
import com.gxuwz.bean.vo.courselist;
import com.gxuwz.bean.vo.specialitylist;

public class actionspeciality {
	private String speID;
	private String speName;
	private String depID;

	public actionspeciality(String speID, String speName, String depID) {
		super();
		this.speID = speID;
		this.speName = speName;
		this.depID = depID;
	}

	public actionspeciality() {
		super();
	}

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

	public List<specialitylist> listspeciality() throws Exception {

		String sql = "select speID,speName,depName from sys_speciality,sys_department where sys_department.depID=sys_speciality.depID";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		// 定义int序号变量

		List<specialitylist> ls = new ArrayList<specialitylist>();
		while (rs.next()) {
			speID = rs.getString("speID");
			speName = rs.getString("speName");
	 String depName = rs.getString("depName");
		

	 specialitylist sl = new specialitylist(speID, speName, depName);
			ls.add(sl);

		}

		return ls;
	}

	public void addspeciality() throws Exception {

		String sql = "insert into sys_speciality(speID,speName,depID) values(?,?,?)";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, speID);
		pstmt.setString(Index++, speName);
		pstmt.setString(Index++, depID);
		
		 pstmt.executeUpdate();
		// 定义int序号变量

	}

	public void updatespeciality() throws Exception {
		String sql = "update sys_speciality set speName=?,depID=? where speID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, speName);
		pstmt.setString(Index++, depID);
		pstmt.setString(Index++, speID);
		pstmt.executeUpdate();
		// 定义int序号变量

	}

	public void removespeciality(String speID) throws Exception {
		Connection conn = database.getConn();
		String sql = "delete from sys_speciality where speID=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int parameterIndex = 1;
		pstmt.setString(parameterIndex, speID);

		int count = pstmt.executeUpdate();

		database.close(pstmt, conn);
	}
}
