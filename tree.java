public class tree {

	static class Node {
		int val;
		Node left, right;

		Node(int v) { val = v; }
	}

	private Node root;

	// Insert a value into the BST
	public void insert(int val) {
		root = insertRec(root, val);
	}

	private Node insertRec(Node node, int val) {
		if (node == null) return new Node(val);
		if (val < node.val) node.left = insertRec(node.left, val);
		else node.right = insertRec(node.right, val);
		return node;
	}

	// Search in BST
	public boolean search(int val) {
		Node cur = root;
		while (cur != null) {
			if (cur.val == val) return true;
			cur = (val < cur.val) ? cur.left : cur.right;
		}
		return false;
	}

	// Traversals
	public void inorder() { inorderRec(root); System.out.println(); }
	private void inorderRec(Node node) {
		if (node == null) return;
		inorderRec(node.left);
		System.out.print(node.val + " ");
		inorderRec(node.right);
	}

	public void preorder() { preorderRec(root); System.out.println(); }
	private void preorderRec(Node node) {
		if (node == null) return;
		System.out.print(node.val + " ");
		preorderRec(node.left);
		preorderRec(node.right);
	}

	public void postorder() { postorderRec(root); System.out.println(); }
	private void postorderRec(Node node) {
		if (node == null) return;
		postorderRec(node.left);
		postorderRec(node.right);
		System.out.print(node.val + " ");
	}

	// Simple demo
	public static void main(String[] args) {
		tree t = new tree();
		int[] values = {50, 30, 20, 40, 70, 60, 80};
		for (int v : values) t.insert(v);

		System.out.print("Inorder: "); t.inorder();    // should be sorted
		System.out.print("Preorder: "); t.preorder();
		System.out.print("Postorder: "); t.postorder();

		System.out.println("Search 60: " + t.search(60));
		System.out.println("Search 25: " + t.search(25));
	}

}
