package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.bean.BO.actionclass;
import com.gxuwz.bean.BO.actioncourse;
import com.gxuwz.bean.entity.sys_classes;
import com.gxuwz.bean.vo.courselist;

public class classServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
             
         	 String type =request.getParameter("type");
        	
    		if(type.equals("list")){
    			actionclass as =new actionclass();
    			 try {
    				List<sys_classes> sl=as.listclasses();
    				request.setAttribute("classeslist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}

    		if(type.equals("add")){
    			String classID = request.getParameter("classID");
                String className = request.getParameter("className");
                int stuNum = Integer.parseInt(request.getParameter("stuNum"));
                String grade = request.getParameter("grade");
                String speID = request.getParameter("speID");
    			actionclass as =new actionclass( classID,  className,  stuNum, grade,  speID);
    			try {
    				as.addclasses();
    				List<sys_classes> sl=as.listclasses();
    				request.setAttribute("classeslist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			String classID = request.getParameter("classID");
                String className = request.getParameter("className");
                int stuNum = Integer.parseInt(request.getParameter("stuNum"));
                String grade = request.getParameter("grade");
                String speID = request.getParameter("speID");
    			actionclass as =new actionclass( classID,  className,  stuNum, grade,  speID);
    			try {
    				as.updateclasses();
    				List<sys_classes> sl=as.listclasses();
    				request.setAttribute("classeslist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    		    rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		String classID = request.getParameter("classID");
    		actionclass as =new actionclass();
    		 try {
    			 as.removeclasses(classID);
    			List<sys_classes> sl=as.listclasses();
    			request.setAttribute("classeslist",sl);
    			RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
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
