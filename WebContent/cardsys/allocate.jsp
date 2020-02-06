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
</head>
<body>
<div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/cardinfo/allocate.html">      
      <div class="form-group">
        <div class="label">
          <label>卡号：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="cardno" data-validate="required:请输入卡号"/>
          	<div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>学生学号/教师工号：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="account" data-validate="required:请输入学生学号/教师工号"/>
          	<div class="tips"></div>
        </div>
      </div>
     <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <textarea name="allocatemsg" class="input" style="height:150px; border:1px solid #ddd;"></textarea>
          <div class="tips"></div>
        </div>
      </div>
     <div class="form-group">
        <font color="red">${message }</font>
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