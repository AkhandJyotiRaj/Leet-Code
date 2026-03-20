import java.io.*;
import java.util.*;

public class FOrestqueirs {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] pref = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                int val = (s.charAt(j - 1) == '*') ? 1 : 0;

                pref[i][j] = val
                        + pref[i - 1][j]
                        + pref[i][j - 1]
                        - pref[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int ans = pref[y2][x2]
                    - pref[y1 - 1][x2]
                    - pref[y2][x1 - 1]
                    + pref[y1 - 1][x1 - 1];

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}