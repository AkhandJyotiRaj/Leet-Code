class Solution {
    public int numSub(String s) {
        long ans = 0;
        long ones = 0;
        long MOD = 1000000007;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                ans = (ans + (ones * (ones + 1) / 2) % MOD) % MOD;
                ones = 0;
            }
        }

        ans = (ans + (ones * (ones + 1) / 2) % MOD) % MOD;
        return (int)(ans % MOD);
    }
}