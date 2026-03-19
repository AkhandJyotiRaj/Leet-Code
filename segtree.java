import javax.swing.tree.TreeNode;

public class segtree {
    public void seg(TreeNode node){
        int segTree
int lazy[] = new int[4*N];

void lazyUpdate(int idx, int start, int end, int qStart, int qEnd, int val){
    if(lazy[idx]!=0){
        segTree[idx] = segTree[idx] + (end-start+1)*lazy[idx];

        if(start!=end){

        
        lazy[2*idx+1] += lazy[idx];
        lazy[2*idx+2] += lazy[idx];
        }

        lazy[idx] = 0;
    }

    if(start>qEnd || end<qStart) return;

    if(start>=qStart && end<=qEnd){
        segTree[idx] += (end-start+1)*val;

        if(start!=end){
            lazy[2*idx+1] += val;
            lazy[2*idx+2] += val;
        }
    }

    int mid = (start+end)/2;

    lazyUpdate(2*idx+1, start, mid, qStart, qEnd, val);
    lazyUpdate(2*idx+2, mid+1, end, qStart, qEnd, val);

    segTree[idx] = segTree[2*idx+1] + segTree[2*idx+2];


}
    }
    public static void main(String[] args) {
        
    }
    
}