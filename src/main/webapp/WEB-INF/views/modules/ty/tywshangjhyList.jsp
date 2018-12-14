<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商家信息管理</title>
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
		<li class="active"><a href="${ctx}/ty/tywshangjhy/">商家信息列表</a></li>
		<shiro:hasPermission name="ty:tywshangjhy:edit"><li><a href="${ctx}/ty/tywshangjhy/form">商家信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tywshangjhy" action="${ctx}/ty/tywshangjhy/" method="post" class="breadcrumb form-search">
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
				<th>单位名称</th>
				<th>商家类型</th>
				<th>文字介绍</th>
				<th>会员政策</th>
				<th>折扣幅度</th>
				<th>地理位置</th>
				<th>纬度</th>
				<th>经度</th>
				<th>联系人</th>
				<th>联系电话</th>
				<shiro:hasPermission name="ty:tywshangjhy:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tywshangjhy">
			<tr>
				<td>${tywshangjhy.danwmc}</td>
				<td>${tywshangjhy.shangjlx}</td>
				<td>${tywshangjhy.wenzjs}</td>
				<td>${tywshangjhy.huiyzc}</td>
				<td>${tywshangjhy.zkfd}</td>
				<td>${tywshangjhy.dlwz}</td>
				<td>${tywshangjhy.wd}</td>
				<td>${tywshangjhy.jd}</td>
				<td>${tywshangjhy.lianxr}</td>
				<td>${tywshangjhy.lxdh}</td>
				<shiro:hasPermission name="ty:tywshangjhy:edit"><td>
    				<a class="btn btn-primary btn-xs" href="${ctx}/ty/tywshangjhy/form?id=${tywshangjhy.id}">修改</a>
					<a class="btn btn-danger btn-xs" href="${ctx}/ty/tywshangjhy/delete?id=${tywshangjhy.id}" onclick="return confirmx('确认要删除该商家信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>