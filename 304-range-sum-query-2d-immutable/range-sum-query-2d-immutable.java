class NumMatrix {
    static int[][] preComp;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        preComp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            preComp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            preComp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                preComp[i][j] = matrix[i-1][j-1] + preComp[i - 1][j] + preComp[i][j - 1] - preComp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = preComp[row2+1][col2+1];
        //+1 because preComp is shifted one index ahead
        // all values as row2, row1 can be simply visualised as row2-1 ....

        sum-= preComp[row2+1][col1];
        sum-=preComp[row1][col2+1];
        sum+=preComp[row1][col1];

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */