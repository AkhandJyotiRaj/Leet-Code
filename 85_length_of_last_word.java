class Solution {
    public int lengthOfLastWord(String s) {
        int l = 0;

        // Traverse from the end
        for (int i = s.length() - 1; i >= 0; i--) {
            // Count letters until a space appears after counting starts
            if (s.charAt(i) != ' ') l++;
            else if (l > 0) return l;
        }
        return l;
    }
}