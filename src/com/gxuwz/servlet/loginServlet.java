package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

import com.gxuwz.base.database;
import com.gxuwz.base.base;
public class loginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		 String password =request.getParameter("password");
		 String type =request.getParameter("type");
		 boolean flag=false;
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs =null;
		 
		 try{
		 //2:身份认证
		  	conn=database.getConn();
		  	String sql="select * from sys_user where userid=? and password=? and type=?";
		  	pstmt=conn.prepareStatement(sql);
		 //设置动态参数对应的值
		  	int index=1;
		  	pstmt.setString(index++, userid);
		  	pstmt.setString(index++, password);
		  	pstmt.setString(index++, type);
		 //执行查询
		  	rs=pstmt.executeQuery();
		  	flag=rs.next();
		   }catch(SQLException e){
		     e.printStackTrace();
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			database.close(rs, pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 //3:跳转目标页面
		  if(flag){
			//将用户编号绑定到session对象，方便功能菜单取值
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			if(type.equals("0")){
				 base.process(request, response, "/manager_index.jsp");
			}
			else if(type.equals("1")){
		    base.process(request, response, "/teacher_index.jsp");
			}
		else if(type.equals("2")){
			    base.process(request, response, "/student_index.jsp");
				}
		  }else if(type.equals("loginout")){
			  String path = request.getContextPath();
			  HttpSession session = request.getSession();
			  session.invalidate();
			  response.sendRedirect(path+"/login.jsp");
		  }
		  else{
		    base.process(request, response, "/login.jsp");
		  }
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              doGet(request,response);
	}

}
