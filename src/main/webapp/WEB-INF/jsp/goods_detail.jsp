<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>${info.name}</title>
<%@include file="common/head.jsp"%>
</head>
<body>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>${info.name}</h2>
				<p>${info.title}</p>
			</div>
			<div class="panel-body text-center">
			     <p>${info.introduce}</p>
			     <p class="text-success">单价：<fmt:formatNumber value="${info.price}" type="currency" pattern="￥.##" /></p>
			     <p>只剩 ${info.number} 件啦</p>
			     <button class="btn btn-primary">立即购买</button>
			</div>
		</div>
	</div>

<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>