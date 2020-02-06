<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<script type="text/javascript">
	if (self != top) {  
		parent.window.location.href = "${pageContext.request.contextPath}/login.jsp";
	} else {
		window.location.href = "${pageContext.request.contextPath}/login.jsp";
	}
</script>
<body>
</body>
</html>
