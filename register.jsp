<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/common/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/common/css/main.css" />
<link href="${pageContext.request.contextPath}/common/css/select.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/common/css/test.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/common/js/jsapi.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/common/js/format+zh_CN,default,corechart.I.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/common/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/common/js/jquery.ba-resize.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/common/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/common/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/common/js/select-ui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/common/editor/kindeditor.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/common/js/pintuer.js"></script>
<script type="text/javascript">
	$(function() {
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	})
</script>




<script type="text/javascript">
	function flushCode() {
		document.getElementById("codeimg").src = "imageServlet.servlet?random="
				+ Math.random();
	}
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
</script>
</head>
<body
	style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">

	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>欢迎光临<spring:message code="system_name" /></span>
	</div>
	<form action="register.action" method="post">
		<div class="loginbody">

			<span class="systemlogo"></span>

			<div class="loginbox">

				<ul>
					<li><input name="util.s_0" type="text" class="loginuser"
						onclick="JavaScript:this.value=''" />
					</li>
					<li><input name="util.s_1" type="password" class="loginpwd"
						onclick="JavaScript:this.value=''" />
					</li>
					<input name="util.s_11" type="hidden" value="user" />
					<li><input name="code" type="text" class="logincd"
						onclick="JavaScript:this.value=''" /> &nbsp;&nbsp;&nbsp; <img
						id="safecode" src="imageServlet" onClick="flushCode()" />
					</li>
					<li><input name="" type="submit" class="loginbtn" value="注册" />
						<label> </label> <label> <a href="#">已有帐号？直接登录</a> </label> <font
						color=red><s:property value="errMsg" /> </font>
					</li>
				</ul>


			</div>

		</div>


	</form>


</body>
</html>
