
public class Driver {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(5);
		bt.root.left = new Node(3);
		bt.root.left.left = new Node(2);
		bt.root.left.right = new Node(1);
		bt.root.right = new Node(9);
		bt.root.right.left = new Node(7);
		bt.root.right.right = new Node(12);
		bt.root.right.right.left = new Node(10);
		bt.root.right.right.left.right = new Node(11);

		bt.preorder();
		bt.IterPreorder();

		if (bt.isBST()) {
			System.out.println("Tree is binary search tree.");
		} else {
			System.out.println("Tree is not binary search tree.");
		}

		bt.postOrder();
		bt.IterPostOrder();

		bt.inorder();
		bt.IterInorder();

		System.out.println("Height = " + bt.heightOf());

		System.out.println("MinDepth = " + bt.minDepth());

		System.out.println("Mininum Element = " + bt.minElement());

		BinaryTree bt2 = new BinaryTree();
		bt2.root = new Node(0);
		bt2.root.left = new Node(1);
		bt2.root.right = new Node(1);
		bt2.root.left.right = new Node(3);
		bt2.root.left.left = new Node(4);
		bt2.root.right.left = new Node(3);
		//bt2.root.right.left.right = new Node(5);
		boolean symmetric = bt2.isSymmetric();
		if (symmetric) {
			System.out.println("The tree is symmetric.");
		} else {
			System.out.println("The tree is asymmetric.");
		}
		
		if (bt2.isBalanced()) {
			System.out.println("The tree is balanced.");
		} else {
			System.out.println("The tree is not balanced.");
		}
		
		bt2.levelWisePrint();
		
		BinaryTree bt3 = new BinaryTree();
		bt3.root = new Node(3);
		bt3.root.left = new Node(2);
		bt3.root.right = new Node(1);
		bt3.root.right.left = new Node(10);
		
		if (bt.isSubtree(bt3.root)) {
			System.out.println("It is a sub-tree.");
		} else {
			System.out.println("It is not a sub-tree.");
		}
	}
}
