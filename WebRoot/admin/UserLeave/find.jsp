<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../com.jsp"%>
<script type="text/javascript">
	function topPage() {
		var contextPath = "${pageContext.request.contextPath}";
		var field = document.getElementById("field").value;
		var fieldValue = document.getElementById("fieldValue").value;
		var pageNo = "${pageModel.topPageNo}";
		window.location = contextPath
				+ '/UserLeave-getAllUtil.action?pageModel.currentPageNo='
				+ pageNo + '&field=' + field + '&fieldValue=' + fieldValue + '';
	}

	function previousPage() {
		var contextPath = "${pageContext.request.contextPath}";
		var field = document.getElementById("field").value;
		var fieldValue = document.getElementById("fieldValue").value;
		var pageNo = "${pageModel.previousPageNo}";
		window.location = contextPath
				+ '/UserLeave-getAllUtil.action?pageModel.currentPageNo='
				+ pageNo + '&field=' + field + '&fieldValue=' + fieldValue + '';
	}

	function nextPage() {
		var contextPath = "${pageContext.request.contextPath}";
		var field = document.getElementById("field").value;
		var fieldValue = document.getElementById("fieldValue").value;
		var pageNo = "${pageModel.nextPageNo}";
		window.location = contextPath
				+ '/UserLeave-getAllUtil.action?pageModel.currentPageNo='
				+ pageNo + '&field=' + field + '&fieldValue=' + fieldValue + '';
	}

	function bottomPage() {
		var contextPath = "${pageContext.request.contextPath}";
		var field = document.getElementById("field").value;
		var fieldValue = document.getElementById("fieldValue").value;
		var pageNo = "${pageModel.buttomPageNo}";
		window.location = contextPath
				+ '/UserLeave-getAllUtil.action?pageModel.currentPageNo='
				+ pageNo + '&field=' + field + '&fieldValue=' + fieldValue + '';
	}
	$(document).ready(function() {
		$(".click").click(function() {

			var ids = document.getElementsByName("id");
			var flag = 0;
			for ( var i = 0; i < ids.length; i++) {
				if (ids[i].checked) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				$(".tip").fadeIn(200);
			} else {
				alert("至少选中一条记录");
			}

		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);

		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});

	function check() {
		return true;
	}
</script>
</head>
<body>
	<div class="place">
		<span>当前位置</span>
		<ul class="placeul">
			<li>请假管理</li>
			<li>查询界面</li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">

			<c:if test="${type == 'admin'}">
				<ul class="toolbar" style="margin-top:-10px;">
					<li class="click"><span><img
							src="${pageContext.request.contextPath}/common/images/t03.png" />
					</span>批量删除</li>
				</ul>
			</c:if>
			<form
				action="${pageContext.request.contextPath}/UserLeave-getAllUtil.action">
				<ul class="toolbar1" style="float: left;margin-top:-10px;">
					<li style="font-size: 16px; margin-left: 26px;">请填写查询条件 <span>
					</span></li>
					<li style="margin-left: 26px;"><select id="field" name="field"
						style="font-size: 20px; background-color: #F9F9F9; margin: 3px 0px 0px 10px;">
							<option <c:if test="${field == 'user.s_2'}">selected</c:if>
								value="user.s_2" /> 请假人
							</option>
							<option <c:if test="${field == 'user1.s_2'}">selected</c:if>
								value="user.s_2" /> 审批人
							</option>
							<option <c:if test="${field == 's_0'}">selected</c:if>
								value="s_0" /> 请假名称
							</option>
							<option <c:if test="${field == 's_1'}">selected</c:if>
								value="s_1" /> 请假时间
							</option>
							<option <c:if test="${field == 's_2'}">selected</c:if>
								value="s_2" /> 请假天数
							</option>
							<option <c:if test="${field == 's_3'}">selected</c:if>
								value="s_3" /> 请假类型
							</option>
							<option <c:if test="${field == 's_4'}">selected</c:if>
								value="s_4" /> 请假原因
							</option>
					</select></li>
					<div style="float: left; margin-left: 20px; margin-top: 0px;">
						<input class="dfinput" type="text" name="fieldValue"
							id="fieldValue" value="${fieldValue }" style="width: 350px;" />
					</div>
					<div style="float: left; margin-top: 0px;">
						<input class="btn btn-inverse" id="find" type="submit"
							value="查&nbsp;&nbsp;询" style="width: 80px; margin-left: 26px;" />
						&nbsp;&nbsp; <input class="btn btn-inverse" type="button"
							value="清&nbsp;&nbsp;空"
							onclick="javascript: document.getElementById('fieldValue').value='';"
							style="width: 80px; margin-left: 10px;" />&nbsp;&nbsp;
							<input class="btn btn-inverse" type="button" value="打&nbsp;&nbsp;印" onclick="javascript:window.print();" style="width: 80px; margin-left: 10px;" />
							

					</div>
				</ul>
			</form>
		</div>
		<form
			action="${pageContext.request.contextPath}/UserLeave-deleteManyUtil.action"
			name="myform" id="listform" method="post" onsubmit="return check()">
			<table class="imgtable">
				<thead>
					<tr>
						<th width="78px;"><input id="checkall" name="checkall"
							type="checkbox"> 全选</th>
						<th>请假人</th>
						<th>审批人</th>
						<th>请假名称</th>
						<th>请假时间</th>
						<th>请假天数</th>
						<th>请假类型</th>
						<th>请假原因</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${pageModel.list != 'null'}">
						<c:forEach var="tmp" items="${pageModel.list}">
							<tr>
								<td><input name="id" value="${tmp.id }" type="checkbox">
								</td>
								<td>${tmp.user.s_2 }</td>
								<td>${tmp.user1.s_2}</td>
								<td>${tmp.s_0 }</td>
								<td>${tmp.s_1 }</td>
								<td>${tmp.s_2 }</td>
								<td>${tmp.s_3 }</td>
								<td>${tmp.s_4 }</td>
								<td>${tmp.s_5 }</td>
								<td><c:if test="${type == 'root' && tmp.s_5 == '申请中' || type == 'admin' && type == '辅导员同意'}">
										<a target="Conframe" class="tablelink"
											href="${pageContext.request.contextPath}/UserLeave-fdytyUtil.action?util.id=${tmp.id }">辅导员同意
										</a>
										<a target="Conframe" class="tablelink"
											href="${pageContext.request.contextPath}/UserLeave-fdybhUtil.action?util.id=${tmp.id }">辅导员拒绝
										</a>
									</c:if> <c:if test="${type == 'admin'}">

										<c:if test="${tmp.s_5 == '辅导员同意' || tmp.s_5 == '申请中'}">
											<a target="Conframe" class="tablelink"
												href="${pageContext.request.contextPath}/UserLeave-lstyUtil.action?util.id=${tmp.id }">
												教师同意 </a>
											<a target="Conframe" class="tablelink"
												href="${pageContext.request.contextPath}/UserLeave-lsbhUtil.action?util.id=${tmp.id }">
												教师拒绝 </a>
										</c:if>



										<a target="Conframe" class="tablelink"
											href="${pageContext.request.contextPath}/UserLeave-selectUtil.action?util.id=${tmp.id }">修改
										</a>
										<a target="Conframe" class="tablelink"
											href="${pageContext.request.contextPath}/UserLeave-deleteUtil.action?util.id=${tmp.id }">删除
										</a>
									</c:if> <c:if test="${type != 'admin'}">
										<a target="Conframe" class="tablelink"
											href="${pageContext.request.contextPath}/UserLeave-selectUtil.action?util.id=${tmp.id }">查看
										</a>
									</c:if></td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
			</c:if>
			<div class="pagin">
				<div class="message">
					共 <i class="blue">${pageModel.totalRecords}</i>条记录，当前显示第&nbsp; <i
						class="blue">${pageModel.currentPageNo}&nbsp;</i>页
				</div>
				<ul class="paginList">
					<li class="paginItem"><a href="javascript:;"
						onClick="javascript:topPage();">|&lt;&lt; </a></li>
					<li class="paginItem"><a href="javascript:;"
						onClick="javascript:previousPage();"> &lt; </a></li>
					<li class="paginItem"><a href="javascript:;"
						onClick="javascript:nextPage();"> &gt; </a></li>
					<li class="paginItem"><a href="javascript:;"
						onClick="javascript:bottomPage();"> &gt;&gt;|</a></li>
				</ul>
			</div>
	</div>
	<div class="tip">
		<div class="tiptop">
			<span>提示信息</span><a></a>
		</div>
		<div class="tipinfo">
			<span><img
				src="${pageContext.request.contextPath}/common/images/ticon.png" />
			</span>
			<div class="tipright">
				<p>是否确认删除所选记录 ？</p>
				<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
			</div>
		</div>
		<div class="tipbtn">
			<input class="btn btn-inverse" type="submit" value="确&nbsp;&nbsp;定"
				style="width: 80px; margin-left: 26px;" /> &nbsp; <input
				class="btn btn-inverse" type="reset" value="取&nbsp;&nbsp;消"
				style="width: 80px; margin-left: 26px;" />
		</div>
	</div>
	</form>
	<script type="text/javascript">
		$('.imgtable tbody tr:odd').addClass('odd');
	</script>

</body>
</html>
