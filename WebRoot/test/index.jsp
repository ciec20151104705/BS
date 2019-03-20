<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>HTML5 Canvas折线图表和柱形图表DEMO演示</title>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jQuery.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/jquery.jqplot.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/examples/syntaxhighlighter/scripts/shCore.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/examples/syntaxhighlighter/scripts/shBrushJScript.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/examples/syntaxhighlighter/scripts/shBrushXml.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/plugins/jqplot.logAxisRenderer.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/plugins/jqplot.canvasTextRenderer.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/plugins/jqplot.canvasAxisLabelRenderer.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/plugins/jqplot.dateAxisRenderer.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/plugins/jqplot.categoryAxisRenderer.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/plugins/jqplot.barRenderer.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/plugins/jqplot.pointLabels.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/jqplot/plugins/jqplot.dateAxisRenderer.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/test/m_jqplot.js"></script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/test/jqplot/jquery.jqplot.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/test/jqplot/examples/syntaxhighlighter/styles/shCoreDefault.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/test/jqplot/examples/syntaxhighlighter/styles/shThemejqPlot.min.css " />
	</head>
	<body>

		<div id="chart1"></div>


		<div id="chart2"></div>
		<script type="text/javascript">
			
			var data = [[${data}]];
			var data_max = ${max}+10; //Y轴最大刻度
			var line_title = ["A","B"]; //曲线名称
			var y_label = "这是Y轴"; //Y轴标题
			var x_label = "这是X轴"; //X轴标题
			var x = [${data}]; //定义X轴刻度值
			var title = "这是标题"; //统计图标标题
			j.jqplot.diagram.base("chart1", data, line_title, "这是统计标题", x, x_label, y_label, data_max, 1);
			j.jqplot.diagram.base("chart2", data, line_title, "这是统计标题", x, x_label, y_label, data_max, 2);
		
		</script>
	</body>
</html>


