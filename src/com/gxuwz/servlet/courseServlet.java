package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.bean.BO.actioncourse;
import com.gxuwz.bean.vo.courselist;

public class courseServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
             String courseID = request.getParameter("courseID");
             String courseName = request.getParameter("courseName");
             String credit = request.getParameter("credit");
             String teacherID = request.getParameter("teacherID");
             String period = request.getParameter("period");
             String courseTime = request.getParameter("courseTime");
             String courseSite = request.getParameter("courseSite");
             String term = request.getParameter("term");
             String classID = request.getParameter("classID");
         	String type =request.getParameter("type");
        	
    		if(type.equals("list")){
    			actioncourse as =new actioncourse();
    			 try {
    				List<courselist> sl=as.listcourse();
    				request.setAttribute("courselist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/course/course_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}

    		if(type.equals("add")){
    			actioncourse as =new actioncourse(courseID,  courseName,  credit, teacherID,  period,  courseTime,  courseSite,term,classID);
    			try {
    				as.addcourse();
    				List<courselist> sl=as.listcourse();
    				request.setAttribute("courselist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/course/course_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			actioncourse as =new actioncourse(courseID,  courseName,  credit, teacherID,  period,  courseTime,  courseSite,term,classID);
    			try {
    				as.updatecourse();
    				List<courselist> sl=as.listcourse();
    				
    				request.setAttribute("courselist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/course/course_list.jsp");
    		      rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		
    		actioncourse as =new actioncourse();
    		 try {
    			 as.removecourse(courseID);
    			List<courselist> sl=as.listcourse();
    			request.setAttribute("courselist",sl);
    			RequestDispatcher rd=request.getRequestDispatcher("/page/course/course_list.jsp");
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
