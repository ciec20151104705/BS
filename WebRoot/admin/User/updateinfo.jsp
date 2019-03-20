<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
  </script>

		<script type="text/javascript">
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
			<span>位置：</span>
			<ul class="placeul">
				<li>
					个人资料
				</li>
			</ul>
		</div>

		<div class="formbody">


			<div id="usual1" class="usual">

				<div class="itab">
					<ul>
						<li class="selected">
							<a href="#tab1">修改个人信息</a>
						</li>

					</ul>
				</div>
				<form action="${pageContext.request.contextPath}/updateInfo.action"
					method="post">
					<div id="tab1" class="tabson">
						<input name="util.id" value="${util.id }" type="hidden" />
						<input name="util.s_0" value="${util.s_0 }" type="hidden" />
						<input name="util.s_1" value="${util.s_1 }" type="hidden" />
						<input name="util.s_11" value="${util.s_11 }" type="hidden" />
						<ul class="forminfo">

							<li>
								<label>
									姓名
								</label>
								<div class="vocation">
									<input name="util.s_2" value="${util.s_2 }" type="text"
										class="dfinput" value="" />
								</div>
								<label class="second">
									出生日期
								</label>
								<div class="vocation">
									<input class="span2 datepicker" name="util.s_3"
										onClick="WdatePicker();" value="${util.s_3 }" type="text"
										readonly />
									<img width=30 height=30
										style="float: right; margin-left: 10px;"
										src="${pageContext.request.contextPath}/common/images/d04.png"
										title="日期" />
								</div>
							</li>


							<li>
								<label>
									性别
								</label>

								<div class="vocation">
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
								</div>
								<label style="padding-left: 228px;">
									联系方式
								</label>

								<div class="vocation">

									<input name="util.s_5" value="${util.s_5 }" type="text"
										class="dfinput" value="" />

								</div>
							</li>

							<li>
								<label>
									紧急联系人
								</label>

								<div class="vocation">
									<input class="dfinput" name="util.s_6" value="${util.s_6 }"
										type="text" />

								</div>
								<label class="second">
									紧急联系方式
								</label>

								<div class="vocation">
									<input class="dfinput" name="util.s_7" value="${util.s_7 }"
										type="text" />
								</div>

							</li>
							<li>
								<label>
									籍贯
								</label>

								<div class="vocation">
									<input class="dfinput" name="util.s_8" value="${util.s_8 }"
										type="text" />

								</div>
								<label class="second">
									家庭住址
								</label>

								<div class="vocation">
									<input class="dfinput" name="util.s_9" value="${util.s_9 }"
										type="text" />
								</div>

							</li>
							<li>
								<label>
									爱好
								</label>

								<div class="vocation">
									<input class="dfinput" name="util.s_10" value="${util.s_10 }"
										type="text" />

								</div>
								<label class="second">
									身份类型
								</label>

								<label class="second">
									<c:if test="${util.s_11 == 'admin'}">
										<spring:message code="sys_admin" />
									</c:if>
									<c:if test="${util.s_11 == 'root'}">
										<spring:message code="sys_teacher" />
									</c:if>
									<c:if test="${util.s_11 == 'user'}">
										<spring:message code="sys_user" />
									</c:if>
								</label>

							</li>
							<li>
								<label>
									备注
								</label>
								<textarea id="content7" name="util.s_15"
									style="width: 700px; height: 250px; visibility: hidden;">${util.s_15 }</textarea>
							</li>
							<li>
								<label>
									&nbsp;
								</label>
								<c:if test="${type == 'admin'}">
									<input name="" type="submit" class="btn btn-inverse"
										value="马上提交" />
								</c:if>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input class="btn btn-inverse" type="reset"
									value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;" />
								<font color=red><s:property value="errMsg" /> </font>
							</li>
						</ul>

					</div>
				</form>

			</div>

			<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>

			<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

		</div>

	</body>
</html>
