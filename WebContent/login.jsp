<%@page import="com.cardsys.model.User"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	User userName = (User) session.getAttribute("user");
	if (userName != null) {
		response.sendRedirect("main.html");
	}
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<title>高校一卡通管理系统</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css">
	</head>
	<body>
		<div class="login">
		    <div class="message">高校一卡通管理系统</div>
		    <div id="darkbannerwrap"></div>
		    <div style="color:red">${errors }</div><br/>
		    <form action="${pageContext.request.contextPath}/login.html" method="post">
				<input name="action" value="login" type="hidden">
				<input name="username" placeholder="用户名" required type="text">
				<hr class="hr15">
				<input name="password" placeholder="密码" required type="password">
				<hr class="hr15">
				<input name="randomCode" style="width:69%" placeholder="验证码" required type="text">
				<img id="vimg"  title="点击更换" onclick="changeCode();" src="${pageContext.request.contextPath}/code.html">
				<hr class="hr15">
				<input value="登录" style="width:100%;" type="submit">
				<hr class="hr20">
				
			</form>
		</div>
	</body>
	<script type="text/javascript">
		function changeCode() {
			var imgNode = document.getElementById("vimg");
			imgNode.src = "${pageContext.request.contextPath}/code.html?t=" + Math.random(); 
		}
	</script>
</html>