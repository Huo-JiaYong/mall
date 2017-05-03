<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>商品列表</title>
<%@include file="../common/head.jsp"%>
</head>
<body>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>商品列表</h2>
			</div>
			<div class="panel-body">
				<div class="pull-right">
					<a href="<%=path%>/admin/goods" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>&nbsp;新增商品</a>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>图片</th>
							<th>名称</th>
							<th>简介</th>
							<th>价格</th>
							<th>库存</th>
							<th>创建时间</th>
							<th>最后修改</th>
							<th width="12%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="info" items="${infos}">
							<tr>
								<td><img src="<%=path%>${info.img}"></img></td>
								<td>${info.name}</td>
								<td>${info.title}</td>
								<td><fmt:formatNumber value="${info.price}" type="currency" pattern="￥.##" /></td>
								<td>${info.number}</td>
								<td><fmt:formatDate value="${info.gmtCreate}" pattern="MM-dd hh:mm" /></td>
								<td><fmt:formatDate value="${info.gmtModified}" pattern="MM-dd hh:mm" /></td>
								<td>
								    <a href="<%=path%>/admin/goods/${info.id}" class="btn btn-info">修改</a>
								    <a data-value="${info.id }" href="javascript:;" class="btn btn-danger">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="https://cdn.bootcss.com/layer/3.0/layer.min.js"></script>
	<script src="<%=path%>/resource/js/handler.js"></script>
	<script type="text/javascript">
		$(function() {
			handler.init({});
		});
	</script>
</body>
</html>