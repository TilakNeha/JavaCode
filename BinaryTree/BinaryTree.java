import java.util.*;
import java.util.logging.Logger;

public class BinaryTree {

	public Node root;

	BinaryTree() {
		root = null;
	}

	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node n, int min, int max) {
		if (n == null) {
			return true;
		}
		if (n.data < min || n.data > max) {
			return false;
		}
		return isBST(n.left, min, n.data) && isBST(n.right, n.data, max);
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node n) {
		if (n != null) {
			System.out.println(n.data);
			preorder(n.left);
			preorder(n.right);
		}
	}

	public void IterPreorder() {
		Stack<Node> q = new Stack<Node>();

		q.push(root);

		while (!q.isEmpty()) {
			Node n = q.pop();
			System.out.println(n.data);
			if (n.right != null) {
				q.push(n.right);
			}
			if (n.left != null) {
				q.push(n.left);
			}
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node n) {
		if (n != null) {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.data + " ");
		}
	}

	public void IterPostOrder() {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		System.out.println("");
		if (root != null) {
			s1.push(root);
			while (!s1.isEmpty()) {
				Node n = s1.pop();
				s2.push(n);
				if (n.left != null)
					s1.push(n.left);
				if (n.right != null)
					s1.push(n.right);
			}
			while (!s2.isEmpty()) {
				Node n = s2.pop();
				System.out.print(n.data + " ");
			}
		}
	}

	public void inorder() {
		System.out.println("");
		inorder(root);
	}

	private void inorder(Node n) {
		if (n == null) {
			return;
		}
		inorder(n.left);
		System.out.print(n.data + " ");
		inorder(n.right);
	}

	public void IterInorder() {
		System.out.println("");
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		Node n = s.peek().left;
		while (!s.isEmpty()) {
			while (n != null) {
				s.push(n);
				n = n.left;
			}
			n = s.pop();
			System.out.print(n.data + " ");
			n = n.right;
			if (n != null) {
				s.push(n);
				n = n.left;
			}
		}
	}

	public int heightOf() {
		return heightOf(root);
	}

	private int heightOf(Node n) {
		if (n == null) {
			return 0;
		}
		return Math.max(heightOf(n.left), heightOf(n.right)) + 1;
	}

	/*
	 * Difference in depth of any two leaves can be more than 1.
	 * 
	 */
	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node n) {
		if (checkHeight(n) == -1)
			return false;
		return true;
	}

	private int checkHeight(Node n) {
		if (n == null) {
			return 0;
		}
		int leftheight = checkHeight(n.left);
		if (leftheight == -1) {
			return -1;
		}

		int rightheight = checkHeight(n.right);
		if (rightheight == -1) {
			return -1;
		}

		if (Math.abs(leftheight - rightheight) > 1) {
			return -1;
		}
		return Math.max(leftheight, rightheight) + 1;
	}

	/*
	 * Returns depth of shallow-most leaf.
	 */
	public int minDepth() {
		return minDepth(root);
	}

	private int minDepth(Node n) {
		if (n == null)
			return 0;
		if (n.right == null && n.left == null)
			return 1;
		if (n.left == null)
			return minDepth(n.right) + 1;
		if (n.right == null)
			return minDepth(n.left) + 1;

		return Math.min(minDepth(n.left), minDepth(n.right)) + 1;
	}

	/*
	 * Returns the minimum value element in the tree.
	 * 
	 */
	public int minElement() {
		return minElement(root);
	}

	private int minElement(Node n) {
		if (n == null)
			return Integer.MAX_VALUE;
		if (n.left == null && n.right == null)
			return n.data;
		if (n.left == null)
			return Math.min(minElement(n.right), n.data);
		if (n.right == null)
			return Math.min(minElement(n.left), n.data);
		int leftmin = minElement(n.left);
		int rightmin = minElement(n.right);
		if (n.data < leftmin && n.data < rightmin)
			return n.data;
		return Math.min(leftmin, rightmin);
	}

	public boolean isMirror(Node root2) {
		return isMirror(root, root2);
	}

	/*
	 * Returns true if one tree is mirror image of the other.
	 * 
	 */
	private boolean isMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null && root2 != null) {
			return false;
		}
		if (root2 == null && root1 != null) {
			return false;
		}
		if (root1.data != root2.data) {
			return false;
		}
		return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
	}

	public boolean isSymmetric() {
		return isMirror(root, root);
	}

	/*
	 * Print all nodes of a binary tree in a level.
	 */
	public void levelWisePrint() {
		int[] count = new int[10];
		Arrays.fill(count, 0);

		Queue<Node> s = new LinkedList<Node>();

		int level = 0;

		if (root != null) {
			count[0] = 1;
			s.add(root);
		} else {
			return;
		}

		Node current = root;
		int count2 = 0;
		while (!s.isEmpty()) {
			current = s.remove();
			System.out.print(current.data + " ");
			count2++;

			if (current.left != null) {
				s.add(current.left);
				count[level + 1]++;
			}

			if (current.right != null) {
				s.add(current.right);
				count[level + 1]++;
			}

			if (count2 == count[level]) {
				level++;
				count2 = 0;
				System.out.println("");
			}
		}
	}
}
