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
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/student/save.html">      
      <div class="form-group">
        <div class="label">
          <label>学号：</label>
        </div>
        <div class="field">
        	<input type="hidden" name="type" value="student">
        	<input type="hidden" name="id" value="${student.id }">
         	<input type="text" class="input w50" name="account" value="${student.account }" data-validate="required:请输入工号"/>
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="name" value="${student.name }" data-validate="required:请输入姓名"/>
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
         	<input type="password" class="input w50" name="password" value="${student.password }"/>&nbsp;&nbsp;&nbsp;{ 默认:000000}
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
         	<select name="sex" class="input" style="width:100px; line-height:17px; display:inline-block">
            	<option value="男" <c:if test="${student.sex == \"男\" }">selected</c:if>>男</option>
            	<option value="女" <c:if test="${student.sex == \"女\" }">selected</c:if>>女</option>
	        </select>
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>所属学院：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="college" value="${student.college }" data-validate="required:请输入姓名"/>
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>班级：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="grade" value="${student.grade }" data-validate="required:请输入姓名"/>
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>名族：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="nation" value="${student.nation }" data-validate="required:请输入姓名"/>
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>入学时间 ：</label>
        </div>
        <div class="field">
         	<input type="text" name="schooltime" value="${student.schooltime }" class="input w50"  onclick="laydate()" >
          	<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>出生时间 ：</label>
        </div>
        <div class="field">
         	<input type="text" name="birthday" value="${student.birthday }" class="input w50"  onclick="laydate()" >
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