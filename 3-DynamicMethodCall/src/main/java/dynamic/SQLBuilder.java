package dynamic;

public class SQLBuilder {

	public static String select(String tableName, String... fields) {
		return "SELECT " + list(fields, ", ", false) + " FROM " + tableName;
	}
	
	public static String insert(String tableName, String... values) {
		return "INSERT INTO " + tableName + " VALUES (" + list(values, ", ", true) + ")";
	}
	
	public static String delete(String tableName, String... conditions) {
		return "DELETE FROM " + tableName + " WHERE " + list(conditions, " AND ", false);
	}
	
	private static String list(String[] fields, String separator, boolean quote) {
		StringBuffer list = new StringBuffer();
		for (String field: fields) {
			if (quote) list.append('\'');
			list.append(field);
			if (quote) list.append('\'');
			list.append(separator);
		}
		return list.substring(0, list.length() - separator.length());
	}

}
