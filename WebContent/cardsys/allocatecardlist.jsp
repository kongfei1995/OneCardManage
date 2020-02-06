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

</head>
<body>
  <div class="panel admin-panel">
    <h1 style="text-align:center">卡片列表</h1>
    <div class="padding border-bottom">
		<br>
			<ul class="search" style="padding-left:10px;">
		        <li>卡号&nbsp;&nbsp;&nbsp;:
				 <input type="text" id="name" name="name" value="${searchVO.name }" class="input" style="width:200px;height:38px; display:inline-block" />
				</li>
				<li>分配日期&nbsp;&nbsp;&nbsp;:
					<input type="text" name="filebegindate" id="begin" value="${searchVO.startDate }" class="input" style="width:125px; line-height:17px;height:38px;display:inline-block"  onclick="laydate()" placeholder="开始日期 " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '开始日期 ';}" >
		          	&nbsp;—&nbsp;
				  	<input type="text" name="fileenddate" id="end" value="${searchVO.endDate }" class="input" style="width:125px; line-height:17px;height:38px;display:inline-block "  onclick="laydate()" placeholder="结束日期 " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '结束日期 ';}" >
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
        <th width="10%">卡号</th>
        <th width="10%">所有者</th>
        <th width="10%">类型</th>
        <th width="10%">分配日期</th>
        <th width="10%">状态</th>
        <th width="20%">备注</th>
      </tr>
       	<c:forEach items="${cardinfos}" var="cardinfo">
	       <tr>
        	<td>${cardinfo.id}</td> 
        	<td>${cardinfo.cardno}</td> 
        	<td>${cardinfo.username}</td> 
        	<td>${cardinfo.cardname}</td> 
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"  value="${cardinfo.allocatetime}" /></td> 
			<td>${cardinfo.state}</td> 
			<td>${cardinfo.allocatemsg}</td> 
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
      var begin = $('#begin').val();
      var end = $.trim($('#end').val());

      var url = '${pageContext.request.contextPath}/cardinfo/allocatedlist.html?';
      if(pageNow) url += 'pageNow=' + pageNow + "&";
      if(name) url += 'name=' + name + "&";
      if(begin) url += 'startDate=' + begin + "&";
      if(end) url += 'endDate=' + end;

      location.href = url;
      return false;
    }
  </script>
</body>
</html>