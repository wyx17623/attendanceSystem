package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxuwz.bean.BO.SelectCourseID;
import com.gxuwz.bean.BO.actionattendance;
import com.gxuwz.bean.BO.actionstudent;
import com.gxuwz.bean.vo.attendanceStulist;
import com.gxuwz.bean.vo.attendancelist;
import com.gxuwz.bean.vo.attendancelistrecord;
import com.gxuwz.bean.vo.listattendanceStatistics;
import com.gxuwz.bean.vo.studentlist;

public class attendanceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String stuID = request.getParameter("stuID");
		String classID = request.getParameter("classID");
		String type = request.getParameter("type");
		String sign = request.getParameter("sign");

		if (type.equals("list")) {
			if (sign != null) {
				actionattendance as = new actionattendance();

				try {
					List<attendancelist> sl = as.listattendance(classID);
					HttpSession session = request.getSession();
					session.setAttribute("classID", classID);
					request.setAttribute("attendancelist", sl);
					RequestDispatcher rd = request
							.getRequestDispatcher("/page/attendance/attendance_list.jsp");
					rd.forward(request, response);
				} catch (Exception e) {

					e.printStackTrace();
				}
			} else {
				actionattendance as = new actionattendance();
				try {
					List<attendancelist> sl = as.listattendance(classID);
					request.setAttribute("attendancelist", sl);
					RequestDispatcher rd = request
							.getRequestDispatcher("/page/attendance/attendance_list.jsp");
					rd.forward(request, response);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}
		// 将考勤记录插入到数据库：考勤功能
		if (type.equals("add")) {
			HttpSession session = request.getSession();
			int index = (Integer) session.getAttribute("index");
			String teacherID = (String) session.getAttribute("userid");
			classID = (String) session.getAttribute("classID");
			String stuIDarray[] = new String[50];
			List<attendancelist> ls = (List<attendancelist>) session.getAttribute("list");
			Iterator<attendancelist> it = ls.iterator();
			int j = 0;
			while (it.hasNext()) {
				attendancelist st = (attendancelist) it.next();
				stuIDarray[j] = st.getStuID();
				j++;
			}
			String courseID = null;
			try {
				courseID = new SelectCourseID().getCourseID(teacherID, classID);

			} catch (Exception e1) {

				e1.printStackTrace();
			}
			String status = null;
			actionattendance as = new actionattendance();
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String attendanceTime = sf.format(date);
			request.setAttribute("attendanceTime", attendanceTime);
			for (int i = 1; i <= index - 1; i++) {
				status = request.getParameter("status" + i);// 代码凌乱此处应放在Javabean中处理
				stuID = stuIDarray[i - 1];

				try {
					as.addattendance(stuID, courseID, status, attendanceTime,classID);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("/servlet/attendanceServlet?type=attendanceShow");
			rd.forward(request, response);
		}
		// 考勤提交之后的显示界面
		if (type.equals("attendanceShow")) {
			actionattendance as1 = new actionattendance();
			HttpSession session = request.getSession();
			classID = (String) session.getAttribute("classID");
			String attendanceTime = (String) request
					.getAttribute("attendanceTime");
			try {
				List<attendancelist> sl = as1.listattendance(classID,attendanceTime);
				request.setAttribute("attendancelist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/attendance/attendance_show.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		// 教师查询以前的考勤记录
		if (type.equals("listrecord")) {
			actionattendance as1 = new actionattendance();
			HttpSession session = request.getSession();
			String teacherID = (String) session.getAttribute("userid");

			try {
				List<attendancelistrecord> sl = as1
						.listattendancerecord(teacherID);
				request.setAttribute("attendancelistrecord", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/attendance/attendance_showrecord.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}// 教师查看班级的详细情况
		if (type.equals("attendanceClassrecord")) {
			actionattendance as1 = new actionattendance();
			HttpSession session = request.getSession();
			classID = request.getParameter("classID");
			String attendanceTime = request.getParameter("attendanceTime");
			try {
				List<attendancelist> sl = as1.listattendance(classID,attendanceTime);
				request.setAttribute("attendancelist", sl);
				RequestDispatcher rd = request.getRequestDispatcher("/page/attendance/attendance_show.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}// 根据条件筛选班级
		if (type.equals("attendanceStatistics")) {
			actionattendance as1 = new actionattendance();
			String status = request.getParameter("status");
			try {
				List<listattendanceStatistics> sl = as1.attendanceStatistics(classID, status);

				request.setAttribute("listattendanceStatistics", sl);
				RequestDispatcher rd = request.getRequestDispatcher("/page/attendance/attendance_Statistics.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//学生个人考勤记录
		if (type.equals("studentlistrecord")) {
			actionattendance as1 = new actionattendance();
			HttpSession session = request.getSession();
			   stuID = (String) session.getAttribute("userid");
			try {
				List<attendanceStulist> sl = as1.listStuattendancerecord(stuID);
				request.setAttribute("attendanceStulist", sl);
				RequestDispatcher rd = request.getRequestDispatcher("/page/attendance/attendance_Sturecord.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}//根据条件筛选学生个人出勤情况
		if (type.equals("attendanceStuStatistics")) {
			HttpSession session = request.getSession();
			   stuID = (String) session.getAttribute("userid");
			actionattendance as1 = new actionattendance();
			String status = request.getParameter("status");
			try {
				List<listattendanceStatistics> sl = as1.attendanceStuStatistics(stuID, status);

				request.setAttribute("listattendanceStuStatistics", sl);
				RequestDispatcher rd = request.getRequestDispatcher("/page/attendance/attendance_StuStatistics.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
