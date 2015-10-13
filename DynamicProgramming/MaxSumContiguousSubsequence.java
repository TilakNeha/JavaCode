/*
 * Given sequence of real numbers : A[1...n]
 * Find index i to j such that sum of elements from A[i] to A[j] is maximized.
 * Recurrence relation:
 * M(i,j) = maximum sum from i to j
 *        = max(M(i,j-1) + A[j], A[j])
 * Solution : M(0,n) 
 */
public class MaxSumContiguousSubsequence {

	public static void main(String[] args) {
		int[] seq = {2,3,4,5,-10,8,8,5,-9,2,7};
		int sum = maxSum(seq,0,seq.length-1);
		System.out.println("Maximum sum = " + sum);
	}

	private static int maxSum(int[] seq, int i, int j) {
		int maxVal = seq[i];
		int interMax = maxVal;
		for (int k = i+1; k <= j ; k++ ) {
			interMax = Math.max(interMax + seq[k], seq[k]);
			if (interMax > maxVal) maxVal = interMax;
		}
		return maxVal;
	}
}
