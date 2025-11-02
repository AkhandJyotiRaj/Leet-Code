public class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int maxArea=0;
        while(left<right){
            int currentmax=(right-left)*Math.min(height[left],height[right]);
            maxArea=Math.max(maxArea,currentmax);
            if(height[left]<height[right])left++;
            else right--;
        }
        return maxArea;
    }
}
/*
// gives tle
class Solution {
    public int maxArea(int[] height) {
        if(height==null||height.length<2)return 0;
        return outerhelper(height,0,0);
    }
    public int outerhelper(int []height,int index,int currentmax){
        if(index==height.length-1)return currentmax;
        return outerhelper(height,index+1,Math.max(currentmax,inherhelper(height,index,index+1,currentmax)));
    }
    public int inherhelper(int[] height,int left,int right,int currentmax){
        if(right==height.length)return currentmax;
        return inherhelper(height,left,right+1,Math.max(currentmax,(right-left)*Math.min(height[left],height[right])));
    }
}
*/hard coantintwnumer {
    
}
