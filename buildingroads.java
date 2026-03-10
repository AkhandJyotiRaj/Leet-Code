import java.util.ArrayList;
import java.util.Scanner;

class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if(pa!=pb){
                parent[pb] = pa; 
            }
        }
    }
public class buildingroads {

    
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        DSU dsu = new DSU(n);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            dsu.union(a, b);
        }

        ArrayList<Integer> comp = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (dsu.find(i) == i) {
                comp.add(i);
            }
        }

        System.out.println(comp.size() - 1);

        for (int i = 1; i < comp.size(); i++) {
            System.out.println(comp.get(i - 1) + " " + comp.get(i));
        }

    }
}