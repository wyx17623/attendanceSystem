package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.bean.BO.actionteacher;
import com.gxuwz.bean.vo.teacherlist;

public class teacherServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
			String teacherID = request.getParameter("teacherID");
			String teacherName = request.getParameter("teacherName");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("telephone");
			String depID =request.getParameter("depID");
			String resSec =request.getParameter("resSec");
			String type =request.getParameter("type");
		
			if(type.equals("list")){
				actionteacher as =new actionteacher();
				 try {
					List<teacherlist> sl=as.listteacher();
					
					request.setAttribute("teacherlist",sl);
					RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
				      rd.forward(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}

			if(type.equals("add")){
				actionteacher as =new actionteacher(teacherID,  teacherName,  sex, telephone,  depID,resSec);
				try {
					as.addteacher();
					List<teacherlist> sl=as.listteacher();
					request.setAttribute("teacherlist",sl);
				} catch (Exception e) {
					e.printStackTrace();
				}
				RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
			      rd.forward(request, response);
			}
			if(type.equals("update")){
				actionteacher as =new actionteacher(teacherID,  teacherName,  sex, telephone,  depID,  resSec);
				try {
					as.updateteacher();
					List<teacherlist> sl=as.listteacher();
					request.setAttribute("teacherlist",sl);
				} catch (Exception e) {
					e.printStackTrace();
				}
				RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
			      rd.forward(request, response);
			}
		if(type.equals("remove")){
			
			actionteacher as =new actionteacher();
			 try {
				 as.removeteacher(teacherID);
				List<teacherlist> sl=as.listteacher();
				request.setAttribute("teacherlist",sl);
				RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			}
		}
		
		
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             doGet(request,response);
		
	}



}
