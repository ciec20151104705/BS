<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="common.jsp"%>
</head>
<body style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>系统菜单
	</div>
	<dl class="leftmenu">
		<c:if test="${type == 'admin'}">
			<dd>
				<div class="title">
					<span><img
						src="${pageContext.request.contextPath}/common/images/leftico01.png" />
					</span>用户管理
				</div>
				<ul class="menuson">
					<li class="active"><cite></cite><a
						href="${pageContext.request.contextPath}/admin/User/saveOrUpdate.jsp"
						target="Conframe">增加用户</a><i></i></li>
					<li><cite></cite><a
						href="${pageContext.request.contextPath}/User-getAllUtil.action"
						target="Conframe">查询用户</a><i></i></li>
				</ul>
			</dd>
		</c:if>
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/common/images/leftico02.png" />
				</span>通告管理
			</div>
			<ul class="menuson">
				<c:if test="${type == 'admin'}">
					<li class="active"><cite></cite><a
						href="${pageContext.request.contextPath}/Notice-initUtil.action"
						target="Conframe">增加</a><i></i></li>
				</c:if>
				<li><cite></cite><a
					href="${pageContext.request.contextPath}/Notice-getAllUtil.action"
					target="Conframe">查询</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/common/images/leftico03.png" />
				</span>请假管理
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a
					href="${pageContext.request.contextPath}/UserLeave-initUtil.action"
					target="Conframe">增加</a><i></i></li>
				<li><cite></cite><a
					href="${pageContext.request.contextPath}/UserLeave-getAllUtil.action"
					target="Conframe">查询</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/common/images/leftico04.png" />
				</span>文件管理
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a
					href="${pageContext.request.contextPath}/UserFile-initUtil.action"
					target="Conframe">增加</a><i></i></li>
				<li><cite></cite><a
					href="${pageContext.request.contextPath}/UserFile-getAllUtil.action"
					target="Conframe">查询</a><i></i></li>
			</ul>
		</dd>
	</dl>
</body>
</html>