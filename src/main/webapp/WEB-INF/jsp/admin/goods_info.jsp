<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>商品详情</title>
<%@include file="../common/head.jsp"%>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap-fileinput/4.3.9/css/fileinput.min.css" />
</head>
<body>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>商品详情</h2>
			</div>
			<div class="panel-body">
				<form action="<%=path%>/admin/goods" method="POST" id="goods-from" role="form">
					<div class="form-group">
						<input type="text" name="name" value="${info.name}" class="form-control" placeholder="请输入商品名称" />
					</div>
					<div class="form-group">
						<input type="text" name="title" value="${info.title }" class="form-control"
							placeholder="请输入商品标题" />
					</div>
					<div class="form-group">
						<input type="text" name="price" value="${info.price }" class="form-control"
							placeholder="请输入商品单价" />
					</div>
					<div class="form-group">
						<input type="text" name="number" value="${info.number }" class="form-control"
							placeholder="请输入商品数量" />
					</div>
					<div class="form-group">
						<textarea rows="5" class="form-control" name="introduce" placeholder="请输入您的商品简介">${info.introduce }</textarea>
					</div>
					<div class="form-group">
						<input type="file" id="goods-img" placeholder="请选择商品图片" />
					</div>
					<div class="form-group">
						<img alt="${info.img}" src="<%=path%>${info.img}">
					</div>
					<input type="hidden" name="img" value="${info.img}" />
					<div class="pull-right">
						<input type="submit" class="btn btn-success" value="提交" /> 
						<a href="javascript:history.go(-1);" class="btn btn-default">返回</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.3.9/js/fileinput.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.3.9/js/locales/zh.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#goods-img').fileinput({
				language : 'zh',
				enctype : 'multipart/form-data',
				uploadUrl : '../upload/img',
				allowedFileExtensions : [ 'jpg', 'gif', 'jpeg', 'png' ],
				initialCaption : '请选择商品图片',
				maxFileCount : 10
			});
			$('#goods-img').on('fileuploaded',
					function(event, data, previewId, index) {
						$("input[name='img']").val(data.response.info);
						// $('#service-img').attr('src','../' + data.response.info);
					});
			
			// TODO 判断新增还是修改
			if($('input[name="name"]').val()){
				$('#goods-from').attr('action', "<%=path%>/admin/goods/${info.id}")
				                .attr('method', 'PUT');
			}
		});
	</script>
</body>
</html>