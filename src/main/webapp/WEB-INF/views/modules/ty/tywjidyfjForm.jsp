<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/ty/tywjidyfj/">保存列表</a></li>
		<li class="active"><a href="${ctx}/ty/tywjidyfj/form?id=${tywjidyfj.id}">保存<shiro:hasPermission name="ty:tywjidyfj:edit">${not empty tywjidyfj.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="ty:tywjidyfj:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tywjidyfj" action="${ctx}/ty/tywjidyfj/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">行政区_ID：</label>
			<div class="controls">
				<form:input path="tywId" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				<form:input path="mingc" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">优惠政策：</label>
			<div class="controls">
				<form:input path="yhzc" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">景区介绍：</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="jqjs" htmlEscape="false" maxlength="1000" class="input-xlarge "/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="control-group">
			<label class="control-label">景区介绍:</label>
			<div class="controls">
				<form:textarea id="jqjs" htmlEscape="true" path="jqjs" rows="4" maxlength="200" class="input-xxlarge"/>
				<sys:ckeditor replace="jqjs" uploadPath="/ty/tywjidyfj" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">地理位置：</label>
			<div class="controls">
				<form:input path="dlwz" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">经度：</label>
			<div class="controls">
				<form:input path="jd" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">纬度：</label>
			<div class="controls">
				<form:input path="wd" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系电话：</label>
			<div class="controls">
				<form:input path="lxdh" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排名次序：</label>
			<div class="controls">
				<form:input path="pxh" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/>
			</div>
		</div>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">是否推荐：</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="iftuij" htmlEscape="false" maxlength="1" class="input-xlarge "/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="control-group">
			<label class="control-label">是否推荐:</label>
			<div class="controls">
				<form:radiobuttons path="iftuij" items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="ty:tywjidyfj:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>