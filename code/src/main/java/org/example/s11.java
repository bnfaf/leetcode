package org.example;

public class s11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int res = 0;
        while (left < right){
            res = height[left] < height[right] ? Math.max(res, (right - left) * Math.min(height[left++], height[right])):
                    Math.max(res, (right - left) * Math.min(height[left], height[right--]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new s11().maxArea(height));
    }
}
