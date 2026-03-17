import java.util.*;
public class countOddEven{

    static int[] st;
    public static void buildtree(int i, int s, int e,int[] arr){
        if(s==e){
            if(arr[s]%2 == 1) st[i] = 1;
            else st[i] = 0;
            return;
        }
        int mid = (s+e)/2;
        buildtree(2*i+1,s,mid,arr);
        buildtree(2*i+2,mid+1,e,arr);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public static void main(String[] args) {
        int[] arr = {1,5,7,8,6,1,3};
        int n = arr.length;
        st = new int[4*n];
        buildtree(0,0,n-1,arr);
        int odd = st[0];
        int even = n-odd;
        System.out.println("Odd: " + odd + " Even: " + even);
    }
}