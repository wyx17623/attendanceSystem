<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectDepName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_department" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectClassName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_classes" %>
<%@ page language="java" import="com.gxuwz.bean.vo.liststudent"%>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_speciality" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectSpeciality" %>
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
<title>学生列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%  
SelectDepName sd =new SelectDepName(); 
    List<sys_department> list = sd.getDepName(); 
    SelectClassName sc =new SelectClassName();
    List<sys_classes> list1 = sc.getClassName(); 
    SelectSpeciality ss =new SelectSpeciality();
    List<sys_speciality> list2 = ss.getSpeName(); 
    %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加学生</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/studentServlet?type=add">  
      <div class="form-group">
        <div class="label">
          <label>学生编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="stuID"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>学生姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="stuName"   />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
         <select name="sex" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
           
            <option value="男">男</option>
            <option value="女">女</option>
      </select></div>
     
           <div class="form-group">
        <div class="label">
          <label>所属班级：</label>
        </div>
         <select name="classID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             
        <%
        
        Iterator<sys_classes> it1 = list1.iterator();
		while(it1.hasNext()){
			sys_classes st = (sys_classes)it1.next();
			String classID =st.getClassID();
			
			String className =st.getClassName();
        %>       
             <option value="<%=classID%>"><%=className %></option>
            
      <%} %>
      </select></div>
    <div class="form-group">
        <div class="label">
          <label>所属专业：</label>
        </div>
         <select name="speID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             <%
             %>
        <%
        
        Iterator<sys_speciality> it2 = list2.iterator();
		while(it2.hasNext()){
			sys_speciality st = (sys_speciality) it2.next();
			String speID =st.getSpeID();
			
			String speName =st.getSpeName();
        %>       
             <option value="<%=speID%>"><%=speName %></option>
            
      <%} %>
      </select></div>
      <div class="form-group">
        <div class="label">
          <label>所属学院：</label>
        </div>
         <select name="depID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             <%
             %>
        <%
        
        Iterator<sys_department> it = list.iterator();
		while(it.hasNext()){
			sys_department st = (sys_department) it.next();
			String depID =st.getDepID();
			
			String depName =st.getDepName();
        %>       
             <option value="<%=depID%>"><%=depName %></option>
            
      <%} %>
      </select></div>
       <div class="form-group">
        <div class="label">
          <label>联系电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="stuTel" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>通讯地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="address" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
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
