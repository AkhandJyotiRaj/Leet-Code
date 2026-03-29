import java.io.*;
import java.util.*;

public class HOtelqueries {
    static int n;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int m;

        n = fs.nextInt();
        m = fs.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = fs.nextLong();

        tree = new long[4 * n];
        build(arr, 1, 0, n - 1);

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < m; i++) {
            long req = fs.nextLong();
            int idx = findHotel(1, 0, n - 1, req);

            if (idx == -1) {
                ans.append(0).append(" ");
            } else {
                ans.append(idx + 1).append(" ");
                update(1, 0, n - 1, idx, req);
            }
        }

        System.out.println(ans);
    }

    // Build tree
    static void build(long[] arr, int node, int l, int r) {
        if (l == r) {
            tree[node] = arr[l];
            return;
        }

        int mid = (l + r) / 2;
        build(arr, 2 * node, l, mid);
        build(arr, 2 * node + 1, mid + 1, r);

        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    // Find first hotel with enough rooms
    static int findHotel(int node, int l, int r, long req) {
        if (tree[node] < req) return -1;

        if (l == r) return l;

        int mid = (l + r) / 2;

        if (tree[2 * node] >= req)
            return findHotel(2 * node, l, mid, req);
        else
            return findHotel(2 * node + 1, mid + 1, r, req);
    }

    // Update after assigning rooms
    static void update(int node, int l, int r, int idx, long req) {
        if (l == r) {
            tree[node] -= req;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            update(2 * node, l, mid, idx, req);
        else
            update(2 * node + 1, mid + 1, r, idx, req);

        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    // Fast I/O
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}