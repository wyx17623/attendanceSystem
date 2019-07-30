<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listattendanceStatistics"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectClassName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_classes" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>考勤统计信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>
<!--   班级所有学生考勤情况统计页面                             -->
<body>
<%
String userid =(String)session.getAttribute("userid");
  
SelectClassName sc =new SelectClassName();
List<sys_classes> list1 = sc.getClassName(userid); 
  session.setAttribute("classID", request.getParameter("classID"));

%>
    <div class="panel-head"><strong class="icon-reorder"> 考勤统计情况列表</strong> </div>
  
  <form method="post" action="servlet/attendanceServlet?type=add" id="listform">
   <div class="panel admin-panel">
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
       <th>姓名</th>
       <th>学号</th>
       <th>所属班级</th>
       <th>考勤课程</th>
       <th>考勤</th>
       <th>次数</th>
       
      </tr>
    
			<% List<listattendanceStatistics> sl = (List<listattendanceStatistics>)request.getAttribute("listattendanceStatistics");
			
			
			int index=1;
			Iterator<listattendanceStatistics> it = sl.iterator();
			while(it.hasNext()){
				listattendanceStatistics st = (listattendanceStatistics) it.next();
				String stuName =st.getStuName();
				String stuID = st.getStuID();				
				String className = st.getClassName();
				String courseName =st.getCourseName();
				String status = st.getStatus();
				String amount = st.getAmount();
				  %>
		<tr>    
		        <td><%=index++ %></td>
			  	<td><%=stuName %></td>
				<td><%=stuID %></td>
				<td><%=className %></td>
				<td><%=courseName %></td>
				<td><%=status %></td>
				<td><%=amount %></td>
			</tr>
	<%  

	}
			 %>
			 
    </table>
     </div>
  
</form>
</body>
</html>
