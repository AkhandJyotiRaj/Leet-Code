class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;          // → number of rows
        int n = mat[0].length;       // → number of columns
        int count = 0;                // → we'll count special positions here

        // Walk through every cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Is this cell a candidate? Only if it's a 1
                if (mat[i][j] == 1) {
                    boolean special = true;   // start by assuming it's special

                    // --- CHECK THE ROW (left to right, skipping the cell itself) ---
                    for (int col = 0; col < n; col++) {
                        if (col != j && mat[i][col] == 1) {
                            special = false;   // found another 1 in the same row → not special
                            break;
                        }
                    }

                    // --- IF THE ROW IS CLEAN, CHECK THE COLUMN ---
                    if (special) {
                        for (int row = 0; row < m; row++) {
                            if (row != i && mat[row][j] == 1) {
                                special = false;   // found another 1 in the same column → not special
                                break;
                            }
                        }
                    }

                    // --- IF BOTH ROW AND COLUMN ARE CLEAN, WE HAVE A WINNER ---
                    if (special) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}