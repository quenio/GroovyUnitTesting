package sorting;

import java.util.Random;

import junit.framework.TestCase;

public class BubbleSortJavaRandomTests extends TestCase {

	private int[] randomArray() {
		int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(array.length+1);
		}
        return array;
	}

	public void testRandomArray() {
		int[] array = randomArray();
		int[] sortedArray = BubbleSort.sort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
			assertTrue(sortedArray[i] < sortedArray[i+1]);
		}
	}

}
