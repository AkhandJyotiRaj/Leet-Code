class Solution {
    public void combSum(int idx,List<Integer> list,List<List<Integer>> result,int[] candidates,int target,int sum)
    {
        if(idx>=candidates.length || sum>=target)
        {
            if(sum==target)
            {
                result.add(list);
            }
            return;
        }
        List<Integer> take=new ArrayList<>(list);
        take.add(candidates[idx]);
        sum+=candidates[idx];
        if(sum<=target)
        {
            combSum(idx,take,result,candidates,target,sum);
        }
        else
        {
            return;
        }
        sum-=candidates[idx];
        combSum(idx+1,list,result,candidates,target,sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int sum=0;
        combSum(0,list,result,candidates,target,sum);
        return result;
    }
}