package medium;
import java.util.*;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * @author miao
 *
 */
public class GeneralizedAbbreviation320 {

	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<String>();
		if(word == null)  return res;
		backTrack(res, word, 0, "", 0);
		
		return res;
	}
	
	/**
	 * 
	 * @param res 
	 * @param word
	 * @param pos
	 * @param curr
	 * @param count    number of abbreviate
	 */
	public void backTrack(List<String> res, String word, int pos, String curr, int count) {
		if(pos == word.length()) {
			if(count > 0) {
				curr += count;
			}
			res.add(curr);
		} else {
			backTrack(res, word, pos + 1, curr, count + 1);
			backTrack(res, word, pos + 1, curr + (count > 0 ? count : "") + word.charAt(pos), 0);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralizedAbbreviation320 genAbb = new GeneralizedAbbreviation320();
		List<String> result = genAbb.generateAbbreviations("word");
		for(String i : result) {
			System.out.print(i + ",");
		}
	}

}
