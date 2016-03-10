package medium;

public class PaintHouse256 {
	
	public int paintHouse(int[][] costs) {
		if(costs == null || costs.length == 0) {
			return 0;
		}
		int lastR = costs[0][0];
		int lastG = costs[0][1];
		int lastB = costs[0][2];
		
		for(int i = 1; i < costs.length; i++) {
			int currR = Math.min(lastG, lastB) + costs[i][0];
			int currG = Math.min(lastR, lastB) + costs[i][1];
			int currB = Math.min(lastR, lastG) + costs[i][2];
			lastR = currR;
			lastG = currG;
			lastB = currB;
		}
		return Math.min(Math.min(lastR, lastG), lastB);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintHouse256 pt = new PaintHouse256();
		int[][] costs = {{2,3,5},{4,3,6},{5,6,3}, {3,4,1},{5,3,2},{4,1,6}};
		System.out.println(pt.paintHouse(costs));
	}

}
