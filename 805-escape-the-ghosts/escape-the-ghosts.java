class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int myDist = Math.abs(target[0]) + Math.abs(target[1]);

        for (int[] ghost : ghosts) {
            int ghostDist = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (ghostDist <= myDist) {
                return false; // ghost can reach target before or at same time
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] ghosts1 = {{1,0},{0,3}};
        int[] target1 = {0,1};
        System.out.println(sol.escapeGhosts(ghosts1, target1)); // true

        int[][] ghosts2 = {{1,0}};
        int[] target2 = {2,0};
        System.out.println(sol.escapeGhosts(ghosts2, target2)); // false

        int[][] ghosts3 = {{2,0}};
        int[] target3 = {1,0};
        System.out.println(sol.escapeGhosts(ghosts3, target3)); // false
    }
}
   
    