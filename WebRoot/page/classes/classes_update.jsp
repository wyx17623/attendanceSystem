<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectTeacher" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_classes" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectSpeciality" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_speciality" %>
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
<title>班级添加</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%  List<sys_classes> sl = (List<sys_classes>)session.getAttribute("list"); 
String index = request.getParameter("index");
sys_classes tl = sl.get(Integer.parseInt(index));
    SelectSpeciality ss =new SelectSpeciality();
    List<sys_speciality> list = ss.getSpeName(); 
    
     
    %>
<div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/classServlet?type=update">  
      <div class="form-group">
        <div class="label">
          <label>班级编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getClassID() %>" name="classID"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>班级名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getClassName() %>" name="className"   />
          <div class="tips"></div>
        </div>
      </div>
     <div class="form-group">
        <div class="label">
          <label>班级人数：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getStuNum() %>" name="stuNum"   />
          <div class="tips"></div>
        </div>
      </div>
     
           
        <div class="form-group">
        <div class="label">
          <label>所属年级：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getGrade() %>" name="grade"   />
          <div class="tips"></div>
        </div>
      </div>
      
           <div class="form-group">
        <div class="label">
          <label>所属专业：</label>
        </div>
         <select name="speID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             <%
             %>
        <%
        
        Iterator<sys_speciality> it1 = list.iterator();
		while(it1.hasNext()){
			sys_speciality s = (sys_speciality) it1.next();
			String speID =s.getSpeID();
			
			String SpeName =s.getSpeName();
        %>       
             <option value="<%=speID%>"><%=SpeName %></option>
            
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
