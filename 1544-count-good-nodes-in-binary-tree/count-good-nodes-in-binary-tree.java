class Solution {
    int count  = 0;
    public int goodNodes(TreeNode root) {
       dfs(root,root.val);
       return count;
    }


    public void dfs(TreeNode node,int max){
        if(node== null) return ;
        if(node.val >= max)
            count++;
            max = Math.max(max,node.val);

             dfs(node.left,max);
             dfs(node.right,max);
    }
}