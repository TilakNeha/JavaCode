
public class QuickSort {
	public static int[] value;
	public static int[] sort(int[] arr) {
		value = arr;
		partition(0,value.length-1);
		return value;
	}
	
	private static void partition(int low, int high) {
		int i = low, j = high;
		int pivot = low + ((high-low)/2);
		while (i <=j) {
			while (value[i] < value[pivot]) i++;
			while (value[j] > value[pivot]) j--;
			if (i <= j) {
				int temp = value[i];
				value[i] = value[j];
				value[j] = temp;
				i++;
				j--;
			}
			
		}
		
		if (j > low) {
			partition(low,j);
		}
		if (i < high) {
			partition(i,high);
		}
	}
}