<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>用户登录</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="col-sm-offset-4 col-sm-4" style="margin-top:10%">
		<form role="form" class="form-horizontal" id="form-login">
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">phone</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="phone" placeholder="input your phone">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="password" placeholder="input your password">
				</div>
			</div>

			<div id="tip" class="form-group" style="margin-bottom: 0px; display: none;">
				<div class="col-sm-offset-2 col-sm-10">
                    <span class="text-danger">账号密码不匹配</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox">remember me</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a id="btn-login" class="btn btn-primary btn-block" href="javascript:;">登录</a>
				</div>
			</div>
		</form>
	</div>
	<script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#btn-login').on('click', function() {
				$('#tip').css('display','none');
				var data = $('#form-login').serialize();
				$.post('<%=path%>admin/login', data, function(data){
					if(data.success){
						window.location.href= "<%=path%>admin/index";
					} else {
						$('#tip').css('display','block');
					}
				});
			});
		});
	</script>
</body>
</html>