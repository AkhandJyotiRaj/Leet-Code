class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] size = new int[n];
        int[] parent = new int[n];
        Map<String, Integer> mailMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }

        List<List<String>> ans = new ArrayList<>();
        List<List<String>> temp = new ArrayList<>();

        // Union accounts having common emails
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mailMap.containsKey(mail)) {
                    union(size, parent, i, mailMap.get(mail));
                } else {
                    mailMap.put(mail, i);
                }
            }
            temp.add(new ArrayList<>());
        }

        // Group emails by root parent
        for (String mail : mailMap.keySet()) {
            int root = find(parent, mailMap.get(mail));
            temp.get(root).add(mail);
        }

        // Sort emails and add account name
        for (int i = 0; i < n; i++) {
            if (!temp.get(i).isEmpty()) {
                Collections.sort(temp.get(i));
                temp.get(i).add(0, accounts.get(i).get(0));
                ans.add(temp.get(i));
            }
        }

        return ans;
    }

    private static boolean union(int[] size, int[] parent, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);

        if (pu == pv) return false;

        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu]++;
        } else {
            parent[pu] = pv;
            size[pv]++;
        }
        return true;
    }

    private static int find(int[] parent, int u) {
        if (u != parent[u]) {
            parent[u] = find(parent, parent[u]);
        }
        return parent[u];
    }
}