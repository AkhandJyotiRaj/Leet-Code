class Solution {
    public int numOfWays(int n) {
        long MOD = 1000000007L;
        long A = 0, B = 1, C = 1, D = 0;
        for (int x = n - 1; x > 0; x >>= 1) {
            if ((x & 1) == 1) {
                long nextA = (A * D + B * C + 5 * A * C) % MOD;
                long nextB = (B * D - 2 * A * C) % MOD;
                A = nextA;
                B = nextB;
            }
            long nextC = (2 * C * D + 5 * C * C) % MOD;
            long nextD = (D * D - 2 * C * C) % MOD;
            C = nextC;
            D = nextD;
        }
        return (int) ((54 * A + 12 * B + MOD * MOD) % MOD);
    }
}