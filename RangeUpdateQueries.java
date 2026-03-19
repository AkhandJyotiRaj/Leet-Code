import java.io.*;
import java.util.*;

public class RangeUpdateQueries {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }

    private long[] bit;
    private int n;

    public RangeUpdateQueries(int n) {
        this.n = n;
        this.bit = new long[n + 1];
    }

    // Standard BIT update: adds val to index i
    public void update(int i, long val) {
        for (; i <= n; i += i & -i) {
            bit[i] += val;
        }
    }

    // Standard BIT query: returns prefix sum up to index i
    public long query(int i) {
        long sum = 0;
        for (; i > 0; i -= i & -i) {
            sum += bit[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        int q = fr.nextInt();

        RangeUpdateQueries ft = new RangeUpdateQueries(n);
        long[] initialArray = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            initialArray[i] = fr.nextLong();
            // Build the difference array in the BIT
            // diff[i] = x[i] - x[i-1]
            ft.update(i, initialArray[i] - initialArray[i - 1]);
        }

        while (q-- > 0) {
            int type = fr.nextInt();
            
            if (type == 1) {
                int a = fr.nextInt();
                int b = fr.nextInt();
                long u = fr.nextLong();
                // Range update [a, b] by u
                ft.update(a, u);
                if (b + 1 <= n) {
                    ft.update(b + 1, -u);
                }
            } else {
                int k = fr.nextInt();
                // Point query at k is the prefix sum of differences
                out.println(ft.query(k));
            }
        }
        out.close();
    }
}