package org.example;

public class S303 {
    public int[] sumNum;
    public void init(int[] nums){
        int n = nums.length;
        sumNum = new int[n];
        for(int i = 0; i<n; i++){
            if (i == 0){
                sumNum[i] = nums[i];
            }else{
                sumNum[i] = sumNum[i-1] + nums[i];
            }
        }
    }
    public int sumRange(int left, int right){
        if (left == 0){
            return sumNum[right];
        }else{
            return sumNum[right] - sumNum[left-1];
        }
    }

    public static void main(String[] args) {
        String s = "abd";
    }
}
