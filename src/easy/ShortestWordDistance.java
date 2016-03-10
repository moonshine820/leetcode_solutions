package easy;
/*
 * 243. Shortest Word Distance
 */
public class ShortestWordDistance {

	public int shortestDistance(String[] words, String word1, String word2) {
		int index1 = -1; // position of word1 in words
		int index2 = -1; //position of word2 in words
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				index1 = i;
			}
			if(words[i].equals(word2)) {
				index2 = i;
			}
			if(index1 != -1 && index2 != -1) {
				min = Integer.min(min, Math.abs(index1 - index2));
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
