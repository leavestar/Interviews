package CH7;
/****************** Exercise 1 ****************
 * Create a Cycle class, with subclasses
 * Unicycle, Bicycle, and Tricycle. Demonstrate
 * that an instance of each type can be upcast
 * to Cycle via a ride() method.
 ***********************************************/
class Cycle{}
class Unicycle extends Cycle{}
class Bicycle extends Cycle{}
class Tricycle extends Cycle{}


public class E01_Upcasting{
	public static void ride(Cycle c){}
	public static void main(String[] args){
		ride(new Cycle());    // No upcasting
        ride(new Unicycle()); // Upcast
        ride(new Bicycle());  // Upcast
        ride(new Tricycle()); // Upcast
	}
}