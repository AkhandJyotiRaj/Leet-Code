class Solution {
    static final int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int[] row : score)
            Arrays.fill(row, -1);

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (board.get(i).charAt(j) == 'X')
                    continue;

                if (i == n - 1 && j == n - 1)
                    continue;

                int best = -1;
                int count = 0;

                int[][] dir = {{1,0},{0,1},{1,1}};

                for (int[] d : dir) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x >= n || y >= n || score[x][y] == -1)
                        continue;

                    if (score[x][y] > best) {
                        best = score[x][y];
                        count = ways[x][y];
                    } else if (score[x][y] == best) {
                        count = (count + ways[x][y]) % MOD;
                    }
                }

                if (best == -1)
                    continue;

                score[i][j] = best;

                char c = board.get(i).charAt(j);

                if (Character.isDigit(c))
                    score[i][j] += c - '0';

                ways[i][j] = count;
            }
        }

        if (ways[0][0] == 0)
            return new int[]{0,0};

        return new int[]{score[0][0], ways[0][0]};
    }
}