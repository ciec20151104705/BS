<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/common/tld/extremecomponents.tld" prefix="ec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="${pageContext.request.contextPath}/common/css/select.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/common/css/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/common/Styles/bootstrap.min.css" />
	
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/common/Scripts/My97DatePicker/WdatePicker.js"></script>	
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


