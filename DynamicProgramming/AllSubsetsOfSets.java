import java.util.HashSet;
/* Create a set of all subsets of a set of integers.*/
public class AllSubsetsOfSets {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		for (HashSet<Integer> h : getSubSets(arr,arr.length-1)) {
			System.out.println("");
			for (int i : h) {
				System.out.print(" " + i );
			}
		}
	}
	
	public static HashSet<HashSet<Integer>> getSubSets(int[] arr, int index) {
		if (index == 0) {// Base-case
			HashSet<Integer> hset = new HashSet<Integer>();
			HashSet<HashSet<Integer>> subsets = new HashSet<HashSet<Integer>>();
			hset.add(arr[index]);
			subsets.add(hset);
			return subsets;
		}
		
		HashSet<HashSet<Integer>> subset = getSubSets(arr,index-1);
		HashSet<HashSet<Integer>> newset = new HashSet<HashSet<Integer>>(subset); 
		HashSet<Integer> hset = new HashSet<Integer>();
		hset.add(arr[index]);
		newset.add(hset);
		for (HashSet<Integer> h : subset) {
			HashSet<Integer> tset = new HashSet<Integer>();
			tset.add(arr[index]);
			for (int i : h) {
				tset.add(i);
				newset.add(tset);
			}
		}
		return newset;
	}
}
