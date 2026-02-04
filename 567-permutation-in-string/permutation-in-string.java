class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character,Integer> mp1 = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char curr = s1.charAt(i);
            mp1.put(curr, mp1.getOrDefault(curr, 0) + 1);
        }

        HashMap<Character,Integer> mp2 = new HashMap<>();

        int windowStart = 0;
        int windowEnd = 0;
        int k = s1.length();

        while(windowEnd < s2.length()){
            char curr = s2.charAt(windowEnd);
            mp2.put(curr, mp2.getOrDefault(curr, 0) + 1);

            if(windowEnd >= k - 1){
                if(mp1.equals(mp2)) return true;

                char temp = s2.charAt(windowStart);
                mp2.put(temp, mp2.get(temp) - 1);

                if(mp2.get(temp) == 0)
                    mp2.remove(temp);

                windowStart++;
            }

            windowEnd++;
        }

        return false;
    }
}
