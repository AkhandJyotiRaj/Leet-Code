public class oddeven {
    class Pair {
        int odd;
        int even;

        Pair(int odd, int even) {
            this.odd = odd;
            this.even = even;
        }
    }

    class SegmentTree {

        Pair segTree[];

        SegmentTree(int n) {
            segTree = new Pair[4 * n];
        }

        void buildTree(int arr[], int idx, int start, int end) {

            if (start == end) {
                if (arr[start] % 2 == 0)
                    segTree[idx] = new Pair(0, 1);
                else
                    segTree[idx] = new Pair(1, 0);
                return;
            }

            int mid = (start + end) / 2;

            buildTree(arr, idx * 2 + 1, start, mid);
            buildTree(arr, idx * 2 + 2, mid + 1, end);

            Pair parent = new Pair(0, 0);
            Pair left = segTree[idx * 2 + 1];
            Pair right = segTree[idx * 2 + 2];
            parent.odd = left.odd + right.odd;
            parent.even = left.even + right.even;

            segTree[idx] = parent;

        }

        Pair query(int idx, int qStart, int qEnd, int start, int end) {

            if (start >= qStart && end <= qEnd)
                return segTree[idx];
            if (end < qStart || start > qEnd)
                return new Pair(0, 0);

            int mid = (start + end) / 2;

            Pair left = query(idx * 2 + 1, qStart, qEnd, start, mid);
            Pair right = query(idx * 2 + 2, qStart, qEnd, mid + 1, end);

            Pair ans = new pair(left.odd + right.odd, left.even + right.even);
            return ans;
        }

    }
}
    

