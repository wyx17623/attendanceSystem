<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.liststudent"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectClassName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_classes" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 考勤班级选择页面 -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>在线点名</title>
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

%>
<form method="post" action="servlet/attendanceServlet?type=list&sign=choose" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 考勤</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <li>考勤班级</li>
       <li>
            <select name="classID" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
              <option value="">请选择班级</option>
              <%Iterator<sys_classes> it1 = list1.iterator();
              while(it1.hasNext()){
            		sys_classes st = (sys_classes)it1.next();
            		String classID =st.getClassID();
            		
            		String className =st.getClassName(); %>
              <option value="<%=classID%>"><%=className %></option>
            <%} %>
            </select></li>
          
          
<li> <button class="button bg-main icon-check-square-o" type="submit">确认</button></li>
      </ul>
  
      </div>
   
      
    
  </div>
   
</form>
</body>
</html>
