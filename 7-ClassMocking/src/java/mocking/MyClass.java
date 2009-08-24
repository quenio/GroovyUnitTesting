package mocking;

public class MyClass {

	public int one() { throw new IllegalStateException("This method should have been mocked."); }
	public int one(int arg1) { throw new IllegalStateException("This method should have been mocked."); }
	public int one(int arg1, int arg2) { throw new IllegalStateException("This method should have been mocked."); }
	public int two() { throw new IllegalStateException("This method should have been mocked."); }

}