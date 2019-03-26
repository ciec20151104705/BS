package org.apache.tools.ant.taskdefs.optional.junit03;

import java.util.ArrayList;

public class UtilsJsp {

	public static StringBuffer createHibernateCfgXml(String packName,
			ArrayList<String> _NAMES) {
		StringBuffer _S_B = new StringBuffer();

		_S_B
				.append("<!DOCTYPE hibernate-configuration PUBLIC\n \t\"-//Hibernate/Hibernate Configuration DTD 3.0//EN\"\n \t\"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd\">\n \n<hibernate-configuration>\n \t<session-factory>\n \t\t<property name=\"hibernate.connection.url\">\n \t\t\tjdbc:mysql://localhost/LXMSystem\n \t\t</property>\n \t\t<property name=\"hibernate.connection.driver_class\">\n \t\t\tcom.mysql.jdbc.Driver\n \t\t</property>\n \t\t<property name=\"hibernate.connection.username\">root</property>\n \t\t<property name=\"hibernate.connection.password\">root</property>\n \t\t<property name=\"hibernate.dialect\">\n \t\t\torg.hibernate.dialect.MySQLDialect\n \t\t</property>\n \t\t<property name=\"hibernate.show_sql\">true</property>\n \t\t<property name=\"hibernate.current_session_context_class\">\n \t\t\tthread\n \t\t</property>\n \t\t<property name=\"connection.useUnicode\">true</property>\n \t\t<property name=\"connection.characterEncoding\">UTF-8</property>\n \n\t\t<mapping resource=\"bysj/net/model/User.hbm.xml\" />\n");

		for (int j = 0; j < _NAMES.size(); j++) {

			_S_B.append("\t\t<mapping resource=\"" + packName + "/"
					+ _NAMES.get(j) + ".hbm.xml\" />\n ");

		}

		_S_B.append("\n\t</session-factory>\n</hibernate-configuration>\n ");

		return _S_B;
	}

	public static StringBuffer createApplicationContextXml(String packName,
			ArrayList<String> _NAMES) {
		StringBuffer _S_B = new StringBuffer();

		_S_B
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n<beans xmlns=\"http://www.springframework.org/schema/beans\"\n\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n\txmlns:aop=\"http://www.springframework.org/schema/aop\"\n\txmlns:tx=\"http://www.springframework.org/schema/tx\"\n\txsi:schemaLocation=\"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd\n           http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.0.xsd\n           http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.0.xsd\">\n\n\t<!-- sessionFactory -->\n\t<bean id=\"sessionFactory\"\n\t\tclass=\"org.springframework.orm.hibernate3.LocalSessionFactoryBean\">\n\t\t<property name=\"configLocation\">\n\t\t\t<value>classpath:hibernate.cfg.xml</value>\n\t\t</property>\n\t</bean>\n\n\t<bean id=\"transactionManager\"\n\t\tclass=\"org.springframework.orm.hibernate3.HibernateTransactionManager\">\n\t\t<property name=\"sessionFactory\">\n\t\t\t<ref bean=\"sessionFactory\" />\n\t\t</property>\n\t</bean>\n\n\t<bean id=\"messageSource\"\n\t\tclass=\"org.springframework.context.support.ResourceBundleMessageSource\">\n\t\t<property name=\"basename\" value=\"message\" />\n\t</bean>\n\n\t<bean id=\"ObjectManagerImpl\"\n\t\tclass=\"bysj.net.manager.ObjectManagerImpl\" />\n\n\t<!-- ====================================================== -->\n\t<bean id=\"LoginAction\" class=\"bysj.net.action.LoginAction\">\n\t\t<property name=\"objectManager\" ref=\"ObjectManagerImpl\" />\n\t</bean>\n\t<bean id=\"UserAction\" class=\"bysj.net.action.UserAction\">\n\t\t<property name=\"objectManager\" ref=\"ObjectManagerImpl\" />\n\t</bean>\n");

		for (int j = 0; j < _NAMES.size(); j++) {
			_S_B
					.append("\n\t<bean id=\""
							+ _NAMES.get(j)
							+ "Action\" class=\"bysj.net.action."
							+ _NAMES.get(j)
							+ "Action\">\n\t\t<property name=\"objectManager\" ref=\"ObjectManagerImpl\" />\n\t</bean>");
		}

		_S_B.append("\n</beans>");

