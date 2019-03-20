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
					密码管理
				</li>
			</ul>
		</div>

		<div class="formbody">


			<div id="usual1" class="usual">

				<div class="itab">
					<ul>
						<li class="selected">
							<a href="#tab1">修改密码</a>
						</li>

					</ul>
				</div>
				<form action="${pageContext.request.contextPath}/updatePwd.action"
					method="post">
					<div id="tab1" class="tabson">
						<input name="util.id" value="${util.id }" type="hidden" />
						<ul class="forminfo">

							<li>
								<label>
									原密码
								</label>
								<div class="vocation">
									<input name="util.s_3" type="text" class="dfinput" value="" />
								</div>
							</li>
							<li>
								<label>
									新密码
								</label>
								<div class="vocation">
									<input name="util.s_4" type="text" class="dfinput" value="" />
								</div>
							</li>
							<li>
								<label>
									确认新密码
								</label>
								<div class="vocation">
									<input name="util.s_5" type="text" class="dfinput" value="" />
								</div>
							</li>


							<li>
								<label>
									&nbsp;
								</label>
								<input name="" type="submit" class="btn btn-inverse"
									value="马上提交" />
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
