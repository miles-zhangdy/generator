package cn.org.rapid_framework.generator.util.typemapping;


import java.sql.Types;
import java.util.HashMap;
/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */
public class DatabaseDataTypesUtils {

	private final static IntStringMap _preferredJavaTypeForSqlType = new IntStringMap();
	 
	public static boolean isFloatNumber(String javaType) {
		if(javaType.endsWith("Float") || javaType.endsWith("Double") || javaType.endsWith("BigDecimal") || javaType.endsWith("BigInteger")) {
			return true;
		}
		if(javaType.endsWith("float") || javaType.endsWith("double") || javaType.endsWith("BigDecimal") || javaType.endsWith("BigInteger")) {
            return true;
        }
		return false;
	}
	
	public static boolean isIntegerNumber(String javaType) {
		if(javaType.endsWith("Long") || javaType.endsWith("Integer") || javaType.endsWith("Short") || javaType.endsWith("Byte")) {
			return true;
		}
		if(javaType.endsWith("long") || javaType.endsWith("int") || javaType.endsWith("short") || javaType.endsWith("byte")) {
            return true;
        }
		return false;
	}

	public static boolean isDate(String javaType) {
		if(javaType.endsWith("Date") || javaType.endsWith("Timestamp") || javaType.endsWith("Time")) {
			return true;
		}
		return false;
	}
	
	public static boolean isString(String javaType) {
		if(javaType.endsWith("String")) {
			return true;
		}
		return false;
	}
	
	public static String getPreferredJavaType(int sqlType, int size,
			int decimalDigits) {
		if ((sqlType == Types.DECIMAL || sqlType == Types.NUMERIC)
				&& decimalDigits == 0) {
			if (size == 1) {
				// https://sourceforge.net/tracker/?func=detail&atid=415993&aid=662953&group_id=36044
				return "Boolean";
			} else if (size < 3) {
				return "Byte";
			} else if (size < 5) {
				return "Short";
			} else if (size < 10) {
				return "Integer";
			} else if (size < 19) {
				return "Long";
			} else {
				return "java.math.BigDecimal";
			}
		}
		String result = _preferredJavaTypeForSqlType.getString(sqlType);
		if (result == null) {
			result = "Object";
		}
		return result;
	}
		   
   static {
      _preferredJavaTypeForSqlType.put(Types.TINYINT, "Integer");
      _preferredJavaTypeForSqlType.put(Types.SMALLINT, "Short");
      _preferredJavaTypeForSqlType.put(Types.INTEGER, "Integer");
      _preferredJavaTypeForSqlType.put(Types.BIGINT, "Long");
      _preferredJavaTypeForSqlType.put(Types.REAL, "Float");
      _preferredJavaTypeForSqlType.put(Types.FLOAT, "Double");
      _preferredJavaTypeForSqlType.put(Types.DOUBLE, "Double");
      _preferredJavaTypeForSqlType.put(Types.DECIMAL, "java.math.BigDecimal");
      _preferredJavaTypeForSqlType.put(Types.NUMERIC, "java.math.BigDecimal");
      _preferredJavaTypeForSqlType.put(Types.BIT, "Integer");
      _preferredJavaTypeForSqlType.put(Types.BOOLEAN, "Boolean");
      _preferredJavaTypeForSqlType.put(Types.CHAR, "String");
      _preferredJavaTypeForSqlType.put(Types.VARCHAR, "String");
      // according to resultset.gif, we should use java.io.Reader, but String is more convenient for EJB
      _preferredJavaTypeForSqlType.put(Types.LONGVARCHAR, "String");
      _preferredJavaTypeForSqlType.put(Types.BINARY, "byte[]");
      _preferredJavaTypeForSqlType.put(Types.VARBINARY, "byte[]");
      _preferredJavaTypeForSqlType.put(Types.LONGVARBINARY, "byte[]");
      _preferredJavaTypeForSqlType.put(Types.DATE, "java.sql.Date");
      _preferredJavaTypeForSqlType.put(Types.TIME, "java.sql.Time");
      _preferredJavaTypeForSqlType.put(Types.TIMESTAMP, "java.sql.Timestamp");
      _preferredJavaTypeForSqlType.put(Types.CLOB, "java.sql.Clob");
      _preferredJavaTypeForSqlType.put(Types.BLOB, "java.sql.Blob");
      _preferredJavaTypeForSqlType.put(Types.ARRAY, "java.sql.Array");
      _preferredJavaTypeForSqlType.put(Types.REF, "java.sql.Ref");
      _preferredJavaTypeForSqlType.put(Types.STRUCT, "Object");
      _preferredJavaTypeForSqlType.put(Types.JAVA_OBJECT, "Object");
   }
		
   private static class IntStringMap extends HashMap {

		public String getString(int i) {
			return (String) get(new Integer(i));
		}

		public String[] getStrings(int i) {
			return (String[]) get(new Integer(i));
		}

		public void put(int i, String s) {
			put(new Integer(i), s);
		}

		public void put(int i, String[] sa) {
			put(new Integer(i), sa);
		}
	}
	   
}
