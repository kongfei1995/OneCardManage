<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/teacher/save.html">      
      <div class="form-group">
        <div class="label">
          <label>工号：</label>
        </div>
        <div class="field">
        	<input type="hidden" name="type" value="teacher">
        	<input type="hidden" name="id" value="${teacher.id }">
         	<input type="text" class="input w50" name="account" value="${teacher.account }" data-validate="required:请输入工号"/>
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="name" value="${teacher.name }" data-validate="required:请输入姓名"/>
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
         	<input type="password" class="input w50" name="password" value="${teacher.password }"/>&nbsp;&nbsp;&nbsp;{ 默认:000000}
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>入职时间 ：</label>
        </div>
        <div class="field">
         	<input type="text" name="schooltime" value="${teacher.schooltime }" class="input w50"  onclick="laydate()" placeholder="入职时间 " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '入职时间  ';}" >
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
      </div>
    </form>
  </div>
</div>
</body></html>