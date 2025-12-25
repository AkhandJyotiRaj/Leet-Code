public class findcommoncharactor {
    
}
class Solution {
    public List<String> commonChars(String[] words) {
        int[] cnt1 = new int[26];
        
        for(int i = 0; i < words.length; i++) {
            int[] cnt2 = new int[26];
            if(i == 0) {
                for(char c : words[i].toCharArray()) cnt1[c - 'a']++;
            } else {
                for(char c : words[i].toCharArray()) cnt2[c - 'a']++;
                for(int j = 0; j < 26; j++)
                    cnt1[j] = Math.min(cnt1[j], cnt2[j]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            while(cnt1[i]-- > 0) {
                ans.add(String.valueOf((char)(i + 'a')));
            }
        }
        return ans;
    }
}