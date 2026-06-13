class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (int i = 0; i < word.length(); i++) {
                sum += weights[word.charAt(i) - 'a'];
            }

            char ch = (char) ('a' + (25 - sum % 26));
            ans.append(ch);
        }

        return ans.toString();
    }
}