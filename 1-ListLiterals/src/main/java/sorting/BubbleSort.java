package sorting;

public class BubbleSort {

	public static int[] sort(int[] x) {
	    int n = x.length;
	    for (int pass=1; pass < n; pass++) {
	        for (int i=0; i < n-pass; i++) {
	            if (x[i] > x[i+1]) {
	                int temp = x[i];  x[i] = x[i+1];  x[i+1] = temp;
	            }
	        }
	    }
	    return x;
	}
	
}
