package mocking;

public class MyCallerClassMockingTests extends GroovyTestCase {

	public void testMyCaller() {

		def mock = [
		   one: { int[] args -> args.length == 0? 1: (args.length == 1? args[0] + 1: args[0] + args[1]) }
		];
		
		def caller = new MyCaller(mock as MyClass) 
		
	    assert caller.callOne() == 1   
	    assert caller.callOne() == 1   
	    assert caller.callOne(10) == 11   
	    assert caller.callOne(100,10) == 110   
	    //assert caller.callTwo() == 2
	    //assert caller.callTwo() == 2
	    //assert caller.callTwo() == 2
	}
	
}