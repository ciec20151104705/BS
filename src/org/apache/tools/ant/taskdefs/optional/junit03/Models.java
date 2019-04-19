package org.apache.tools.ant.taskdefs.optional.junit03;

import java.util.ArrayList;

public class Models {

	// 普通类model
	public static StringBuffer creteModel1(String name, int num, String packName) {
		StringBuffer _S_B = new StringBuffer();
		String packageName = "package " + packName + ";\n\n";
		_S_B.append(packageName);

		String className = "public class " + name + " {" + "\n";
		_S_B.append(className);

		_S_B.append("\tprivate int id;\n");

		String result = "";
		String fildname = "";
		String setMethod = "";
		String getMethod = "";
		for (int j = 0; j < num; j++) {
			result = "s_" + j;
			fildname = "\tprivate String " + result + ";\n";
			_S_B.append(fildname);
		}

		_S_B.append("\n\tpublic " + name + "() {\n\t}" + "\n\n");

		_S_B
				.append("\tpublic void setId(int id) {\n\t\tthis.id = id;\n\t}\n\n");

		for (int j = 0; j < num; j++) {
			result = "s_" + j;

			setMethod = "\tpublic void set" + Utils.toFirstUp(result)
					+ "(String " + result + ") {" + "\n\t" + "\tthis." + result
					+ " = " + result + ";\n\t}" + "\n\n";
			_S_B.append(setMethod);
		}

		_S_B.append("\tpublic int getId() {\n\t\treturn this.id;\n\t}\n\n");

		for (int j = 0; j < num; j++) {
			result = "s_" + j;

			getMethod = "\tpublic String get" + Utils.toFirstUp(result)
					+ "() {" + "\n\t\t" + "return this." + result
					+ ";\n\t}\n\n";
			_S_B.append(getMethod);

		}

		String end = "}\n";
		_S_B.append(end);
		return _S_B;
	}

	// 有父类普通类 model
	public static StringBuffer createModelN(String name, int num,
			String packName, ArrayList<String> _fields, ArrayList<String> _NAMES) {
		String First = "", first = "";
		String result = "", fildname = "";
		String setMethod = "", getMethod = "";

		boolean flag = false;
		StringBuffer _S_B = new StringBuffer();
		String packageName = "package " + packName + ";\n\n";
		_S_B.append(packageName);

		String className = "public class " + name + " {" + "\n";
		_S_B.append(className);

		_S_B.append("\tprivate int id;\n");
		_S_B.append("\n\tpublic " + name + "() {\n\t}" + "\n\n");

		_S_B
				.append("\tpublic void setId(int id) {\n\t\tthis.id = id;\n\t}\n\n");

		_S_B.append("\tpublic int getId() {\n\t\treturn this.id;\n\t}\n\n");

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

				_S_B.append("\tprivate " + First + " " + first + ";\n");

				First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
				first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(i)));

				_S_B.append("\tpublic void set" + First + "(" + First + " "
						+ first + ") {\n\t\tthis." + first + " = " + first
						+ ";\n\t}\n\n");

				First = Utils.toFirstUp(Utils.toFirstUp(_fields.get(i)));
				first = Utils.toFirstDown(Utils.toFirstUp(_fields.get(i)));

				_S_B.append("\tpublic " + First + " get" + First
						+ "() {\n\t\treturn this." + first + ";\n\t}\n\n");
			} else {

				result = "s_" + index;

				fildname = "\tprivate String " + result + ";\n";
				_S_B.append(fildname);

				result = "s_" + index;
				First = Utils.toFirstUp(result);

				setMethod = "\tpublic void set" + First + "(String " + result
						+ ") {" + "\n\t" + "\tthis." + result + " = " + result
						+ ";\n\t}" + "\n\n";
				_S_B.append(setMethod);

				result = "s_" + index;
				First = Utils.toFirstUp(result);

				getMethod = "\tpublic String get" + First + "() {" + "\n\t\t"
						+ "return this." + result + ";\n\t}\n\n";
				_S_B.append(getMethod);
				index++;
			}
		}

		String end = "}\n";
		_S_B.append(end);
		return _S_B;
	}

}
