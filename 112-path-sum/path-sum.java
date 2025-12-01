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
    public boolean hasPathSum(TreeNode root, int target) 
    {
        int i=solve(root,target);
        return i>0?true:false;
    }
    private int solve(TreeNode root, int target)
    {
        if(root==null)
        {
            return 0;
        }
        if (root.left == null && root.right == null) 
        {
            return (target == root.val) ? 1 : 0;
        }


        int left=solve(root.left,target-root.val);
        int right=solve(root.right,target-root.val);
        return left+right;
    }
}