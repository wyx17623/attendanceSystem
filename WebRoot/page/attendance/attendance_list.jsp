<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.attendancelist"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectClassName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_classes" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--              考勤界面 -->

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
<%
String userid =(String)session.getAttribute("userid");
  
SelectClassName sc =new SelectClassName();
List<sys_classes> list1 = sc.getClassName(userid); 
  session.setAttribute("classID", request.getParameter("classID"));

%>
<form method="post" action="servlet/attendanceServlet?type=list&sign=choose" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 学生列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <li>考勤班级</li>
       <li>
            <select name="classID" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
              <option value="">请选择班级</option>
              <% Iterator<sys_classes> it1 = list1.iterator();
              while(it1.hasNext()){
            		sys_classes st = (sys_classes)it1.next();
            		String classID =st.getClassID();
            		
            		String className =st.getClassName(); %>
              <option value="<%=classID%>"><%=className %></option>
            <%} %>
            </select>
          </li>
          
<li> <button class="button bg-main icon-check-square-o" type="submit">确认</button></li>
      </ul>
    </div>
    </div>
  </form>
 
  <form method="post" action="servlet/attendanceServlet?type=add" id="listform">
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
       <th>姓名</th>
       <th>学号</th>
       <th>所属班级</th>
       <th>操作</th>
       
      </tr>
    
			<% List<attendancelist> sl = (List<attendancelist>)request.getAttribute("attendancelist");
			
			session.setAttribute("list", sl);
			
			int index=1;
			Iterator<attendancelist> it = sl.iterator();
			while(it.hasNext()){
				attendancelist st = (attendancelist) it.next();
				String stuName =st.getStuName();
				String stuID = st.getStuID();				
				String className = st.getClassName();
				
				  %>
		<tr>     <td><%=index++ %></td>
			  	<td><%=stuName %></td>
				<td><%=stuID %></td>
				<td><%=className %></td>
				<td>
				 迟到<input type="radio" name="status<%=index-1 %>" value="0"> 
				 早退<input type="radio" name="status<%=index-1 %>" value="1"> 
				 旷课<input type="radio" name="status<%=index-1 %>" value="2"> 
				 请假<input type="radio" name="status<%=index-1 %>" value="3"> 
				 正常<input type="radio" name="status<%=index-1 %>" value="4"checked="checked"> 
		         
				</td>
			</tr>
	<%  

	}
			 session.setAttribute("index", index);
			 %>
    </table>
 <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="提交"></div>

</form>
</body>
</html>
