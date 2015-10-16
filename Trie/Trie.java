
public class Trie {
	public Node root;
	
	public Trie() {
		root = new Node(26);
	}
	
	public void insertString(String s) {
		Node current = root;
		for (int i = 0; i< s.length(); i++) {
			char c = s.charAt(i);
			int j = c-'a';
			if (current.characters[j] == null) {
				System.out.println("Inserting new node for " + c);
				current.characters[j] = new Node(26);
			}
			current = current.characters[j];
		}
	}
	
	public boolean isPresent(String s) {
		Node current = root;
		for (int i =0 ; i < s.length(); i++) {
			char c = s.charAt(i);
			int j = c-'a';
			Node next = current.characters[j];
			if (next == null) return false;
			current = next;
		}
		return true;
	}
}
