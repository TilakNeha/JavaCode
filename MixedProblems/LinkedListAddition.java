/*
 * Given two numbers represented by two linked lists, write a function that returns sum list. 
 * The sum list is linked list representation of addition of two input numbers. 
 * It is not allowed to modify the lists. Also, not allowed to use explicit extra space
 */
import java.util.LinkedList;

public class LinkedListAddition {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();

		addToList(list1, 20356);
		addToList(list2, 44);

		LinkedList<Integer> sum = addNumber(list1, list2);

		for (int i : sum) {
			System.out.print(i + " ");
		}

		LinkedList<Integer> list3 = new LinkedList<Integer>();
		LinkedList<Integer> list4 = new LinkedList<Integer>();

		System.out.println("");
		list3.add(2);
		list3.add(0);
		list3.add(3);
		list3.add(5);
		list3.add(6);

		list4.add(4);
		list4.add(4);

		LinkedList<Integer> sum1 = addNumberReverse(list3, list4);

		for (int i : sum1) {
			System.out.print(i + " ");
		}
	}

	public static void addToList(LinkedList<Integer> list, int num) {

		while (num > 10) {
			int rem = num % 10;
			list.add(rem);
			num = num / 10;
		}
		list.add(num);
	}

	public static LinkedList<Integer> addNumber(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		LinkedList<Integer> ans = new LinkedList<Integer>();
		int carry = 0;
		for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
			int sum = list1.get(i) + list2.get(i) + carry;
			carry = sum / 10;
			sum = sum % 10;
			ans.add(sum);
		}
		LinkedList<Integer> longer = list1.size() > list2.size() ? list1 : list2;
		int min = Math.min(list1.size(), list2.size());

		ans.add(longer.get(min) + carry);
		for (int i = min + 1; i < longer.size(); i++) {
			ans.add(longer.get(i));

		}
		return ans;
	}

	public static void addToListReverse(LinkedList<Integer> list, int num) {
		LinkedList<Integer> ans = new LinkedList<Integer>();
	}

	public static LinkedList<Integer> addNumberReverse(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		LinkedList<Integer> ans = new LinkedList<Integer>();
		recursiveAdd(list1, list2, ans,0);
		return ans;
	}

	public static void recursiveAdd(LinkedList<Integer> list1, LinkedList<Integer> list2, LinkedList<Integer> sum,int carry) {
		int i = list1.isEmpty() ? 0:list1.getLast();
		int j = list2.isEmpty() ? 0:list2.getLast();
		int k = i + j + carry;
		int c = k / 10;
		k = k % 10;
		
		if (!list1.isEmpty()) list1.removeLast();
		if (!list2.isEmpty()) list2.removeLast();
		if (!list1.isEmpty() || !list2.isEmpty()) {
			recursiveAdd(list1, list2, sum,c);
		}
		sum.add(k);
	}
}
