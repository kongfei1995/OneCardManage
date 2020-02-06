<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<script type="text/JavaScript">
	function del()
	{
	   if(confirm("确定要删除此记录吗？"))
	     return true;
	   else
	     return false;	 
	}
</script>
</head>
<body>
  <div class="panel admin-panel">
    <h1 style="text-align:center">学生列表</h1>
    <div class="padding border-bottom">
		<br>
			<ul class="search" style="padding-left:10px;">
		        <li>学生姓名&nbsp;&nbsp;&nbsp;:
				 <input type="text" id="name" name="name" value="${searchVO.name }" class="input" style="width:200px;height:38px; display:inline-block" />
				</li>
				 <li>
				   <button class="button border-main icon-search"  onclick="searchSaleList();return false" style=" height:38px;"> 查询</button>
				   </li>
		      </ul>	
      	<br>
	 </div> 
    <table class="table table-hover text-center">
      <tr>
        <th width="10%">序号</th>
        <th width="10%">学号</th>
        <th width="10%">姓名</th>
        <th width="10%">性别</th>
        <th width="10%">年级</th>
        <th width="10%">名族</th>
        <th width="10%">出生日期</th>
        <th width="10%">入学时间</th>
        <th width="20%">操作</th>
      </tr>
       	<c:forEach items="${students}" var="student">
	       <tr>
        	<td>${student.id}</td> 
        	<td>${student.account}</td> 
			<td>${student.name}</td> 
			<td>${student.sex}</td> 
			<td>${student.college}${student.grade}</td> 
			<td>${student.nation}</td> 
			<td>${student.birthday}</td> 
			<td>${student.schooltime}</td> 
        	<td>
			 <div class="button-group"> 
			 	<a class="button border-main" href="${pageContext.request.contextPath}/student/update.html?id=${student.id}"> 编辑</a> 
			 	<a class="button border-red" style="margin-left:5px;" href="${pageContext.request.contextPath}/student/delete.html?id=${student.id}" onClick="return del();">删除</a> 		
		     </div>
		    </td> 
		   </tr>
	    </c:forEach>
      	<tr>
        	<td colspan="9">
        		<div class="pagelist">
        			<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
						${page.pageNow} 页</font> <a href="#" onclick="searchSaleList(1)">首页</a>
					<c:choose>
						<c:when test="${page.pageNow - 1 > 0}">
							<a href="#" onclick="searchSaleList(${page.pageNow - 1})">上一页</a>
						</c:when>
						<c:when test="${page.pageNow - 1 <= 0}">
							<a href="#" onclick="searchSaleList(1)">上一页</a>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${page.totalPageCount==0}">
							<a href="#" onclick="searchSaleList(${page.pageNow})">下一页</a>
						</c:when>
						<c:when test="${page.pageNow + 1 < page.totalPageCount}">
							<a href="#" onclick="searchSaleList(${page.pageNow + 1})">下一页</a>
						</c:when>
						<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
							<a href="#" onclick="searchSaleList(${page.totalPageCount})">下一页</a>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${page.totalPageCount==0}">
							<a href="#" onclick="searchSaleList(${page.pageNow})">尾页</a>
						</c:when>
						<c:otherwise>
							<a href="#" onclick="searchSaleList(${page.totalPageCount})">尾页</a>
						</c:otherwise>
					</c:choose>
        		</div>
        	</td>
      </tr>
    </table>
  </div>
  <script type="text/javascript">
  	function searchSaleList(pageNow) {
      var name = $('#name').val();

      var url = '${pageContext.request.contextPath}/student/list.html?';
      if(pageNow) url += 'pageNow=' + pageNow + "&";
      if(name) url += 'name=' + name;

      location.href = url;
      return false;
    }
  </script>
</body>
</html>