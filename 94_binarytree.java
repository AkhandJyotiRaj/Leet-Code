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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorder(root,new ArrayList<>());
    }
    public List<Integer> inorder(TreeNode node , List<Integer> ans ) {
        if(node == null){
            return ans;
        }
        inorder(node.left,ans);
        ans.add(node.val);
        inorder(node.right,ans);
        return ans;
    }
}