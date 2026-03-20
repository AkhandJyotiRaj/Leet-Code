import java.io.*;
import java.util.*;

public class ForestQueriesSegTree {

    static int n;
    static int[][] tree;

    static void buildY(int nodeX, int startX, int endX, int nodeY, int startY, int endY, int[][] grid) {
        if (startY == endY) {
            if (startX == endX) {
                tree[nodeX][nodeY] = grid[startX][startY];
            } else {
                tree[nodeX][nodeY] = tree[nodeX * 2][nodeY] + tree[nodeX * 2 + 1][nodeY];
            }
        } else {
            int midY = (startY + endY) / 2;
            buildY(nodeX, startX, endX, nodeY * 2, startY, midY, grid);
            buildY(nodeX, startX, endX, nodeY * 2 + 1, midY + 1, endY, grid);
            tree[nodeX][nodeY] = tree[nodeX][nodeY * 2] + tree[nodeX][nodeY * 2 + 1];
        }
    }

    static void buildX(int nodeX, int startX, int endX, int[][] grid) {
        if (startX != endX) {
            int midX = (startX + endX) / 2;
            buildX(nodeX * 2, startX, midX, grid);
            buildX(nodeX * 2 + 1, midX + 1, endX, grid);
        }
        buildY(nodeX, startX, endX, 1, 0, n - 1, grid);
    }


    static int queryY(int nodeX, int nodeY, int startY, int endY, int y1, int y2) {
        if (y2 < startY || endY < y1) return 0;
        if (y1 <= startY && endY <= y2) return tree[nodeX][nodeY];

        int mid = (startY + endY) / 2;
        return queryY(nodeX, nodeY * 2, startY, mid, y1, y2)
                + queryY(nodeX, nodeY * 2 + 1, mid + 1, endY, y1, y2);
    }

    static int queryX(int nodeX, int startX, int endX, int x1, int x2, int y1, int y2) {
        if (x2 < startX || endX < x1) return 0;
        if (x1 <= startX && endX <= x2) {
            return queryY(nodeX, 1, 0, n - 1, y1, y2);
        }

        int mid = (startX + endX) / 2;
        return queryX(nodeX * 2, startX, mid, x1, x2, y1, y2)
                + queryX(nodeX * 2 + 1, mid + 1, endX, x1, x2, y1, y2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = (row.charAt(j) == '*') ? 1 : 0;
            }
        }

        tree = new int[4 * n][4 * n];

        buildX(1, 0, n - 1, grid);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;

            int ans = queryX(1, 0, n - 1, y1, y2, x1, x2);
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}