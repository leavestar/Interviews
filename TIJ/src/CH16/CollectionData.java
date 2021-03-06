package CH16;

import java.util.*;
import CH15.*;
import CH14.*;

interface Generator<T> {
	T next();
}

public class CollectionData<T> extends ArrayList<T> {
	public CollectionData(Generator<T> gen, int quantity) {
		for(int i=0; i<quantity;i++)
			add(gen.next());
	}

	public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
		return new CollectionData<T>(gen, quantity);
	}
}
