package uvg.edu.common;

import java.util.Comparator;

public class StringComparator<K> implements Comparator<K> {

	@Override
	public int compare(K o1, K o2) {
		String w1 = o1.toString();
		String w2 = o2.toString();
		
		return w1.compareTo(w2);
	}

}
