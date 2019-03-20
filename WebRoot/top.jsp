<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<%@ include file="common.jsp"%>
		<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
	</head>

	<body
		style="background: url(${pageContext.request.contextPath}/common/images/topbg.gif) repeat-x;">

		 <div class="topleft">
			<a href="main.jsp" target="_parent"><div style="margin-top: 22px;font-size: 30px;color:#FFFFFF;">
					<spring:message code="system_name" />
				</div> </a>
		</div>
		<ul class="nav">
			<li>
				<a href="#" class="selected"><img
						src="${pageContext.request.contextPath}/common/images/icon01.png"
						title="工作台" />
					<h2>
						欢
					</h2> </a>
			</li>
			<li>
				<a href="#"><img
						src="${pageContext.request.contextPath}/common/images/icon02.png"
						title="模型管理" />
					<h2>
						迎
					</h2> </a>
			</li>
			<li>
				<a href="#"><img
						src="${pageContext.request.contextPath}/common/images/icon03.png"
						title="模块设计" />
					<h2>
						光
					</h2> </a>
			</li>
			<li>
				<a href="#"><img
						src="${pageContext.request.contextPath}/common/images/icon04.png"
						title="常用工具" />
					<h2>
						临
					</h2> </a>
			</li>

		</ul>
		
		
		<div class="topright">
			<ul>
				<li>
					<span><img width=25 height=23
							src="${pageContext.request.contextPath}/common/images/sun.png"
							title="帮助" class="helpimg" /> </span><a href="index.jsp"
						target="Conframe">首页</a>
				</li>
				<li>
					<a href="login.jsp" target="_parent">退出</a>
				</li>
			</ul>

			<div class="user">
				<span>${username }</span>|&nbsp;
				<a href="${pageContext.request.contextPath}/initInfo.action" target="Conframe"><i>个人信息</i> </a> &nbsp;|&nbsp;
				<a href="${pageContext.request.contextPath}/admin/User/updatepwd.jsp" target="Conframe"><i>修改密码</i> </a> &nbsp;&nbsp;&nbsp;
			</div>

		</div>


	</body>
</html>
