package org.apache.tools.ant.taskdefs.optional.junit03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import bysj.net.util.LxmUtil;

public class SimpleTypeConverterUtil {

	private static String _PATH1 = "D:\\TXT\\1";// 普通类

	private static String _PATH2 = "D:\\TXT\\2";// 有父类普通类

	private static String _PATH3 = "D:\\TXT\\3";// 文件类

	private static String _PATH4 = "D:\\TXT\\4";// 有父类文件类

	private static Utils utils = new Utils();

	private static int index = 0;
	private static String[] _index = { "01", "02", "03", "04", "05", "06",
			"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17",
			"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
			"29", "30" };

	public static final int BUFFER_SIZE = 1;

	String _NAME = null;
	String _VALUE = null;
	ArrayList<String> _FIELDS = null;
	ArrayList<String> _FIELDS_VALUES = null;
	ArrayList<String> _NAMES = new ArrayList<String>();
	ArrayList<String> _VALUES = new ArrayList<String>();
	String _STR = null;
	File _FILE = null;
	File _FILE_A = null;

	public void test() {
		_FILE_A = new File("WebRoot/left.jsp");
		try {
			_FILE_A.createNewFile();
			StringBuffer _S_A = new StringBuffer();
			_S_A
					.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n\tpageEncoding=\"gbk\"%>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\t<head>\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t\t<title>Insert title here</title>\n\t\t<%@ include file=\"common.jsp\"%>\n\t</head>\n\t<body style=\"background: #f0f9fd;\">\n\t\t<div class=\"lefttop\"><span></span>系统菜单</div>");

			_S_A.append("<dl class=\"leftmenu\">");

			_S_A.append("\n\t\t\t\t\t<c:if test=\"${type == 'admin'}\">");

			_S_A.append("\n\t\t\t\t\t<dd>\n\t\t\t\t\t<div class=\"title\">");

			_S_A
					.append("\n\t\t\t\t\t<span><img src=\"${pageContext.request.contextPath}/common/images/leftico"
							+ _index[index++] + ".png\" /></span>用户管理");

			_S_A.append("\n\t\t\t\t\t</div>\n\t\t\t\t\t<ul class=\"menuson\">");

			_S_A
					.append("\n\t\t\t\t\t<li class=\"active\">\n\t\t\t\t\t<cite></cite><a href=\"${pageContext.request.contextPath}/admin/User/saveOrUpdate.jsp\" target=\"Conframe\">增加用户</a><i></i>\n\t\t\t\t\t</li>");
			_S_A
					.append("\n\t\t\t\t\t<li>\n\t\t\t\t\t<cite></cite><a href=\"${pageContext.request.contextPath}/User-getAllUtil.action\" target=\"Conframe\">查询用户</a><i></i>\n\t\t\t\t\t</li>");

			_S_A.append("\n\t\t\t\t\t</ul>\n\t\t\t\t\t</dd>");

			_S_A.append("\n\t\t\t\t\t</c:if>");

			readTxt1(_S_A);
			readTxt2(_S_A);
			readTxt3(_S_A);
			readTxt4(_S_A);
			_S_A.append("\t\t\t\t\t</dl>\n\t</body>\n</html>");

			OutputStreamWriter _osw = new OutputStreamWriter(
					new FileOutputStream(_FILE_A), LxmUtil.encode);
			BufferedWriter _OUT_A = new BufferedWriter(_osw);

			_OUT_A.write(_S_A.toString());
			_OUT_A.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		utils.createHibernateCfgXml(_NAMES);
		utils.createApplicationContextXml(_NAMES);
		System.out.println("Over");
	}

