
public class SelectionSort {
	public static int[] sort (int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int min = Integer.MAX_VALUE;
			int min_pos = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					min_pos = j;
				}
			}
			int temp = arr[i];
			arr[i] = min;
			arr[min_pos] = temp;
			
		}
		return arr;
	}
}
