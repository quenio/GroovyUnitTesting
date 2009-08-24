package mocking;

public class MyCaller {
	
	private MyClass obj;
	
	public MyCaller(MyClass obj) {
		this.obj = obj;
	}

    public int callOne() {
        return obj.one();
    }
    
    public int callOne(int arg) {
        return obj.one(arg);
    }
    
    public int callOne(int arg1, int arg2) {
        return obj.one(arg1, arg2);
    }
    
    public int callTwo() {
        return obj.two();
    }

}
