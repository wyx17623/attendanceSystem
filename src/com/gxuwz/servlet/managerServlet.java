package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.bean.BO.actionmanager;
import com.gxuwz.bean.vo.managerlist;

public class managerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String fullname = request.getParameter("fullname");
		String telephone = request.getParameter("telephone");
		String password =request.getParameter("password");
		String type = request.getParameter("type");
		if(type.equals("list")){
			actionmanager as =new actionmanager();
			 try {
				List<managerlist> sl=as.listmanager();
				request.setAttribute("managerlist",sl);
				RequestDispatcher rd=request.getRequestDispatcher("/page/manager/manager_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		
		if(type.equals("update")){
			actionmanager as =new actionmanager(userid,  fullname,  telephone, password);
			try {
				as.updatemanager();
				List<managerlist> sl=as.listmanager();
				request.setAttribute("managerlist",sl);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("/page/manager/manager_list.jsp");
		      rd.forward(request, response);
		}
	
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					doGet(request,response);
	}



}
