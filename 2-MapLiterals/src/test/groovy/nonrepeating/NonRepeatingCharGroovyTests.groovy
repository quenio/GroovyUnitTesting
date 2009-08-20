package nonrepeating;

public class NonRepeatingCharGroovyTests extends GroovyTestCase {

	def cases = [
	    "": '\0',
	    "a": 'a',
	    "ab": 'a',
	    "aabb": '\0',
	    "abbb": 'a',
	    "aaab": 'b',
	    "aacbb": 'c',
	    "cabba": 'c', 
	    "abbac": 'c',
	    "abcde": 'a'
	];
	
	public void testFindingNonRepeatingChar() {
		cases.each { assert NonRepeatingChar.find(it.key) == it.value }
	}
	
}