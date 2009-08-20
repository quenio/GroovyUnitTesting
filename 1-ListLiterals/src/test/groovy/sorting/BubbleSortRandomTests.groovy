package sorting;

public class BubbleSortRandomTests extends GroovyTestCase {

    private def length = 100

    private int[] randomArray() {
        def random = new Random()
		(0..<length).collect {
			random.nextInt(length+1)
		}
	}

	public void testRandomArray() {
		def array = randomArray()
		def sortedArray = BubbleSort.sort(array)
		
		int i = 0
		(sortedArray.length - 1).times {
			assert sortedArray[i] < sortedArray[++i]
		}

		/*
		def newArray = sortedArray + length+1 
		sortedArray.eachWithIndex { n, i -> println(i); assert n <= newArray[i+1] }
		*/
	}
	
}