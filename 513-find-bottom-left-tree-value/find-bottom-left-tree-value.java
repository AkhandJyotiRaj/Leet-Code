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
    public int findBottomLeftValue(TreeNode root) {

        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        traverse(root,lst,0);
        return lst.get(lst.size() - 1).get(0);    
        
    }

    public void traverse(TreeNode root, List<List<Integer>> lst, int lvl){
        if(root == null) return;
        if(lst.size() == lvl) lst.add(new ArrayList<Integer>());

        lst.get(lvl).add(root.val);
        traverse(root.left, lst, lvl + 1);
        traverse(root.right, lst, lvl + 1);
    }
}