class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int[] ans = new int[wordsQuery.length];
        Trie t = new Trie();
        for (int i = 0; i < wordsContainer.length; i++) {
            StringBuilder str = new StringBuilder(wordsContainer[i]);
            t.create(str.reverse().toString(), i);
        }
        for (int i = 0; i < wordsQuery.length; i++) {
            StringBuilder str = new StringBuilder(wordsQuery[i]);
            ans[i] = t.query(str.reverse().toString());
        }
        return ans;
    }

    class Node {
        Node[] node;
        int e;
        boolean isEnd;
        int dp;

        Node() {
            node = new Node[26];
            e = Integer.MAX_VALUE;
            isEnd = false;
            dp = -1;
        }
    }

    class Trie {
        Node root;
        int l = Integer.MAX_VALUE;
        int id = -1;

        Trie() {
            root = new Node();
        }

        public void create(String s, int idx) {
            if (s.length() == 0)
                return;
            if (l > s.length()) {
                l = s.length();
                id = idx;
            }
            c(root, s, 0, idx);
        }

        private void c(Node n, String s, int idx, int i) {
            if (idx == s.length()) {
                n.isEnd = true;
                if (n.e > i)
                    n.e = i;
                return;
            }
            int c = s.charAt(idx) - 'a';
            if (n.node[c] == null)
                n.node[c] = new Node();
            c(n.node[c], s, idx + 1, i);
        }

        public int query(String s) {
            return q(root, s, 0);
        }

        private int q(Node n, String s, int idx) {
            if (idx == s.length()) {
                if (n.isEnd)
                    return n.e;
                if (n.dp != -1)
                    return n.dp;
                return n.dp = bfs(n);
            }
            int c = s.charAt(idx) - 'a';
            if (n.node[c] != null) {
                return q(n.node[c], s, idx + 1);
            }
            if (n.dp != -1)
                return n.dp;
            return n.dp = bfs(n);
        }

        private int bfs(Node n) {
            Queue<Node> q = new LinkedList<>();
            q.add(n);
            int temp = Integer.MAX_VALUE;
            boolean f = false;
            while (!q.isEmpty()) {
                int s = q.size();
                for (int i = 0; i < s; i++) {
                    Node nod = q.poll();
                    if (nod.isEnd) {
                        temp = Math.min(temp, nod.e);
                        f = true;
                    }
                    for (Node node : nod.node) {
                        if (node != null) {
                            q.add(node);
                        }
                    }
                }
                if (f) {
                    return temp;
                }
            }
            return -1;
        }
    }
}