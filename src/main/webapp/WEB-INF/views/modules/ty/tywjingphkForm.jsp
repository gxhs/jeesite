<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>艺海画库管理</title>
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
		<li><a href="${ctx}/ty/tywjingphk/">艺海画库列表</a></li>
		<li class="active"><a href="${ctx}/ty/tywjingphk/form?id=${tywjingphk.id}">艺海画库<shiro:hasPermission name="ty:tywjingphk:edit">${not empty tywjingphk.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="ty:tywjingphk:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tywjingphk" action="${ctx}/ty/tywjingphk/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">价格：</label>
			<div class="controls">
				<form:input path="price" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简介：</label>
			<div class="controls">
				<form:textarea path="introduction" htmlEscape="false" rows="4" maxlength="1500" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">缩略图：</label>
			<div class="controls">
				<form:hidden id="thumb" path="thumb" htmlEscape="false" maxlength="100" class="input-xlarge"/>
				<sys:ckfinder input="thumb" type="files" uploadPath="/ty/tywjingphk" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">高清图：</label>
			<div class="controls">
				<form:hidden id="hD" path="hD" htmlEscape="false" maxlength="100" class="input-xlarge"/>
				<sys:ckfinder input="hD" type="files" uploadPath="/ty/tywjingphk" selectMultiple="true"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="ty:tywjingphk:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>