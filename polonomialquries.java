import java.io.*;
import java.util.*;

public class polonomialquries {
    static int n, q;
    static long[] tree, lazyA, lazyB;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        n = fs.nextInt();
        q = fs.nextInt();

        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = fs.nextLong();

        tree = new long[4 * n];
        lazyA = new long[4 * n];
        lazyB = new long[4 * n];

        build(1, 1, n, arr);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int t = fs.nextInt();
            int l = fs.nextInt();
            int r = fs.nextInt();

            if (t == 1) {
                update(1, 1, n, l, r, 1, 1 - l);
            } else {
                sb.append(query(1, 1, n, l, r)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static void build(int node, int l, int r, long[] arr) {
        if (l == r) {
            tree[node] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(node << 1, l, mid, arr);
        build(node << 1 | 1, mid + 1, r, arr);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    static void apply(int node, int l, int r, long a, long b) {
        long len = r - l + 1;
        long sumI = (long)(l + r) * len >> 1;

        tree[node] += a * sumI + b * len;

        lazyA[node] += a;
        lazyB[node] += b;
    }

    static void push(int node, int l, int r) {
        if (lazyA[node] == 0 && lazyB[node] == 0) return;

        int mid = (l + r) >> 1;

        apply(node << 1, l, mid, lazyA[node], lazyB[node]);
        apply(node << 1 | 1, mid + 1, r, lazyA[node], lazyB[node]);

        lazyA[node] = 0;
        lazyB[node] = 0;
    }

    static void update(int node, int l, int r, int ql, int qr, long a, long b) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, a, b);
            return;
        }

        push(node, l, r);

        int mid = (l + r) >> 1;

        if (ql <= mid) update(node << 1, l, mid, ql, qr, a, b);
        if (qr > mid) update(node << 1 | 1, mid + 1, r, ql, qr, a, b);

        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    static long query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) return tree[node];

        push(node, l, r);

        int mid = (l + r) >> 1;
        long res = 0;

        if (ql <= mid) res += query(node << 1, l, mid, ql, qr);
        if (qr > mid) res += query(node << 1 | 1, mid + 1, r, ql, qr);

        return res;
    }

    // Ultra fast scanner
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            while ((c = read()) <= ' ') ;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c;
            long sign = 1, val = 0;
            while ((c = read()) <= ' ') ;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
    }
}