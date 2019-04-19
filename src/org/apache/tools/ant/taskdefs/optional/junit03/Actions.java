package org.apache.tools.ant.taskdefs.optional.junit03;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Actions {

	// 普通类 Action
	public static StringBuffer createAction1(String name, String packName) {
		StringBuffer _S_B = new StringBuffer();
		_S_B.append("package " + packName + ";\n\n");

		packName = packName.replace(".action", "");
		_S_B.append("import java.util.*;\n");
		_S_B.append("import " + packName + ".model." + name + ";\n");
		_S_B.append("import " + packName + ".manager.*;\n");
		_S_B.append("import com.opensymphony.xwork2.*;\n\n");
		_S_B.append("import javax.servlet.http.HttpServletRequest;\n\n");
		_S_B.append("import org.apache.struts2.ServletActionContext;\n\n");
		_S_B.append("import bysj.net.util.PageModel;\n\n");

		_S_B.append("@SuppressWarnings({ \"unchecked\", \"serial\" })\n");
		_S_B.append("public class " + name + "Action extends ActionSupport {"
				+ "\n");

		_S_B.append("\tprivate String errMsg;\n");
		_S_B.append("\tprivate String field;\n");
		_S_B.append("\tprivate String fieldValue;\n");
		_S_B.append("\tprivate ObjectManager objectManager;\n\n");
		_S_B.append("\tprivate " + name + " util;\n");
		_S_B.append("\tprivate PageModel<" + name + "> pageModel;\n");

		/*-------------------------------*/
		_S_B
				.append("\tpublic String saveOrUpdateObject() throws Exception {\n");
		_S_B.append("\t\tif (null != util && 0 == util.getId()) {\n");
		_S_B.append("\t\t\tString sql = \"from " + name
				+ " where s_0 = '\" + util.getS_0() + \"'\";\n");
		_S_B.append("\t\t\tList list = objectManager.getUtil(sql);\n");
		_S_B.append("\t\t\tif (null != list && list.size() > 0) {\n");
		String _msg = null;
		try {
			_msg = new String("该信息已存在".getBytes("utf-8"), "gbk");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		_S_B.append("\t\t\t\terrMsg = \"" + _msg + "\";\n");
		_S_B.append("\t\t\t\treturn \"saveOrUpdate\";\n");
		_S_B.append("\t\t\t}\n");
		_S_B.append("\t\t}\n");
		_S_B.append("\t\tobjectManager.saveOrUpdateObject(util);\n");
		_S_B.append("\t\tutil = null;\n");
		_S_B.append("\t\terrMsg = null;\n");
		_S_B.append("\t\treturn getAllUtil();\n");
		_S_B.append("\t}\n");
		
		/*-------------------------------*/
		_S_B.append("\n\tpublic String deleteManyUtil() throws Exception {");
		_S_B.append("\n\t\tHttpServletRequest request = ServletActionContext.getRequest();");
		_S_B.append("\n\t\tString ids[] = request.getParameterValues(\"id\");");
		_S_B.append("\n\t\t" + name + " util = null;");
		_S_B.append("\n\t\tfor (String id : ids) {");
		_S_B.append("\n\t\t\tutil = new " + name + "();");
		_S_B.append("\n\t\t\tutil.setId(Integer.parseInt(id));");
		_S_B.append("\n\t\t\tobjectManager.deleteObject(util);");
		_S_B.append("\n\t\t}");
		_S_B.append("\n\t\tutil = null;");
		_S_B.append("\n\t\treturn getAllUtil();");
		_S_B.append("\n\t}");

		/*-------------------------------*/
		_S_B.append("\tpublic String deleteUtil() throws Exception{\n");
		_S_B.append("\t\tobjectManager.deleteObject(util);\n");
		_S_B.append("\t\tutil = null;\n");
		_S_B.append("\t\treturn getAllUtil();\n");
		_S_B.append("\t}\n\n");

		/*-------------------------------*/
		_S_B.append("\tpublic String selectUtil() throws Exception{\n");
		_S_B.append("\t\tutil = (" + name + ") objectManager.getObject(new "
				+ name + "(), util.getId());\n");
		_S_B.append("\t\terrMsg = null;\n");
		_S_B.append("\t\treturn \"saveOrUpdate\";\n");
		_S_B.append("\t}\n\n");

		/*-------------------------------*/
		_S_B.append("\tpublic String getAllUtil() throws Exception{\n");
		_S_B.append("\t\tif (null == pageModel) {\n");
		_S_B.append("\t\t\tpageModel = new PageModel<" + name + ">();\n");
		_S_B.append("\t\t}\n");
		_S_B.append("\t\tif (0 == pageModel.getCurrentPageNo()) {\n");
		_S_B.append("\t\t\tpageModel.setCurrentPageNo(1);\n");
		_S_B.append("\t\t}\n");

		_S_B.append("\t\tStringBuilder _sql = new StringBuilder();\n");

		_S_B.append("\t\t_sql.append(\" from " + name + " \");\n");
		_S_B.append("\t\tif (null != field && field.trim().length() > 0) {\n");
		_S_B
				.append("\t\t\tfieldValue = new String(fieldValue.getBytes(\"iso-8859-1\"), \"utf-8\");\n");
		_S_B
				.append("\t\t\t_sql.append(\" where \" + field + \" like '%\" + fieldValue + \"%'\");\n");
		_S_B.append("\t\t}\n");
		_S_B
				.append("\t\tpageModel = objectManager.getUtil(_sql.toString(), pageModel.getCurrentPageNo());\n");
		_S_B.append("\t\terrMsg = null;\n");

		_S_B.append("\t\treturn \"find\";\n");
		_S_B.append("\t}\n\n");

		_S_B
				.append("\tpublic "
						+ name
						+ " getUtil() {\n"
						+ "\t\treturn util;\n"
						+ "\t}\n\n"
						+ "\tpublic void setUtil("
						+ name
						+ " util) {\n"
						+ "\t\tthis.util = util;\n"
						+ "\t}\n\n"
						+ "\tpublic String getErrMsg() {\n"
						+ "\t\treturn errMsg;\n"
						+ "\t}\n\n"
						+ "\tpublic void setErrMsg(String errMsg) {\n"
						+ "\t\tthis.errMsg = errMsg;\n"
						+ "\t}\n\n"

						+ "\tpublic String getField() {\n"
						+ "\t\treturn field;\n"
						+ "\t}\n\n"
						+ "\tpublic void setField(String field) {\n"
						+ "\t\tthis.field = field;\n"
						+ "\t}\n\n"

						+ "\tpublic String getFieldValue() {\n"
						+ "\t\treturn fieldValue;\n"
						+ "\t}\n\n"
						+ "\tpublic void setFieldValue(String fieldValue) {\n"
						+ "\t\tthis.fieldValue = fieldValue;\n"
						+ "\t}\n\n"

						+ "\tpublic ObjectManager getObjectManager() {\n"
						+ "\t\treturn objectManager;\n"
						+ "\t}\n\n"
						+ "\tpublic void setObjectManager(ObjectManager objectManager) {\n"
						+ "\t\tthis.objectManager = objectManager;\n"

						+ "\t}\n\n" + "\tpublic PageModel<" + name
						+ "> getPageModel() {\n" + "\t\treturn pageModel;\n"
						+ "\t}\n\n" + "\tpublic void setPageModel(PageModel<"
						+ name + "> pageModel) {\n"
						+ "\t\tthis.pageModel = pageModel;\n" + "\t}\n\n");

		_S_B.append("}\n");
		return _S_B;
	}

	// 有父类普通类 Action
	public static StringBuffer createActionN(String name, String packName,
			ArrayList<String> _fields, ArrayList<String> _NAMES) {
		String First = "";
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

		_S_B.append("package " + packName + ";\n\n");

		packName = packName.replace(".action", "");

		_S_B.append("import java.util.*;\n");

		_S_B.append("import " + packName + ".model.*;\n");

		_S_B.append("import " + packName + ".manager.ObjectManager;\n");
		_S_B.append("import com.opensymphony.xwork2.*;\n\n");
		_S_B.append("import bysj.net.util.PageModel;\n\n");

		_S_B.append("import javax.servlet.http.HttpServletRequest;\n\n");
		_S_B.append("import org.apache.struts2.ServletActionContext;\n\n");
		_S_B.append("@SuppressWarnings({ \"unchecked\", \"serial\" })\n");
		_S_B.append("public class " + name + "Action extends ActionSupport {"
				+ "\n");

		_S_B.append("\tprivate " + name + " util;\n");
		_S_B.append("\tprivate PageModel<" + name + "> pageModel;\n");

		for (int i = 0; i < a; i++) {
			First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
			_S_B.append("\tprivate List<" + First + "> list" + First + ";\n");
		}

		_S_B.append("\tprivate String errMsg;\n");
		_S_B.append("\tprivate String field;\n");
		_S_B.append("\tprivate String fieldValue;\n");
		_S_B.append("\tprivate ObjectManager objectManager;\n\n");

		_S_B.append("\tpublic String initUtil() throws Exception{\n");

		for (int i = 0; i < a; i++) {
			First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
			_S_B.append("\t\tlist" + First + " = objectManager.getUtil(\"from "
					+ First + "\");\n");
		}

		_S_B.append("\t\tutil = null;\n");
		_S_B.append("\t\treturn \"saveOrUpdate\";\n");
		_S_B.append("\t}\n\n");

		_S_B.append("\tpublic String saveOrUpdateObject() throws Exception{\n");
		_S_B.append("\t\tobjectManager.saveOrUpdateObject(util);\n");
		_S_B.append("\t\tutil = null;\n");
		_S_B.append("\t\terrMsg = null;\n");
		_S_B.append("\t\treturn getAllUtil();\n");
		_S_B.append("\t}\n\n");
		
		/*-------------------------------*/
		_S_B.append("\n\tpublic String deleteManyUtil() throws Exception {");
		_S_B.append("\n\t\tHttpServletRequest request = ServletActionContext.getRequest();");
		_S_B.append("\n\t\tString ids[] = request.getParameterValues(\"id\");");
		_S_B.append("\n\t\t" + name + " util = null;");
		_S_B.append("\n\t\tfor (String id : ids) {");
		_S_B.append("\n\t\t\tutil = new " + name + "();");
		_S_B.append("\n\t\t\tutil.setId(Integer.parseInt(id));");
		_S_B.append("\n\t\t\tobjectManager.deleteObject(util);");
		_S_B.append("\n\t\t}");
		_S_B.append("\n\t\tutil = null;");
		_S_B.append("\n\t\treturn getAllUtil();");
		_S_B.append("\n\t}");

		_S_B.append("\tpublic String deleteUtil() throws Exception{\n");
		_S_B.append("\t\tobjectManager.deleteObject(util);\n");
		_S_B.append("\t\tutil = null;\n");
		_S_B.append("\t\terrMsg = null;\n");
		_S_B.append("\t\treturn getAllUtil();\n");
		_S_B.append("\t}\n\n");

		_S_B.append("\tpublic String selectUtil() throws Exception{\n");

		for (int i = 0; i < a; i++) {
			First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
			_S_B.append("\t\tlist" + First + " = objectManager.getUtil(\"from "
					+ First + "\");\n");
		}

		_S_B.append("\t\tutil = (" + name + ") objectManager.getObject(new "
				+ name + "(), util.getId());\n");
		_S_B.append("\t\treturn \"saveOrUpdate\";\n");
		_S_B.append("\t}\n\n");

		_S_B.append("\tpublic String getAllUtil() throws Exception{\n");
		_S_B
				.append("\t\t//Map session = ActionContext.getContext().getSession();\n");
		_S_B.append("\t\t//String type = (String) session.get(\"type\");\n");
		_S_B.append("\t\t//int id = (Integer) session.get(\"id\");\n");
		_S_B.append("\t\tif (null == pageModel) {\n");
		_S_B.append("\t\t\tpageModel = new PageModel<" + name + ">();\n");
		_S_B.append("\t\t}\n");
		_S_B.append("\t\tif (0 == pageModel.getCurrentPageNo()) {\n");
		_S_B.append("\t\t\tpageModel.setCurrentPageNo(1);\n");
		_S_B.append("\t\t}\n");

		_S_B.append("\t\tStringBuilder _sql = new StringBuilder();\n");

		_S_B.append("\t\t_sql.append(\" from " + name + " where 1 = 1 \");\n");
		_S_B.append("\t\t//if (!\"admin\".equals(type)) {\n");
		_S_B.append("\t\t//\t_sql.append(\" and user.id = \" + id);\n");
		_S_B.append("\t\t//}\n");

		_S_B.append("\t\tif (null != field && field.trim().length() > 0) {\n");
		_S_B
				.append("\t\t\tfieldValue = new String(fieldValue.getBytes(\"iso-8859-1\"), \"utf-8\");\n");
		_S_B
				.append("\t\t\t_sql.append(\" and \" + field + \" like '%\" + fieldValue + \"%'\");\n");
		_S_B.append("\t\t}\n");

		_S_B
				.append("\t\tpageModel = objectManager.getUtil(_sql.toString(), pageModel.getCurrentPageNo());\n");
		_S_B.append("\t\terrMsg = null;\n");

		_S_B.append("\t\treturn \"find\";\n");
		_S_B.append("\t}\n\n");

		_S_B
				.append("\tpublic "
						+ name
						+ " getUtil() {\n"
						+ "\t\treturn util;\n"
						+ "\t}\n\n"
						+ "\tpublic void setUtil("
						+ name
						+ " util) {\n"
						+ "\t\tthis.util = util;\n"
						+ "\t}\n\n"
						+ "\tpublic String getErrMsg() {\n"
						+ "\t\treturn errMsg;\n"
						+ "\t}\n\n"
						+ "\tpublic void setErrMsg(String errMsg) {\n"
						+ "\t\tthis.errMsg = errMsg;\n"
						+ "\t}\n\n"

						+ "\tpublic String getField() {\n"
						+ "\t\treturn field;\n"
						+ "\t}\n\n"
						+ "\tpublic void setField(String field) {\n"
						+ "\t\tthis.field = field;\n"
						+ "\t}\n\n"

						+ "\tpublic String getFieldValue() {\n"
						+ "\t\treturn fieldValue;\n"
						+ "\t}\n\n"
						+ "\tpublic void setFieldValue(String fieldValue) {\n"
						+ "\t\tthis.fieldValue = fieldValue;\n"
						+ "\t}\n\n"

						+ "\tpublic ObjectManager getObjectManager() {\n"
						+ "\t\treturn objectManager;\n"
						+ "\t}\n\n"
						+ "\tpublic void setObjectManager(ObjectManager objectManager) {\n"
						+ "\t\tthis.objectManager = objectManager;\n"

						+ "\t}\n\n" + "\tpublic PageModel<" + name
						+ "> getPageModel() {\n" + "\t\treturn pageModel;\n"
						+ "\t}\n\n" + "\tpublic void setPageModel(PageModel<"
						+ name + "> pageModel) {\n"
						+ "\t\tthis.pageModel = pageModel;\n" + "\t}\n\n");

		for (int i = 0; i < a; i++) {
			First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
			_S_B.append("\tpublic List<" + First + "> getList" + First
					+ "() {\n" + "\t\treturn list" + First + ";\n" + "\t}\n\n"
					+ "\tpublic void setList" + First + "(List<" + First
					+ "> list" + First + ") {\n" + "\t\tthis.list" + First
					+ " = list" + First + ";\n" + "\t}\n\n");
		}

		_S_B.append("}\n");
		return _S_B;
	}

	// 文件类 Action
	public static StringBuffer createAction3(String name, String packName) {
		StringBuffer _S_B = new StringBuffer();
		_S_B.append("package " + packName + ";\n\n");
		packName = packName.replace(".action", "");
		_S_B.append("import java.util.*;\n");
		_S_B.append("import java.io.*;\n");
		_S_B.append("import java.text.*;\n");
		_S_B.append("import org.apache.struts2.ServletActionContext;\n");

		_S_B.append("import javax.servlet.http.HttpServletRequest;\n\n");
		_S_B.append("import " + packName + ".manager.ObjectManager;\n");
		_S_B.append("import " + packName + ".model." + name + ";\n");
		_S_B.append("import com.opensymphony.xwork2.*;\n\n");
		_S_B.append("import bysj.net.util.PageModel;\n\n");

		_S_B.append("@SuppressWarnings({ \"unchecked\" })\n");
		_S_B.append("public class " + name + "Action extends ActionSupport {"
				+ "\n");

		_S_B.append("\tprivate static final long serialVersionUID = 1l;\n");
		_S_B.append("\tprivate static final int BUFFER_SIZE = 1;\n");
		_S_B.append("\tprivate File myFile;\n");
		_S_B.append("\tprivate String contentType;\n");
		_S_B.append("\tprivate String fileName;\n");
		_S_B.append("\tprivate String imageFileName;\n");
		_S_B.append("\tprivate " + name + " util;\n");
		_S_B.append("\tprivate PageModel<" + name + "> pageModel;\n");
		_S_B.append("\tprivate String errMsg;\n");
		_S_B.append("\tprivate String field;\n");
		_S_B.append("\tprivate String fieldValue;\n");
		_S_B.append("\tprivate ObjectManager objectManager;\n\n");

		/*-------------------------------*/
		_S_B.append("\tpublic String getAllUtil() throws Exception{\n");
		_S_B.append("\t\tif (null == pageModel) {\n");
		_S_B.append("\t\t\tpageModel = new PageModel<" + name + ">();\n");
		_S_B.append("\t\t}\n");
		_S_B.append("\t\tif (0 == pageModel.getCurrentPageNo()) {\n");
		_S_B.append("\t\t\tpageModel.setCurrentPageNo(1);\n");
		_S_B.append("\t\t}\n");

		_S_B.append("\t\tStringBuilder _sql = new StringBuilder();\n");

		_S_B.append("\t\t_sql.append(\" from " + name + " \");\n");
		_S_B.append("\t\tif (null != field && field.trim().length() > 0) {\n");
		_S_B
				.append("\t\t\tfieldValue = new String(fieldValue.getBytes(\"iso-8859-1\"), \"utf-8\");\n");
		_S_B
				.append("\t\t\t_sql.append(\" where \" + field + \" like '%\" + fieldValue + \"%'\");\n");
		_S_B.append("\t\t}\n");
		_S_B
				.append("\t\tpageModel = objectManager.getUtil(_sql.toString(), pageModel.getCurrentPageNo());\n");
		_S_B.append("\t\terrMsg = null;\n");

		_S_B.append("\t\treturn \"find\";\n");
		_S_B.append("\t}\n\n");

		_S_B
				.append("\tpublic String updateUtil() throws Exception {\n"
						+ "\t\tint id = util.getId();\n" + "\t\tif(id == 0){\n"
						+ "\t\t\tboolean flag = false;\n"
						+ "\t\t\tflag = upload();\n" + "\t\t\tif (flag) {\n"
						+ "\t\t\t\tobjectManager.saveObject(util);\n"
						+ "\t\t\t\tutil = null;\n" + "\t\t\t\treturn \"ok\";\n"
						+ "\t\t\t} else {\n"
						+ "\t\t\t\terrMsg = \"upload err\";\n"
						+ "\t\t\t\treturn \"saveOrUpdate\";\n" + "\t\t\t}\n"
						+ "\t\t}\n" + "\t\t"
						+ name
						+ " tmp = ("
						+ name
						+ ") objectManager.getObject(new "
						+ name
						+ "(), util.getId());\n"
						+ "\t\tif (fileName == null || (fileName != null && fileName.equals(tmp.getS_2()))) {\n"
						// + "\t\t\tutil.setUtil(tmp.getUtil());\n"
						+ "\t\t\tutil.setS_0(tmp.getS_0());\n"
						+ "\t\t\tutil.setS_1(tmp.getS_1());\n"
						+ "\t\t\tutil.setS_2(tmp.getS_2());\n"
						+ "\t\t\tobjectManager.updateObject(util);\n"
						+ "\t\t\treturn getAllUtil();\n"
						+ "\t\t}\n"
						+ "\t\tboolean flag = false;\n"
						+ "\t\tflag = upload();\n"
						+ "\t\tif (flag) {\n"
						+ "\t\t\tobjectManager.updateObject(util);\n"
						+ "\t\t\tutil = null;\n"
						+ "\t\t\terrMsg = null;\n"
						+ "\t\t\treturn getAllUtil();\n"
						+ "\t\t} else {\n"
						+ "\t\t\terrMsg = \"update err\";\n"
						+ "\t\t\treturn \"saveOrUpdate\";\n"
						+ "\t\t}\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic String selectUtil() throws Exception {\n"
						+ "\t\tutil = ("
						+ name
						+ ") objectManager.getObject(new "
						+ name
						+ "(), util.getId());\n"
						+ "\t\terrMsg = null;\n"
						+ "\t\treturn \"saveOrUpdate\";\n"
						+ "\t}\n"
						/*-------------------------------*/
						+"\n\tpublic String deleteManyUtil() throws Exception {"
						+"\n\t\tHttpServletRequest request = ServletActionContext.getRequest();"
						+"\n\t\tString ids[] = request.getParameterValues(\"id\");"
						+"\n\t\t" + name + " util = null;"
						+"\n\t\tfor (String id : ids) {"
						+"\n\t\t\tutil = new " + name + "();"
						+"\n\t\t\tutil.setId(Integer.parseInt(id));"
						+"\n\t\t\tobjectManager.deleteObject(util);"
						+"\n\t\t}"
						+"\n\t\tutil = null;"
						+"\n\t\treturn getAllUtil();"
						+"\n\t}"
						+ "\n"
						+ "\tpublic String deleteUtil() throws Exception {\n"
						+ "\t\tobjectManager.deleteObject(util);\n"
						+ "\t\treturn getAllUtil();\n"
						+ "\t}\n"
						+ "\n"
						+ "\tprivate boolean upload() {\n"
						+ "\t\tif (null == fileName) {\n"
						+ "\t\t\treturn false;\n"
						+ "\t\t}\n"
						+ "\t\tint pos = fileName.lastIndexOf(\".\");\n"
						+ "\t\tfileName.substring(pos);\n"
						+ "\t\timageFileName = fileName.substring(0, pos) + new Date().getTime()\n"
						+ "\t\t\t\t+ fileName.substring(pos);\n"
						+ "\t\tString path = ServletActionContext.getServletContext().getRealPath( \"/upload\") + \"/\" + imageFileName;\n"
						+ "\t\tFile imageFile = new File(path);\n"
						+ "\t\tutil.setS_0(imageFileName);\n"
						+ "\t\tString date = new SimpleDateFormat(\"yyyy-MM-dd\").format(Calendar.getInstance().getTime());\n"
						+ "\t\tutil.setS_2(date);\n"
						+ "\t\tutil.setS_1(fileName);\n"
						+ "\t\ttry {\n"
						+ "\t\t\tcopy(myFile, imageFile);\n"
						+ "\t\t} catch (Exception e) {\n"
						+ "\t\t\treturn false;\n"
						+ "\t\t}\n"
						+ "\n"
						// + "\t\tMap session =
						// ActionContext.getContext().getSession();\n"
						// + "\t\tList list = objectManager.getUtil(\"from User
						// where s_0 = '\"\n"
						// + "\t\t\t\t+ (String) session.get(\"username\") + \"'
						// \");\n"
						// + "\t\tUser tmp = null;\n"
						// + "\t\tif (null != list && list.size() > 0) {\n"
						// + "\t\t\ttmp = (User) list.get(0);\n"
						// + "\t\t\tutil.setUtil(tmp);\n"
						// + "\t\t}\n"
						+ "\t\treturn true;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tprivate void copy(File src, File dst) throws Exception {\n"
						+ "\t\tInputStream in = new BufferedInputStream(new FileInputStream(src),\n"
						+ "\t\t\t\tBUFFER_SIZE);\n"
						+ "\t\tOutputStream out = new BufferedOutputStream(new FileOutputStream(dst),\n"
						+ "\t\t\t\tBUFFER_SIZE);\n"
						+ "\t\tbyte[] buffer = new byte[BUFFER_SIZE];\n"
						+ "\t\twhile (in.read(buffer) > 0) {\n"
						+ "\t\t\tout.write(buffer);\n"
						+ "\t\t}\n"
						+ "\t\tin.close();\n"
						+ "\t\tout.close();\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setMyFileContentType(String contentType) {\n"
						+ "\t\tthis.contentType = contentType;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setMyFileFileName(String fileName) {\n"
						+ "\t\tthis.fileName = fileName;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setMyFile(File myFile) {\n"
						+ "\t\tthis.myFile = myFile;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic String getImageFileName() {\n"
						+ "\t\treturn imageFileName;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic String getContentType() {\n"
						+ "\t\treturn contentType;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setContentType(String contentType) {\n"
						+ "\t\tthis.contentType = contentType;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic String getFileName() {\n"
						+ "\t\treturn fileName;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setFileName(String fileName) {\n"
						+ "\t\tthis.fileName = fileName;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic static int getBUFFER_SIZE() {\n"
						+ "\t\treturn BUFFER_SIZE;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic File getMyFile() {\n"
						+ "\t\treturn myFile;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setImageFileName(String imageFileName) {\n"
						+ "\t\tthis.imageFileName = imageFileName;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic ObjectManager getObjectManager() {\n"
						+ "\t\treturn objectManager;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setObjectManager(ObjectManager objectManager) {\n"
						+ "\t\tthis.objectManager = objectManager;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic PageModel<"
						+ name
						+ "> getPageModel() {\n"
						+ "\t\treturn pageModel;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setPageModel(PageModel<"
						+ name
						+ "> pageModel) {\n"
						+ "\t\tthis.pageModel = pageModel;\n"
						+ "\t}\n"
						+ "\n"

						+ "\tpublic String getErrMsg() {\n"
						+ "\t\treturn errMsg;\n"
						+ "\t}\n\n"
						+ "\tpublic void setErrMsg(String errMsg) {\n"
						+ "\t\tthis.errMsg = errMsg;\n"
						+ "\t}\n\n"

						+ "\tpublic String getField() {\n"
						+ "\t\treturn field;\n"
						+ "\t}\n\n"
						+ "\tpublic void setField(String field) {\n"
						+ "\t\tthis.field = field;\n"
						+ "\t}\n\n"

						+ "\tpublic String getFieldValue() {\n"
						+ "\t\treturn fieldValue;\n"
						+ "\t}\n\n"
						+ "\tpublic void setFieldValue(String fieldValue) {\n"
						+ "\t\tthis.fieldValue = fieldValue;\n"
						+ "\t}\n\n"
						+ "\n"
						+ "\tpublic static long getSerialVersionUID() {\n"
						+ "\t\treturn serialVersionUID;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic "
						+ name
						+ " getUtil() {\n"
						+ "\t\treturn util;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setUtil("
						+ name
						+ " util) {\n"
						+ "\t\tthis.util = util;\n" + "\t}\n" + "\n" + "}\n");

		return _S_B;
	}

	// 有父类文件类 Action
	public static StringBuffer createAction4(String name, String packName,
			ArrayList<String> _fields, ArrayList<String> _NAMES) {
		String First = "";

		

		StringBuffer _S_B = new StringBuffer();
		_S_B.append("package " + packName + ";\n\n");
		packName = packName.replace(".action", "");
		_S_B.append("import java.util.*;\n");
		_S_B.append("import java.io.*;\n");
		_S_B.append("import java.text.*;\n");

		_S_B.append("import javax.servlet.http.HttpServletRequest;\n\n");
		_S_B.append("import org.apache.struts2.ServletActionContext;\n");
		_S_B.append("import " + packName + ".manager.ObjectManager;\n");
		_S_B.append("import " + packName + ".model.*;\n");
		_S_B.append("import com.opensymphony.xwork2.*;\n\n");
		_S_B.append("import bysj.net.util.PageModel;\n\n");

		_S_B.append("@SuppressWarnings({ \"unchecked\" })\n");
		_S_B.append("public class " + name + "Action extends ActionSupport {"
				+ "\n");

		_S_B.append("\tprivate static final long serialVersionUID = 1l;\n");
		_S_B.append("\tprivate static final int BUFFER_SIZE = 1;\n");
		_S_B.append("\tprivate File myFile;\n");
		_S_B.append("\tprivate String contentType;\n");
		_S_B.append("\tprivate String fileName;\n");
		_S_B.append("\tprivate String imageFileName;\n");
		_S_B.append("\tprivate " + name + " util;\n");
		_S_B.append("\tprivate PageModel<" + name + "> pageModel;\n");

		_S_B.append("\tprivate String errMsg;\n");
		_S_B.append("\tprivate String field;\n");
		_S_B.append("\tprivate String fieldValue;\n");
		_S_B.append("\tprivate ObjectManager objectManager;\n\n");
		
		
		boolean flag = false;
		for (int i = 0; i < _fields.size(); i++) {
			flag = false;
			for (int j = 0; j < _NAMES.size(); j++) {
				if (_fields.get(i).equals(_NAMES.get(j))) {
					flag = true;
				}
			}
			if (flag) {
				First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
				_S_B.append("\tprivate List<" + First + "> list" + First + ";\n");
			}  
		}
 

		_S_B.append("\tpublic String initUtil() throws Exception{\n");
		for (int i = 0; i < _fields.size(); i++) {
			flag = false;
			for (int j = 0; j < _NAMES.size(); j++) {
				if (_fields.get(i).equals(_NAMES.get(j))) {
					flag = true;
				}
			}
			if (flag) {
				First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
				_S_B.append("\t\tlist" + First + " = objectManager.getUtil(\"from "
						+ First + "\");\n");
			}  
		}
		 
		_S_B.append("\t\tutil = null;\n");
		_S_B.append("\t\treturn \"saveOrUpdate\";\n");
		_S_B.append("\t}\n\n");

		_S_B.append("\tpublic String selectUtil() throws Exception{\n");
		for (int i = 0; i < _fields.size(); i++) {
			flag = false;
			for (int j = 0; j < _NAMES.size(); j++) {
				if (_fields.get(i).equals(_NAMES.get(j))) {
					flag = true;
				}
			}
			if (flag) {
				First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
				_S_B.append("\t\tlist" + First + " = objectManager.getUtil(\"from "
						+ First + "\");\n");
			}  
		}
		_S_B.append("\t\tutil = (" + name + ") objectManager.getObject(new "
				+ name + "(), util.getId());\n");
		_S_B.append("\t\terrMsg = null;\n");
		_S_B.append("\t\treturn \"saveOrUpdate\";\n");
		_S_B.append("\t}\n\n");

		/*-------------------------------*/
		_S_B.append("\tpublic String getAllUtil() throws Exception{\n");
		_S_B.append("\t\tif (null == pageModel) {\n");
		_S_B.append("\t\t\tpageModel = new PageModel<" + name + ">();\n");
		_S_B.append("\t\t}\n");
		_S_B.append("\t\tif (0 == pageModel.getCurrentPageNo()) {\n");
		_S_B.append("\t\t\tpageModel.setCurrentPageNo(1);\n");
		_S_B.append("\t\t}\n");

		_S_B.append("\t\tStringBuilder _sql = new StringBuilder();\n");

		_S_B.append("\t\t_sql.append(\" from " + name + " \");\n");
		_S_B.append("\t\tif (null != field && field.trim().length() > 0) {\n");
		_S_B
				.append("\t\t\tfieldValue = new String(fieldValue.getBytes(\"iso-8859-1\"), \"utf-8\");\n");
		_S_B
				.append("\t\t\t_sql.append(\" where \" + field + \" like '%\" + fieldValue + \"%'\");\n");
		_S_B.append("\t\t}\n");
		_S_B
				.append("\t\tpageModel = objectManager.getUtil(_sql.toString(), pageModel.getCurrentPageNo());\n");
		_S_B.append("\t\terrMsg = null;\n");

		_S_B.append("\t\treturn \"find\";\n");
		_S_B.append("\t}\n\n");

		_S_B
				.append("\tpublic String updateUtil() throws Exception {\n"
						+ "\t\tint id = util.getId();\n" + "\t\tif(id == 0){\n"
						+ "\t\t\tboolean flag = false;\n"
						+ "\t\t\tflag = upload();\n" + "\t\t\tif (flag) {\n"
						+ "\t\t\t\tobjectManager.saveObject(util);\n"
						+ "\t\t\t\tutil = null;\n" + "\t\t\t\treturn \"ok\";\n"
						+ "\t\t\t} else {\n"
						+ "\t\t\t\terrMsg = \"upload err\";\n"
						+ "\t\t\t\treturn \"saveOrUpdate\";\n" + "\t\t\t}\n"
						+ "\t\t}\n" + "\t\t"
						+ name
						+ " tmp = ("
						+ name
						+ ") objectManager.getObject(new "
						+ name
						+ "(), util.getId());\n"
						+ "\t\tif (fileName == null || (fileName != null && fileName.equals(tmp.getS_2()))) {\n"
						+ "\t\t\tutil.setS_0(tmp.getS_0());\n"
						+ "\t\t\tutil.setS_1(tmp.getS_1());\n"
						+ "\t\t\tutil.setS_2(tmp.getS_2());\n"
						+ "\t\t\tobjectManager.updateObject(util);\n"
						+ "\t\t\treturn getAllUtil();\n"
						+ "\t\t}\n"
						+ "\t\tboolean flag = false;\n"
						+ "\t\tflag = upload();\n"
						+ "\t\tif (flag) {\n"
						+ "\t\t\tobjectManager.updateObject(util);\n"
						+ "\t\tutil = null;\n"
						+ "\t\terrMsg = null;\n"
						+ "\t\t\treturn getAllUtil();\n"
						+ "\t\t} else {\n"
						+ "\t\t\terrMsg = \"update err\";\n"
						+ "\t\t\treturn \"saveOrUpdate\";\n"
						+ "\t\t}\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic String deleteUtil() throws Exception {\n"
						+ "\t\tobjectManager.deleteObject(util);\n"
						+ "\t\treturn getAllUtil();\n"
						+ "\t}\n"
						+ "\n"
						/*-------------------------------*/
						+"\n\tpublic String deleteManyUtil() throws Exception {"
						+"\n\t\tHttpServletRequest request = ServletActionContext.getRequest();"
						+"\n\t\tString ids[] = request.getParameterValues(\"id\");"
						+"\n\t\t" + name + " util = null;"
						+"\n\t\tfor (String id : ids) {"
						+"\n\t\t\tutil = new " + name + "();"
						+"\n\t\t\tutil.setId(Integer.parseInt(id));"
						+"\n\t\t\tobjectManager.deleteObject(util);"
						+"\n\t\t}"
						+"\n\t\tutil = null;"
						+"\n\t\treturn getAllUtil();"
						+"\n\t}"
						+ "\n"
						+ "\tprivate boolean upload() {\n"
						+ "\t\tif (null == fileName) {\n"
						+ "\t\t\treturn false;\n"
						+ "\t\t}\n"
						+ "\t\tint pos = fileName.lastIndexOf(\".\");\n"
						+ "\t\tfileName.substring(pos);\n"
						+ "\t\timageFileName = fileName.substring(0, pos) + new Date().getTime()\n"
						+ "\t\t\t\t+ fileName.substring(pos);\n"
						+ "\t\tString path = ServletActionContext.getServletContext().getRealPath( \"/upload\") + \"/\" + imageFileName;\n"
						+ "\t\tFile imageFile = new File(path);\n"
						+ "\t\tutil.setS_0(imageFileName);\n"
						+ "\t\tString date = new SimpleDateFormat(\"yyyy-MM-dd\").format(Calendar.getInstance().getTime());\n"
						+ "\t\tutil.setS_2(date);\n"
						+ "\t\tutil.setS_1(fileName);\n"
						+ "\t\ttry {\n"
						+ "\t\t\tcopy(myFile, imageFile);\n"
						+ "\t\t} catch (Exception e) {\n"
						+ "\t\t\treturn false;\n"
						+ "\t\t}\n"
						+ "\n"
						+ "\t\treturn true;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tprivate void copy(File src, File dst) throws Exception {\n"
						+ "\t\tInputStream in = new BufferedInputStream(new FileInputStream(src),\n"
						+ "\t\t\t\tBUFFER_SIZE);\n"
						+ "\t\tOutputStream out = new BufferedOutputStream(new FileOutputStream(dst),\n"
						+ "\t\t\t\tBUFFER_SIZE);\n"
						+ "\t\tbyte[] buffer = new byte[BUFFER_SIZE];\n"
						+ "\t\twhile (in.read(buffer) > 0) {\n"
						+ "\t\t\tout.write(buffer);\n"
						+ "\t\t}\n"
						+ "\t\tin.close();\n"
						+ "\t\tout.close();\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setMyFileContentType(String contentType) {\n"
						+ "\t\tthis.contentType = contentType;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setMyFileFileName(String fileName) {\n"
						+ "\t\tthis.fileName = fileName;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setMyFile(File myFile) {\n"
						+ "\t\tthis.myFile = myFile;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic String getImageFileName() {\n"
						+ "\t\treturn imageFileName;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic String getContentType() {\n"
						+ "\t\treturn contentType;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setContentType(String contentType) {\n"
						+ "\t\tthis.contentType = contentType;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic String getFileName() {\n"
						+ "\t\treturn fileName;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setFileName(String fileName) {\n"
						+ "\t\tthis.fileName = fileName;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic static int getBUFFER_SIZE() {\n"
						+ "\t\treturn BUFFER_SIZE;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic File getMyFile() {\n"
						+ "\t\treturn myFile;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setImageFileName(String imageFileName) {\n"
						+ "\t\tthis.imageFileName = imageFileName;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic ObjectManager getObjectManager() {\n"
						+ "\t\treturn objectManager;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setObjectManager(ObjectManager objectManager) {\n"
						+ "\t\tthis.objectManager = objectManager;\n"
						+ "\t}\n"
						+ "\n"

						 
						+ "\tpublic PageModel<"
						+ name
						+ "> getPageModel() {\n"
						+ "\t\treturn pageModel;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setPageModel(PageModel<"
						+ name
						+ "> pageModel) {\n"
						+ "\t\tthis.pageModel = pageModel;\n"
						+ "\t}\n"
						+ "\n"

						+ "\tpublic String getErrMsg() {\n"
						+ "\t\treturn errMsg;\n"
						+ "\t}\n\n"
						+ "\tpublic void setErrMsg(String errMsg) {\n"
						+ "\t\tthis.errMsg = errMsg;\n"
						+ "\t}\n\n"

						+ "\tpublic String getField() {\n"
						+ "\t\treturn field;\n"
						+ "\t}\n\n"
						+ "\tpublic void setField(String field) {\n"
						+ "\t\tthis.field = field;\n"
						+ "\t}\n\n"

						+ "\tpublic String getFieldValue() {\n"
						+ "\t\treturn fieldValue;\n"
						+ "\t}\n\n"
						+ "\tpublic void setFieldValue(String fieldValue) {\n"
						+ "\t\tthis.fieldValue = fieldValue;\n"
						+ "\t}\n\n"
						+ "\n"
						+ "\tpublic static long getSerialVersionUID() {\n"
						+ "\t\treturn serialVersionUID;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic "
						+ name
						+ " getUtil() {\n"
						+ "\t\treturn util;\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void setUtil("
						+ name
						+ " util) {\n"
						+ "\t\tthis.util = util;\n" + "\t}\n" + "\n");
		
		for (int i = 0; i < _fields.size(); i++) {
			flag = false;
			for (int j = 0; j < _NAMES.size(); j++) {
				if (_fields.get(i).equals(_NAMES.get(j))) {
					flag = true;
				}
			}
			if (flag) {
				First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
				_S_B.append("\tpublic List<" + First + "> getList" + First
						+ "() {\n" + "\t\treturn list" + First + ";\n" + "\t}\n\n"
						+ "\tpublic void setList" + First + "(List<" + First
						+ "> list" + First + ") {\n" + "\t\tthis.list" + First
						+ " = list" + First + ";\n" + "\t}\n\n");
			}  
		}

		_S_B.append("}\n");

		return _S_B;
	}

}
