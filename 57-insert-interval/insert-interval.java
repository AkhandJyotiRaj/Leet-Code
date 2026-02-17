class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int s1 = intervals[0][0], e1 = intervals[0][1];
        for(int i=1; i<n; i++) {
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if(e1 >= s2) {
                e1 = Math.max(e1, e2);
            } else {
                ans.add(new int[]{s1,e1});
                s1 = s2;
                e1 = e2;
            }
        }
        ans.add(new int[]{s1, e1});
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        boolean insert = false;

        for(int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            // if current start is greater than newInterval start
            if(!insert && start >=  newInterval[0]) {
                ans.add(newInterval);
                insert = true;
            }
            // add the remaining intervals
            ans.add(intervals[i]);
        }
        // if not yet inserted
        if(!insert) ans.add(newInterval);
        return merge(ans.toArray(new int[ans.size()][]));
    }
}