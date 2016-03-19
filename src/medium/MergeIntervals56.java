package medium;
import java.util.*;

public class MergeIntervals56 {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		
		if(intervals == null || intervals.size() == 0) {
			return res;
		}
		intervals.sort(new Comparator<Interval>() {
		    @Override
			public int compare(Interval v1, Interval v2) {
				return v1.start - v2.start;
			}
		});
		
		int len = intervals.size();
		Interval tmp = intervals.get(0); 
		for(int i = 1; i < len; i++) {
		    Interval curr = intervals.get(i);
			if(curr.start > tmp.end) {
				res.add(tmp);
				tmp = curr;
			} else {
				tmp.end = curr.end;
			}
		}
		res.add(tmp);
		return res; 
	}
	
	public static void main(String[] args) {
		MergeIntervals56 mi = new MergeIntervals56();
		Interval v1 = new Interval(0, 15);
		Interval v2 = new Interval(10, 30);
		Interval v3 = new Interval(30, 45);
		Interval v4 = new Interval(30, 50);
		
		List<Interval> interval = new ArrayList<Interval>();
		interval.add(v1);
		interval.add(v2);
		interval.add(v3);
		interval.add(v4);
		List<Interval> res = mi.merge(interval);
		for(Interval i : res) {
			System.out.println(i.start + "," + i.end);
		}
	}
}

/**
 * This class is already defined at MeetingRoomII253.java
 * @author miao
 *
 */
/*
class Interval {
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public Interval() {
		this.start = 0;
		this.end = 0;
	}
}
*/