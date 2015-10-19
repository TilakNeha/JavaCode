
public class Driver {
	public static void main(String[] args) {
		int[] arr = {33,77,11,32,89,56,90,12};
		int[] arr2 = {33,77,11,32,89,56,90,12};
		int[] arr3 = {33,77,11,32,89,56,90,12};
		int[] arr4 = {33,77,11,32,89,56,90,12};
		int[] arr5 = {33,77,11,32,89,56,90,12};
		
		for (int i : BubbleSort.sort(arr)) {
		System.out.print(i + " ");
		}
		
		System.out.println("");
		for (int i : InsertionSort.sort(arr2)) {
			System.out.print(i + " ");
		}
		
		System.out.println("");
		for (int i : SelectionSort.sort(arr3)) {
			System.out.print(i + " ");
		}
		
		System.out.println("");
		for (int i : QuickSort.sort(arr4)) {
			System.out.print(i + " ");
		}
		
	}
}
