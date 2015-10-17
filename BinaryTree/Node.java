public class Node {
	public int data;
	public Node left, right;
	
	Node() {
		this(-1);
	}
	
	Node(int d) {
		left = null;
		right = null;
		data = d;
	}
}
