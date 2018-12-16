<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商家信息管理</title>
	<meta name="decorator" content="default"/>
	<style>
		#container{
			width: 600px;
			height: 300px;
		}
		#myPageTop {
			position: absolute;
			top: 5px;
			right: 10px;
			background: #fff none repeat scroll 0 0;
			border: 1px solid #ccc;
			margin: 10px auto;
			padding:6px;
			font-family: "Microsoft Yahei", "微软雅黑", "Pinghei";
			font-size: 14px;
			z-index: 99;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
            //$("#name").focus();
            $("#inputForm").validate({
                submitHandler: function (form) {
                    loading('正在提交，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function (error, element) {
                    $("#messageBox").text("输入有误，请先更正。");
                    if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });
            $("#container").hide();
            $("#myPageTop").hide();
            $("#dw").click(function () {
                $("#myPageTop").show();
                $("#container").show();
                var map = new AMap.Map("container", {
                    resizeEnable: true
                });
                //输入提示
                var autoOptions = {
                    input: "tipinput"
                };
                var auto = new AMap.Autocomplete(autoOptions);
                var placeSearch = new AMap.PlaceSearch({
                    map: map
                });  //构造地点查询类
                AMap.event.addListener(auto, "select", select);//注册监听，当选中某条记录时会触发
                function select(e) {
                    placeSearch.setCity(e.poi.adcode);
                    placeSearch.search(e.poi.name);  //关键字查询查询
                    map.on('click', function(e) {
                        var lng = e.lnglat.getLng();
                        var lat = e.lnglat.getLat();
                        $("#lng").attr("value",lng);
                        $("#lat").attr("value",lat);
                        // $("#lng").val = lng;
                        // $("#lat").val = lat;
                        var lnglatXY = [lng, lat];//地图上所标点的坐标
                        AMap.service('AMap.Geocoder',function() {//回调函数
                            geocoder = new AMap.Geocoder({
                            });
                            geocoder.getAddress(lnglatXY, function (status, result) {
                                if (status === 'complete' && result.info === 'OK') {
                                    //获得了有效的地址信息:
                                    //即，result.regeocode.formattedAddress
                                    var address = result.regeocode.formattedAddress;
                                    $("#position"). html(address);
                                } else {
                                    //获取地址失败
                                    alert("获取地址失败")
                                }
                            });
                        })
                    });
                }
            }); //地图加载
        })
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/ty/tywshangjhy/">商家信息列表</a></li>
		<li class="active"><a href="${ctx}/ty/tywshangjhy/form?id=${tywshangjhy.id}">商家信息<shiro:hasPermission name="ty:tywshangjhy:edit">${not empty tywshangjhy.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="ty:tywshangjhy:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tywshangjhy" action="${ctx}/ty/tywshangjhy/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">行政区_ID：</label>
			<div class="controls">
				<form:input path="tywId" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单位名称：</label>
			<div class="controls">
				<form:input path="danwmc" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商家类型：</label>
			<div class="controls">
				<form:input path="shangjlx" htmlEscape="false" maxlength="1" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文字介绍：</label>
			<div class="controls">
				<form:textarea path="wenzjs" rows="5" cols="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会员政策：</label>
			<div class="controls">
				<form:textarea path="huiyzc" rows="5" cols="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">折扣幅度：</label>
			<div class="controls">
				<form:input path="zkfd" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地理位置：</label>
			<div class="controls">
				<span id="position"></span>
				<button id="dw" type="button">定位</button>
				<%--<form: inputpath="dlwz" htmlEscape="false" maxlength="50" class="input-xlarge "/>--%>
			</div>
		</div>
		<div id="container" class="controls">
			<div id="myPageTop">
				<table>
					<tr>
						<td>
							<label>请输入关键字：</label>
						</td>
					</tr>
					<tr>
						<td>
							<input id="tipinput"/>
						</td>
					</tr>
				</table>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">纬度：</label>
			<div class="controls">
				<form:input id="lat" path="wd" readonly="true"   htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">经度：</label>
			<div class="controls">
				<form:input id="lng" path="jd" readonly="true" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系人：</label>
			<div class="controls">
				<form:input path="lianxr" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系电话：</label>
			<div class="controls">
				<form:input path="lxdh" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排名次序:</label>
			<div class="controls">
				<form:input path="pxh" htmlEscape="false" maxlength="11" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="ty:tywshangjhy:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	</form:form>
	<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.11&key=508f5d5af249e1c3ce45d6bf57f1c1bf&plugin=AMap.Autocomplete,AMap.PlaceSearch"></script>
</body>
</html>