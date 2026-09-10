class Avg{
    int sum;
    int count;
    int nodes;

    Avg(int sum, int count, int nodes){
        this.sum = sum;
        this.count = count;
        this.nodes = nodes;
    }
}

class Solution {

    public static Avg helper(TreeNode root){
        if(root==null){
            return new Avg(0,0,0);
        }

        if(root.left==null && root.right==null){
            return new Avg(root.val, 1, 1);
        }

        Avg lst = helper(root.left);
        Avg rst = helper(root.right);

        int totalSum = lst.sum + rst.sum + root.val;
        int totalNodes = lst.nodes + rst.nodes + 1;
        
        int totalCount = lst.count + rst.count;
        int average = (totalSum/totalNodes);
        if(average==root.val) totalCount++;

       
        return new Avg(totalSum, totalCount, totalNodes);
    }

    public int averageOfSubtree(TreeNode root) {
        Avg ans = helper(root);
        return ans.count;

    }
}