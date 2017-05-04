<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>Welcome</title>
<%@include file="common/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>Hello</h2>
			</div>
			<div class="panel-body">
				<a href="<%=path%>goods/list" class="btn btn-default">商品列表</a>
				<hr />
				<a href="<%=path%>admin/index" class="btn btn-primary">后台管理系统</a>
			</div>
		</div>
	</div>
</body>
</html>
