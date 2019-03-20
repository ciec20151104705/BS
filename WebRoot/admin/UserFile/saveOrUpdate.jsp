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
					
			function check(){
				var s_0 = document.getElementById("util.s_0");
				if('' == s_0.value.replace(/(^\s*)|(\s*$)/g, "") ){
					alert("请输入内容");
					s_0.value = "";
					s_0.focus();
					return false;
				}
				return true;
			}
		$(document).ready(function(e) {
		    $(".select1").uedSelect({
		width : 345	
		});    $(".select2").uedSelect({
		width : 167	
		});    $(".select3").uedSelect({
		width : 100	
		});
		});
		</script>
	</head>
	<body>
		<div class="place">
			<span>当前位置</span>
			<ul class="placeul"><li>文件管理
			</li>
		<li>增加界面</li>
		</ul>
		</div>
		<div class="formbody">
		<form
			action="${pageContext.request.contextPath}/UserFile-updateUtil.action"
			method="post"	onsubmit="return check()"	enctype="multipart/form-data">
			<input name="util.id" value="${util.id }" type="hidden" />
			<table
				class="table table-striped table-bordered table-condensed list">
				<thead>
					<tr>
						<td colspan="4">
							<b>文件管理 </b>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							文件地址
						</td>
						<td colspan="3">
							<div class="input-append">
								<s:file name="myFile"/>
								<font size="2" color="red">文件为空表示不修改文件</font>
							</div>
						</td>
					</tr>
<tr>
						<td>
							请假名称
						</td>
						<td  colspan="3" >
							<select  class="select2"  name="util.userLeave.id">
								<c:forEach var="type" items="${listUserLeave}">
									<option
										<c:if test="${type.id == util.userLeave.id }">
																	selected
																	</c:if>
										value="${type.id }">
										${type.s_0 }
									</option>
								</c:forEach>
							</select>
							
						</td>
					</tr>
					<tr>
						<td>
							文件名称
						</td>
						<td>
							<input name="util.s_3" value="${util.s_3 }" type="text" />
							
						</td>
						<td>
							说明
						</td>
						<td>
							<input name="util.s_4" value="${util.s_4 }" type="text" />
						</td>
					</tr>
					<tr>
						<td width="15%">
							备注
						</td>
						<td width="500" colspan="3" height="">
							<textarea id="content7"  name="util.s_5" style="width: 95%" rows="4" cols="5">${util.s_5 }</textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td>
							&nbsp;
						</td>
						<td colspan="3">
								<input class="btn btn-inverse" id="find" type="submit"
									value="保存" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="btn btn-inverse" type="reset" value="取消" /><font color=red><s:property value="errMsg" /> </font>
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