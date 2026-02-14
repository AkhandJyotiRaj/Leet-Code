class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int totgas=0;
        int totcost=0;
        int fuel=0;
        int tank=0;
        int start=0;
        for(int i=0; i<gas.length ;i++)
        {
            totgas += gas[i];
            totcost += cost[i];
            tank += gas[i] - cost[i];
        if(tank < 0)
        {
            start = i+1;
            tank  = 0;
        }
        }
       return totgas >= totcost ? start:-1;
    }
}






















