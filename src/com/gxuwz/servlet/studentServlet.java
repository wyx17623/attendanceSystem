package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.bean.BO.actionstudent;
import com.gxuwz.bean.vo.studentlist;
/*
 * Ñ§ÉúÌí¼ÓServlet
 */
public class studentServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		String stuID = request.getParameter("stuID");
		String stuName = request.getParameter("stuName");
		String sex = request.getParameter("sex");
		String classID =request.getParameter("classID");
		String depID =request.getParameter("depID");
		String speID = request.getParameter("speID");
		String stuTel = request.getParameter("stuTel");
		String address = request.getParameter("address");
		String type =request.getParameter("type");
	
		if(type.equals("list")){
			actionstudent as =new actionstudent();
			 try {
				List<studentlist> sl=as.liststudent();
				request.setAttribute("studentlist",sl);
				RequestDispatcher rd=request.getRequestDispatcher("/page/student/student_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		if(type.equals("add")){
			actionstudent as =new actionstudent(stuID,  stuName,  sex, classID,  depID,  speID,  stuTel,address);
			try {
				as.addstudent();
				List<studentlist> sl=as.liststudent();
				request.setAttribute("studentlist",sl);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("/page/student/student_list.jsp");
		      rd.forward(request, response);
		}
		if(type.equals("update")){
			actionstudent as =new actionstudent(stuID,  stuName,  sex, classID,  depID,  speID,  stuTel,address);
			try {
				as.updatestudent();
				List<studentlist> sl=as.liststudent();
				
				request.setAttribute("studentlist",sl);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("/page/student/student_list.jsp");
		      rd.forward(request, response);
		}
	if(type.equals("remove")){
		
		actionstudent as =new actionstudent();
		 try {
			 as.removestudent(stuID);
			List<studentlist> sl=as.liststudent();
			request.setAttribute("studentlist",sl);
			RequestDispatcher rd=request.getRequestDispatcher("/page/student/student_list.jsp");
		      rd.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		}
	if(type.equals("personallist")){
		actionstudent as =new actionstudent();
		 try {
			List<studentlist> sl=as.liststudent(stuID);
			request.setAttribute("studentlist",sl);
			RequestDispatcher rd=request.getRequestDispatcher("/page/student/student_personalList.jsp");
		      rd.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	if(type.equals("persionalupdate")){
		actionstudent as =new actionstudent(stuID,  stuName,  sex, classID,  depID,  speID,  stuTel,address);
		try {
			as.updatestudent();
			List<studentlist> sl=as.liststudent(stuID);	
			request.setAttribute("studentlist",sl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("/page/student/student_personalList.jsp");
	      rd.forward(request, response);
	}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
              this.doGet(request,response);
		
	}

	
	

}
