class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        HashMap<String,Integer> map = new HashMap<>();
        int result = 1;
        for(String word : words){
            int bestword = 1;


            for(int i =0;i<word.length();i++){
                String prev = word.substring(0,i) + word.substring(i+1);

                bestword = Math.max(bestword,map.getOrDefault(prev,0)+1);

                map.put(word,bestword);
            }
            result = Math.max(result,bestword);
        }
        return result;
    }
}