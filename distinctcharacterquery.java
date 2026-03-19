import java.io.*;
import java.util.*;

public class distinctcharacterquery {
    static int[] tree;
    static char[] arr;
    static int n;

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = 1 << (arr[start] - 'a');
        } else {
            int mid = (start + end) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] | tree[2 * node + 1];
        }
    }

    static void update(int node, int start, int end, int idx, char val) {
        if (start == end) {
            arr[idx] = val;
            tree[node] = 1 << (val - 'a');
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid)
                update(2 * node, start, mid, idx, val);
            else
                update(2 * node + 1, mid + 1, end, idx, val);

            tree[node] = tree[2 * node] | tree[2 * node + 1];
        }
    }

    static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;

        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;
        int left = query(2 * node, start, mid, l, r);
        int right = query(2 * node + 1, mid + 1, end, l, r);

        return left | right;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = s.length();

        arr = s.toCharArray();
        tree = new int[4 * n];

        build(1, 0, n - 1);

        int q = Integer.parseInt(br.readLine());

        StringBuilder output = new StringBuilder();

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int pos = Integer.parseInt(st.nextToken()) - 1;
                char c = st.nextToken().charAt(0);
                update(1, 0, n - 1, pos, c);
            } else {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;

                int mask = query(1, 0, n - 1, l, r);
                output.append(Integer.bitCount(mask)).append("\n");
            }
        }

        System.out.print(output);
    }
}