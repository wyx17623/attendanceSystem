<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listmanager"%>
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
<title>管理员信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 管理员列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <!-- <li> <a class="button border-main icon-plus-square-o" href="page/user/user_add.jsp"> 添加管理员</a> </li> -->
        <li>搜索：</li>
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				<th>工号</th>
				<th>姓名</th>
				<th>密码</th>
				<th>手机号</th>
				<th>操作</th>
      </tr>
    
				
				
			<%--读取所有管理员信息记录 --%>
			

			<%
							List<listmanager> sl = (List<listmanager>)request.getAttribute("managerlist");
							
							     session.setAttribute("list", sl);
							
							int index=1;
							Iterator<listmanager> it = sl.iterator();
							while(it.hasNext()){
								listmanager st = (listmanager) it.next();
								String userid=st.getUserid();
								String fullname = st.getFullname();
								String telephone =st.getTelephone();
								
								String password = st.getPassword();
						%>
			

			<tr>
				 <td><%=index++ %></td>
				<td><%=userid %></td>
				<td><%=fullname %></td>
				<td><%=password %></td>
				<td><%=telephone %></td>
				<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/manager/manager_update.jsp"><span class="icon-edit"></span> 修改</a> <!-- <a class="button border-red" href="<%=path%>/page/user/action_delUser.jsp?userid=<%=userid%>" ><span class="icon-trash-o"></span> 删除</a> --> </div>
				</td>
			</tr>
			<%
				}
			%>
    </table>
  </div>
  <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
</form>
</body>
</html>
