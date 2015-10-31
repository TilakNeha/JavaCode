/*
 * Check if a given array can represent Preorder Traversal of Binary Search Tree
 */
public class CheckBST {
	public static void main(String[] args) {
		int[] arr1 = {2,4,3};
		String output1 = isBST(arr1,0,arr1.length-1) ? "Tree is BST." : "Tree is not BST.";
		System.out.println(output1);
		
		int[] arr2 = {2,4,1};
		String output2 = isBST(arr2,0,arr2.length-1) ? "Tree is BST." : "Tree is not BST.";
		System.out.println(output2);
		
	}
	
	public static boolean isBST(int[] preorder,int low, int high) {
		int root = preorder[low];
		int i = low + 1;
		while (preorder[i] < root && i <= high ) {
			i++;
		}
		if (i == high) {
			return isBST(preorder,low+1,high);
		}
		while (i <= high) {
			if (preorder[i] < root) {
				return false;
			}
			i++;
		}
		return true;
	}

}