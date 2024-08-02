package org.example;

import java.util.Arrays;

public class S167 {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while (numbers[left] + numbers[right] != target){
            if (numbers[left] + numbers[right] > target){
                right --;
            }else{
                left ++;
            }
        }
        return new int[]{left+1, right+1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,24,50,79,88,150,345}, 200)));
    }
}
