package medium;
import java.lang.reflect.Array;
import java.util.*;
/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 * 
 * Solution1:Sort the meeting according the start time, then iterator all the meetings, flag the start and end. 
 * If encounter start, then number of room add 1, otherwise room minus 1. Remember to record the max room number.
 * At last, return the max room number.  
 * 
 * Solution2: store start and end time to two separate arrays, then sort. Iterator start array, if start time less than end time,
 * then rooms++; otherwise, position of end time move on.  
 * @author miao
 *
 */
public class MeetingRoomII253 {
	
	public static void main(String[] args) {
		MeetingRoomII253 mr = new MeetingRoomII253();
		
		Interval v1 = new Interval(0, 15);
		Interval v2 = new Interval(10, 30);
		Interval v3 = new Interval(30, 45);
		Interval v4 = new Interval(30, 50);
		
		Interval[] interval = {v1, v2,v3,v4};
		System.out.println(mr.minMeetingRoom(interval));
	}
	
	public int minMeetingRoom(Interval[] interval) {
		int rooms = 0;
		int[] starts = new int[interval.length];
		int[] ends = new int[interval.length];
		
		for(int i = 0; i < interval.length; i++) {
			starts[i] = interval[i].start;
			ends[i] = interval[i].end;
		}
		
		Arrays.sort(starts);
		Arrays.sort(ends);
		int endPos = 0; //record the cursor of end time
		for(int i = 0; i < starts.length; i++) {
			if(starts[i] < ends[endPos]) {
				rooms++;
			} else {
				endPos++;
			}
		}
		
		return rooms;
	}
}

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