<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/ty/tywjidyfj/">保存列表</a></li>
		<shiro:hasPermission name="ty:tywjidyfj:edit">
			<li><a href="${ctx}/ty/tywjidyfj/form">保存添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tywjidyfj" action="${ctx}/ty/tywjidyfj/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>

			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			<th>名称</th>
			<th>联系电话</th>
			<th>排名次序</th>
			<th>是否推荐</th>
				<shiro:hasPermission name="ty:tywjidyfj:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tywjidyfj">

			<tr>
				<shiro:hasPermission name="ty:tywjidyfj:edit">
					<td>${tywjidyfj.mingc}</td>
					<td>${tywjidyfj.lxdh}</td>
					<td>${tywjidyfj.pxh}</td>
					<%--<td>${tywjidyfj.mingc}</td>--%>
					<td>${tywjidyfj.iftuij}</td>
				<td>
    				<a href="${ctx}/ty/tywjidyfj/form?id=${tywjidyfj.id}">修改</a>
					<a href="${ctx}/ty/tywjidyfj/delete?id=${tywjidyfj.id}" onclick="return confirmx('确认要删除该保存吗？', this.href)">删除</a>
				</td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>