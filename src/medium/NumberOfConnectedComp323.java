package medium;

import java.util.HashSet;

public class NumberOfConnectedComp323 {

	private int[] father;
    public int countComponents(int n, int[][] edges) {
        father = new int[n];
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < n; i++) {
            father[i] = i;
        }
        for(int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }
        
        for(int i = 0; i < n; i++) {
            set.add(find(i));
        }
        return set.size();
    }
    
    public int find(int node) {
        if(father[node] == node) {
            return node;
        }
        father[node] = find(father[node]);
        return father[node];
    }
    public void union(int node1, int node2) {
        father[find(node1)] = find(node2);
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfConnectedComp323 noc = new NumberOfConnectedComp323();
		int n = 5;
		int[][] edges = {{0,1},{1,2},{3,4}};
		System.out.println(noc.countComponents(n, edges));
	}

}
