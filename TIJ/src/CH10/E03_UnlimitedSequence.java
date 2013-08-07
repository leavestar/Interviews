package CH10;
/****************** Exercise 3 ******************
 * Modify innerclasses/Sequence.java so you
 * can add any number of elements to it.
 ***********************************************/
import java.util.*;

interface Selector{
	boolean end();
	Object current();
	void next();
}

class UnlimitedSequence{
	private final List<Object> items= new ArrayList<Object>();
	public void add(Object x){
		items.add(x);
	}
	private class SequenceSelector implements Selector{
		private int i;
		public boolean end(){ return i == items.size();}
		public Object current() { return items.get(i);}
		public void next(){ if(i<items.size()) i++; }
	}
	public Selector selector(){
		return new SequenceSelector();
	}
}

public class E03_UnlimitedSequence{
	public static void main(String[] args){
		UnlimitedSequence sequence = new UnlimitedSequence();
		for(int i =0; i<10; i++)
			sequence.add(Integer.toString(i));
		Selector selector= sequence.selector();
		while(!selector.end()){
			System.out.println(selector.current()+" ");
			selector.next();
		}
	}
}


