package dynamic;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class SQLBuilderJavaTests extends TestCase {

	private static final String TABLE_NAME = "Customers";
	
	private static final String METHOD_SELECT = "select";
	private static final String METHOD_INSERT = "insert";
	private static final String METHOD_DELETE = "delete";
	
	private static String KEY_LIST = "list";
	private static String KEY_STATEMENT = "statement";
		
	private Map<String, Map<String, Object>> getCases() {

		Map<String, Map<String, Object>> cases = new HashMap<String, Map<String, Object>>();
		
		Map<String, Object> selectMap = new HashMap<String, Object>();
		selectMap.put(KEY_LIST, new String[] {"Name", "Address", "Phone"});
		selectMap.put(KEY_STATEMENT, "SELECT Name, Address, Phone FROM Customers");
		cases.put(METHOD_SELECT, selectMap);
		
		Map<String, Object> insertMap = new HashMap<String, Object>();
		insertMap.put(KEY_LIST, new String[] {"Barrack Obama", "White House", "800-GO-DADDY"});
		insertMap.put(KEY_STATEMENT, "INSERT INTO Customers VALUES ('Barrack Obama', 'White House', '800-GO-DADDY')");
		cases.put(METHOD_INSERT, insertMap);
		
		Map<String, Object> deleteMap = new HashMap<String, Object>();
		deleteMap.put(KEY_LIST, new String[] {"Address = 'White House'", "Phone = '800-GO-DADDY'"});
		deleteMap.put(KEY_STATEMENT, "DELETE Customers WHERE Address = 'White House' AND Phone = '800-GO-DADDY'");
		cases.put(METHOD_DELETE, deleteMap);

		return cases;
	}
		
	public void testSQLBuilder() {
		
		Map<String, Map<String, Object>> cases = getCases();
		
		for (String methodName: cases.keySet()) {
			try {
				Method method = SQLBuilder.class.getMethod(methodName, String.class, String[].class);
				Map<String, Object> methodMap = cases.get(methodName);
				
				Object result = method.invoke(SQLBuilder.class, new Object[] {TABLE_NAME, methodMap.get(KEY_LIST)});
				
				assertEquals(methodMap.get(KEY_STATEMENT), result);
				
			} catch (Throwable exception) {
				fail(exception.getMessage());
			}
		}
	}

}