	public void readTxt1(StringBuffer _S_A) throws Exception {
		_FILE = new File(_PATH1);
		if (_FILE.isDirectory()) {

			File[] _tmpFile = _FILE.listFiles();
			for (File _tmp : _tmpFile) {

				FileInputStream _fis = new FileInputStream(_tmp);

				BufferedReader _br = new BufferedReader(new InputStreamReader(
						_fis, LxmUtil.encode));

				_STR = "";
				_FIELDS = new ArrayList<String>();
				_FIELDS_VALUES = new ArrayList<String>();

				if ((_STR = _br.readLine()) != null) {
					String[] _S = _STR.split("=");
					_NAME = Utils.toFirstUp(_S[0]);
					_VALUE = _S[1];
				}

				while ((_STR = _br.readLine()) != null) {
					String[] _S = _STR.split("=");
					_FIELDS.add(_S[0]);
					_FIELDS_VALUES.add(_S[1]);
				}

				_NAMES.add(_NAME);
				_VALUES.add(_VALUE);
				utils.createModel1(_NAME, _FIELDS);
				utils.createAction1(_NAME, _FIELDS);
				utils.createSaveOrUpdateObjectJsp1(_NAME, _VALUE,
						_FIELDS_VALUES);

				_S_A
						.append("\n\t\t\t\t\t<dd>\n\t\t\t\t\t<div class=\"title\">");
				_S_A
						.append("\n\t\t\t\t\t<span><img src=\"${pageContext.request.contextPath}/common/images/leftico"
								+ _index[index++] + ".png\" /></span>" + _VALUE);

				_S_A
						.append("\n\t\t\t\t\t</div>\n\t\t\t\t\t<ul class=\"menuson\">");

				_S_A.append("\n\t\t\t\t\t<c:if test=\"${type == 'admin'}\">");

				_S_A
						.append("\n\t\t\t\t\t<li class=\"active\">\n\t\t\t\t\t<cite></cite><a href=\"${pageContext.request.contextPath}/admin/"
								+ _NAME
								+ "/saveOrUpdate.jsp\" target=\"Conframe\">增加</a><i></i>\n\t\t\t\t\t</li>");
				_S_A.append("\n\t\t\t\t\t</c:if>");
				_S_A
						.append("\n\t\t\t\t\t<li>\n\t\t\t\t\t<cite></cite><a href=\"${pageContext.request.contextPath}/"
								+ _NAME
								+ "-getAllUtil.action\" target=\"Conframe\">查询</a><i></i>\n\t\t\t\t\t</li>");
				_S_A.append("\n\t\t\t\t\t</ul>\n\t\t\t\t\t</dd>");

			}
		}
	}

