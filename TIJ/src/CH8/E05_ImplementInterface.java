package CH8;
/****************** Exercise 5 ******************
 * Create an interface with three methods in its
 * own package. Implement the interface in a
 * different package.
 ***********************************************/
interface AnInterface{
	void f();
	void g();
	void h();
}

class ImplementInterface implements AnInterface{
	public void f(){// must be public
		System.out.println("ImplementInterface.f");
	}
	public void g(){
		System.out.println("ImplementInterface.g"); 
	}
	public void h() {
		System.out.println("ImplementInterface.h");
	}
}

public class E05_ImplementInterface {
    public static void main(String args[]) {
      ImplementInterface imp = new ImplementInterface();
      imp.f();
      imp.g();
      imp.h();
}
}
