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
    public static int maxH ;
    public static void dfs(TreeNode root, List<Integer>list,int currH){
        if(root == null) return;
        // if(root.left == null && root.right == null) return;
        if(maxH < currH ){ // maxH changes
            list.add(root.val);
            maxH = currH;
        }
        dfs(root.right,list,currH+1);
        dfs(root.left,list,currH+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        maxH = -1;
        dfs(root,list,0);
        return list;
    }
}