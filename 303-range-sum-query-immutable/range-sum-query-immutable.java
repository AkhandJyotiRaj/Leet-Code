class NumArray {
    private int[] seg;
    private int[] num;
    public NumArray(int[] nums) {
        int n = nums.length;
        num = nums;
        seg = new int[4*n];
        build(0, 0, n-1);
    }
    
    public int sumRange(int left, int right) {
        return query(0, 0, num.length-1, left, right);
    }

    int query(int ind, int low, int high, int l, int r){
        if(low>=l && high<=r)// Total overlap
            return seg[ind];
        
        if(high<l || low>r) return 0; //no Overlap
        //Partial overlap
        int mid = (low+high)/2;
        int left = query(2*ind+1, low, mid, l, r);
        int right = query(2*ind+2, mid+1, high, l, r);

        return left+right;
    }

    void build(int ind, int low, int high){
        if(low==high){
            seg[ind] = num[low];
            return;
        }
        int mid = (low+high)/2;
        build(2*ind+1, low, mid);
        build(2*ind+2, mid+1, high);

        seg[ind] = seg[2*ind+1]+seg[2*ind+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */