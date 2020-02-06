<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>高校一卡通管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>高校一卡通管理系统</h1>
		</div>
		<div class="head-l" style="float: right; padding-right: 30px;">
			<a class="button button-little bg-red" href="logout.html"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
		<div class="head-l">
			<h1>${user.name}</h1>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class=""></span>教师管理
		</h2>
		<ul style="display: block">
			<li><a href="${pageContext.request.contextPath}/teacher/list.html" target="right"><span
					class="icon-caret-right"></span>教师列表</a></li>
			<li><a href="${pageContext.request.contextPath}/teacher/add.html" target="right"><span
					class="icon-caret-right"></span>添加教师</a></li>
		</ul>
		<h2>
			<span class=""></span>学生管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/student/list.html" target="right"><span
					class="icon-caret-right"></span>学生列表</a></li>
			<li><a href="${pageContext.request.contextPath}/student/add.html" target="right"><span
					class="icon-caret-right"></span>添加学生</a></li>
		</ul>
		<h2>
			<span class=""></span>卡片入库管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/cardinfo/list.html" target="right"><span
					class="icon-caret-right"></span>入库卡片列表</a></li>
			<li><a href="${pageContext.request.contextPath}/cardinfo/add.html" target="right"><span
					class="icon-caret-right"></span>卡片入库</a></li>
		</ul>
		<h2>
			<span class=""></span>补卡管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/cardinfo/changelist.html" target="right"><span
					class="icon-caret-right"></span>补卡信息列表</a></li>
			<li><a href="${pageContext.request.contextPath}/cardinfo/toChange.html" target="right"><span
					class="icon-caret-right"></span>补卡</a></li>
		</ul>	
		<h2>
			<span class=""></span>废弃卡片管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/cardinfo/invalidlist.html" target="right"><span
					class="icon-caret-right"></span>废弃卡片列表</a></li>
			<li><a href="${pageContext.request.contextPath}/cardinfo/toInvalid.html" target="right"><span
					class="icon-caret-right"></span>废弃卡片</a></li>
		</ul>		
		<h2>
			<span class=""></span>卡片管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/cardinfo/allocatedlist.html" target="right"><span
					class="icon-caret-right"></span>卡片列表</a></li>
			<li><a href="${pageContext.request.contextPath}/cardinfo/toAllocate.html" target="right"><span
					class="icon-caret-right"></span>分配卡片</a></li>
		</ul>
		<h2>
			<span class=""></span>密码修改
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/user/changePassword.html" target="right"><span
					class="icon-caret-right"></span>密码修改</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>

	<div class="admin">
		<!-- 显示登录进去的页面 -->
		<iframe scrolling="auto" rameborder="0" src="" name="right"
			width="100%" height="100%"></iframe>
	</div>
	<div style="text-align: center;"></div>
</body>
</html>
