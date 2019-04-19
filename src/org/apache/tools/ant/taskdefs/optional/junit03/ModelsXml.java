package org.apache.tools.ant.taskdefs.optional.junit03;

import java.util.ArrayList;

public class ModelsXml {

	public static String _MESS_BG = "<?xml version=\"1.0\"?>\n<!DOCTYPE hibernate-mapping PUBLIC \n	\"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"\n	\"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd\">\n<hibernate-mapping>\n";

	public static String _MESS_ED = "	</class>\n</hibernate-mapping>";

	// 普通类 modelXml
	public static StringBuffer creteModelXml1(String name, String packName,
			ArrayList<String> args) {
		StringBuffer _S_B = new StringBuffer();
		String _MESS_CL = "	<class name=\""
				+ packName
				+ "."
				+ name
				+ "\" table=\"t_"
				+ name
				+ "\">\n		<id name=\"id\">\n			<generator class=\"native\" />\n		</id>\n";
		_S_B.append(_MESS_BG);
		_S_B.append(_MESS_CL);

		String result = "";
		for (int j = 0; j < args.size(); j++) {
			result = "s_" + j;
			_S_B.append("		<property name=\"" + result + "\" column=\""
					+ args.get(j) + "\" />\n");
		}

		_S_B.append(_MESS_ED);
		return _S_B;
	}

	// 有父类普通类 modelXml
	public static StringBuffer creteModelXmlN(String name, String packName,
			ArrayList<String> _fields, ArrayList<String> _NAMES) {
		String First = "", first = "";
		String result = "";
		
		StringBuffer _S_B = new StringBuffer();
		String _MESS_CL = "	<class name=\""
				+ packName
				+ "."
				+ name
				+ "\" table=\"t_"
				+ name
				+ "\">\n		<id name=\"id\">\n			<generator class=\"native\" />\n		</id>\n";
		_S_B.append(_MESS_BG);
		_S_B.append(_MESS_CL);

		boolean flag = false;
		for (int i = 0, index = 0; i < _fields.size(); i++) {
			flag = false;
			for (int j = 0; j < _NAMES.size(); j++) {
				if (_fields.get(i).equals(_NAMES.get(j))) {
					flag = true;
				}
			}
			if (flag) {
				First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
				first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(i)));
				_MESS_CL = "		<many-to-one name=\""
						+ first
						+ "\" class=\"bysj.net.model."
						+ First
						+ "\" outer-join=\"false\" lazy=\"false\">\n		</many-to-one>\n";
				_S_B.append(_MESS_CL);
			} else {
				result = "s_" + index;

				first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(i)));

				_S_B.append("		<property name=\"" + result + "\" column=\""
						+ first + "\" />\n");
				index++;
			}
		}

		_S_B.append(_MESS_ED);
		return _S_B;
	}

}
