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
    static class Info{
        TreeNode node;
        int idx;

        public Info(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));

        int maxWidth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int left = q.peek().idx; // leftmost index
            int right = left; // rightmost index (will update)

            for(int i=0; i<size; i++){
                Info curr = q.poll();
                TreeNode currNode = curr.node;
                int idx = curr.idx - left; // normalize to prevent overflow
                right = idx;

                if(currNode.left != null) q.add(new Info(currNode.left, 2*idx));
                if(currNode.right != null) q.add(new Info(currNode.right, 2*idx + 1));
            }

            maxWidth = Math.max(maxWidth, right+1);
        }
        return maxWidth;
    }
}