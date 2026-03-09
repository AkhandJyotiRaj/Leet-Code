public class dsu {
    private int[] parent;

    public dsu(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        dsu dsu = new dsu(5);
        System.out.println("Find(3): " + dsu.find(3));
        System.out.println("Find(1): " + dsu.find(1));
        dsu.union(1, 3);
        System.out.println("After union(1, 3):");
        System.out.println("Find(1): " + dsu.find(1));
        System.out.println("Find(3): " + dsu.find(3));
        System.out.println("Connected 1 and 3? " + dsu.connected(1, 3));
    }
}
