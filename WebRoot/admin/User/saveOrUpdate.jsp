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
		 
			function check(){
				var s_0 = document.getElementById("util.s_0");
				if(null == s_0 || '' == s_0.value.replace(/(^\s*)|(\s*$)/g, "") ){
					alert("请输入用户名");
					s_0.value = "";
					s_0.focus();
					return false;
				}
				return true;
			}
		</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					用户管理
				</li>
				<li>
					增加界面
				</li>

			</ul>
		</div>

		<div class="formbody">
			<form
				action="${pageContext.request.contextPath}/User-saveOrUpdateObject.action"
				method="post" onsubmit="return check()">
				<input name="util.id" value="${util.id }" type="hidden" />
				<table
					class="table table-striped table-bordered table-condensed list">
					<thead>
						<tr>
							<td colspan="4">
								<b>用户管理 </b>
							</td>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>
								用户名
							</td>
							<td>
								<input name="util.s_0" id="util.s_0" value="${util.s_0 }"
									type="text" class="dfinput" />
							</td>
							<td>
								密码
							</td>
							<td>
								<input name="util.s_1" value="${util.s_1 }" type="text"
									class="dfinput" />
							</td>
						</tr>
						<tr>
							<td>
								姓名
							</td>
							<td>
								<input name="util.s_2" value="${util.s_2 }" type="text"
									class="dfinput" />
							</td>
							<td>
								出生日期
							</td>
							<td>
								<div class="input-append" style="float: left;">
									<input class="span2 datepicker" name="util.s_3"
										style="width: 160px;" value="${util.s_3 }" type="text"
										onClick="WdatePicker();" class="select2" readonly />
									<img width=30 height=30
										src="${pageContext.request.contextPath}/common/images/d04.png"
										title="日期" />
								</div>
							</td>
						</tr>
						<tr>
							<td>
								性别
							</td>
							<td>
								<select name="util.s_4" class="select2">
									<option <c:if test="${util.s_4 == '男'}">selected</c:if>
										value="男">
										男
									</option>
									<option <c:if test="${util.s_4 == '女'}">selected</c:if>
										value="女">
										女
									</option>
								</select>
							</td>
							<td>
								联系方式
							</td>
							<td>
								<input name="util.s_5" value="${util.s_5 }" type="text"
									class="dfinput" />
							</td>
						</tr>
						<tr>
							<td>
								紧急联系人
							</td>
							<td>
								<input name="util.s_6" value="${util.s_6 }" type="text"
									class="dfinput" />

							</td>
							<td>
								紧急联系方式
							</td>
							<td>
								<input name="util.s_7" value="${util.s_7 }" type="text"
									class="dfinput" />
							</td>
						</tr>
						<tr>
							<td>
								籍贯
							</td>
							<td>
								<input name="util.s_8" value="${util.s_8 }" type="text"
									class="dfinput" />

							</td>
							<td>
								家庭住址
							</td>
							<td>
								<input name="util.s_9" value="${util.s_9 }" type="text"
									class="dfinput" />
							</td>
						</tr>
						<tr>
							<td>
								爱好
							</td>
							<td>
								<input name="util.s_10" value="${util.s_10 }" type="text"
									class="dfinput" />
							</td>
							<td>
								身份类型
							</td>
							<td>
								<select name="util.s_11" class="select2">
									<option <c:if test="${util.s_11 == 'user'}">selected</c:if>
										value="root">
										<spring:message code="sys_user" />
									</option>
									<option <c:if test="${util.s_11 == 'root'}">selected</c:if>
										value="root">
										<spring:message code="sys_teacher" />
									</option>
									<option <c:if test="${util.s_11 == 'admin'}">selected</c:if>
										value="admin">
									<spring:message code="sys_admin" />
									</option>
								</select>
							</td>
						</tr>
						<tr>
							<td width="15%">
								备注
							</td>
							<td width="500" colspan="3" height="">
								<textarea name="util.s_15" style="width: 95%" rows="4" cols="5">${util.s_15 }</textarea>
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td>
								&nbsp;
							</td>
							<td colspan="3">
								<c:if test="${type == 'admin'}">
									<input class="btn btn-inverse" id="find" type="submit"
										value="确&nbsp;&nbsp;定" style="width: 80px; margin-left: 26px;" />
								</c:if>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input class="btn btn-inverse" type="reset"
									value="取&nbsp;&nbsp;消" style="width: 80px; margin-left: 26px;" />
								<font color=red><s:property value="errMsg" /> </font>
							</td>
						</tr>
					</tfoot>
				</table>
			</form>


			<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>

			<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

		


	</body>
</html>
