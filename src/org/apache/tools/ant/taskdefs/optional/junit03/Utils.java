package org.apache.tools.ant.taskdefs.optional.junit03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import bysj.net.util.HibernateUtils;

public class Utils {

	public static final int BUFFER_SIZE = 1;

	public static String toFirstUp(String str) {
		String result = "";
		String str1 = str.substring(0, 1);
		String str2 = "";
		if (str.length() > 1) {
			str2 = str.substring(1, str.length());
		}
		result = str1.toUpperCase() + str2;
		return result;
	}

	public static String toFirstDown(String str) {
		String result = "";
		String str1 = str.substring(0, 1);
		String str2 = "";
		if (str.length() > 1) {
			str2 = str.substring(1, str.length());
		}
		result = str1.toLowerCase() + str2;
		return result;
	}

	public void createSaveOrUpdateObjectJsp1(String _NAME, String _VALUE,
			ArrayList<String> _VALUES) {
		File _FILE_A = null;
		File _FILE_B = null;
		_FILE_A = new File("WebRoot/admin/" + _NAME);
		try {

			_FILE_A.mkdir();

			String path = _FILE_A.getPath();

			_FILE_A = new File(path + "/saveOrUpdate.jsp");
			_FILE_B = new File(path + "/find.jsp");

			_FILE_A.createNewFile();
			_FILE_B.createNewFile();

			StringBuffer _S_A = UtilsJsp.createSaveOrUpdateObjectJsp1(_NAME,
					_VALUE, _VALUES);
			StringBuffer _S_B = UtilsJsp.createFindJsp1(_NAME, _VALUE, _VALUES);

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));
			BufferedWriter _OUT_B = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_B), HibernateUtils._ENCODE));

			_OUT_A.write(_S_A.toString());
			_OUT_B.write(_S_B.toString());

			_OUT_A.close();
			_OUT_B.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createSaveOrUpdateObjectJsp3(String _NAME, String _VALUE,
			ArrayList<String> _VALUES) {
		File _FILE_A = null;
		File _FILE_B = null;
		File _FILE_C = null;
		_FILE_A = new File("WebRoot/admin/" + _NAME);
		try {

			_FILE_A.mkdir();

			String path = _FILE_A.getPath();

			_FILE_A = new File(path + "/saveOrUpdate.jsp");
			_FILE_B = new File(path + "/find.jsp");
			_FILE_C = new File(path + "/ok.jsp");

			_FILE_A.createNewFile();
			_FILE_B.createNewFile();
			_FILE_C.createNewFile();

			StringBuffer _S_A = UtilsJsp.createSaveOrUpdateObjectJsp3(_NAME,
					_VALUE, _VALUES);
			StringBuffer _S_B = UtilsJsp.createFindJsp3(_NAME, _VALUE, _VALUES);
			StringBuffer _S_C = UtilsJsp.createOkJsp3(_NAME, _VALUE, _VALUES);

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));
			BufferedWriter _OUT_B = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_B), HibernateUtils._ENCODE));
			BufferedWriter _OUT_C = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_C), HibernateUtils._ENCODE));

			_OUT_A.write(_S_A.toString());
			_OUT_B.write(_S_B.toString());
			_OUT_C.write(_S_C.toString());

			_OUT_A.close();
			_OUT_B.close();
			_OUT_C.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createSaveOrUpdateObjectJsp4(String _NAME, String _VALUE,
			ArrayList<String> _VALUES, ArrayList<String> _fields,
			ArrayList<String> _NAMES) {
		File _FILE_A = null;
		File _FILE_B = null;
		File _FILE_C = null;
		_FILE_A = new File("WebRoot/admin/" + _NAME);
		try {

			_FILE_A.mkdir();

			String path = _FILE_A.getPath();

			_FILE_A = new File(path + "/saveOrUpdate.jsp");
			_FILE_B = new File(path + "/find.jsp");
			_FILE_C = new File(path + "/ok.jsp");

			_FILE_A.createNewFile();
			_FILE_B.createNewFile();
			_FILE_C.createNewFile();
 
			StringBuffer _S_A = UtilsJsp.createSaveOrUpdateObjectJsp4(_NAME,
					_VALUE, _VALUES, _fields, _NAMES);
			StringBuffer _S_B = UtilsJsp.createFindJsp4(_NAME,
					_VALUE, _VALUES, _fields, _NAMES);
			StringBuffer _S_C = UtilsJsp.createOkJsp3(_NAME, _VALUE, _VALUES);

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));
			BufferedWriter _OUT_B = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_B), HibernateUtils._ENCODE));
			BufferedWriter _OUT_C = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_C), HibernateUtils._ENCODE));

			_OUT_A.write(_S_A.toString());
			_OUT_B.write(_S_B.toString());
			_OUT_C.write(_S_C.toString());

			_OUT_A.close();
			_OUT_B.close();
			_OUT_C.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createSaveOrUpdateObjectJspN(String _NAME, String _VALUE,
			ArrayList<String> _VALUES, ArrayList<String> _fields,
			ArrayList<String> _NAMES) {
		File _FILE_A = null;
		File _FILE_B = null;
		_FILE_A = new File("WebRoot/admin/" + _NAME);
		try {

			_FILE_A.mkdir();

			String path = _FILE_A.getPath();

			_FILE_A = new File(path + "/saveOrUpdate.jsp");
			_FILE_B = new File(path + "/find.jsp");

			_FILE_A.createNewFile();
			_FILE_B.createNewFile();

			StringBuffer _S_A = UtilsJsp.createSaveOrUpdateObjectJspN(_NAME,
					_VALUE, _VALUES, _fields, _NAMES);
			StringBuffer _S_B = UtilsJsp.createFindJspN(_NAME, _VALUE, _VALUES,
					_fields, _NAMES);

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));
			BufferedWriter _OUT_B = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_B), HibernateUtils._ENCODE));

			_OUT_A.write(_S_A.toString());
			_OUT_B.write(_S_B.toString());

			_OUT_A.close();
			_OUT_B.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createApplicationContextXml(ArrayList<String> _NAMES) {
		String _PATH = (HibernateUtils._PACKAGE + ".action").replace('.', '/');
		File _FILE_A = null;
		_FILE_A = new File("src/applicationContext.xml");
		try {

			_FILE_A.createNewFile();
			StringBuffer _S_A = UtilsJsp.createApplicationContextXml(_PATH,
					_NAMES);

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));

			_OUT_A.write(_S_A.toString());
			_OUT_A.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createHibernateCfgXml(ArrayList<String> _NAMES) {
		String _PATH = (HibernateUtils._PACKAGE + ".model").replace('.', '/');
		File _FILE_A = null;
		_FILE_A = new File("src/hibernate.cfg.xml");
		try {

			_FILE_A.createNewFile();
			StringBuffer _S_A = UtilsJsp.createHibernateCfgXml(_PATH, _NAMES);

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));

			_OUT_A.write(_S_A.toString());
			_OUT_A.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createAction1(String _NAME, ArrayList<String> _fields) {
		File _FILE_A = null;
		String pack = HibernateUtils._PACKAGE + ".action";
		String _PATH = "src/" + pack.replace('.', '/');
		_FILE_A = new File(_PATH);

		try {
			FileUtils.forceMkdir(_FILE_A);

			StringBuffer _S_A = Actions.createAction1(_NAME, pack);

			_FILE_A = new File(_PATH + "/" + _NAME + "Action.java");
			_FILE_A.createNewFile();

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));

			_OUT_A.write(_S_A.toString());
			_OUT_A.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createActionN(String _NAME, ArrayList<String> _fields,
			String _VALUE, ArrayList<String> _VALUES, ArrayList<String> _NAMES) {
		File _FILE_A = null;
		String pack = HibernateUtils._PACKAGE + ".action";
		String _PATH = "src/" + pack.replace('.', '/');
		_FILE_A = new File(_PATH);

		try {
			FileUtils.forceMkdir(_FILE_A);

			StringBuffer _S_A = Actions.createActionN(_NAME, pack, _fields,
					_NAMES);

			_FILE_A = new File(_PATH + "/" + _NAME + "Action.java");
			_FILE_A.createNewFile();

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));
			_OUT_A.write(_S_A.toString());
			_OUT_A.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createAction3(String _NAME, ArrayList<String> _fields) {
		File _FILE_A = null;
		String pack = HibernateUtils._PACKAGE + ".action";
		String _PATH = "src/" + pack.replace('.', '/');
		_FILE_A = new File(_PATH);

		try {
			FileUtils.forceMkdir(_FILE_A);

			StringBuffer _S_A = Actions.createAction3(_NAME, pack);

			_FILE_A = new File(_PATH + "/" + _NAME + "Action.java");
			_FILE_A.createNewFile();

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));
			_OUT_A.write(_S_A.toString());
			_OUT_A.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createAction4(String _NAME, ArrayList<String> _fields,
			String _VALUE, ArrayList<String> _VALUES, ArrayList<String> _NAMES) {
		File _FILE_A = null;
		String pack = HibernateUtils._PACKAGE + ".action";
		String _PATH = "src/" + pack.replace('.', '/');
		_FILE_A = new File(_PATH);

		try {
			FileUtils.forceMkdir(_FILE_A);

			StringBuffer _S_A = Actions.createAction4(_NAME, pack, _fields,
					_NAMES);

			_FILE_A = new File(_PATH + "/" + _NAME + "Action.java");
			_FILE_A.createNewFile();

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));
			_OUT_A.write(_S_A.toString());
			_OUT_A.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createModel1(String _NAME, ArrayList<String> _fields) {
		File _FILE_A = null;
		File _FILE_B = null;
		String pack = HibernateUtils._PACKAGE + ".model";

		String _PATH = "src/" + pack.replace('.', '/');

		try {
			FileUtils.forceMkdir(new File(_PATH));

			_FILE_A = new File(_PATH + "/" + _NAME + ".java");
			_FILE_A.createNewFile();

			StringBuffer _S_A = Models.creteModel1(_NAME, _fields.size(), pack);

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));
			_OUT_A.write(_S_A.toString());
			_OUT_A.close();

			_FILE_B = new File(_PATH + "/" + _NAME + ".hbm.xml");
			_FILE_B.createNewFile();

			BufferedWriter _OUT_B = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_B), HibernateUtils._ENCODE));
			StringBuffer _S_B = ModelsXml.creteModelXml1(_NAME, pack, _fields);
			_OUT_B.write(_S_B.toString());
			_OUT_B.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createModelN(String _NAME, ArrayList<String> _fields,
			String _VALUE, ArrayList<String> _VALUES, ArrayList<String> _NAMES) {
		File _FILE_A = null;
		File _FILE_B = null;
		String pack = HibernateUtils._PACKAGE + ".model";

		String _PATH = "src/" + pack.replace('.', '/');

		try {
			FileUtils.forceMkdir(new File(_PATH));

			_FILE_A = new File(_PATH + "/" + _NAME + ".java");
			_FILE_A.createNewFile();
			StringBuffer _S_A = Models.createModelN(_NAME, _fields.size(),
					pack, _fields, _NAMES);

			BufferedWriter _OUT_A = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_A), HibernateUtils._ENCODE));

			_OUT_A.write(_S_A.toString());
			_OUT_A.close();

			_FILE_B = new File(_PATH + "/" + _NAME + ".hbm.xml");
			_FILE_B.createNewFile();

			BufferedWriter _OUT_B = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(_FILE_B), HibernateUtils._ENCODE));

			StringBuffer _S_B = ModelsXml.creteModelXmlN(_NAME, pack, _fields,
					_NAMES);
			_OUT_B.write(_S_B.toString());
			_OUT_B.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
