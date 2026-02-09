import java.util.*;
public class Undiretectedweighted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Pair>> adjLIst = new ArrayList();

        for (int i = 0; i < n; i++) {
            adjLIst.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to1 = sc.nextInt();
            int weight1 = sc.nextInt();

            Pair curr = new Pair();
            curr.to = to1;
            curr.weight = weight1;
        }
    }
}
