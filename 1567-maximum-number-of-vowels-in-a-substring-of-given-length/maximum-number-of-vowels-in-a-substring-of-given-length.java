class Solution {
    public int maxVowels(String s, int k) {
        int l = 0, count = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) count++;

            if (i - l + 1 > k) {
                if (isVowel(s.charAt(l))) count--;
                l++;
            }

            ans = Math.max(ans, count);
            if (ans == k) return ans; //early exit, we hit the jackpot
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}