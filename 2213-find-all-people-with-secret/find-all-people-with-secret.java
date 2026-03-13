
class Solution {
    int[] parent;

    int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // path compression
            x = parent[x];
        }
        return x;
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        boolean[] known = new boolean[n];
        known[0] = true;
        known[firstPerson] = true;

        int i = 0;
        while (i < meetings.length) {

            int time = meetings[i][2];
            int start = i;

            // Union all meetings at the same time
            while (i < meetings.length && meetings[i][2] == time) {
                union(meetings[i][0], meetings[i][1]);
                i++;
            }

            // Mark components that know the secret
            for (int j = start; j < i; j++) {
                int x = meetings[j][0];
                int y = meetings[j][1];
                if (known[x] || known[y]) {
                    known[find(x)] = true;
                }
            }

            // Spread secret or reset components
            for (int j = start; j < i; j++) {
                int x = meetings[j][0];
                int y = meetings[j][1];

                int px = find(x);
                int py = find(y);

                if (known[px]) {
                    known[x] = true;
                    known[y] = true;
                } else {
                    parent[x] = x;
                    parent[y] = y;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (known[p]) res.add(p);
        }
        return res;
    }
}