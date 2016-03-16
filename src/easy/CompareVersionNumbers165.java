package easy;
/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * @author miao
 * @date  03/15/2016
 */
public class CompareVersionNumbers165 {
	public int compareVersion(String version1, String version2) {
		String[] v1Arr = version1.split("\\.");
		String[] v2Arr = version2.split("\\.");
		int len = Math.max(v1Arr.length, v2Arr.length);
		for(int i = 0; i < len; i++) {
			int tmp1 = i >= v1Arr.length ? 0 : Integer.parseInt(v1Arr[i]);
			int tmp2 = i >= v2Arr.length ? 0 : Integer.parseInt(v2Arr[i]);
			if(tmp1 > tmp2) {
				return 1;
			} else if(tmp1 < tmp2) {
				return -1;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareVersionNumbers165 cvn = new CompareVersionNumbers165();
		System.out.println(cvn.compareVersion("1.3.5", "1.3"));
	}

}
