<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectTeacher" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_teacher" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectDepName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_department" %>
<%@ page language="java" import="com.gxuwz.bean.vo.specialitylist"%>

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
<title>专业修改</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%   List<specialitylist> sl = (List<specialitylist>)session.getAttribute("list"); 
String index = request.getParameter("index");
specialitylist tl = sl.get(Integer.parseInt(index));
   
    SelectDepName sd =new SelectDepName();
    List<sys_department> list = sd.getDepName();
  
     
    %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改专业</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/specialityServlet?type=update">  
      <div class="form-group">
        <div class="label">
          <label>专业编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getSpeID()%>" name="speID"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>专业名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getSpeName() %>" name="speName"   />
          <div class="tips"></div>
        </div>
      </div>     
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
