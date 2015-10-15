
/*
 * Given two strings
 * Find longest common sub-sequence.
 */

import java.util.ArrayList;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		ArrayList<Character> al = new ArrayList<Character>();

		// Common : aahdjtejjslk

		String s1 = "abahdjtejjslqofk";

		String s2 = "aachggdjhtehjjiswlk";

		int common = LCS(s1, s2, al);

		System.out.print("LCS = " + common);

		System.out.println("al = " + al.toString());

	}

	private static int LCS(String s1, String s2, ArrayList<Character> al) {

		// Base Case

		if (s1.length() == 0 || s2.length() == 0) {

			return 0;

		}

		// if char is same, then it is present in the LCS.

		if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {

			al.add(s1.charAt(s1.length() - 1));

			return LCS(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1), al) + 1;

		}

		// if char are not same then the LCS is the max of two cases.

		int a, b;

		a = LCS(s1.substring(0, s1.length() - 1), s2, al);

		b = LCS(s2.substring(0, s2.length() - 1), s1, al);

		return Math.max(a, b);

	}

}