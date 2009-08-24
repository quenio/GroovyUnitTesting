package mocking;

import groovy.mock.interceptor.MockFor

public class MyCallerTests extends GroovyTestCase {
	
	public void testMyCaller() {
		
		def mock = new MockFor(MyInterface)   

		mock.demand.one(2..2) { 1 }                 
		mock.demand.one() { arg -> arg + 1 }                 
		mock.demand.one() { arg1, arg2 -> arg1 + arg2 }                 
		mock.demand.two(0..2) { 2 }                 

		def proxy = mock.proxyDelegateInstance()
		def caller = new MyCaller(proxy) 
		
	    assert caller.callOne() == 1   
	    assert caller.callOne() == 1   
	    assert caller.callOne(10) == 11   
	    assert caller.callOne(100,10) == 110   
	    //assert caller.callTwo() == 2
	    //assert caller.callTwo() == 2
	    //assert caller.callTwo() == 2
	    
	    mock.verify(proxy)
	}
	
}