	public void readTxt2(StringBuffer _S_A) throws Exception {
		_FILE = new File(_PATH2);

		if (_FILE.isDirectory()) {

			File[] _tmpFile = _FILE.listFiles();
			for (File _tmp : _tmpFile) {

				FileInputStream _fis = new FileInputStream(_tmp);
				BufferedReader _br = new BufferedReader(new InputStreamReader(
						_fis, LxmUtil.encode));

				_STR = "";
				if ((_STR = _br.readLine()) != null) {
					String[] _S = _STR.split("=");
					_NAME = Utils.toFirstUp(_S[0]);
					_VALUE = _S[1];
				}

				_NAMES.add(_NAME);
				_VALUES.add(_VALUE);

				_S_A
						.append("\n\t\t\t\t\t<dd>\n\t\t\t\t\t<div class=\"title\">");
				_S_A
						.append("\n\t\t\t\t\t<span><img src=\"${pageContext.request.contextPath}/common/images/leftico"
								+ _index[index++] + ".png\" /></span>" + _VALUE);

				_S_A
						.append("\n\t\t\t\t\t</div>\n\t\t\t\t\t<ul class=\"menuson\">");
				_S_A.append("\n\t\t\t\t\t<c:if test=\"${type == 'admin'}\">");
				_S_A
						.append("\n\t\t\t\t\t<li class=\"active\">\n\t\t\t\t\t<cite></cite><a href=\"${pageContext.request.contextPath}/"
								+ _NAME
								+ "-initUtil.action\" target=\"Conframe\">增加</a><i></i>\n\t\t\t\t\t</li>");
				_S_A.append("\n\t\t\t\t\t</c:if>");
				_S_A
						.append("\n\t\t\t\t\t<li>\n\t\t\t\t\t<cite></cite><a href=\"${pageContext.request.contextPath}/"
								+ _NAME
								+ "-getAllUtil.action\" target=\"Conframe\">查询</a><i></i>\n\t\t\t\t\t</li>");
				_S_A.append("\n\t\t\t\t\t</ul>\n\t\t\t\t\t</dd>");

				_br.close();
				_fis.close();
			}

			_NAMES.add("User");
			for (File _tmp : _tmpFile) {

				FileInputStream _fis = new FileInputStream(_tmp);
				BufferedReader _br = new BufferedReader(new InputStreamReader(
						_fis, LxmUtil.encode));
				_STR = "";
				_FIELDS = new ArrayList<String>();
				_FIELDS_VALUES = new ArrayList<String>();

				_STR = "";
				if ((_STR = _br.readLine()) != null) {
					String[] _S = _STR.split("=");
					_NAME = Utils.toFirstUp(_S[0]);
					_VALUE = _S[1];
				}

				while ((_STR = _br.readLine()) != null) {
					String[] _S = _STR.split("=");
					_FIELDS.add(_S[0]);
					_FIELDS_VALUES.add(_S[1]);
				}
				utils.createModelN(_NAME, _FIELDS, _VALUE, _FIELDS_VALUES,
						_NAMES);
				utils.createActionN(_NAME, _FIELDS, _VALUE, _FIELDS_VALUES,
						_NAMES);
				utils.createSaveOrUpdateObjectJspN(_NAME, _VALUE,
						_FIELDS_VALUES, _FIELDS, _NAMES);
				_br.close();
				_fis.close();
			}

		}
	}

	public void readTxt3(StringBuffer _S_A) throws Exception {
		_FILE = new File(_PATH3);
		if (_FILE.isDirectory()) {

			File[] _tmpFile = _FILE.listFiles();
			for (File _tmp : _tmpFile) {

				FileInputStream _fis = new FileInputStream(_tmp);
				BufferedReader _br = new BufferedReader(new InputStreamReader(
						_fis, LxmUtil.encode));
				_STR = "";
				_FIELDS = new ArrayList<String>();
				_FIELDS_VALUES = new ArrayList<String>();

				if ((_STR = _br.readLine()) != null) {
					String[] _S = _STR.split("=");
					_NAME = Utils.toFirstUp(_S[0]);
					_VALUE = _S[1];
				}

				_FIELDS.add("tp");
				_FIELDS_VALUES.add("图片");
				_FIELDS.add("wjm");
				_FIELDS_VALUES.add("文件名");
				_FIELDS.add("scsj");
				_FIELDS_VALUES.add("上传时间");

				while ((_STR = _br.readLine()) != null) {
					String[] _S = _STR.split("=");
					_FIELDS.add(_S[0]);
					_FIELDS_VALUES.add(_S[1]);
				}

				_NAMES.add(_NAME);
				_VALUES.add(_VALUE);
				utils.createModel1(_NAME, _FIELDS);
				utils.createAction3(_NAME, _FIELDS);
				utils.createSaveOrUpdateObjectJsp3(_NAME, _VALUE,
						_FIELDS_VALUES);
				_S_A
						.append("\n\t\t\t\t\t<dd>\n\t\t\t\t\t<div class=\"title\">");
				_S_A
						.append("\n\t\t\t\t\t<span><img src=\"${pageContext.request.contextPath}/common/images/leftico"
								+ _index[index++] + ".png\" /></span>" + _VALUE);

				_S_A
						.append("\n\t\t\t\t\t</div>\n\t\t\t\t\t<ul class=\"menuson\">");
				_S_A.append("\n\t\t\t\t\t<c:if test=\"${type == 'admin'}\">");
				_S_A
						.append("\n\t\t\t\t\t<li class=\"active\">\n\t\t\t\t\t<cite></cite><a href=\"${pageContext.request.contextPath}/admin/"
								+ _NAME
								+ "/saveOrUpdate.jsp\" target=\"Conframe\">增加</a><i></i>\n\t\t\t\t\t</li>");
				_S_A.append("\n\t\t\t\t\t</c:if>");
				_S_A
						.append("\n\t\t\t\t\t<li>\n\t\t\t\t\t<cite></cite><a href=\"${pageContext.request.contextPath}/"
								+ _NAME
								+ "-getAllUtil.action\" target=\"Conframe\">查询</a><i></i>\n\t\t\t\t\t</li>");
				_S_A.append("\n\t\t\t\t\t</ul>\n\t\t\t\t\t</dd>");
			}
		}
	}

