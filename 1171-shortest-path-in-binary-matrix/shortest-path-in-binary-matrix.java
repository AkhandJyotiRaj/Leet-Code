class Solution {
    public int shortestPathBinaryMatrix(int[][] g) {
        int R = g.length, C = R;
        if(g[0][0] == 1 || g[R - 1][C - 1] == 1) return -1;
        int[] dirR = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
        int[] dirC = new int[]{1, 0, -1, 0, 1, -1, 1, -1};

        g[0][0] = 1;
        int ans = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while(!q.isEmpty()) {
            ++ans;
            int len = q.size();

            for(int l = 0; l < len; ++l) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                if(r == R - 1 && c == C - 1) return ans;

                for(int i = 0; i < 8; ++i) {
                    int nr = r + dirR[i], nc = c + dirC[i];
                    if(nr < 0 || nc < 0 || nr >= R || nc >= C || g[nr][nc] == 1) continue;
                    g[nr][nc] = 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }
}