import java.util.*;

class Solution {
    
    public List<String> letterCombinations(String digits) {
        
        // Result list to store final combinations
        List<String> result = new ArrayList<>();
        
        // Edge case: if input is empty
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Mapping digits to letters
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        // Call backtracking function
        backtrack(result, map, digits, 0, new StringBuilder());
        
        return result;
    }
    
    private void backtrack(List<String> result,
                           Map<Character, String> map,
                           String digits,
                           int index,
                           StringBuilder current) {
        
        // Base case:
        // If current combination length equals digits length
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get letters corresponding to current digit
        String letters = map.get(digits.charAt(index));
        
        // Loop through each letter
        for (char ch : letters.toCharArray()) {
            
            // Choose
            current.append(ch);
            
            // Explore next digit
            backtrack(result, map, digits, index + 1, current);
            
            // Undo choice (Backtrack)
            current.deleteCharAt(current.length() - 1);
        }
    }
}
