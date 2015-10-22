/*
 * surpasser[i] in array is number of elements to right of i that are greater than a[i]
 * For given array find maximum surpasser.
 */
public class MaxSurpasser {
	public static void main(String[] args) {
		int[] arr = {2,7,5,5,2,7,0,8,1};
		
		int min = 0;
		int surpasser = 0;
		
		for (int i = 1; i< arr.length; i++ ) {
			if (arr[i] > arr[min]) surpasser ++;
		}
		
		int i = min+1;
		while (i < arr.length) {
			while (arr[i] >= arr[min] && i <arr.length) {
				i++;
			}
			if (i < arr.length-1) {
			int temp_surpasser = 0;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] > arr[i]) temp_surpasser++;
			}
			if (temp_surpasser > surpasser) {
				min = i;
				surpasser = temp_surpasser;
			}
			}
			i++;
		}
		
		System.out.println("Maximum surpasser = " + surpasser);
		System.out.println("For index = " + min);
		
	}
}
