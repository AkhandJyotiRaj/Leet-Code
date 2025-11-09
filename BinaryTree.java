ggimport java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    // Insert into a Binary Search Tree
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node node, int val) {
        if (node == null) return new Node(val);
        if (val < node.val) node.left = insertRec(node.left, val);
        else node.right = insertRec(node.right, val);
        return node;
    }

    // Traversals
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node == null) return;
        inorderRec(node.left);
        System.out.print(node.val + " ");
        inorderRec(node.right);
    }

    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorderRec(node.left);
        preorderRec(node.right);
    }

    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node node) {
        if (node == null) return;
        postorderRec(node.left);
        postorderRec(node.right);
        System.out.print(node.val + " ");
    }

    // Level-order (BFS)
    public void levelOrder() {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
        System.out.println();
    }

    // Height of the tree
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    // Simple demo
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int v : values) bt.insert(v);

        System.out.println("Inorder (should be sorted):");
        bt.inorder();

        System.out.println("Preorder:");
        bt.preorder();

        System.out.println("Postorder:");
        bt.postorder();

        System.out.println("Level-order:");
        bt.levelOrder();

        System.out.println("Height: " + bt.height());
    }
}
