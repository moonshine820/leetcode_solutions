package easy;

import java.util.Iterator;
import java.util.List;
/*
 * 0310
 */
public class Flatten2DVector251 {
	private Iterator<List<Integer>> iList;
	private Iterator<Integer> iInt;
	public void Vector2D(List<List<Integer>> vec2d) {
		iList = vec2d.iterator();
		iInt = iList.hasNext() ? iList.next().iterator() : null;
	}
	
	public int next() {
		hasNext();
		return iInt.next();
	}
	
	public boolean hasNext() {
		if(iInt == null) {
			return false;
		} else if(iInt.hasNext()) {
			return true;
		} else {
			while(iList.hasNext()) {
				iInt = iList.next().iterator();
				if(iInt.hasNext()) {
					return true;
				}
			}
			return false;
		}
	}
}
