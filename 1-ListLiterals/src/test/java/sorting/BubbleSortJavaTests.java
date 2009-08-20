package sorting;
import sorting.BubbleSort;
import junit.framework.TestCase;

public class BubbleSortJavaTests extends TestCase {
	
	private void assertEquals(int[] expected, int[] actual) {
		super.assertEquals(expected, actual);
		/*assertEquals(expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}*/
	}

	public void testUnsortedArray() {
		assertEquals(new int[] {1, 2, 3, 4}, BubbleSort.sort(new int[] {4, 2, 1, 3}));
	}
	
	public void testOrderedArray() {
		assertEquals(new int[] {1, 2, 3, 4}, BubbleSort.sort(new int[] {1, 2, 3, 4}));
	}

	public void testDescendingArray() {
		assertEquals(new int[] {1, 2, 3, 4}, BubbleSort.sort(new int[] {4, 3, 2, 1}));
	}

}
