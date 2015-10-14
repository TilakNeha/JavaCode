/*
 * Given sequence A[1...n]
 * Find maximum length subsequence such that its strictly increasing
 * 
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int seq[] = {3,6,1,3,8,4,9,10,3,4,12};
		int len = maxLen(seq,seq.length-1);
		System.out.println("The length of maximum length subsequence is " + len);
		
		
	}

	/*
	 * len(j) = length of max-length increasing subsequence ending at j containing seq[j]
	 *        = max(i = 0 to j-1) len(j-i) + 1    if such a seq[j] exists
	 *          else 1
	 */
	private static int maxLen(int[] seq, int j) {
		int max = 0;
		if (j == 0) return 1;
		for (int i = 0; i <= j-1; i++) {
			int len = maxLen(seq,i);
			if (seq[i] < seq[j]) {
				len = len + 1;
			} else {
				len = 1;
			}
			if (max < len) max = len;
		}
		return max;
	}
}
