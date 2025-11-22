class Solution {
    class Pair{
        String s;
        int step;
        Pair(String s,int step){
            this.s=s;
            this.step=step;
        }
    }

    public int openLock(String[] deadends, String target) {
        Set<String> dead=new HashSet<>(Arrays.asList(deadends));

        if(dead.contains("0000")) return -1;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair("0000",0));

        while(!q.isEmpty()){
            Pair curr=q.poll();
            String currLock=curr.s;
            int currStep=curr.step;

            if(currLock.equals(target)) return currStep;

            for(String next:getAllNeighbours(currLock)){
                if(!dead.contains(next)){
                    dead.add(next);
                    q.add(new Pair(next,currStep+1));
                }
            }
        }
        return -1;
    }

    List<String> getAllNeighbours(String currStr){
        List<String> list=new ArrayList<>();
        char[] arr=currStr.toCharArray();

        for(int i=0;i<4;i++){
            char original=arr[i];

            arr[i]=(char)((original-'0'+1)%10+'0');
            list.add(new String(arr));

            arr[i]=(char)((original-'0'+9)%10+'0');
            list.add(new String(arr));

            arr[i]=original;
        }

        return list;
    }
}