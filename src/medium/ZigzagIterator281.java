package medium;

import java.util.*;

public class ZigzagIterator281 {
	List<Iterator<Integer>> list;	
	public ZigzagIterator281(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator<Integer>>();
        if(v1 != null && !v1.isEmpty()) {
            list.add(v1.iterator());
        }
        if(v2 != null && !v2.isEmpty()) {
            list.add(v2.iterator());
        }
	}
	
	public int next() {
        Iterator<Integer> poll = list.remove(0);
        int result = poll.next();
        if(poll.hasNext()) {
            list.add(poll);
        }
        return result;
	}
	
	public boolean hasNext() {
		return !list.isEmpty();
	}
}
