package test.annotation.test3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解处理器TableCreator.java 下面是一个注解处理器的例子，它将读取一个类文件，并检查其上的数据库注解，并生成用来创建数据库的SQL命令
 * 
 * @author chen
 *
 */
public class TableCreator {

	public static final String[] args= {"test.annotation.test3.Member"};
	
	public static void main(String[] args1) throws Exception {
		if (args.length < 1) {
			System.out.println("arguments: annotated classes");
			System.exit(0);
		}
//		String[] args = {"Member","2","3"};
		for (String className : args) {
			Class<?> cl = Class.forName(className);
			DBTable dbTable = cl.getAnnotation(DBTable.class);
			if (dbTable == null) {
				System.out.println("No DBTable annotations in class " + className);
				continue;
			}
			String tableName = dbTable.name();
			// If the name is empty, use the Class name:
			if (tableName.length() < 1)
				tableName = cl.getName().toUpperCase();
			List<String> columnDefs = new ArrayList<String>();
			for (Field field : cl.getDeclaredFields()) {
				String columnName = null;
				Annotation[] anns = field.getDeclaredAnnotations();
				if (anns.length < 1)
					continue; // Not a db table column
				if (anns[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) anns[0];
					// Use field name if name not specified
					if (sInt.name().length() < 1)
						columnName = field.getName().toUpperCase();
					else
						columnName = sInt.name();
					columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
				}
				if (anns[0] instanceof SQLString) {
					SQLString sString = (SQLString) anns[0];
					// Use field name if name not specified.
					if (sString.name().length() < 1)
						columnName = field.getName().toUpperCase();
					else
						columnName = sString.name();
					columnDefs.add(
							columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
				}
				StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
				for (String columnDef : columnDefs)
					createCommand.append("\n    " + columnDef + ",");
				// Remove trailing comma
				String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
				System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
			}
		}
	}

	private static String getConstraints(Constraints con) {
		String constraints = "";
		if (!con.allowNull())
			constraints += " NOT NULL";
		if (con.primaryKey())
			constraints += " PRIMARY KEY";
		if (con.unique())
			constraints += " UNIQUE";
		return constraints;
	}
} /*
	 * Output: Table Creation SQL for annotations.database.Member is : CREATE
	 * TABLE MEMBER( FIRSTNAME VARCHAR(30)); Table Creation SQL for
	 * annotations.database.Member is : CREATE TABLE MEMBER( FIRSTNAME
	 * VARCHAR(30), LASTNAME VARCHAR(50)); Table Creation SQL for
	 * annotations.database.Member is : CREATE TABLE MEMBER( FIRSTNAME
	 * VARCHAR(30), LASTNAME VARCHAR(50), AGE INT); Table Creation SQL for
	 * annotations.database.Member is : CREATE TABLE MEMBER( FIRSTNAME
	 * VARCHAR(30), LASTNAME VARCHAR(50), AGE INT, HANDLE VARCHAR(30) PRIMARY
	 * KEY);
	 */// :~
