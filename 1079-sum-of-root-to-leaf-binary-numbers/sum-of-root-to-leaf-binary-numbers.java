/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        List<String> path = new ArrayList<>();
        helper(root, path, "");

        int sum = 0;

        for (int i = 0; i < path.size(); i++) {
            String binary = path.get(i);
            int number = Integer.parseInt(binary, 2);
            sum += number;
        }

        return sum;
    }

    public void helper(TreeNode root, List<String> path, String ans) {
        if (root == null) {
            return;
        }

        ans = ans + root.val;

        // If leaf node
        if (root.left == null && root.right == null) {
            path.add(ans);
            return;
        }

        helper(root.left, path, ans);
        helper(root.right, path, ans);
    }
}