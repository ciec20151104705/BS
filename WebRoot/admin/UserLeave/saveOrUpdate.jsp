<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../common.jsp"%>
<script type="text/javascript">
	KE.show({
		id : 'content7',
		cssPath : './index.css'
	});

	function check() {
		var s_0 = document.getElementById("util.s_0");
		if ('' == s_0.value.replace(/(^\s*)|(\s*$)/g, "")) {
			alert("����������");
			s_0.value = "";
			s_0.focus();
			return false;
		}
		return true;
	}
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>
</head>
<body>
	<div class="place">
		<span>��ǰλ��</span>
		<ul class="placeul">
			<li>��ٹ���</li>
			<li>���ӽ���</li>
		</ul>
	</div>
	<div class="formbody">
		<form
			action="${pageContext.request.contextPath}/UserLeave-saveOrUpdateObject.action"
			method="post" onsubmit="return check()">
			<input name="util.id" value="${util.id }" type="hidden" />
			<table
				class="table table-striped table-bordered table-condensed list">
				<thead>
					<tr>
						<td colspan="4"><b>��ٹ��� </b>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>�����</td>
						<td><select class="select2" name="util.user.id">
								<c:forEach var="type" items="${listUser}">
									<option
										<c:if test="${type.id == util.user.id }">
																	selected
																	</c:if>
										value="${type.id }">${type.s_0 }</option>
								</c:forEach>
						</select>
						</td>
						<c:if test="${type == 'admin'}">
							<td>������</td>
							<td><select class="select2" name="util.user.id">
									<c:forEach var="type" items="${listUser}">
										<option
											<c:if test="${type.id == util.user.id }">
																	selected
																	</c:if>
											value="${type.id }">${type.s_0 }</option>
									</c:forEach>
							</select>
							</td>
						</c:if>
					</tr>

					<tr>
						<td>�������</td>
						<td><input name="util.s_0" value="${util.s_0 }" type="text" />

						</td>
						<td>���ʱ��</td>
						<td>
							<div class="input-append">
								<input name="util.s_1" value="${util.s_1 }" type="text"
									class="span2 datepicker" readonly="readonly"
									onClick="WdatePicker();" /> <img width=30 height=30
									src="${pageContext.request.contextPath}/common/images/d04.png"
									title="����" />
							</div>
						</td>
					</tr>
					<tr>
						<td>�������</td>
						<td><input name="util.s_2" value="${util.s_2 }" type="text" />

						</td>
						<td>�������</td>
						<td><input name="util.s_3" value="${util.s_3 }" type="text" />
						</td>
					</tr>
					<tr>
						<td>���ԭ��</td>
						<td><input name="util.s_4" value="${util.s_4 }" type="text" />

						</td>
						<td>״̬</td>
						<td><input name="util.s_5" value="${util.s_5 }" type="text"
							readonly /></td>
					</tr>
					<tr>
						<td width="15%">��ע</td>
						<td width="500" colspan="3" height=""><textarea id="content7"
								name="util.s_6" style="width: 95%" rows="4" cols="5">${util.s_6 }</textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td>&nbsp;</td>
						<td colspan="3"><c:if
								test="${type == 'admin' || type == 'user' &&  null ==util.s_5 || type == 'user' &&  '' ==util.s_5 || type == 'root' &&  null ==util.s_5 || type == 'root' &&  '' ==util.s_5 }">
								<input class="btn btn-inverse" id="find" type="submit"
									value="����" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="btn btn-inverse" type="reset" value="ȡ��" />
								<font color=red><s:property value="errMsg" /> </font>
							</c:if>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<script type="text/javascript">
			$("#usual1 ul").idTabs();
			$('.tablelist tbody tr:odd').addClass('odd');
			</div>
			</body>
			</html>
		