package medium;

public class ShortestWordDistance {
	/**
	 * 245.
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
    public int shortestWordDistance(String[] words, String word1, String word2) {
		int index1 = -1; // position of word1 in words
		int index2 = -1; //position of word2 in words
		int min = Integer.MAX_VALUE;
		boolean same = word1.equals(word2);
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				if(same) {
					index1 = index2;
					index2 = i;
				} else {
					index1 = i;
				}
			}else if(words[i].equals(word2)) {
				index2 = i;
			}
			if(index1 != -1 && index2 != -1) {
				min = Integer.min(min, Math.abs(index1 - index2));
			}
		}
		return min;        
    }
}

/**
 * 244
 * @author miao
 *
 */
/**
public class WordDistance {

    private String[] wordlist;
    public WordDistance(String[] words) {
        wordlist = words;
    }

    public int shortest(String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i < wordlist.length; i++) {
            if(wordlist[index1].equals(word1)) {
                index1 = i;
            }
            if(wordlist[index2].equals(word2)) {
                index2 = i;
            }
            if(index1 != -1 && (index2 != -1)) {
                distance = Math.min(distance, Math.abs(index2 - index1));
            }
        }
        return distance;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");   
*/