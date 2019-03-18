<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/common/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/common/css/main.css" />
<link href="${pageContext.request.contextPath}/common/css/select.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/common/css/style.css"
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
	$(function(){	
		$(".menuson li").click(function(){
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});
		
		$('.title').click(function(){
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if($ul.is(':visible')){
				$(this).next('ul').slideUp();
			}else{
				$(this).next('ul').slideDown();
			}
		});
	})	
</script>


