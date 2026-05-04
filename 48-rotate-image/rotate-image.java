class Solution {
    public void rotate(int[][] matrix) {
        int i,j;
        int m = matrix.length;
        for(i=0;i<m;i++)
        {
            for(j=i;j<m;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(i=0;i<m;i++)
        {
            int left=0,right=m-1;
            while(left<right)
            {
                int temp=matrix[i][right];
                matrix[i][right]=matrix[i][left];
                matrix[i][left]=temp;
                left++;
                right--;
            }
                
    }
}
}