	public void readTxt4(StringBuffer _S_A) throws Exception {
		_FILE = new File(_PATH4);
		if (_FILE.isDirectory()) {

			File[] _tmpFile = _FILE.listFiles();
			for (File _tmp : _tmpFile) {

				FileInputStream _fis = new FileInputStream(_tmp);
				BufferedReader _br = new BufferedReader(new InputStreamReader(
						_fis, LxmUtil.encode));
				_STR = "";
				_FIELDS = new ArrayList<String>();
				_FIELDS_VALUES = new ArrayList<String>();

				if ((_STR = _br.readLine()) != null) {
					String[] _S = _STR.split("=");
					_NAME = Utils.toFirstUp(_S[0]);
					_VALUE = _S[1];
				}
				_FIELDS.add("tp");
				_FIELDS_VALUES.add("图片");
				_FIELDS.add("wjm");
				_FIELDS_VALUES.add("文件名");
				_FIELDS.add("scsj");
				_FIELDS_VALUES.add("上传时间");
				while ((_STR = _br.readLine()) != null) {
					String[] _S = _STR.split("=");
					_FIELDS.add(_S[0]);
					_FIELDS_VALUES.add(_S[1]);
				}

				_NAMES.add(_NAME);
				_VALUES.add(_VALUE);
				utils.createModelN(_NAME, _FIELDS, _VALUE, _FIELDS_VALUES,
						_NAMES);
				utils.createAction4(_NAME, _FIELDS, _VALUE, _FIELDS_VALUES,
						_NAMES);
				utils.createSaveOrUpdateObjectJsp4(_NAME, _VALUE,
						_FIELDS_VALUES, _FIELDS, _NAMES);

				_S_A
						.append("\n\t\t\t\t\t<dd>\n\t\t\t\t\t<div class=\"title\">");
				_S_A
						.append("\n\t\t\t\t\t<span><img src=\"${pageContext.request.contextPath}/common/images/leftico"
								+ _index[index++] + ".png\" /></span>" + _VALUE);

				_S_A
						.append("\n\t\t\t\t\t</div>\n\t\t\t\t\t<ul class=\"menuson\">");
				_S_A.append("\n\t\t\t\t\t<c:if test=\"${type == 'admin'}\">");
				_S_A
						.append("\n\t\t\t\t\t<li class=\"active\">\n\t\t\t\t\t<cite></cite><a href=\"${pageContext.request.contextPath}/"
								+ _NAME
								+ "-initUtil.action\" target=\"Conframe\">增加</a><i></i>\n\t\t\t\t\t</li>");
				_S_A.append("\n\t\t\t\t\t</c:if>");
				_S_A
						.append("\n\t\t\t\t\t<li>\n\t\t\t\t\t<cite></cite><a href=\"${pageContext.request.contextPath}/"
								+ _NAME
								+ "-getAllUtil.action\" target=\"Conframe\">查询</a><i></i>\n\t\t\t\t\t</li>");
				_S_A.append("\n\t\t\t\t\t</ul>\n\t\t\t\t\t</dd>");
			}
		}
		_NAMES.remove("User");
	}

}
