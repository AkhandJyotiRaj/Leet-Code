public class Solution {
    public void combineLetters(String curr, List<List<String>> list, List<String> result, int idx1, int idx2, int n) {
        if (curr.length() == n) {
            result.add(curr);
            return;
        }
        if (idx1 >= list.size()) return;
        if (idx2 >= list.get(idx1).size()) return;

        String newcurr = curr + list.get(idx1).get(idx2);

        if (idx1 < n) {
            combineLetters(newcurr, list, result, idx1 + 1, 0, n);
        }

        if (idx2 + 1 < list.get(idx1).size()) {
            combineLetters(curr, list, result, idx1, idx2 + 1, n);
        }
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        int ascii = 97;
        for (int i = 2; i <= 9; i++) {
            List<String> list = new ArrayList<>();
            int count = (i == 7 || i == 9) ? 4 : 3;
            for (int j = 0; j < count; j++) {
                list.add(String.valueOf((char) ascii));
                ascii++;
            }
            map.put(i, list);
        }

        int n = digits.length();
        List<List<String>> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            list.add(map.get(digits.charAt(i) - '0'));
        }

        if (n > 0)
            combineLetters("", list, result, 0, 0, n);

        return result;
    }
} combinationofphonenumber {
    
}
