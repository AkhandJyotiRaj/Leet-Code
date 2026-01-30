class Solution {
    public String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        int max = 0;
        int start = 0;

        // odd center
        for (int i = 0; i < chars.length; i++) {
            int left = i;
            int right = i;

            while (left > 0 && right < chars.length - 1 && chars[left - 1] == chars[right + 1]) {
                left--;
                right++;
            }

            if (right - left + 1 > max) {
                max = right - left + 1;
                start = left;
            }
        }

        // even center
        for (int i = 0; i < chars.length - 1; i++) {
            int left = i;
            int right = i + 1;

            if (chars[left] == chars[right]) {

                while (left > 0 && right < chars.length - 1 && chars[left - 1] == chars[right + 1]) {
                    left--;
                    right++;
                }

                if (right - left + 1 > max) {
                    max = right - left + 1;
                    start = left;
                }
            }
        }

        return s.substring(start, start + max);
    }
}