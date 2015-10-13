/*
 * Given prices of lengths of rods.
 * Maximize value of given length of rod.
 */
public class RodCutting {
	
	public static int count = 0; 

	public static void main(String[] args) {
		int prices[] = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		int n = 9;
		int results[] = new int[11];
		for (int i = 0; i <11; i++) results[i] = -1;
		System.out.println("Max price of " + n + " meters = " + maxPrice(n, prices, results));
		System.out.println("Count = " + count);
	}

	public static int maxPrice(int len, int[] prices, int[] results) {
		count ++;
		if (len == 0) {
			return 0;
		}
		int max = -1;
		for (int i = 1; i <= len; i++) {
			if (results[len-i] >= 0) {
				max = Math.max(max, prices[i] + results[len-i]);
			} else {
			max = Math.max(max,prices[i] + maxPrice(len-i,prices, results));
			}
		}
		results[len] = max;
		return max;		
	}

}
