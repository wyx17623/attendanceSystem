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
import com.gxuwz.bean.BO.actionspeciality;
import com.gxuwz.bean.entity.sys_classes;
import com.gxuwz.bean.vo.courselist;
import com.gxuwz.bean.vo.specialitylist;

public class specialityServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
             
         	 String type =request.getParameter("type");
        	
    		if(type.equals("list")){
    			actionspeciality as =new actionspeciality();
    			 try {
    				List<specialitylist> sl=as.listspeciality();
    				request.setAttribute("specialitylist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/speciality/speciality_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}

    		if(type.equals("add")){
    			String speID = request.getParameter("speID");
                String speName = request.getParameter("speName");
               
                String depID = request.getParameter("depID");
    			actionspeciality as =new actionspeciality( speID,  speName,  depID);
    			try {
    				as.addspeciality();
    				List<specialitylist> sl=as.listspeciality();
    				request.setAttribute("specialitylist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/speciality/speciality_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			String speID = request.getParameter("speID");
                String speName = request.getParameter("speName");
                String depID = request.getParameter("depID");
                
    			actionspeciality  as =new actionspeciality(speID, speName, depID);
    			try {
    				as.updatespeciality ();
    				List<specialitylist> sl=as.listspeciality();
    				request.setAttribute("specialitylist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/speciality/speciality_list.jsp");
    		    rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		String speID = request.getParameter("speID");
    		actionspeciality as =new actionspeciality();
    		 try {
    			 as.removespeciality(speID);
    			List<specialitylist> sl=as.listspeciality();
    			request.setAttribute("specialitylist",sl);
    			RequestDispatcher rd=request.getRequestDispatcher("/page/speciality/speciality_list.jsp");
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
