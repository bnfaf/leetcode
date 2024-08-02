package org.hot100;

public class S11 {
    public int maxArea(int[] height) {
        int res= Integer.MIN_VALUE;
        int left = 0, right = height.length-1;
        while (left < right){
            res = Math.max(res, Math.min(height[right], height[left]) * (right - left));
            if (height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
