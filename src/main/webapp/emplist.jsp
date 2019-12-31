<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			//获取   登入的角色  0 管理
			var  a= ${sessionScope.login.role}
			if (a == '0'){
				$(function(){
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/user/showAll.do",
						dataType:"json",
						success:function (data) {
							for(var i=0;i<data.length;i++){
								$("#tb").append("<tr class='row1'><td><input type='checkbox' name='id' value="+data[i].id+"></td> <td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].salary+"</td><td>"+data[i].age+"</td>" +
									"<c:if test="${sessionScope.login.role!='1'}"><td><a href='${pageContext.request.contextPath}/user/delete.do?id="+data[i].id+"'>delete emp</a>&nbsp;<a href='${pageContext.request.contextPath}/updateEmp.jsp?id="+data[i].id+"&salary="+data[i].salary+"&age="+data[i].age+"&name="+data[i].name+"'>" +
									"update emp</a></td></c:if></tr>")
							}
						},
						error:function () {
							alert("本地加载超时");
						}
					})
				})
           }


		</script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">

							<h3>2009/11/20</h3>

                            <input type="button" value="安全退出" onclick="location='${pageContext.request.contextPath}/loginout/out.do'">


					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<form action="${pageContext.request.contextPath}/user/showLike.do" method="post">
						<h1>
							Welcome ${sessionScope.login.name}! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${sessionScope.login.role=='0'}">
								<select name="key">
									<option value="name">用户名</option>
									<option value="age">年龄</option>
									<option value="salary">工资</option>
								</select>
								<input type="text" name="content"  placeholder="请输入查询条件"/>
								<input type="submit" value="提交">


								<input type="button" class="button" value="showAll" onclick="location='${pageContext.request.contextPath}/emplist.jsp'"/>
							</c:if>
						</h1>
					</form>
					<form action="${pageContext.request.contextPath}/user/delete.do">
						<table class="table">
							<tbody id="tb">
								<tr class="table_header">
									<td>Del</td>
									<td>ID</td>
									<td>Name</td>
									<td>Salary</td>
									<td>Age</td>
									<c:if test="${sessionScope.login.role!='1'}">
										<td>Operation</td>
									</c:if>
								</tr>
								<c:if test="${sessionScope.login.role==1}">
									<tr class="row1">
										<td>${sessionScope.login.id}</td>
										<td>${sessionScope.login.name}</td>
										<td>${sessionScope.login.salary}</td>
										<td>${sessionScope.login.age}</td>
									</tr>
								</c:if>

								<c:if test="${sessionScope.login.role==0}">
									<c:forEach var="user" items="${requestScope.users}">
										<tr class="row2">
                                            <td><input type='checkbox' name='id' value="${user.id}"></td>
											<td>${user.id}</td>
											<td>${user.name}</td>
											<td>${user.salary}</td>
											<td>${user.age}</td>
											<td>
												<a href="emplist.html">delete emp</a>&nbsp;<a href="updateEmp.html">update emp</a>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
						<c:if test="${sessionScope.login.role=='0'}">	<input type="submit" value="Del">  </c:if>
					</form>
					<c:if test="${sessionScope.login.role!='1'}">
						<p>
							<input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
						</p>
					</c:if>

				</div>
				<a href="">1</a>
				<a href="">2</a>
				<a href="">3</a>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
