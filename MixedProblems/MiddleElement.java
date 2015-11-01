/*
 * Given an array of integers, find an element such that all elements to the left of it are 
 * smaller than it and and all elements right of it are greater.
 */
public class MiddleElement {
	public static void main(String[] args) {
		int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
		int ans = findMidElement(arr);
		System.out.print("The element is : " + ans);
	}
	
	public static int findMidElement(int[] arr) {
		int size = arr.length;
		int[] leftMax = new int[size]();
		int[] rightMin = new int[size];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		// populate leftMax
		for (int i = 0; i < size; i++) {
			leftMax[i] = Math.max(max, arr[i]);
			max = arr[i];
		}
		
		// populate rightMin
		for (int i = size-1; i >= 0; i--) {
			rightMin[i] = Math.min(min, arr[i]);
			min = arr[i];
		}
		
		for (int i = 0; i < size; i++) {
			if (arr[i] >= leftMax[i] && arr[i] <= rightMin[i]) {
				return arr[i];
			}
		}
		return 0;
	}

}
