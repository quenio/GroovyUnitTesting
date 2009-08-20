package sorting;

public class BubbleSortGroovyTests extends GroovyTestCase {

	private def sort(list) {
		BubbleSort.sort(list as int[])
	}
	
	public void testUnsortedArray() {
		assert sort([4, 2, 1, 3]) == [1, 2, 3, 4];
	}
	
	public void testOrderedArray() {
		assert sort([1, 2, 3, 4]) == [1, 2, 3, 4];
	}

	public void testDescendingArray() {
		assert sort([4, 3, 2, 1]) == [1, 2, 3, 4];
	}

}