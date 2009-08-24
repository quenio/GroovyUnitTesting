package nonrepeating;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class NonRepeatingJavaTests extends TestCase {

 	public void testFindingNonRepeatingChar() {
 		Map<String, Character> cases = new HashMap<String, Character>();
 		cases.put("", '\0');
 		cases.put("a", 'a');
 		cases.put("ab", 'a');
 		cases.put("aabb", '\0');
 		cases.put("abbb", 'a');
 		cases.put("aaab", 'b');
 		cases.put("aacbb", 'c');
 		cases.put("cabba", 'c');
 		cases.put("abbac", 'c');
 		cases.put("abcde", 'a');
 		//cases.put("abcde", 'b');
	     	
 		for (String str: cases.keySet()) { 
 			assertEquals(cases.get(str).charValue(), NonRepeatingChar.find(str)); 
 		}
 	}

}
