<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.attendancelistrecord"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectClassName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_classes" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 教师考勤情况的班级记录列表页面                                                                                     -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>考勤信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%
String userid =(String)session.getAttribute("userid");
  
SelectClassName sc =new SelectClassName();
List<sys_classes> list1 = sc.getClassName(userid); 
  session.setAttribute("classID", request.getParameter("classID"));

%>
<form method="post" action="servlet/attendanceServlet?type=list&sign=choose" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 考勤记录列表</strong> </div>
   
    </div>
  </form>
 
  <form method="post" action="servlet/attendanceServlet?type=add" id="listform">
   <div class="panel admin-panel">
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
       <th>班号</th>
       <th>班级名称</th>
       <th>考勤课程</th>
       <th>考勤时间</th>
       <th>操作</th>
       
      </tr>
    
			<% List<attendancelistrecord> sl = (List<attendancelistrecord>)request.getAttribute("attendancelistrecord");
			
			session.setAttribute("list", sl);
			
			int index=1;
			Iterator<attendancelistrecord> it = sl.iterator();
			while(it.hasNext()){
				attendancelistrecord st = (attendancelistrecord) it.next();
				String classID = st.getClassID();	
				String className =st.getClassName();			
				String courseName = st.getCourseName();
				String attendanceTime = st.getAttendanceTime();
				  %>
		<tr>     <td><%=index++ %></td>
			  	<td><%=classID %></td>
				<td><%=className %></td>
				<td><%=courseName %></td>
				<td><%=attendanceTime %></td>
				<td><div class="button-group">
				 <a class="button border-main" href="servlet/attendanceServlet?type=attendanceClassrecord&classID=<%=classID%>&attendanceTime=<%= attendanceTime%>"><span class="icon-edit"></span> 查看</a> </div>
				 </td>
			</tr>
	<%  

	}
			 %>
			 
    </table>
     </div>
  
</form>
</body>
</html>
