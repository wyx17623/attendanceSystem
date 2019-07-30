<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.liststudent"%>
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
<title>学生信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 学生列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <li> <a class="button border-main icon-plus-square-o" href="page/student/student_add.jsp"> 添加学生</a> </li>
        <li>搜索：</li>
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <input type="submit" class="button border-main icon-search" onclick="changesearch()" value="搜索" > </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				
  
         <th>姓名</th>
         <th>学号</th>
         <th>性别</th>
         <th>所属班级</th>
         <th>所属学院</th>
         <th>所属专业</th>
         <th>联系电话</th>
         <th>通讯地址</th>
         <th>操作</th>
         

      </tr>
    
			<%
    				List<liststudent> sl = (List<liststudent>)request.getAttribute("studentlist");
    				
    				session.setAttribute("list", sl);
    				
    				int index=1;
    				Iterator<liststudent> it = sl.iterator();
    				while(it.hasNext()){
    					liststudent st = (liststudent) it.next();
    					String stuName =st.getStuName();
    					String stuID = st.getStuID();
    					String sex =st.getSex();
    					String className = st.getClassName();
    					String depName = st.getDepName();
    					String speName = st.getSpeName();
    					String address = st.getAddress();
    					String stuTel = st.getStuTel();
    			%>
				
		
			<tr>
				 <td><%=index++ %></td>
				  <td><%=stuName %></td>
				 <td><%=stuID %></td>
				 <td><%=sex %></td>
				<td><%=className %></td>
				<td><%=depName %></td>
				<td><%=speName %></td>
				<td><%=stuTel %></td>
				<td><%=address %></td>
				
			
				<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/student/student_update.jsp?index=<%=index-2%>"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="<%=path%>/servlet/studentServlet?type=remove&stuID=<%=stuID%>" ><span class="icon-trash-o"></span> 删除</a>  </div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
  <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
</form>
</body>
</html>
