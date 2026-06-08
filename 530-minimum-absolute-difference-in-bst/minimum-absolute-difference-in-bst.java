class Solution {
    TreeNode prev= null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root);
        
        
        return min;

    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if(prev!=null){
            min= Math.min(min ,  Math.abs(prev.val - root.val));
        }
        prev=root;
    
        inorder(root.right);
    }
}