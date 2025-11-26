public import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int left, int right, int n) {
        // If the string is complete
        if (left == n && right == n) {
            result.add(current);
            return;
        }

        // Add "(" if possible
        if (left < n) {
            backtrack(result, current + "(", left + 1, right, n);
        }

        // Add ")" if it maintains validity
        if (right < left) {
            backtrack(result, current + ")", left, right + 1, n);
        }
    }
}
 GenerateParanthesis {
    
}
