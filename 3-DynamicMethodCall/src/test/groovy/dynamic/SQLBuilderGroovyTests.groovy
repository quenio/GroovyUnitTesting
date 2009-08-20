package dynamic;

import groovy.util.GroovyTestCase;

public class SQLBuilderGroovyTests extends GroovyTestCase {

	def tableName = "Customers"
	
	def cases = [
	    select: [
	        list: ["Name", "Address", "Phone"],
	        statement: "SELECT Name, Address, Phone FROM Customers"
	    ],
	    insert: [
	        list: ["Barrack Obama", "White House", "800-GO-DADDY"],
	        statement: "INSERT INTO Customers VALUES ('Barrack Obama', 'White House', '800-GO-DADDY')"
	    ],
	    delete: [
	        list: ["Address = 'White House'", "Phone = '800-GO-DADDY'"],
	        statement: "DELETE Customers WHERE Address = 'White House' AND Phone = '800-GO-DADDY'"
	    ]
	]
	
	public void testSQLBuilder() {
		cases.each { assert SQLBuilder."$it.key"(tableName, it.value.list as String[]) == it.value.statement }
	}
	
}