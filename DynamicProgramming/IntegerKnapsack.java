import java.util.Arrays;

/*
 * Given items 1 to n
 * Given sizes s1 to sn
 * Given values v1 to vn
 * Given capacity C
 * Find maximum value of knapsack.
 */
public class IntegerKnapsack {
	
	public static int[] subSol;

	public static void main(String[] args) {
		
		int[] values = {3,5,2,2,6,7};
		int[] sizes  = {2,6,1,8,5,3};
		int capacity = 25;
		subSol = new int[capacity];
		Arrays.fill(subSol, -1);
		int value = maxValue(values,sizes,capacity);
		System.out.println("The maximum value of given knapsack is :" + value);
	}

	private static int maxValue(int[] values, int[] sizes, int capacity) {
		if (capacity <= 0) return 0;
		int max_val = Integer.MIN_VALUE;
		for (int i = 0; i < values.length;i++) {
			int val;
			if (sizes[i] <= capacity) {
				if (sizes[i] == capacity) {
					val = values[i];
				} else if (subSol[capacity -sizes[i]-1] > -1) {
					val = values[i] + subSol[capacity -sizes[i]-1];
				} else {
					val = values[i] + maxValue(values, sizes, capacity - sizes[i]);
				}
				if (val > max_val) {
					max_val = val;
				}
			}
		}
		int subsol = Math.max(maxValue(values,sizes,capacity-1),max_val);
		subSol[capacity-1] = subsol;
		return subsol;
	}
}
