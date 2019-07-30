package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.gxuwz.bean.BO.actiondepartment;
import com.gxuwz.bean.entity.sys_department;


public class departmentServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");       
         	 String type =request.getParameter("type");
    		if(type.equals("list")){
    			actiondepartment as =new actiondepartment();
    			 try {
    				List<sys_department> sl=as.listdepartment();
    				request.setAttribute("departmentlist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}

    		if(type.equals("add")){
    			String depID= request.getParameter("depID");
                String depName = request.getParameter("depName");
                
                actiondepartment as =new actiondepartment(depID,depName);
    			try {
    				as.adddepartment();
    				List<sys_department> sl=as.listdepartment();
    				request.setAttribute("departmentlist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			String depID = request.getParameter("depID");
                String depName = request.getParameter("depName");
               
    			actiondepartment as =new actiondepartment( depID,  depName);
    			try {
    				as.updatedepartment();
    				List<sys_department> sl=as.listdepartment();
    				request.setAttribute("departmentlist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
    		    rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		String depID = request.getParameter("depID");
    		actiondepartment as =new actiondepartment();
    		 try {
    			 as.removedepartment(depID);
    			List<sys_department> sl=as.listdepartment();
    			request.setAttribute("departmentlist",sl);
    			RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
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
