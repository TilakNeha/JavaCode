public class DutchNationalFlag {
	public static void main(String[] args) {
		int arr[] = {1,0,2,2,0,1,1,0,2,1,0};
		String str = "wE aRE GoinG";
		ThreeWayPartition(arr);
		SortString(str);
	}
	
	public static void ThreeWayPartition(int a[]) {
		System.out.print("Old Array: ");
		for(int i:a) {
			System.out.print(i + " ");
		}
		System.out.println("");
		
		int low = 0;
		int high = a.length -1;
		int mid = 0;
		
		while (mid <= high)  {
			switch(a[mid]) {
			case 0 : a[mid] = a[low];
					 a[low] = 0;
					 low++;
					 mid++;
					 break;
			case 1 : mid++;
					 break;
			case 2 : a[mid] = a[high];
			         a[high] = 2;
			         high--;
			         break;
			}			
		}
		System.out.print("New Array: ");
		for(int i:a) {
			System.out.print(i + " ");
		}
	}
	
	public static void SortString(String s) {
		System.out.println("Old String = " + s);
		int low = 0;
		int high = s.length() -1;
		int mid = 0;
		
		char[] cstr = s.toCharArray();
		while (mid <= high) {
			if (cstr[mid] <= 'z' && cstr[mid] >= 'a') {
				char temp = cstr[low];
				cstr[low] = cstr[mid];
				cstr[mid] = temp;
				mid++;
				low++;
			} else if (cstr[mid] == ' ') {
				mid++;
			} else if (cstr[mid] <= 'Z' && cstr[mid] >= 'A'){
				char temp = cstr[high];
				cstr[high] = cstr[mid];
				cstr[mid] = temp;
				high--;
			}
		}
		s = new String(cstr);
		System.out.println("New String = " + s);
	}
}
