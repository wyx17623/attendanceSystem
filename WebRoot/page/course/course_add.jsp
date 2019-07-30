<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectTeacher" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_teacher" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectClassName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_classes" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listteacher"%>

<%@ page language="java" import="java.sql.*" %>
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
<title>课程添加</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%  
    SelectTeacher st =new SelectTeacher();
    List<sys_teacher> list = st.getTeacher(); 
    SelectClassName sc =new SelectClassName();
    List<sys_classes> list1 = sc.getClassName(); 
    
     
    %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加课程</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/courseServlet?type=add">  
      <div class="form-group">
        <div class="label">
          <label>课程编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="courseID"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>课程名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="courseName"   />
          <div class="tips"></div>
        </div>
      </div>
     <div class="form-group">
        <div class="label">
          <label>课程学分：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="credit"   />
          <div class="tips"></div>
        </div>
      </div>
     
           <div class="form-group">
        <div class="label">
          <label>授课老师：</label>
        </div>
         <select name="teacherID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             <%
             %>
        <%
        
        Iterator<sys_teacher> it1 = list.iterator();
		while(it1.hasNext()){
			sys_teacher s = (sys_teacher) it1.next();
			String teacherID =s.getTeacherID();
			
			String teacherName =s.getTeacherName();
        %>       
             <option value="<%=teacherID%>"><%=teacherName %></option>
            
      <%} %>
      </select></div>
        <div class="form-group">
        <div class="label">
          <label>学时：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="period"   />
          <div class="tips"></div>
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label>上课时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="courseTime" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>上课地点：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="courseSite" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
        <div class="form-group">
        <div class="label">
          <label>学期：</label>
        </div>
         <select name="term" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
           
            <option value="1">第一学期</option>
            <option value="2">第二学期</option>
      </select></div>
       <div class="form-group">
        <div class="label">
          <label>所属班级：</label>
        </div>
         <select name="classID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             
        <%
        
        Iterator<sys_classes> it2 = list1.iterator();
		while(it2.hasNext()){
			sys_classes sc1 = (sys_classes)it2.next();
			String classID =sc1.getClassID();
			
			String className =sc1.getClassName();
        %>       
             <option value="<%=classID%>"><%=className %></option>
            
      <%} %>
      </select></div>
     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div> </form>
      </div>
    
  </div>


</body>
</html>
