class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> m = new HashMap<>();
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        char ch;
        String word;
        for(int i = 0; i < pattern.length(); i++) {
            ch = pattern.charAt(i);
            word = arr[i];
            if((m.containsValue(word) || m.containsKey(ch)) && !(m.containsKey(ch) && m.get(ch).equals(word))) 
                return false;
            else m.put(ch, word);
        }
        return true;
    }
}