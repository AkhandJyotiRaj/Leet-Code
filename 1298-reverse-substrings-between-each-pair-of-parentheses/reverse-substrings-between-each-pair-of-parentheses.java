class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        java.util.Deque<Integer> openings = new java.util.ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openings.push(i);
            } else if (ch == ')') {
                int j = openings.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder answer = new StringBuilder(n);
        int i = 0;
        int direction = 1;

        while (i >= 0 && i < n) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == ')') {
                i = pair[i];
                direction = -direction;
            } else {
                answer.append(ch);
            }

            i += direction;
        }

        return answer.toString();
    }
}