		return _S_B;
	}

	// 普通类save Jsp
	public static StringBuffer createSaveOrUpdateObjectJsp1(String _NAME,
			String _VALUE, ArrayList<String> _VALUES) {
		StringBuffer _S_B = new StringBuffer();
		int num = _VALUES.size();
		int j = 0;
		_S_B
				.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n\tpageEncoding=\"GBK\"%>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\t<head>\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t\t<title>Insert title here</title>\n\t\t<%@ include file=\"../common.jsp\"%>\n\t\t<script type=\"text/javascript\">\n\t\t\tKE.show({ \n\t\t\t\tid : 'content7',\n\t\t\t\tcssPath : './index.css'\n\t\t\t\t});\n\t\t\tfunction check(){\n\t\t\t\tvar s_0 = document.getElementById(\"util.s_0\");\n\t\t\t\tif('' == s_0.value.replace(/(^\\s*)|(\\s*$)/g, \"\") ){\n\t\t\t\t\talert(\"请输入内容\");\n\t\t\t\t\ts_0.value = \"\";\n\t\t\t\t\ts_0.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\treturn true;\n\t\t\t}\n\t\t$(document).ready(function(e) {\n\t\t    $(\".select1\").uedSelect({\n\t\twidth : 345	\n\t\t});    $(\".select2\").uedSelect({\n\t\twidth : 167	\n\t\t});    $(\".select3\").uedSelect({\n\t\twidth : 100	\n\t\t});\n\t\t});\n\t\t</script>\n\t</head>\n\t<body>\n\t\t<div class=\"place\">\n\t\t\t<span>当前位置</span>\n\t\t\t<ul class=\"placeul\"><li>"
						+ _VALUE
						+ "\n\t\t\t</li>\n\t\t<li>增加界面</li>\n\t\t</ul>\n\t\t</div>\n\t\t<div class=\"formbody\">\n\t\t<form\n\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-saveOrUpdateObject.action\"\n\t\t\tmethod=\"post\"  onsubmit=\"return check()\">\n\t\t\t<input name=\"util.id\" value=\"${util.id }\" type=\"hidden\" />\n\t\t\t<table\n\t\t\t\tclass=\"table table-striped table-bordered table-condensed list\">\n\t\t\t\t<thead>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\">\n\t\t\t\t\t\t\t<b>"
						+ _VALUE
						+ " </b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t\t\t\t<tbody>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
						+ _VALUES.get(0)
						+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_0\" id=\"util.s_0\" value=\"${util.s_0 }\" type=\"text\" />\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
						+ _VALUES.get(1)
						+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<div class=\"input-append\">\n\t\t\t\t\t\t\t\t<input name=\"util.s_1\" value=\"${util.s_1 }\" type=\"text\"\n\t\t\t\t\t\t\t\t\tclass=\"span2 datepicker\" onClick=\"WdatePicker();\" readonly=\"readonly\" />\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<img width=30 height=30 src=\"${pageContext.request.contextPath}/common/images/d04.png\" title=\"日期\" />\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");

		for (j = 2; j < num - 2; j = j + 2) {
			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(j)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ j
							+ "\" value=\"${util.s_"
							+ j
							+ " }\" type=\"text\" />\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(j + 1)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ (j + 1)
							+ "\" value=\"${util.s_"
							+ (j + 1)
							+ " }\" type=\"text\" />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");
		}

		if ((j - 1) != (num - 2)) {
			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(num - 2)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ (num - 2)
							+ "\" size=100 class=123 value=\"${util.s_"
							+ (num - 2)
							+ " }\"\n\t\t\t\t\t\t\t\ttype=\"text\" />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"2\"></td>\n\t\t\t\t\t</tr>\n");
		}
		_S_B
				.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"15%\">\n\t\t\t\t\t\t\t"
						+ _VALUES.get(num - 1)
						+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"500\" colspan=\"3\" height=\"\">\n\t\t\t\t\t\t\t<textarea id=\"content7\"  name=\"util.s_"
						+ (num - 1)
						+ "\" style=\"width: 95%\" rows=\"4\" cols=\"5\">${util.s_"
						+ (num - 1)
						+ " }</textarea>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");
		_S_B
				.append("\t\t\t\t</tbody>\n\t\t\t\t<tfoot>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"3\">\n\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\">\n\t\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" id=\"find\" type=\"submit\"\n\t\t\t\t\t\t\t\t\tvalue=\"保存\" />\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" type=\"reset\" value=\"取消\" /><font color=red><s:property value=\"errMsg\" /> </font>\n\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</tfoot>\n\t\t\t</table>\n\t\t</form>\n\t<script type=\"text/javascript\"> \n\t$(\"#usual1 ul\").idTabs();\n\t$('.tablelist tbody tr:odd').addClass('odd');\n\t</div>\n\t</body>\n</html>");
		return _S_B;
	}

	// 普通类find Jsp
	public static StringBuffer createFindJsp1(String _NAME, String _VALUE,
			ArrayList<String> _VALUES) {
		StringBuffer _S_B = new StringBuffer();
		int num = _VALUES.size() - 1;

		_S_B
				.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n\tpageEncoding=\"GBK\"%>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\t<head>\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t\t<title>Insert title here</title>\n\t\t<%@ include file=\"../com.jsp\"%>\n\t\t<script type=\"text/javascript\">\n\tfunction topPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.topPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction previousPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.previousPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction nextPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.nextPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction bottomPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.buttomPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\t\t\t\t$(document).ready(function(){\n\t\t\t$(\".click\").click(function(){\n"
						+ "\n"
						+ "\t\t\t\tvar ids = document.getElementsByName(\"id\");\n"
						+ "\t\t\t\tvar flag = 0;\n"
						+ "\t\t\t\tfor(var i = 0; i < ids.length; i++){\n"
						+ "\t\t\t\t\tif(ids[i].checked){\n"
						+ "\t\t\t\t\t\tflag = 1;\n"
						+ "\t\t\t\t\t\tbreak;\n"
						+ "\t\t\t\t\t}\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t\tif(flag == 1){\n"
						+ "\t\t\t\t\t$(\".tip\").fadeIn(200);\n"
						+ "\t\t\t\t}else{\n"
						+ "\t\t\t\t\talert(\"至少选中一条记录\");\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t\t\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".tiptop a\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(200);\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".sure\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(100);\n"
						+ "\t\t\t\t\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".cancel\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(100);\n"
						+ "\t\t\t});\n"
						+ "\t\t\n"
						+ "\t\t});\n"
						+ "\t\t\n"
						+ "\t\tfunction check(){\n"
						+ "\t\t\treturn true;\n"
						+ "\t\t}\n"
						+ "\n\t</script>\n\t</head>\n\t<body>\n\t\t<div class=\"place\">\n\t\t\t<span>当前位置</span>\n\t\t\t<ul class=\"placeul\"><li>"
						+ _VALUE
						+ "\n\t\t\t</li>\n\t\t<li>查询界面</li>\n\t\t</ul>\n\t\t</div>\t\t<div class=\"rightinfo\">\n\t\t<div class=\"tools\">\n\t\t\n\t\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\"><ul class=\"toolbar\" style=\"margin-top:-10px;\">\n\t\t\t\t\t\t\t<li class=\"click\">\n\t\t\t\t\t\t<span><img\n\t\t\t\t\t\t\t\tsrc=\"${pageContext.request.contextPath}/common/images/t03.png\" />\n\t\t\t\t\t\t</span>批量删除\n\t\t\t\t\t</li>\n\t\t\t\t</ul></c:if>\n\t\t<form\n\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-getAllUtil.action\">\n\t\t\t<ul class=\"toolbar1\" style=\"float: left;margin-top:-10px;\">\n\t\t\t<li style=\"font-size: 16px; margin-left: 26px;\">"
						+ "\n\t\t\t请填写查询条件\n\t\t\t<span> </span>\n\t\t\t</li>\n\t\t\t<li style=\"margin-left: 26px;\">\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t \n\t\t\t\t\t\t\t<select id=\"field\" name=\"field\" style=\"font-size: 20px; background-color: #F9F9F9; margin: 3px 0px 0px 10px;\">\n\t\t\t\t\t\t\t\t");

		if (num > 8)
			num = 8;

		// num--;

		for (int j = 0; j < num; j++) {
			_S_B.append("<option <c:if test=\"${field == 's_" + j
					+ "'}\">selected</c:if> value=\"s_" + j
					+ "\" />\n\t\t\t\t\t\t\t\t\t" + _VALUES.get(j)
					+ "\n\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t");
		}

		_S_B
				.append("</select>\n\t\t\t\t\t\t</li> \n\t\t\t\t\t\t<div style=\"float: left; margin-left: 20px; margin-top: 0px;\">\n\t\t\t\t\t\t\t<input class=\"dfinput\" type=\"text\" name=\"fieldValue\" id=\"fieldValue\" value=\"${fieldValue }\" style=\"width: 350px;\" />\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"float: left; margin-top: 0px;\">\n\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" id=\"find\" type=\"submit\" value=\"查&nbsp;&nbsp;询\" style=\"width: 80px; margin-left: 26px;\" />\n\t\t\t\t\t\t\t&nbsp;&nbsp; <input class=\"btn btn-inverse\" type=\"button\" value=\"清&nbsp;&nbsp;空\" onclick=\"javascript: document.getElementById('fieldValue').value='';\" style=\"width: 80px; margin-left: 10px;\" />&nbsp;&nbsp;\n\t\t\t\t\t\t\t     \n\t\t\t\t\t\t</div>\n\t\t\t\t\t</ul>\n\t\t\t\t</form>\n\t\t\t</div>"
						+ "\t\t\t<form\n\t\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-deleteManyUtil.action\"\n\t\t\t\tname=\"myform\" id=\"listform\" method=\"post\" onsubmit=\"return check()\">\n\t\t\t<table class=\"imgtable\"><thead>\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t<th width=\"78px;\">\t\t\t\t\t\t\t\t<input id=\"checkall\" name=\"checkall\" type=\"checkbox\">\t\t\t\t\t\t\t\t全选\t\t\t\t\t\t\t</th>");

		for (int j = 0; j < num; j++) {
			_S_B.append("\t\t\t\t\t\t<th>\n\t\t\t\t\t\t\t" + _VALUES.get(j)
					+ "\n\t\t\t\t\t\t</th>\n");
		}

		_S_B
				.append("\t\t\t\t\t\t<th>\n\t\t\t\t\t\t\t操作\n\t\t\t\t\t\t</th>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t\t\t\t<tbody>\n\t\t\t\t\t<c:if test=\"${pageModel.list != 'null'}\">\n\t\t\t<c:forEach var=\"tmp\" items=\"${pageModel.list}\">\n\t\t\t\t\t\t<tr>\n"
						+ "<td> \n\t\t\t\t\t\t\t<input name=\"id\" value=\"${tmp.id }\" type=\"checkbox\"> </td>");

		for (int j = 0; j < num; j++) {
			_S_B.append("\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t${tmp.s_" + j
					+ " }\n\t\t\t\t\t\t\t</td>\n");
		}

		_S_B
				.append("\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\">\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-selectUtil.action?util.id=${tmp.id }\">修改\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-deleteUtil.action?util.id=${tmp.id }\">删除\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t\t<c:if test=\"${type != 'admin'}\">\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-selectUtil.action?util.id=${tmp.id }\">查看\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</c:forEach>\n\t\t\t\t</c:if>\n\t\t\t\t</tbody>\n\t\t\t</table>\n\t\t "

						+ "<div class=\"pagin\">\n"
						+ "\t\t\t\t\t<div class=\"message\">\n"
						+ "\t\t\t\t\t\t共\n"
						+ "\t\t\t\t\t\t<i class=\"blue\">${pageModel.totalRecords}</i>条记录，当前显示第&nbsp;\n"
						+ "\t\t\t\t\t\t<i class=\"blue\">${pageModel.currentPageNo}&nbsp;</i>页\n"
						+ "\t\t\t\t\t</div>\n"
						+ "\t\t\t\t\t<ul class=\"paginList\">\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:topPage();\">|&lt;&lt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:previousPage();\"> &lt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:nextPage();\"> &gt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:bottomPage();\"> &gt;&gt;|</a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t</ul>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t<div class=\"tip\">\n"
						+ "\t\t\t<div class=\"tiptop\">\n"
						+ "\t\t\t\t<span>提示信息</span><a></a>\n"
						+ "\t\t\t</div>\n"
						+ "\t\t\t<div class=\"tipinfo\">\n"
						+ "\t\t\t\t<span><img\n"
						+ "\t\t\t\t\t\tsrc=\"${pageContext.request.contextPath}/common/images/ticon.png\" />\n"
						+ "\t\t\t\t</span>\n"
						+ "\t\t\t\t<div class=\"tipright\">\n"
						+ "\t\t\t\t\t<p>\n"
						+ "\t\t\t\t\t\t是否确认删除所选记录 ？\n"
						+ "\t\t\t\t\t</p>\n"
						+ "\t\t\t\t\t<cite>如果是请点击确定按钮 ，否则请点取消。</cite>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t\t</div>\n"
						+ "\t\t\t<div class=\"tipbtn\">\n"
						+ "\t\t\t\t<input class=\"btn btn-inverse\" type=\"submit\" value=\"确&nbsp;&nbsp;定\"\n"
						+ "\t\t\t\t\tstyle=\"width: 80px; margin-left: 26px;\" />\n"
						+ "\t\t\t\t&nbsp;\n"
						+ "\t\t\t\t<input class=\"btn btn-inverse\" type=\"reset\" value=\"取&nbsp;&nbsp;消\"\n"
						+ "\t\t\t\t\tstyle=\"width: 80px; margin-left: 26px;\" />\n"
						+ "\t\t\t</div>\n"
						+ "\t\t</div>\n"
						+ "\t\t</form>\n"
						+ "\t\t<script type=\"text/javascript\">\n"
						+ "\t$('.imgtable tbody tr:odd').addClass('odd');\n"
						+ "\t</script>\n"

						+ "\n\t</body>\n</html>\n");
		return _S_B;
	}

	// 有父类普通类 save Jsp
	public static StringBuffer createSaveOrUpdateObjectJspN(String _NAME,
			String _VALUE, ArrayList<String> _VALUES,
			ArrayList<String> _fields, ArrayList<String> _NAMES) {
		String First = "", first = "";

		int a = 0, b = 0;
		boolean flag = false;
		for (int i = 0; i < _fields.size(); i++) {
			flag = false;
			for (int j = 0; j < _NAMES.size(); j++) {
				if (_fields.get(i).equals(_NAMES.get(j))) {
					flag = true;
				}
			}
			if (flag) {
				a++;// 父类数
			} else {
				b++;// 普通属性数
			}
		}

		StringBuffer _S_B = new StringBuffer();
		int num = _fields.size();
		int j = 0;
		_S_B
				.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n\tpageEncoding=\"GBK\"%>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\t<head>\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t\t<title>Insert title here</title>\n\t\t<%@ include file=\"../common.jsp\"%>\n\t\t<script type=\"text/javascript\">\n\t\t\tKE.show({ \n\t\t\t\tid : 'content7',\n\t\t\t\tcssPath : './index.css'\n\t\t\t\t});\n\t\t\t\t\t \n\t\t\tfunction check(){\n\t\t\t\tvar s_0 = document.getElementById(\"util.s_0\");\n\t\t\t\tif('' == s_0.value.replace(/(^\\s*)|(\\s*$)/g, \"\") ){\n\t\t\t\t\talert(\"请输入内容\");\n\t\t\t\t\ts_0.value = \"\";\n\t\t\t\t\ts_0.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\treturn true;\n\t\t\t}\n\t\t$(document).ready(function(e) {\n\t\t    $(\".select1\").uedSelect({\n\t\twidth : 345	\n\t\t});    $(\".select2\").uedSelect({\n\t\twidth : 167	\n\t\t});    $(\".select3\").uedSelect({\n\t\twidth : 100	\n\t\t});\n\t\t});\n\t\t</script>\n\t</head>\n\t<body>\n\t\t<div class=\"place\">\n\t\t\t<span>当前位置</span>\n\t\t\t<ul class=\"placeul\"><li>"
						+ _VALUE
						+ "\n\t\t\t</li>\n\t\t<li>增加界面</li>\n\t\t</ul>\n\t\t</div>\n\t\t<div class=\"formbody\">\n\t\t<form\n\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-saveOrUpdateObject.action\"\n\t\t\tmethod=\"post\" onsubmit=\"return check()\">\n\t\t\t<input name=\"util.id\" value=\"${util.id }\" type=\"hidden\" />\n\t\t\t<table\n\t\t\t\tclass=\"table table-striped table-bordered table-condensed list\">\n\t\t\t\t<thead>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\">\n\t\t\t\t\t\t\t<b>"
						+ _VALUE
						+ " </b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t\t\t\t<tbody>\n\t\t\t\t\t");
		int i = 0;

		for (i = 0; i < a; i += 2) {
			_S_B.append("<tr>\n\t\t\t\t\t\t");

			First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
			first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(i)));

			_S_B.append("<td>\n\t\t\t\t\t\t\t" + _VALUES.get(i)
					+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td ");

			if ((i + 1) >= a) {
				_S_B.append(" colspan=\"3\" ");
			}

			_S_B
					.append(">\n\t\t\t\t\t\t\t<select  class=\"select2\" name=\"util."
							+ first
							+ ".id\">\n\t\t\t\t\t\t\t\t<c:forEach var=\"type\" items=\"${list"
							+ First
							+ "}\">\n\t\t\t\t\t\t\t\t\t<option\n\t\t\t\t\t\t\t\t\t\t<c:if test=\"${type.id == util."
							+ first
							+ ".id }\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tselected\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t\t\t\tvalue=\"${type.id }\">\n\t\t\t\t\t\t\t\t\t\t${type.s_0 }\n\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t</c:forEach>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>");

			First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i + 1)));
			first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(i + 1)));
			if ((i + 1) < a) {
				_S_B
						.append("<td>\n\t\t\t\t\t\t\t"
								+ _VALUES.get(i + 1)
								+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td >\n\t\t\t\t\t\t\t<select class=\"select2\"  name=\"util."
								+ first
								+ ".id\">\n\t\t\t\t\t\t\t\t<c:forEach var=\"type\" items=\"${list"
								+ First
								+ "}\">\n\t\t\t\t\t\t\t\t\t<option\n\t\t\t\t\t\t\t\t\t\t<c:if test=\"${type.id == util."
								+ first
								+ ".id }\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tselected\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t\t\t\tvalue=\"${type.id }\">\n\t\t\t\t\t\t\t\t\t\t${type.s_0 }\n\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t</c:forEach>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>");

			}

			_S_B.append("\n\t\t\t\t\t</tr>\n");

		}// end for

		_S_B
				.append("\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
						+ _VALUES.get(a)
						+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
						+ (0)
						+ "\" value=\"${util.s_"
						+ (0)
						+ " }\" type=\"text\" />\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
						+ _VALUES.get(a + 1)
						+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<div class=\"input-append\">\n\t\t\t\t\t\t\t\t<input name=\"util.s_"
						+ (1)
						+ "\" value=\"${util.s_"
						+ (1)
						+ " }\" type=\"text\"\n\t\t\t\t\t\t\t\t\tclass=\"span2 datepicker\" readonly=\"readonly\"  onClick=\"WdatePicker();\"/>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<img width=30 height=30 src=\"${pageContext.request.contextPath}/common/images/d04.png\" title=\"日期\" />\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");

		for (j = a + 2; j < num - 2; j = j + 2) {
			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(j)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ (j - a)
							+ "\" value=\"${util.s_"
							+ (j - a)
							+ " }\" type=\"text\" />\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(j + 1)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ (j - a + 1)
							+ "\" value=\"${util.s_"
							+ (j - a + 1)
							+ " }\" type=\"text\" />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");
		}

		if (b % 2 != 0) {
			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"15%\">\n\t\t\t\t\t\t\t"
							+ _VALUES.get(num - 1)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"500\" colspan=\"3\" height=\"\">\n\t\t\t\t\t\t\t<textarea id=\"content7\"  name=\"util.s_"
							+ (b - 1)
							+ "\" style=\"width: 95%\" rows=\"4\" cols=\"5\">${util.s_"
							+ (b - 1)
							+ " }</textarea>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");

		} else {
			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(num - 2)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ (b - 2)
							+ "\" size=100 class=123 value=\"${util.s_"
							+ (b - 2)
							+ " }\"\n\t\t\t\t\t\t\t\ttype=\"text\" />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"2\"></td>\n\t\t\t\t\t</tr>\n");

			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"15%\">\n\t\t\t\t\t\t\t"
							+ _VALUES.get(num - 1)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"500\" colspan=\"3\" height=\"\">\n\t\t\t\t\t\t\t<textarea id=\"content7\"  name=\"util.s_"
							+ (b - 1)
							+ "\" style=\"width: 95%\" rows=\"4\" cols=\"5\">${util.s_"
							+ (b - 1)
							+ " }</textarea>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");

		}
		_S_B
				.append("\t\t\t\t</tbody>\n\t\t\t\t<tfoot>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"3\">\n\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\">\n\t\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" id=\"find\" type=\"submit\"\n\t\t\t\t\t\t\t\t\tvalue=\"保存\" />\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" type=\"reset\" value=\"取消\" /><font color=red><s:property value=\"errMsg\" /> </font>\n\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</tfoot>\n\t\t\t</table>\n\t\t</form>\n\t<script type=\"text/javascript\"> \n\t$(\"#usual1 ul\").idTabs();\n\t$('.tablelist tbody tr:odd').addClass('odd');\n\t</div>\n\t</body>\n</html>");
		return _S_B;
	}

	// 有父类普通类 find Jsp
	public static StringBuffer createFindJspN(String _NAME, String _VALUE,
			ArrayList<String> _VALUES, ArrayList<String> _fields,
			ArrayList<String> _NAMES) {
		String first = "";

		int a = 0, b = 0;
		boolean flag = false;
		for (int i = 0; i < _fields.size(); i++) {
			flag = false;
			for (int j = 0; j < _NAMES.size(); j++) {
				if (_fields.get(i).equals(_NAMES.get(j))) {
					flag = true;
				}
			}
			if (flag) {
				a++;
			} else {
				b++;
			}
		}

		StringBuffer _S_B = new StringBuffer();
		int num = _fields.size();

		_S_B
				.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n\tpageEncoding=\"GBK\"%>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\t<head>\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t\t<title>Insert title here</title>\n\t\t<%@ include file=\"../com.jsp\"%>\n\t\t<script type=\"text/javascript\">\n\tfunction topPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.topPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction previousPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.previousPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction nextPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.nextPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction bottomPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.buttomPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\t\t\t\t$(document).ready(function(){\n\t\t\t$(\".click\").click(function(){\n"
						+ "\n"
						+ "\t\t\t\tvar ids = document.getElementsByName(\"id\");\n"
						+ "\t\t\t\tvar flag = 0;\n"
						+ "\t\t\t\tfor(var i = 0; i < ids.length; i++){\n"
						+ "\t\t\t\t\tif(ids[i].checked){\n"
						+ "\t\t\t\t\t\tflag = 1;\n"
						+ "\t\t\t\t\t\tbreak;\n"
						+ "\t\t\t\t\t}\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t\tif(flag == 1){\n"
						+ "\t\t\t\t\t$(\".tip\").fadeIn(200);\n"
						+ "\t\t\t\t}else{\n"
						+ "\t\t\t\t\talert(\"至少选中一条记录\");\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t\t\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".tiptop a\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(200);\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".sure\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(100);\n"
						+ "\t\t\t\t\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".cancel\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(100);\n"
						+ "\t\t\t});\n"
						+ "\t\t\n"
						+ "\t\t});\n"
						+ "\t\t\n"
						+ "\t\tfunction check(){\n"
						+ "\t\t\treturn true;\n"
						+ "\t\t}\n"
						+ "\n\t</script>\n\t</head>\n\t<body>\n\t\t<div class=\"place\">\n\t\t\t<span>当前位置</span>\n\t\t\t<ul class=\"placeul\"><li>"
						+ _VALUE
						+ "\n\t\t\t</li>\n\t\t<li>查询界面</li>\n\t\t</ul>\n\t\t</div>\t\t<div class=\"rightinfo\">\n\t\t<div class=\"tools\">\n\t\t\n\t\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\"><ul class=\"toolbar\" style=\"margin-top:-10px;\">\n\t\t\t\t\t\t\t<li class=\"click\">\n\t\t\t\t\t\t<span><img\n\t\t\t\t\t\t\t\tsrc=\"${pageContext.request.contextPath}/common/images/t03.png\" />\n\t\t\t\t\t\t</span>批量删除\n\t\t\t\t\t</li>\n\t\t\t\t</ul></c:if>\n\t\t<form\n\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-getAllUtil.action\">\n\t\t\t<ul class=\"toolbar1\" style=\"float: left;margin-top:-10px;\">\n\t\t\t<li style=\"font-size: 16px; margin-left: 26px;\">"
						+ "\n\t\t\t请填写查询条件\n\t\t\t<span> </span>\n\t\t\t</li>\n\t\t\t<li style=\"margin-left: 26px;\">\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t \n\t\t\t\t\t\t\t<select id=\"field\" name=\"field\" style=\"font-size: 20px; background-color: #F9F9F9; margin: 3px 0px 0px 10px;\">\n\t\t\t\t\t\t\t\t");

		if (num > 8)
			num = 8;
		num--;

		for (int j = 0; j < num; j++) {
			first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(j)));

			if (j < a) {
				_S_B.append("<option <c:if test=\"${field == '" + first
						+ ".s_0'}\">selected</c:if> value=\"" + first
						+ ".s_0\" />\n\t\t\t\t\t\t\t\t\t" + _VALUES.get(j)
						+ "\n\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t");
			} else {
				_S_B.append("<option <c:if test=\"${field == 's_" + (j - a)
						+ "'}\">selected</c:if> value=\"s_" + (j - a)
						+ "\" />\n\t\t\t\t\t\t\t\t\t" + _VALUES.get(j)
						+ "\n\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t");
			}

		}

		_S_B
				.append("</select>\n\t\t\t\t\t\t</li> \n\t\t\t\t\t\t<div style=\"float: left; margin-left: 20px; margin-top: 0px;\">\n\t\t\t\t\t\t\t<input class=\"dfinput\" type=\"text\" name=\"fieldValue\" id=\"fieldValue\" value=\"${fieldValue }\" style=\"width: 350px;\" />\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"float: left; margin-top: 0px;\">\n\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" id=\"find\" type=\"submit\" value=\"查&nbsp;&nbsp;询\" style=\"width: 80px; margin-left: 26px;\" />\n\t\t\t\t\t\t\t&nbsp;&nbsp; <input class=\"btn btn-inverse\" type=\"button\" value=\"清&nbsp;&nbsp;空\" onclick=\"javascript: document.getElementById('fieldValue').value='';\" style=\"width: 80px; margin-left: 10px;\" />&nbsp;&nbsp;\n\t\t\t\t\t\t\t     \n\t\t\t\t\t\t</div>\n\t\t\t\t\t</ul>\n\t\t\t\t</form>\n\t\t\t</div>"
						+ "\t\t\t<form\n\t\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-deleteManyUtil.action\"\n\t\t\t\tname=\"myform\" id=\"listform\" method=\"post\" onsubmit=\"return check()\">\n\t\t\t<table class=\"imgtable\"><thead>\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t<th width=\"78px;\">\t\t\t\t\t\t\t\t<input id=\"checkall\" name=\"checkall\" type=\"checkbox\">\t\t\t\t\t\t\t\t全选\t\t\t\t\t\t\t</th>");
		for (int j = 0; j < num; j++) {
			_S_B.append("\t\t\t\t\t\t<th>\n\t\t\t\t\t\t\t" + _VALUES.get(j)
					+ "\n\t\t\t\t\t\t</th>\n");
		}

		_S_B
				.append("\t\t\t\t\t\t<th>\n\t\t\t\t\t\t\t操作\n\t\t\t\t\t\t</th>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t\t\t\t<tbody>\n\t\t\t\t\t<c:if test=\"${pageModel.list != 'null'}\">\n\t\t\t<c:forEach var=\"tmp\" items=\"${pageModel.list}\">\n\t\t\t\t\t\t<tr>\n"
						+ "<td> \n\t\t\t\t\t\t\t<input name=\"id\" value=\"${tmp.id }\" type=\"checkbox\"> </td>");

		for (int j = 0; j < num; j++) {
			first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(j)));

			if (j < a) {
				_S_B.append("\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t${tmp."
						+ first + ".s_0 }\n\t\t\t\t\t\t\t</td>\n");
			} else {
				_S_B.append("\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t${tmp.s_"
						+ (j - a) + " }\n\t\t\t\t\t\t\t</td>\n");
			}

		}

		_S_B
				.append("\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\">\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-selectUtil.action?util.id=${tmp.id }\">修改\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-deleteUtil.action?util.id=${tmp.id }\">删除\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t\t<c:if test=\"${type != 'admin'}\">\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-selectUtil.action?util.id=${tmp.id }\">查看\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</c:forEach>\n\t\t\t\t</tbody>\n\t\t\t</table>\n\t\t</c:if>"
						+ "<div class=\"pagin\">\n"
						+ "\t\t\t\t\t<div class=\"message\">\n"
						+ "\t\t\t\t\t\t共\n"
						+ "\t\t\t\t\t\t<i class=\"blue\">${pageModel.totalRecords}</i>条记录，当前显示第&nbsp;\n"
						+ "\t\t\t\t\t\t<i class=\"blue\">${pageModel.currentPageNo}&nbsp;</i>页\n"
						+ "\t\t\t\t\t</div>\n"
						+ "\t\t\t\t\t<ul class=\"paginList\">\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:topPage();\">|&lt;&lt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:previousPage();\"> &lt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:nextPage();\"> &gt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:bottomPage();\"> &gt;&gt;|</a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t</ul>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t<div class=\"tip\">\n"
						+ "\t\t\t<div class=\"tiptop\">\n"
						+ "\t\t\t\t<span>提示信息</span><a></a>\n"
						+ "\t\t\t</div>\n"
						+ "\t\t\t<div class=\"tipinfo\">\n"
						+ "\t\t\t\t<span><img\n"
						+ "\t\t\t\t\t\tsrc=\"${pageContext.request.contextPath}/common/images/ticon.png\" />\n"
						+ "\t\t\t\t</span>\n"
						+ "\t\t\t\t<div class=\"tipright\">\n"
						+ "\t\t\t\t\t<p>\n"
						+ "\t\t\t\t\t\t是否确认删除所选记录 ？\n"
						+ "\t\t\t\t\t</p>\n"
						+ "\t\t\t\t\t<cite>如果是请点击确定按钮 ，否则请点取消。</cite>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t\t</div>\n"
						+ "\t\t\t<div class=\"tipbtn\">\n"
						+ "\t\t\t\t<input class=\"btn btn-inverse\" type=\"submit\" value=\"确&nbsp;&nbsp;定\"\n"
						+ "\t\t\t\t\tstyle=\"width: 80px; margin-left: 26px;\" />\n"
						+ "\t\t\t\t&nbsp;\n"
						+ "\t\t\t\t<input class=\"btn btn-inverse\" type=\"reset\" value=\"取&nbsp;&nbsp;消\"\n"
						+ "\t\t\t\t\tstyle=\"width: 80px; margin-left: 26px;\" />\n"
						+ "\t\t\t</div>\n"
						+ "\t\t</div>\n"
						+ "\t\t</form>\n"
						+ "\t\t<script type=\"text/javascript\">\n"
						+ "\t$('.imgtable tbody tr:odd').addClass('odd');\n"
						+ "\t</script>\n" + "\n\t</body>\n</html>\n");
		return _S_B;
	}

	// 文件类 save Jsp
	public static StringBuffer createSaveOrUpdateObjectJsp3(String _NAME,
			String _VALUE, ArrayList<String> _VALUES) {
		StringBuffer _S_B = new StringBuffer();
		int num = _VALUES.size();

		_S_B
				.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n\tpageEncoding=\"GBK\"%>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\t<head>\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t\t<title>Insert title here</title>\n\t\t<%@ include file=\"../common.jsp\"%>\n\t\t<script type=\"text/javascript\">\n\t\t\tKE.show({ \n\t\t\t\tid : 'content7',\n\t\t\t\tcssPath : './index.css'\n\t\t\t\t});\n\t\t\tfunction check(){\n\t\t\t\tvar s_0 = document.getElementById(\"util.s_0\");\n\t\t\t\tif('' == s_0.value.replace(/(^\\s*)|(\\s*$)/g, \"\") ){\n\t\t\t\t\talert(\"请输入内容\");\n\t\t\t\t\ts_0.value = \"\";\n\t\t\t\t\ts_0.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\treturn true;\n\t\t\t}\n\t\t$(document).ready(function(e) {\n\t\t    $(\".select1\").uedSelect({\n\t\twidth : 345	\n\t\t});    $(\".select2\").uedSelect({\n\t\twidth : 167	\n\t\t});    $(\".select3\").uedSelect({\n\t\twidth : 100	\n\t\t});\n\t\t});\n\t\t</script>\n\t</head>\n\t<body>\n\t\t<div class=\"place\">\n\t\t\t<span>当前位置</span>\n\t\t\t<ul class=\"placeul\"><li>"
						+ _VALUE
						+ "\n\t\t\t</li>\n\t\t<li>增加界面</li>\n\t\t</ul>\n\t\t</div>\n\t\t<div class=\"formbody\">\n\t\t<form\n\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-updateUtil.action\"\n\t\t\tmethod=\"post\"\tonsubmit=\"return check()\"\tenctype=\"multipart/form-data\">\n\t\t\t<input name=\"util.id\" value=\"${util.id }\" type=\"hidden\" />\n\t\t\t<table\n\t\t\t\tclass=\"table table-striped table-bordered table-condensed list\">\n\t\t\t\t<thead>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\">\n\t\t\t\t\t\t\t<b>"
						+ _VALUE
						+ " </b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t\t\t\t<tbody>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
						+ _VALUES.get(3)
						+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_3\" value=\"${util.s_3 }\" type=\"text\" />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t文件地址\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<div class=\"input-append\">\n\t\t\t\t\t\t\t\t<s:file name=\"myFile\"/>\n\t\t\t\t\t\t\t\t<font size=\"2\" color=\"red\">文件为空表示不修改文件</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");

		for (int j = 4; j < num - 2; j = j + 2) {
			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(j)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ j
							+ "\" value=\"${util.s_"
							+ j
							+ " }\" type=\"text\" />\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(j + 1)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ (j + 1)
							+ "\" value=\"${util.s_"
							+ (j + 1)
							+ " }\" type=\"text\" />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");
		}
		if (num % 2 == 0) {
			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(num - 2)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ (num - 2)
							+ "\" size=100 class=123 value=\"${util.s_"
							+ (num - 2)
							+ " }\"\n\t\t\t\t\t\t\t\ttype=\"text\" />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"2\"></td>\n\t\t\t\t\t</tr>\n");

		}
		_S_B
				.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"15%\">\n\t\t\t\t\t\t\t"
						+ _VALUES.get(num - 1)
						+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"500\" colspan=\"3\" height=\"\">\n\t\t\t\t\t\t\t<textarea id=\"content7\"  name=\"util.s_"
						+ (num - 1)
						+ "\" style=\"width: 95%\" rows=\"4\" cols=\"5\">${util.s_"
						+ (num - 1)
						+ " }</textarea>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");
		_S_B
				.append("\t\t\t\t</tbody>\n\t\t\t\t<tfoot>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"3\">\n\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\">\n\t\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" id=\"find\" type=\"submit\"\n\t\t\t\t\t\t\t\t\tvalue=\"保存\" /> \n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" type=\"reset\" value=\"取消\" /><font color=red><s:property value=\"errMsg\" /> </font>\n\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</tfoot>\n\t\t\t</table>\n\t\t</form>\n\t<script type=\"text/javascript\"> \n\t$(\"#usual1 ul\").idTabs();\n\t$('.tablelist tbody tr:odd').addClass('odd');\n\t</div>\n\t</body>\n</html>");
		return _S_B;
	}

	// 文件类 find Jsp
	public static StringBuffer createFindJsp3(String _NAME, String _VALUE,
			ArrayList<String> _VALUES) {
		StringBuffer _S_B = new StringBuffer();
		int num = _VALUES.size() - 1;

		_S_B
				.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n\tpageEncoding=\"GBK\"%>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\t<head>\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t\t<title>Insert title here</title>\n\t\t<%@ include file=\"../com.jsp\"%>\n\t\t<script type=\"text/javascript\">\n\tfunction topPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.topPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction previousPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.previousPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction nextPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.nextPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction bottomPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.buttomPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\t\t\t\t$(document).ready(function(){\n\t\t\t$(\".click\").click(function(){\n"
						+ "\n"
						+ "\t\t\t\tvar ids = document.getElementsByName(\"id\");\n"
						+ "\t\t\t\tvar flag = 0;\n"
						+ "\t\t\t\tfor(var i = 0; i < ids.length; i++){\n"
						+ "\t\t\t\t\tif(ids[i].checked){\n"
						+ "\t\t\t\t\t\tflag = 1;\n"
						+ "\t\t\t\t\t\tbreak;\n"
						+ "\t\t\t\t\t}\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t\tif(flag == 1){\n"
						+ "\t\t\t\t\t$(\".tip\").fadeIn(200);\n"
						+ "\t\t\t\t}else{\n"
						+ "\t\t\t\t\talert(\"至少选中一条记录\");\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t\t\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".tiptop a\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(200);\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".sure\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(100);\n"
						+ "\t\t\t\t\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".cancel\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(100);\n"
						+ "\t\t\t});\n"
						+ "\t\t\n"
						+ "\t\t});\n"
						+ "\t\t\n"
						+ "\t\tfunction check(){\n"
						+ "\t\t\treturn true;\n"
						+ "\t\t}\n"
						+ "\n\t</script>\n\t</head>\n\t<body>\n\t\t<div class=\"place\">\n\t\t\t<span>当前位置</span>\n\t\t\t<ul class=\"placeul\"><li>"
						+ _VALUE
						+ "\n\t\t\t</li>\n\t\t<li>查询界面</li>\n\t\t</ul>\n\t\t</div>\t\t<div class=\"rightinfo\">\n\t\t<div class=\"tools\">\n\t\t\n\t\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\"><ul class=\"toolbar\" style=\"margin-top:-10px;\">\n\t\t\t\t\t\t\t<li class=\"click\">\n\t\t\t\t\t\t<span><img\n\t\t\t\t\t\t\t\tsrc=\"${pageContext.request.contextPath}/common/images/t03.png\" />\n\t\t\t\t\t\t</span>批量删除\n\t\t\t\t\t</li>\n\t\t\t\t</ul></c:if>\n\t\t<form\n\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-getAllUtil.action\">\n\t\t\t<ul class=\"toolbar1\" style=\"float: left;margin-top:-10px;\">\n\t\t\t<li style=\"font-size: 16px; margin-left: 26px;\">"
						+ "\n\t\t\t请填写查询条件\n\t\t\t<span> </span>\n\t\t\t</li>\n\t\t\t<li style=\"margin-left: 26px;\">\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t \n\t\t\t\t\t\t\t<select id=\"field\" name=\"field\" style=\"font-size: 20px; background-color: #F9F9F9; margin: 3px 0px 0px 10px;\">\n\t\t\t\t\t\t\t\t");

		if (num > 8)
			num = 8;

		num--;

		for (int j = 1; j < num - 1; j++) {
			_S_B.append("<option <c:if test=\"${field == 's_" + j
					+ "'}\">selected</c:if> value=\"s_" + j
					+ "\" />\n\t\t\t\t\t\t\t\t\t" + _VALUES.get(j)
					+ "\n\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t");
		}

		_S_B
				.append("</select>\n\t\t\t\t\t\t</li> \n\t\t\t\t\t\t<div style=\"float: left; margin-left: 20px; margin-top: 0px;\">\n\t\t\t\t\t\t\t<input class=\"dfinput\" type=\"text\" name=\"fieldValue\" id=\"fieldValue\" value=\"${fieldValue }\" style=\"width: 350px;\" />\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"float: left; margin-top: 0px;\">\n\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" id=\"find\" type=\"submit\" value=\"查&nbsp;&nbsp;询\" style=\"width: 80px; margin-left: 26px;\" />\n\t\t\t\t\t\t\t&nbsp;&nbsp; <input class=\"btn btn-inverse\" type=\"button\" value=\"清&nbsp;&nbsp;空\" onclick=\"javascript: document.getElementById('fieldValue').value='';\" style=\"width: 80px; margin-left: 10px;\" />&nbsp;&nbsp;\n\t\t\t\t\t\t\t     \n\t\t\t\t\t\t</div>\n\t\t\t\t\t</ul>\n\t\t\t\t</form>\n\t\t\t</div>"
						+ "\t\t\t<form\n\t\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-deleteManyUtil.action\"\n\t\t\t\tname=\"myform\" id=\"listform\" method=\"post\" onsubmit=\"return check()\">\n\t\t\t<table class=\"imgtable\"><thead>\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t<th width=\"78px;\">\t\t\t\t\t\t\t\t<input id=\"checkall\" name=\"checkall\" type=\"checkbox\">\t\t\t\t\t\t\t\t全选\t\t\t\t\t\t\t</th>");

		_S_B.append("\t\t\t\t\t\t<th>\n\t\t\t\t\t\t\t图片\n\t\t\t\t\t\t</td>\n");
		for (int j = 1; j < num - 1; j++) {
			_S_B.append("\t\t\t\t\t\t<th>\n\t\t\t\t\t\t\t" + _VALUES.get(j)
					+ "\n\t\t\t\t\t\t</th>\n");
		}

		_S_B
				.append("\t\t\t\t\t\t<th>\n\t\t\t\t\t\t\t操作\n\t\t\t\t\t\t</th>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t\t\t\t<tbody>\n\t\t\t\t\t<c:if test=\"${pageModel.list != 'null'}\">\n\t\t\t<c:forEach var=\"tmp\" items=\"${pageModel.list}\">\n\t\t\t\t\t\t<tr>\n"
						+ "<td> \n\t\t\t\t\t\t\t<input name=\"id\" value=\"${tmp.id }\" type=\"checkbox\"> </td>");

		_S_B
				.append("\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<img src=\"${pageContext.request.contextPath}/upload/${tmp.s_0 }\" width=\"60\" height=\"20\"/>\n\t\t\t\t\t\t\t</td>\n");
		for (int j = 1; j < num - 1; j++) {
			_S_B.append("\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t${tmp.s_" + j
					+ " }\n\t\t\t\t\t\t\t</td>\n");
		}

		_S_B
				.append("\t\t\t\t\t\t\t<td>\t\t\t\t\t\t\t\t<a\n\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/admin/download.jsp?filename=${tmp.s_0}\">下载</a>\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\">\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-selectUtil.action?util.id=${tmp.id }\">修改\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-deleteUtil.action?util.id=${tmp.id }\">删除\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t\t<c:if test=\"${type != 'admin'}\">\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-selectUtil.action?util.id=${tmp.id }\">查看\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</c:forEach>\n\t\t\t\t</tbody>\n\t\t\t</table>\n\t\t</c:if>"

						+ "<div class=\"pagin\">\n"
						+ "\t\t\t\t\t<div class=\"message\">\n"
						+ "\t\t\t\t\t\t共\n"
						+ "\t\t\t\t\t\t<i class=\"blue\">${pageModel.totalRecords}</i>条记录，当前显示第&nbsp;\n"
						+ "\t\t\t\t\t\t<i class=\"blue\">${pageModel.currentPageNo}&nbsp;</i>页\n"
						+ "\t\t\t\t\t</div>\n"
						+ "\t\t\t\t\t<ul class=\"paginList\">\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:topPage();\">|&lt;&lt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:previousPage();\"> &lt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:nextPage();\"> &gt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:bottomPage();\"> &gt;&gt;|</a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t</ul>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t<div class=\"tip\">\n"
						+ "\t\t\t<div class=\"tiptop\">\n"
						+ "\t\t\t\t<span>提示信息</span><a></a>\n"
						+ "\t\t\t</div>\n"
						+ "\t\t\t<div class=\"tipinfo\">\n"
						+ "\t\t\t\t<span><img\n"
						+ "\t\t\t\t\t\tsrc=\"${pageContext.request.contextPath}/common/images/ticon.png\" />\n"
						+ "\t\t\t\t</span>\n"
						+ "\t\t\t\t<div class=\"tipright\">\n"
						+ "\t\t\t\t\t<p>\n"
						+ "\t\t\t\t\t\t是否确认删除所选记录 ？\n"
						+ "\t\t\t\t\t</p>\n"
						+ "\t\t\t\t\t<cite>如果是请点击确定按钮 ，否则请点取消。</cite>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t\t</div>\n"
						+ "\t\t\t<div class=\"tipbtn\">\n"
						+ "\t\t\t\t<input class=\"btn btn-inverse\" type=\"submit\" value=\"确&nbsp;&nbsp;定\"\n"
						+ "\t\t\t\t\tstyle=\"width: 80px; margin-left: 26px;\" />\n"
						+ "\t\t\t\t&nbsp;\n"
						+ "\t\t\t\t<input class=\"btn btn-inverse\" type=\"reset\" value=\"取&nbsp;&nbsp;消\"\n"
						+ "\t\t\t\t\tstyle=\"width: 80px; margin-left: 26px;\" />\n"
						+ "\t\t\t</div>\n"
						+ "\t\t</div>\n"
						+ "\t\t</form>\n"
						+ "\t\t<script type=\"text/javascript\">\n"
						+ "\t$('.imgtable tbody tr:odd').addClass('odd');\n"
						+ "\t</script>\n"

						+ "\n\t</body>\n</html>\n");
		return _S_B;
	}

	// 文件类 ok Jsp
	public static StringBuffer createOkJsp3(String _NAME, String _VALUE,
			ArrayList<String> _VALUES) {
		StringBuffer _S_B = new StringBuffer();
		_S_B
				.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n\tpageEncoding=\"GBK\"%>\n<%@ include file=\"../com.jsp\"%>\n\n\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n\t<HEAD>\n\t\t<TITLE>Untitled Page</TITLE>\n\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\n\t\t<meta http-equiv=\"Refresh\"\n\t\t\tcontent=\"5;URL=${pageContext.request.contextPath}/"
						+ _NAME
						+ "-getAllUtil.action\">\n\t</HEAD>\n\t<BODY\n\t\tstyle=\"BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/bg.gif); BACKGROUND-REPEAT: repeat-x\">\n\n\t\t<DIV>\n\t\t\t<TABLE height=\"100%\" cellSpacing=0 cellPadding=0 width=\"100%\"\n\t\t\t\tborder=0>\n\t\t\t\t<TBODY>\n\t\t\t\t\t<TR\n\t\t\t\t\t\tstyle=\"BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/bg_header.gif); BACKGROUND-REPEAT: repeat-x\"\n\t\t\t\t\t\theight=47>\n\t\t\t\t\t\t<TD width=10>\n\t\t\t\t\t\t\t<SPAN\n\t\t\t\t\t\t\t\tstyle=\"FLOAT: left; BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px\"></SPAN>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<SPAN\n\t\t\t\t\t\t\t\tstyle=\"FLOAT: left; BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px\"></SPAN><SPAN\n\t\t\t\t\t\t\t\tstyle=\"PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0 px: \">\n\t\t\t\t\t\t\t\t </SPAN><SPAN\n\t\t\t\t\t\t\t\tstyle=\"FLOAT: left; BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px\"></SPAN>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD\n\t\t\t\t\t\t\tstyle=\"BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_rc.gif)\"\n\t\t\t\t\t\t\twidth=10></TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD\n\t\t\t\t\t\t\tstyle=\"BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_ls.gif)\">\n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD\n\t\t\t\t\t\t\tstyle=\"PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white\"\n\t\t\t\t\t\t\tvAlign=top align=middle>\n\n\t\t\t\t\t\t\t<DIV align=middle>\n\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\">\n\t\t\t\t\t\t\t\t\t<tr align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<br>\n\n\t\t\t\t\t\t\t\t\t\t<font size=\"2\" color=\"green\"> 恭喜你，上传成功..........</font>\n\t\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t\t<br/>\n\t\t\t\t\t\t\t\t\t\t<br/>\n\t\t\t\t\t\t\t\t\t\t网页将在5秒钟后自动跳转到首页，如没自动跳转请点击\n\t\t\t\t\t\t\t\t\t\t<a href=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-getAllUtil.action\">&nbsp;这&nbsp;里&nbsp;</a>\n\n\t\t\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD\n\t\t\t\t\t\t\tstyle=\"BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_rs.gif)\"></TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR\n\t\t\t\t\t\tstyle=\"BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_fs.gif); BACKGROUND-REPEAT: repeat-x\"\n\t\t\t\t\t\theight=10>\n\t\t\t\t\t\t<TD\n\t\t\t\t\t\t\tstyle=\"BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_lf.gif)\"></TD>\n\t\t\t\t\t\t<TD\n\t\t\t\t\t\t\tstyle=\"BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_fs.gif)\"></TD>\n\t\t\t\t\t\t<TD\n\t\t\t\t\t\t\tstyle=\"BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/common/images/main_rf.gif)\"></TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t</DIV>\n\t</BODY>\n</HTML>\n");
		return _S_B;
	}

	// 有父类文件类 save Jsp
	public static StringBuffer createSaveOrUpdateObjectJsp4(String _NAME,
			String _VALUE, ArrayList<String> _VALUES,
			ArrayList<String> _fields, ArrayList<String> _NAMES) {
		String First = "", first = "";
		int a = 0, b = 0;
		boolean flag = false;
		for (int i = 0; i < _fields.size(); i++) {
			flag = false;
			for (int j = 0; j < _NAMES.size(); j++) {
				if (_fields.get(i).equals(_NAMES.get(j))) {
					flag = true;
				}
			}
			if (flag) {
				a++;// 父类数
			} else {
				b++;// 普通属性数
			}
		}

		StringBuffer _S_B = new StringBuffer();
		int num = _VALUES.size();

		_S_B
				.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n\tpageEncoding=\"GBK\"%>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\t<head>\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t\t<title>Insert title here</title>\n\t\t<%@ include file=\"../common.jsp\"%>\n\t\t<script type=\"text/javascript\">\n\t\t\tKE.show({ \n\t\t\t\tid : 'content7',\n\t\t\t\tcssPath : './index.css'\n\t\t\t\t});\n\t\t\t\t\t\n\t\t\tfunction check(){\n\t\t\t\tvar s_0 = document.getElementById(\"util.s_0\");\n\t\t\t\tif('' == s_0.value.replace(/(^\\s*)|(\\s*$)/g, \"\") ){\n\t\t\t\t\talert(\"请输入内容\");\n\t\t\t\t\ts_0.value = \"\";\n\t\t\t\t\ts_0.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\treturn true;\n\t\t\t}\n\t\t$(document).ready(function(e) {\n\t\t    $(\".select1\").uedSelect({\n\t\twidth : 345	\n\t\t});    $(\".select2\").uedSelect({\n\t\twidth : 167	\n\t\t});    $(\".select3\").uedSelect({\n\t\twidth : 100	\n\t\t});\n\t\t});\n\t\t</script>\n\t</head>\n\t<body>\n\t\t<div class=\"place\">\n\t\t\t<span>当前位置</span>\n\t\t\t<ul class=\"placeul\"><li>"
						+ _VALUE
						+ "\n\t\t\t</li>\n\t\t<li>增加界面</li>\n\t\t</ul>\n\t\t</div>\n\t\t<div class=\"formbody\">\n\t\t<form\n\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-updateUtil.action\"\n\t\t\tmethod=\"post\"\tonsubmit=\"return check()\"\tenctype=\"multipart/form-data\">\n\t\t\t<input name=\"util.id\" value=\"${util.id }\" type=\"hidden\" />\n\t\t\t<table\n\t\t\t\tclass=\"table table-striped table-bordered table-condensed list\">\n\t\t\t\t<thead>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\">\n\t\t\t\t\t\t\t<b>"
						+ _VALUE
						+ " </b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t\t\t\t<tbody>");
		int i = 0;
		_S_B
				.append("\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t文件地址\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"3\">\n\t\t\t\t\t\t\t<div class=\"input-append\">\n\t\t\t\t\t\t\t\t<s:file name=\"myFile\"/>\n\t\t\t\t\t\t\t\t<font size=\"2\" color=\"red\">文件为空表示不修改文件</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");

		for (i = 0; i < a; i += 2) {
			_S_B.append("<tr>\n\t\t\t\t\t\t");

			First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i + 3)));
			first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(i + 3)));

			_S_B.append("<td>\n\t\t\t\t\t\t\t" + _VALUES.get(i + 3)
					+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td ");

			if ((i + 1) >= a) {
				_S_B.append(" colspan=\"3\" ");
			}

			_S_B
					.append(">\n\t\t\t\t\t\t\t<select  class=\"select2\"  name=\"util."
							+ first
							+ ".id\">\n\t\t\t\t\t\t\t\t<c:forEach var=\"type\" items=\"${list"
							+ First
							+ "}\">\n\t\t\t\t\t\t\t\t\t<option\n\t\t\t\t\t\t\t\t\t\t<c:if test=\"${type.id == util."
							+ first
							+ ".id }\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tselected\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t\t\t\tvalue=\"${type.id }\">\n\t\t\t\t\t\t\t\t\t\t${type.s_0 }\n\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t</c:forEach>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>");

			First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i + 1 + 3)));
			first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(i + 1 + 3)));
			if ((i + 1) < a) {
				_S_B
						.append("<td>\n\t\t\t\t\t\t\t"
								+ _VALUES.get(i + 1 + 3)
								+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td >\n\t\t\t\t\t\t\t<select  class=\"select2\"  name=\"util."
								+ first
								+ ".id\">\n\t\t\t\t\t\t\t\t<c:forEach var=\"type\" items=\"${list"
								+ First
								+ "}\">\n\t\t\t\t\t\t\t\t\t<option\n\t\t\t\t\t\t\t\t\t\t<c:if test=\"${type.id == util."
								+ first
								+ ".id }\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tselected\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t\t\t\tvalue=\"${type.id }\">\n\t\t\t\t\t\t\t\t\t\t${type.s_0 }\n\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t</c:forEach>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>");

			}

			_S_B.append("\n\t\t\t\t\t</tr>\n");

		}// end for

		for (int j = a + 3; j < num - 2; j = j + 2) {
			System.out.println(_VALUES.get(j));
			System.out.println(_VALUES.get(j + 1));
			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(j)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ (j - a)
							+ "\" value=\"${util.s_"
							+ (j - a)
							+ " }\" type=\"text\" />\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(j + 1)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ (j - a + 1)
							+ "\" value=\"${util.s_"
							+ (j - a + 1)
							+ " }\" type=\"text\" />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");
		}

		if (b % 2 == 0) {
			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"15%\">\n\t\t\t\t\t\t\t"
							+ _VALUES.get(num - 1)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"500\" colspan=\"3\" height=\"\">\n\t\t\t\t\t\t\t<textarea id=\"content7\"  name=\"util.s_"
							+ (b - 1)
							+ "\" style=\"width: 95%\" rows=\"4\" cols=\"5\">${util.s_"
							+ (b - 1)
							+ " }</textarea>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");

		} else {
			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t"
							+ _VALUES.get(num - 2)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input name=\"util.s_"
							+ (b - 2)
							+ "\" size=100 class=123 value=\"${util.s_"
							+ (b - 2)
							+ " }\"\n\t\t\t\t\t\t\t\ttype=\"text\" />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"2\"></td>\n\t\t\t\t\t</tr>\n");

			_S_B
					.append("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"15%\">\n\t\t\t\t\t\t\t"
							+ _VALUES.get(num - 1)
							+ "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"500\" colspan=\"3\" height=\"\">\n\t\t\t\t\t\t\t<textarea id=\"content7\"  name=\"util.s_"
							+ (b - 1)
							+ "\" style=\"width: 95%\" rows=\"4\" cols=\"5\">${util.s_"
							+ (b - 1)
							+ " }</textarea>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n");

		}

		_S_B
				.append("\t\t\t\t</tbody>\n\t\t\t\t<tfoot>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"3\">\n\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\">\n\t\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" id=\"find\" type=\"submit\"\n\t\t\t\t\t\t\t\t\tvalue=\"保存\" />\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" type=\"reset\" value=\"取消\" /><font color=red><s:property value=\"errMsg\" /> </font>\n\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</tfoot>\n\t\t\t</table>\n\t\t</form>\n\t<script type=\"text/javascript\"> \n\t$(\"#usual1 ul\").idTabs();\n\t$('.tablelist tbody tr:odd').addClass('odd');\n\t</div>\n\t</body>\n</html>");
		return _S_B;
	}

	// 有父类文件类 find Jsp
	public static StringBuffer createFindJsp4(String _NAME, String _VALUE,
			ArrayList<String> _VALUES, ArrayList<String> _fields,
			ArrayList<String> _NAMES) {
		String first = "";

		boolean flag = false;

		StringBuffer _S_B = new StringBuffer();
		int num = _fields.size();

		_S_B
				.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n\tpageEncoding=\"GBK\"%>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\t<head>\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t\t<title>Insert title here</title>\n\t\t<%@ include file=\"../com.jsp\"%>\n\t\t<script type=\"text/javascript\">\n\tfunction topPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.topPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction previousPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.previousPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction nextPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.nextPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\n\tfunction bottomPage() {\n\t\tvar contextPath = \"${pageContext.request.contextPath}\";\n\t\tvar field = document.getElementById(\"field\").value;\n\t\tvar fieldValue = document.getElementById(\"fieldValue\").value;\n\t\tvar pageNo = \"${pageModel.buttomPageNo}\";\n\t\twindow.location = contextPath\n\t\t\t\t+ '/"
						+ _NAME
						+ "-getAllUtil.action?pageModel.currentPageNo=' + pageNo\n\t\t\t\t+ '&field=' + field + '&fieldValue=' + fieldValue + '';\n\t}\n\t\t\t\t$(document).ready(function(){\n\t\t\t$(\".click\").click(function(){\n"
						+ "\n"
						+ "\t\t\t\tvar ids = document.getElementsByName(\"id\");\n"
						+ "\t\t\t\tvar flag = 0;\n"
						+ "\t\t\t\tfor(var i = 0; i < ids.length; i++){\n"
						+ "\t\t\t\t\tif(ids[i].checked){\n"
						+ "\t\t\t\t\t\tflag = 1;\n"
						+ "\t\t\t\t\t\tbreak;\n"
						+ "\t\t\t\t\t}\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t\tif(flag == 1){\n"
						+ "\t\t\t\t\t$(\".tip\").fadeIn(200);\n"
						+ "\t\t\t\t}else{\n"
						+ "\t\t\t\t\talert(\"至少选中一条记录\");\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t\t\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".tiptop a\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(200);\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".sure\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(100);\n"
						+ "\t\t\t\t\n"
						+ "\t\t\t});\n"
						+ "\t\t\t\n"
						+ "\t\t\t$(\".cancel\").click(function(){\n"
						+ "\t\t\t\t$(\".tip\").fadeOut(100);\n"
						+ "\t\t\t});\n"
						+ "\t\t\n"
						+ "\t\t});\n"
						+ "\t\t\n"
						+ "\t\tfunction check(){\n"
						+ "\t\t\treturn true;\n"
						+ "\t\t}\n"
						+ "\n\t</script>\n\t</head>\n\t<body>\n\t\t<div class=\"place\">\n\t\t\t<span>当前位置</span>\n\t\t\t<ul class=\"placeul\"><li>"
						+ _VALUE
						+ "\n\t\t\t</li>\n\t\t<li>查询界面</li>\n\t\t</ul>\n\t\t</div>\t\t<div class=\"rightinfo\">\n\t\t<div class=\"tools\">\n\t\t\n\t\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\"><ul class=\"toolbar\" style=\"margin-top:-10px;\">\n\t\t\t\t\t\t\t<li class=\"click\">\n\t\t\t\t\t\t<span><img\n\t\t\t\t\t\t\t\tsrc=\"${pageContext.request.contextPath}/common/images/t03.png\" />\n\t\t\t\t\t\t</span>批量删除\n\t\t\t\t\t</li>\n\t\t\t\t</ul></c:if>\n\t\t<form\n\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-getAllUtil.action\">\n\t\t\t<ul class=\"toolbar1\" style=\"float: left;margin-top:-10px;\">\n\t\t\t<li style=\"font-size: 16px; margin-left: 26px;\">"
						+ "\n\t\t\t请填写查询条件\n\t\t\t<span> </span>\n\t\t\t</li>\n\t\t\t<li style=\"margin-left: 26px;\">\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t \n\t\t\t\t\t\t\t<select id=\"field\" name=\"field\" style=\"font-size: 20px; background-color: #F9F9F9; margin: 3px 0px 0px 10px;\">\n\t\t\t\t\t\t\t\t");

		if (num > 8)
			num = 8;
		num--;

		for (int i = 1, index = 0; i < num; i++) {
			flag = false;
			first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(i)));
			for (int j = 0; j < _NAMES.size(); j++) {
				if (_fields.get(i).equals(_NAMES.get(j))) {
					flag = true;
				}
			}
			if (flag) {
				_S_B.append("<option <c:if test=\"${field == '" + first
						+ ".s_0'}\">selected</c:if> value=\"" + first
						+ ".s_0\" />\n\t\t\t\t\t\t\t\t\t" + _VALUES.get(i)
						+ "\n\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t");
			} else {
				_S_B.append("<option <c:if test=\"${field == 's_" + index
						+ "'}\">selected</c:if> value=\"s_" + index
						+ "\" />\n\t\t\t\t\t\t\t\t\t" + _VALUES.get(i)
						+ "\n\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t");
				index++;
			}
		}

		_S_B
				.append("</select>\n\t\t\t\t\t\t</li> \n\t\t\t\t\t\t<div style=\"float: left; margin-left: 20px; margin-top: 0px;\">\n\t\t\t\t\t\t\t<input class=\"dfinput\" type=\"text\" name=\"fieldValue\" id=\"fieldValue\" value=\"${fieldValue }\" style=\"width: 350px;\" />\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"float: left; margin-top: 0px;\">\n\t\t\t\t\t\t\t<input class=\"btn btn-inverse\" id=\"find\" type=\"submit\" value=\"查&nbsp;&nbsp;询\" style=\"width: 80px; margin-left: 26px;\" />\n\t\t\t\t\t\t\t&nbsp;&nbsp; <input class=\"btn btn-inverse\" type=\"button\" value=\"清&nbsp;&nbsp;空\" onclick=\"javascript: document.getElementById('fieldValue').value='';\" style=\"width: 80px; margin-left: 10px;\" />&nbsp;&nbsp;\n\t\t\t\t\t\t\t     \n\t\t\t\t\t\t</div>\n\t\t\t\t\t</ul>\n\t\t\t\t</form>\n\t\t\t</div>"
						+ "\t\t\t<form\n\t\t\t\taction=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-deleteManyUtil.action\"\n\t\t\t\tname=\"myform\" id=\"listform\" method=\"post\" onsubmit=\"return check()\">\n\t\t\t<table class=\"imgtable\"><thead>\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t<th width=\"78px;\">\t\t\t\t\t\t\t\t<input id=\"checkall\" name=\"checkall\" type=\"checkbox\">\t\t\t\t\t\t\t\t全选\t\t\t\t\t\t\t</th>");

		for (int j = 0; j < num; j++) {
			_S_B.append("\t\t\t\t\t\t<th>\n\t\t\t\t\t\t\t" + _VALUES.get(j)
					+ "\n\t\t\t\t\t\t</th>\n");
		}

		_S_B
				.append("\t\t\t\t\t\t<th>\n\t\t\t\t\t\t\t操作\n\t\t\t\t\t\t</th>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t\t\t\t<tbody>\n\t\t\t\t\t<c:if test=\"${pageModel.list != 'null'}\">\n\t\t\t<c:forEach var=\"tmp\" items=\"${pageModel.list}\">\n\t\t\t\t\t\t<tr>\n"
						+ "<td> \n\t\t\t\t\t\t\t<input name=\"id\" value=\"${tmp.id }\" type=\"checkbox\"> </td>");
		_S_B
				.append("\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<img src=\"${pageContext.request.contextPath}/upload/${tmp.s_0 }\" width=\"60\" height=\"20\"/>\n\t\t\t\t\t\t\t</td>\n");

		for (int i = 1, index = 1; i < num; i++) {
			flag = false;
			first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(i)));
			for (int j = 0; j < _NAMES.size(); j++) {
				if (_fields.get(i).equals(_NAMES.get(j))) {
					flag = true;
				}
			}
			if (flag) {
				_S_B.append("\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t${tmp."
						+ first + ".s_0 }\n\t\t\t\t\t\t\t</td>\n");
			} else {
				_S_B.append("\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t${tmp.s_"
						+ index + " }\n\t\t\t\t\t\t\t</td>\n");
				index++;
			}
		}

		_S_B
				.append("\t\t\t\t\t\t\t<td>\t\t\t\t\t\t\t\t<a\n\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/admin/download.jsp?filename=${tmp.s_0}\">下载</a>\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t<c:if test=\"${type == 'admin'}\">\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-selectUtil.action?util.id=${tmp.id }\">修改\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-deleteUtil.action?util.id=${tmp.id }\">删除\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t\t<c:if test=\"${type != 'admin'}\">\n\t\t\t\t\t\t\t\t\t<a target=\"Conframe\"\tclass=\"tablelink\"\n\t\t\t\t\t\t\t\t\t\thref=\"${pageContext.request.contextPath}/"
						+ _NAME
						+ "-selectUtil.action?util.id=${tmp.id }\">查看\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</c:if>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</c:forEach>\n\t\t\t\t</tbody>\n\t\t\t</table>\n\t\t</c:if>"

						+ "<div class=\"pagin\">\n"
						+ "\t\t\t\t\t<div class=\"message\">\n"
						+ "\t\t\t\t\t\t共\n"
						+ "\t\t\t\t\t\t<i class=\"blue\">${pageModel.totalRecords}</i>条记录，当前显示第&nbsp;\n"
						+ "\t\t\t\t\t\t<i class=\"blue\">${pageModel.currentPageNo}&nbsp;</i>页\n"
						+ "\t\t\t\t\t</div>\n"
						+ "\t\t\t\t\t<ul class=\"paginList\">\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:topPage();\">|&lt;&lt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:previousPage();\"> &lt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:nextPage();\"> &gt; </a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t\t<li class=\"paginItem\">\n"
						+ "\t\t\t\t\t\t\t<a href=\"javascript:;\" onClick=\"javascript:bottomPage();\"> &gt;&gt;|</a>\n"
						+ "\t\t\t\t\t\t</li>\n"
						+ "\t\t\t\t\t</ul>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t<div class=\"tip\">\n"
						+ "\t\t\t<div class=\"tiptop\">\n"
						+ "\t\t\t\t<span>提示信息</span><a></a>\n"
						+ "\t\t\t</div>\n"
						+ "\t\t\t<div class=\"tipinfo\">\n"
						+ "\t\t\t\t<span><img\n"
						+ "\t\t\t\t\t\tsrc=\"${pageContext.request.contextPath}/common/images/ticon.png\" />\n"
						+ "\t\t\t\t</span>\n"
						+ "\t\t\t\t<div class=\"tipright\">\n"
						+ "\t\t\t\t\t<p>\n"
						+ "\t\t\t\t\t\t是否确认删除所选记录 ？\n"
						+ "\t\t\t\t\t</p>\n"
						+ "\t\t\t\t\t<cite>如果是请点击确定按钮 ，否则请点取消。</cite>\n"
						+ "\t\t\t\t</div>\n"
						+ "\t\t\t</div>\n"
						+ "\t\t\t<div class=\"tipbtn\">\n"
						+ "\t\t\t\t<input class=\"btn btn-inverse\" type=\"submit\" value=\"确&nbsp;&nbsp;定\"\n"
						+ "\t\t\t\t\tstyle=\"width: 80px; margin-left: 26px;\" />\n"
						+ "\t\t\t\t&nbsp;\n"
						+ "\t\t\t\t<input class=\"btn btn-inverse\" type=\"reset\" value=\"取&nbsp;&nbsp;消\"\n"
						+ "\t\t\t\t\tstyle=\"width: 80px; margin-left: 26px;\" />\n"
						+ "\t\t\t</div>\n"
						+ "\t\t</div>\n"
						+ "\t\t</form>\n"
						+ "\t\t<script type=\"text/javascript\">\n"
						+ "\t$('.imgtable tbody tr:odd').addClass('odd');\n"
						+ "\t</script>\n" + "\n\t</body>\n</html>\n");
		return _S_B;
	}

}
