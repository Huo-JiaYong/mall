<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="../../common/tag.jsp"%>
<%@include file="../../common/head.jsp"%>
<nav class="nav navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="">后台管理系统</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav navbar-nav">
				<c:forEach var="module" items="${modules}">
					<li><a href="<%=path%>${module.link}">${module.name}</a></li>
				</c:forEach>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<form class="navbar-form">
						<input type="text" class="form-control" placeholder="search">
					</form>
				</li>
				<li class="dropdown">
				    <a href="" data-toggle="dropdown">${adminUser.name}&nbsp;<span class="caret"></span></a>
				    <ul class="dropdown-menu">
				        <li><a href="">我的资料</a></li>
				        <li><a href="">申请权限</a></li>
				        <li><a href="<%=path%>admin/logout">退出</a></li>
				    </ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
