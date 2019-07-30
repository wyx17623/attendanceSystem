<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.attendanceStulist"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectClassName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_classes" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 学生查询个人考勤情况筛选列表页面                                                                                     -->

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
<form method="post" action="servlet/attendanceServlet?type=attendanceStuStatistics" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 考勤记录列表</strong> </div>
        <div class="padding border-bottom">
    <ul class="search" style="padding-left:10px;"> 
    <li>考勤统计条件</li>
       
       <li>
            <select name="status" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
              <option value="">请选择查询条件</option>             
              <option value="0">早退</option>
              <option value="1">迟到</option>
              <option value="2">旷课</option>
              <option value="3">请假</option>
              <option value="4">正常</option>
            </select></li>
            <li> <button class="button bg-main icon-check-square-o" type="submit">确认</button></li>
   </ul>
    </div>
    </div>
  </form>
 
  <form method="" action="" id="listform">
   <div class="panel admin-panel">
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
       <th>学号</th>
       <th>姓名</th>
       <th>考勤课程</th>
       <th>出勤状态</th>
       <th>考勤时间</th>
       
      </tr>
    
			<% List<attendanceStulist> sl = (List<attendanceStulist>)request.getAttribute("attendanceStulist");
			
			session.setAttribute("list", sl);
			
			int index=1;
			Iterator<attendanceStulist> it = sl.iterator();
			while(it.hasNext()){
				attendanceStulist st = (attendanceStulist) it.next();
				String stuID = st.getStuID();	
				String stuName =st.getStuName();			
				String courseName = st.getCourseName();
				String status =st.getStatus();
				String attendanceTime = st.getAttendanceTime();
				  %>
		<tr>     <td><%=index++ %></td>
			  	<td><%=stuID %></td>
				<td><%=stuName %></td>
				<td><%=courseName %></td>
				<td><%=status %></td>
				<td><%=attendanceTime %></td>
				<td><div class="button-group"></td>
			</tr>
	<%  

	}
			 %>
			 
    </table>
     </div>
 
</form>
</body>
</html>
