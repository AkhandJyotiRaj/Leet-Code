class oddeven {
    int[] arr,st;
    public void buildtree(int i, int s, int e){
        if(s==e){
            if(arr[s]%2 == 1) st[i] = 1;
            else st[i] = 0;
            return;
        }
        int mid = (s+e)/2;
        buildtree(2*i+1,s,mid);
        buildtree(2*i+2,mid+1,e);
        st[i] = st[2*i+1] + st[2*i+2];
    }

    public int oddCount(int i, int l, int r, int s, int e){
        //complete overlap
        if(l<=s && r>=e) return st[i];

        //no overlap
        if(r<s || l>e) return 0;

        // partial overlap
        int mid = (s+e)/2;
        int left = oddCount(2*i+1,l,r,s,mid);
        int right = oddCount(2*i+2,l,r,mid+1,e);
        return left + right;
    }

    public int countOdds(int low, int high) {
        int n = high-low+1;
        arr = new int[n];
        st = new int[4*n];
        int j=0;
        for(int i=0;i<n;i++){
            arr[i] = low;
            low++;
        }
        buildtree(0,0,n-1);
        return oddCount(0,0,n-1,0,n-1);
    }
       public int countevens(int low, int high) {
        int n = high-low+1;
        arr = new int[n];
        st = new int[4*n];
        int j=0;
        for(int i=0;i<n;i++){
            arr[i] = low;
            low++;
        }
        buildtree(0,0,n-1);
        return oddCount(0,0,n-1,0,n-1);
    }
    public static void main(String[] args) {
        int arr[]={1,5,7,8,6,1,3};

    }
}