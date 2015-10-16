
public class Driver {
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insertString("hello");
		t.insertString("hellish");
		boolean present = t.isPresent("hello");
		if (present) {
			System.out.println("String present");
		} else {
			System.out.println("String not present");
		}
		present = t.isPresent("hellish");
		if (present) {
			System.out.println("String present");
		} else {
			System.out.println("String not present");
		}
		present = t.isPresent("world");
		if (present) {
			System.out.println("String present");
		} else {
			System.out.println("String not present");
		}
	}
}
